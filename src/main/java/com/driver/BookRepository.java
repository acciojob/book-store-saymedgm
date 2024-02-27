package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private List<Book> bookList;
    private int id;

    public BookRepository(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    public Book save(Book book){
        book.setId(id);
        id++;
        bookList.add(book);
        return book;
    }

    public Book findBookById(int id){
        for(Book book: bookList){
            if(book.getId() == id){
                return book;
            }
        }

        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getId() == id){
                bookList.remove(i);

                return;
            }
        }
    }

    public void deleteAll(){
        bookList = new ArrayList<Book>();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> booksByAuthor = new ArrayList<Book>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author)){
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> booksByGenre = new ArrayList<Book>();
        for(Book book : bookList){
            if(book.getGenre().equals(genre)){
                booksByGenre.add(book);
            }
        }

        return booksByGenre;
    }
}