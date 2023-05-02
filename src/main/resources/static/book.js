$(function () {
    getBooks();
});

function getBooks() {
    $.get('/api/books').done(function (books) {
        books.forEach(function (book) {
            $('tbody').append(`
          <tr>
            <td id="id">${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author.name}</td>
            <td>${book.genre.name}</td>
            <td><button type="button" class="btn btn-primary" onclick="getBook(${book.id})">Edit</button></td>
            <td><button type="button" onclick="deleteBook(${book.id})">Delete</button></td>
          </tr>
        `)
        });
    });
}
function deleteBook(id) {
    $.post('/api/book?id=' + id).done( function (){
        location.reload();
    })
}

function getBook(id) {
    $("#bookModalLabel").html("Edit book");
    $('form').empty(); // Clear previous form content before appending new content
    $.get('/api/book?id=' + id).done(function (book) {
        $('form').append(`
          <div class="form-group">
            <label for="id-input" class="col-form-label">ID:</label>
            <input id="id-input" type="text" readonly="readonly" value="${book.id}">
          </div>
          <div class="form-group">
            <label for="book-title-input" class="col-form-label">Title:</label>
            <input id="book-title-input" name="title" type="text" value="${book.title}">
          </div>
          <div class="form-group">
            <label for="author-name-input" class="col-form-label">Author:</label>
            <select name="author" class="form-control" id="author-name-input" multiple="multiple"></select>
          </div>
          <div class="form-group" class="col-form-label">
            <label for="genre-name-input">Genre:</label>
            <select name="genre" class="form-control" id="genre-name-input" multiple="multiple"></select>
          </div>
          <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="editBook()">Save changes</button>
                </div>
        `);

        $.get('/api/authors').done(function (authors) {
            var options = '';
            for (var i = 0; i < authors.length; i++) {
                options += `<option
                                value="${authors[i].name}">
                                ${authors[i].name}
                                </option>`;
            }
            $('#author-name-input').html(options).val(book.author.name);
        });

        $.get('/api/genres').done(function (genres) {
            var options = '';
            for (var i = 0; i < genres.length; i++) {
                options += `<option value="${genres[i].name}">${genres[i].name}</option>`;
            }
            $('#genre-name-input').html(options).val(book.genre.name);
        });

    });

    // Show the modal
    $('#bookModal').modal('show');
}

function editBook() {
    const idInput = document.getElementById("id-input")
    const titleInput = document.getElementById("book-title-input")
    const authorNameInput = document.getElementById("author-name-input")
    const genreNameInput = document.getElementById("genre-name-input")
    const book = {id: idInput.value, title: titleInput.value, author: {name: authorNameInput.value}, genre: {name: genreNameInput.value}}
    fetch("/api/books", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)})
        .then(rawResponse => rawResponse.json())
    location.reload();
}
function saveBook() {
    const savedBookContainer = document.getElementById("saved-book")
    const titleInput = document.getElementById("book-title-input")
    const authorNameInput = document.getElementById("author-name-input")
    const genreNameInput = document.getElementById("genre-name-input")
    const book = {title: titleInput.value, author: {name: authorNameInput.value}, genre: {name: genreNameInput.value}}
    fetch("/api/books", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(book)})
        .then(rawResponse => rawResponse.json())
        .then(json => savedBookContainer.innerHTML = JSON.stringify(json, null, 4))
}