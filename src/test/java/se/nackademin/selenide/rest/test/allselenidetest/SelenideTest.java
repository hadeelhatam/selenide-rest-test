/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test.allselenidetest;

import static com.codeborne.selenide.Selenide.*;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import se.nackademin.selenide.rest.test.helpers.AuthorHelper;
import se.nackademin.selenide.rest.test.helpers.BookHelper;
import se.nackademin.selenide.rest.test.helpers.UserHelper;
import se.nackademin.selenide.rest.test.helpers.Table;

import se.nackademin.selenide.rest.test.model.Author;
import se.nackademin.selenide.rest.test.model.Book;

import se.nackademin.selenide.rest.test.pages.AddAuthorPage;
import se.nackademin.selenide.rest.test.pages.BookPage;
import se.nackademin.selenide.rest.test.pages.BrowseAuthorsPage;
import se.nackademin.selenide.rest.test.pages.BrowseBooksPage;
import se.nackademin.selenide.rest.test.pages.ConfirmDialog;
import se.nackademin.selenide.rest.test.pages.EditBook;
import se.nackademin.selenide.rest.test.pages.EditUser;
import se.nackademin.selenide.rest.test.pages.MenuPage;
import se.nackademin.selenide.rest.test.pages.MyProfilePage;



public class SelenideTest extends TestBase {

    public SelenideTest() {
    }
    
    @Test
    public void testÄndraPubDate(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        EditBook editBook = page(EditBook.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
                
//        UserHelper.createNewUser("admin", "1234567890", uuid+"@example.com");
        UserHelper.logInAsUser("admin", "1234567890");
     
        menuPage.navigateToBrowseBooks();
        Book book = BookHelper.fetchBook("Good Omens");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        
     //   Book book = BookHelper.fetchBook("Good Omens");
        editBook.TryckEditField();
        editBook.getdatepublishedField();
        editBook.clickSaveBookButton();
        
        menuPage.navigateToBrowseBooks();
        BookHelper.fetchBook("Good Omens");
        browseBooksPage.clickSearchBooksButton();
        
        assertEquals("Publisged date should be ", editBook.getdatepublishedField());
    }

    @Test
    public void testÄndraEmail(){
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        EditUser editUser = page(EditUser.class);
        
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com");
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToMyProfile();
        myProfilePage.clickEditUserButton();
        editUser.getUserEmail(uuid+"@example.com");

        menuPage.navigateToMyProfile();
        editUser.getUserEmail(uuid);
        assertEquals("user Email i profil", editUser.getUserEmail(uuid));
        sleep(200);
    }
    
    private Integer convertToInteger(String input) {
        Integer output = null;
        try {
            output = Integer.valueOf(input);
        } catch (NumberFormatException numberFormatException) {
            //if an exception is caught we'll return null
        }
        return output;
    }
    
    @Test
    public void testLånaBok(){
        open("http://localhost:8080/librarytest");
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
                
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com"); 
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToBrowseBooks();
        
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        String numberBooksAvailable = bookPage.getNumberofCopies();
        String borrowBooksName = bookPage.getTitle();
        Integer i = convertToInteger(numberBooksAvailable);
        bookPage.clickBorrowBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        i--;
        String s1=i.toString();
        assertEquals("number av bok är "+s1, s1, bookPage.getNumberofCopies());
        menuPage.navigateToMyProfile();
        Table table = new Table($(".v-grid-tablewrapper"));
        table.searchAndClick(borrowBooksName, 0);
        
        bookPage.clickReturnBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("bok numb är " , bookPage.getNumberofCopies());
    }
    
    @Test
    public void testLämnaBok(){
        open("http://localhost:8080/librarytest");
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToMyProfile();
        String borrowBooksName = bookPage.getTitle();
        Table table =new Table($(".v-grid-tablewrapper"));
        table.searchAndClick(borrowBooksName, 0);
        
        bookPage.clickReturnBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("Bok är Lämnat ", "Boken är lämnat");
    }
    
    @Test
    public void testAddAuthor(){
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        AddAuthorPage addAuthorPage = page(AddAuthorPage.class);
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);        
       
        UserHelper.logInAsUser("admin", "1234567890");
        menuPage.navigateToAddAuthor();
        
        AuthorHelper.createNewAuthor(uuid, uuid, uuid, uuid);
        Author author = AuthorHelper.fetchAuthor(uuid);
        
        assertEquals("author name ", author.getFirstName());   
        assertEquals("author country ", author.getCountry());   
        assertEquals("author biography ", author.getBiography()); 
        sleep(200);
    }
    
     
    @Test
    //@Ignore
    public void testFatchBook(){
        open("http://localhost:8080/librarytest");
        Book book = BookHelper.fetchBook("Guards!");
        assertEquals("book title should be 'Guards! Guards!', Guards! Guards!", book.getTitle());
    }
    
    @Test
   // @Ignore
    public void testLogin(){
       String uuid = (UUID.randomUUID().toString()).substring(0, 10);
       open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com");
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToMyProfile();
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        assertEquals("user name i profile", myProfilePage.getdisplayName(uuid));
    }
    
    @Test
   // @Ignore
    public void testUsingTable() {
        page(MenuPage.class).navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.clickSearchBooksButton();
        Table table = new Table($(".v-grid-tablewrapper"));
        System.out.println(table.getColumnCount());
        System.out.println(table.getRowCount());
        System.out.println(table.getCellValue(0, 0));
        System.out.println(table.getCellValue(1, 1));
        table.searchAndClick("American Gods", 0);
        sleep(2000);
    }
}


