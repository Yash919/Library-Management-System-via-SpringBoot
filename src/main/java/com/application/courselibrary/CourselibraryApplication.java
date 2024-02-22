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
	public CommandLineRunner initialCreate(BookService bookService){
		return(args) -> {
			Book book1=new Book("Star","You Forever","You know what i am thinking {Thriller} ");
			Author author1=new Author("Yash Mehta","Dexter");
			Category category1=new Category("Trauma Books");
			Publisher publisher1=new Publisher("Weeknd Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);


			Book book2=new Book("B","Positions","We found each other. ");
			Author author2=new Author("Paulo Dybala","Test");
			Category category2=new Category("Dark Books");
			Publisher publisher2=new Publisher("Second Publisher");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3=new Book("C","Atif","Pehli Daffa. ");
			Author author3=new Author("Chad","check");
			Category category3=new Category("Sigma Books");
			Publisher publisher3=new Publisher("Third Publisher");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);


		};
	}

}
