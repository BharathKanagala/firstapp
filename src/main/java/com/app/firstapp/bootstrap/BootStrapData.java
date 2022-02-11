package com.app.firstapp.bootstrap;

import com.app.firstapp.domain.Author;
import com.app.firstapp.domain.Book;
import com.app.firstapp.domain.Publisher;
import com.app.firstapp.repositories.AuthorRepository;
import com.app.firstapp.repositories.BookRepository;
import com.app.firstapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author bharath = new Author("bharath","kanagala");
        Book life = new Book("lifeOfBharu", "3238");

        bharath.getBooks().add(life);
        life.getAuthors().add(bharath);

        authorRepository.save(bharath);
        bookRepository.save(life);

        Publisher sarath = new Publisher("old hickory square","Frisco","8625");


        sarath.getBooks().add(life);
        life.setPublisher(sarath);

        publisherRepository.save(sarath);

        System.out.println("Starting the BootStrap");
        System.out.println("Number of authors " + authorRepository.count());
        System.out.println("Publisher Details " + publisherRepository.count());
        System.out.println("Publisher books "+ sarath.getBooks().size());

    }
}
