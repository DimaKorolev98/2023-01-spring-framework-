package ru.otus.homework;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.sql.SQLException;

@SpringBootApplication
@EnableMongoRepositories
public class LibraryApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(LibraryApplication.class, args);
		Console.main(args);
	}

}
