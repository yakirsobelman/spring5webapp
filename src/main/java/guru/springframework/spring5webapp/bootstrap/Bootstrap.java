package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ben = new Author("Ben", "Shapiro");
        Book il = new Book("Israel", "123456");
        ben.getBooks().add(il);
        authorRepository.save(ben);
        bookRepository.save(il);

        Author dan = new Author("Dan", "Arieli");
        Book ir = new Book("IRCS", "56789");
        dan.getBooks().add(ir);
        authorRepository.save(dan);
        bookRepository.save(ir);

        Publisher modan = new Publisher("Modan", "10th Ditoo St.", "Las-Vegas", "Nevada", "12gh34");
        publisherRepository.save(modan);

        System.out.println("Finished bootstrapping");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
