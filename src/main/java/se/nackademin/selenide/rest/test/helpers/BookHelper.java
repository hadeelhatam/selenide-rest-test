/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test.helpers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package se.nackademin.librarytest.helpers;

import static com.codeborne.selenide.Selenide.page;
import se.nackademin.selenide.rest.test.model.Book;
import se.nackademin.selenide.rest.test.pages.AddAuthorPage;
import se.nackademin.selenide.rest.test.pages.AddBookPage;
import se.nackademin.selenide.rest.test.pages.BookPage;
import se.nackademin.selenide.rest.test.pages.AuthorPage;
import se.nackademin.selenide.rest.test.pages.BrowseBooksPage;
import se.nackademin.selenide.rest.test.pages.MenuPage;

/*import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;
*/
/**
 * @author testautomatisering
 */
public class BookHelper {

    public static void addNewBook(Book book) {

    }

    public static Book fetchBook(String searchQuery) {
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.setTitleField("Guards!");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();

        BookPage bookPage = page(BookPage.class);
        Book book = new Book();
        book.setTitle(bookPage.getTitle());
        book.setAuthor(bookPage.getAuthor());
        book.setDescription(bookPage.getDescription());
        return book;
    }
    
    public static void createNewBook(String title, String description, String numofpages, String numininventory, String datepublished, String isbn) {
        MenuPage menuPage = page(MenuPage.class);
        AddBookPage addBookPage = page(AddBookPage.class);
        AddAuthorPage addAuthorPage = page(AddAuthorPage.class);
         
        menuPage.navigateToAddBook();
        
        addBookPage.setTitle(title);
        addBookPage.setDesecription(description);
        addBookPage.setNumofpages(numofpages);
        addBookPage.setNumininventory(numininventory);
        addBookPage.setPubDate(datepublished);
        addBookPage.setIsbn(isbn);
        
        addBookPage.clickAddBookButton();
            
    }
}



