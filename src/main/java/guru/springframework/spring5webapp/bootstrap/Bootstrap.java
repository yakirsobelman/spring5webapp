package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Bootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("Finished bootstrapping");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());

    }
}
