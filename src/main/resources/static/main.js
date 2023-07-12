function getEngines() {
    $.get('/api/engines').done(function (engines) {
        $('main').empty().append(`
<h2>Catalog</h2>
<table class="engines">
    <thead>
    <tr>
        <th>Name</th>
        <th>Producer</th>
        <th>Price, \$</th>
        <th>Info</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<a onclick="newOrder()" class="btn2">Create Order</a>`);
        engines.forEach(function (engine) {
            $('tbody').append(`
            <tr>
                <td>${engine.name}</td>
                <td>${engine.producer.name}</td>
                <td>${engine.price}</td>
                <td>${engine.info}</td> 
            </tr>
            `);
        });
    });
}

function newOrder() {
    $('main').empty().append(`
<h2>New Order</h2>
<form>
  <label for="address">Address:</label>
  <input type="text" id="address" name="address">
  <br>
  <label for="payment">Payment method:</label>
  <select id="payment" name="payment">
    <option value="credit-card">Credit card</option>
    <option value="paypal">PayPal</option>
  </select>
  <br>
  <div id = "engine-options">
  
</div>
  <input onclick="createOrder()" value="Submit">
</form>
`);
    $.get('/api/engines').done(function (engines) {
        var engineCheckboxes = '';
        engines.forEach(function (engine) {
            const engineValue = JSON.stringify(engine);
            engineCheckboxes += '<label>' +
                `<input type="checkbox" name="engine" value='${engineValue}'> ` + engine.name + '</label><br>';
        });
        $('#engine-options').append(engineCheckboxes);
    });
}



function createOrder() {
    // Get the address and payment type from the form
    const address = document.getElementById("address").value;
    const paymentType = document.getElementById("payment").value;
    const engineChecks = document.querySelectorAll('input[name="engine"]:checked');
    const engineIds = Array.from(engineChecks).map(check => check.value);
    const orderItems = engineIds.map(engine => {
        return {
            engineDto: JSON.parse(engine),
            price: 0, // set price based on engineId later
            count: 1 // always 1 for this example
        };
    });
    const order = {
        orderDate: new Date,
        orderItems: orderItems,
        paymentType: paymentType,
        deliveryType: "delivery",
        deliveryAddress: address,
        comment: "comment",
        status: "new",
        statusDate: new Date
    };
    fetch("/api/orders/new", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(order)
    })
        .then(rawResponse => rawResponse.json())
        .then(response => {
            // display success message or redirect to order confirmation page
        })
        .catch(error => console.error(error));
}

function getUserOrders() {
    $.get("/api/orders/my").done(function (orders) {
        $('main').empty().append(`
<h2>My Orders</h2>
<table class="engines">
    <thead>
    <tr>
        <th>Number</th>
        <th>Date</th>
        <th>Items</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<a href="/" class="btn">Main</a>`);
        orders.forEach(function (order) {
            const items = order.orderItems;
            const engines = [];
            const date = new Date(order.orderDate);
            const formattedDate = `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;

            items.forEach(function (item) {
                engines.push(item.engine.name);
            });

            $('tbody').append(`
    <tr>
      <td>${order.id}</td>
      <td>${formattedDate}</td>
      <td>${engines.join(', ')}</td>
      <td>${order.status}</td> 
    </tr>
  `);
        });
    });
}