package com.application.courselibrary;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Book;
import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourselibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService ) {
		return(args)->{

			Book book = new Book("ABC1","Book Name","My First Book");
			Author author = new Author("Test name1","Test description");
			Category category = new Category("Science fiction");
			Publisher publisher = new Publisher("Publisher1");

			book.addAuthor(author);
			book.addPublisher(publisher);
			book.addCategory(category);
			bookService.createBook(book);

			Book book1 = new Book("ABC2","Book Name1","My Second Book");
			Author author1 = new Author("Test name2","Test description1");
			Category category1 = new Category("Non fiction");
			Publisher publisher1 = new Publisher("Publisher2");

			book1.addAuthor(author1);
			book1.addPublisher(publisher1);
			book1.addCategory(category1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC3","Book Name3","My Third Book");
			Author author2 = new Author("Test name3","Test description2");
			Category category2 = new Category("Comedy");
			Publisher publisher2 = new Publisher("Publisher3");

			book2.addAuthor(author2);
			book2.addPublisher(publisher2);
			book2.addCategory(category2);
			bookService.createBook(book2);




		};
	}

}
