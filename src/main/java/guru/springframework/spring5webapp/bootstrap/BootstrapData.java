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
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher harper = new Publisher("Harper Collins", "195 Broadway", "New-York", "New-York", "10007");
        publisherRepository.save(harper);

        Author eric = new Author("Eric", "Evans");
        Book xxx = new Book("Domain Driven Design", "123123");
        xxx.setPublisher(harper);
        eric.getBooks().add(xxx);
        xxx.getAuthors().add(eric);
        harper.getBooks().add(xxx);

        authorRepository.save(eric);
        bookRepository.save(xxx);
        publisherRepository.save(harper);

        Author rod = new Author("Rod", "Johnson");
        Book yyy = new Book("J2EE Dev without EJB", "123123246");
        yyy.setPublisher(harper);
        rod.getBooks().add(yyy);
        yyy.getAuthors().add(rod);
        harper.getBooks().add(yyy);

        authorRepository.save(rod);
        bookRepository.save(yyy);
        publisherRepository.save(harper);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books "+bookRepository.count());

        System.out.println("Publishers number of book"+harper.getBooks().size());
    }
}
