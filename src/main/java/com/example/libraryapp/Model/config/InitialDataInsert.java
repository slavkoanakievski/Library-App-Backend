package com.example.libraryapp.Model.config;

import com.example.libraryapp.Model.Enumeration.Book_Category;
import com.example.libraryapp.Service.AuthorService;
import com.example.libraryapp.Service.BookService;
import com.example.libraryapp.Service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitialDataInsert {

    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;

    public InitialDataInsert(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void initData()
    {

        this.countryService.save("Macedonia", "Europe");
        this.countryService.save("Serbia", "Europe");
        this.countryService.save("Slovenia", "Europe");



        this.authorService.save("Author0",  "Author0_Surname", this.countryService.findAll().get(0).getId() ); // book0
        this.authorService.save("Author1",  "Author1_Surname", this.countryService.findAll().get(1).getId() ); // book0
        this.authorService.save("Author2",  "Author2_Surname", this.countryService.findAll().get(1).getId() ); // book1
        this.authorService.save("Author3",  "Author3_Surname", this.countryService.findAll().get(2).getId() ); // book1 & book2
        this.authorService.save("Author4",  "Author4_Surname", this.countryService.findAll().get(2).getId() ); // book3 & book2


        this.bookService.save("Hamlet", Book_Category.BIOGRAPHY, 3, this.authorService.findAll().get(0).getId());// author0 & author1
        this.bookService.save("Stranecot", Book_Category.CLASSICS, 7, this.authorService.findAll().get(1).getId()); // author2 & author3
        this.bookService.save("Odiseja", Book_Category.DRAMA, 1, this.authorService.findAll().get(2).getId());// author4 & author3
        this.bookService.save("Tristan i Izolda", Book_Category.FANTASY, 6, this.authorService.findAll().get(2).getId());// author4

    }
}
