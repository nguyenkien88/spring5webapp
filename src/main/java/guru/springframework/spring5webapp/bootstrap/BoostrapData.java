package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositoies.AuthorRepository;
import guru.springframework.spring5webapp.repositoies.BookRepository;
import guru.springframework.spring5webapp.repositoies.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BoostrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher("publisher1");
        publisher1.setCity("hcm");
        publisher1.setLine1("cmt8");
        publisher1.setState("state");
        publisher1.setZip("70000");
        publisherRepository.save(publisher1);


        Author author1 = new Author("nguyen", "kien");
        Book book1 = new Book("book1", "121212");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        Author author2 = new Author("ka", "ka");
        Book book2 = new Book("book2", "1212343");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println(publisher1.getBooks().size());
    }
}
