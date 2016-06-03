/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test.allselenidetest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.nackademin.selenide.rest.test.helpers.AuthorHelper;
import se.nackademin.selenide.rest.test.helpers.BookHelper;
import se.nackademin.selenide.rest.test.helpers.Table;
import se.nackademin.selenide.rest.test.helpers.UserHelper;
import se.nackademin.selenide.rest.test.model.Book;
//import se.nackademin.selenide.rest.test.model.Author;
//import se.nackademin.selenide.rest.test.model.Book;
import se.nackademin.selenide.rest.test.pages.AddAuthorPage;
import se.nackademin.selenide.rest.test.pages.AddBookPage;
import se.nackademin.selenide.rest.test.pages.AuthorPage;
import se.nackademin.selenide.rest.test.pages.BookPage;
import se.nackademin.selenide.rest.test.pages.BrowseAuthorsPage;
import se.nackademin.selenide.rest.test.pages.BrowseBooksPage;
import se.nackademin.selenide.rest.test.pages.ConfirmDialog;
import se.nackademin.selenide.rest.test.pages.EditBook;
import se.nackademin.selenide.rest.test.pages.EditUser;

import se.nackademin.selenide.rest.test.pages.MyProfilePage;
import se.nackademin.selenide.rest.test.pages.MenuPage;

/**
 *
 * @author alhasan
 */
public class TestAdmin extends TestBase{
  
    @Test
    public void testLoginAdmin(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        MyProfilePage myProfilePage = page(MyProfilePage.class);   
        EditBook editBook = page(EditBook.class);
        EditUser editUser = page(EditUser.class);
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890"); 
        assertEquals("messag är Welcome to the Library Test Application!\n" +
                     "Logged in as admin.Librarian'", "Librarian", "Welcome to the Library Test Application!Logged in as admin"); 
        sleep(200);
        }

    @Test
     public void testEdit_PubDate(){
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
        sleep(200);
     }
    
    
    @Test
    public void testEditBook_Feldata(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        EditBook editBook = page(EditBook.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        BookPage bookPage = page(BookPage.class); 
        sleep(200);        
        UserHelper.logInAsUser("admin", "1234567890");
     
        menuPage.navigateToBrowseBooks();
        Book book = BookHelper.fetchBook("Good Omens");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickEditBookButton();
        sleep(200); 
        editBook.newTitle("123"); 
        editBook.clickSaveBookButton(); 
        sleep(200); 
        assertEquals("message är 'Invalid data,  try again.'"," try again."); 
    }  
    

    @Test
    public void testEditBook_NoofPage(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        EditBook editBook = page(EditBook.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        BookPage bookPage = page(BookPage.class); 
        sleep(200);        
        UserHelper.logInAsUser("admin", "1234567890");
     
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField("Good Omens");
        Book book = BookHelper.fetchBook("Good Omens");
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickEditBookButton();
        sleep(200);
        editBook.newNoofPage("220"); 
        editBook.clickSaveBookButton(); 
        sleep(200); 
        assertEquals("message är 'Invalid NoofPage, try again.'"," try again" ); 
    }
        
        
    @Test
    public void testEditBook_Numininventory(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        EditBook editBook = page(EditBook.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        BookPage bookPage = page(BookPage.class); 
        sleep(200);        
        UserHelper.logInAsUser("admin", "1234567890");
     
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField("Good Omens");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickEditBookButton();
        sleep(200);
        editBook.newNuminInventory("3"); 
        editBook.clickSaveBookButton(); 
        sleep(200); 
        assertEquals("message är 'Invalid num in inventory, try again.", "try again" ); 
    }
    
    
    @Test
    public void testLånaBok(){
        open("http://localhost:8080/librarytest");
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");
                
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField("Good Omens");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickBorrowBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("message är 'boken är lånat' ", "Gödkänt låna bok");
    }
    
/*    @Test
    public void testLämnaBok(){
        open("http://localhost:8080/librarytest");
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200);
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToMyProfile();
        String borrowBooksName = bookPage.getTitle();
        Table table = new Table($(".v-grid-tablewrapper"));
        table.searchAndClick(borrowBooksName, 0);
        bookPage.clickReturnBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("Bok är Lämnat ", "Boken är lämnat");
    }
  */      
    @Test
    public void testDeletBok(){
        open("http://localhost:8080/librarytest");
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");
                
        menuPage.navigateToBrowseBooks();
        browseBooksPage.setTitleField("Good Omens");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickDeleteBookButton();
        sleep(200);
        confirmDialog.clickYesButton();
        sleep(200);
        assertEquals("Boken är deleted'", "Gödkänt Delet bok", bookPage.getTitle());
   
    }
    
    @Test//test låna bok beroende om författare namn
    public void testLånaBokOnAuthor(){
        open("http://localhost:8080/librarytest");
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");

        menuPage.navigateToBrowseAuthors();
        browseAuthorsPage.setNameField("Terry Pratchett");
     
        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickFirstResultName();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickBorrowBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("böken är lönat ","Gödkänt löna bok ");
    }
    
    @Test//test Delet bok beroende om författare namn
    public void testDeletBokOnAuthor(){
        open("http://localhost:8080/li brarytest");
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(2000); 
        
        UserHelper.logInAsUser("admin", "1234567890");

        menuPage.navigateToBrowseAuthors();
        browseAuthorsPage.setNameField("Terry Pratchett");

        browseAuthorsPage.clickSearchAuthorsButton();
   //     browseAuthorsPage.clickFirstResultName();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickDeleteBookButton();
        sleep(200);
        confirmDialog.clickYesButton();
        sleep(200);
        assertEquals("Boken är deleted'", "Gödkänt delet bok", bookPage.getTitle());
        
    }
    
    @Test
    public void testDeletAuthor(){
        open("http://localhost:8080/li brarytest");
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        AuthorPage authorPage = page(AuthorPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(2000); 
        
        UserHelper.logInAsUser("admin", "1234567890");

        menuPage.navigateToBrowseAuthors();
        browseAuthorsPage.setNameField("Terry Pratchett");

        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickFirstResultName();
        browseBooksPage.clickFirstResultTitle();
        authorPage.clickDeletAuthorButton();
        
        confirmDialog.clickYesButton(); 
        sleep(200);        
        assertEquals("Gödkänt delet förfatare ","Gödkänt delet författare ", authorPage.getFirstName()); 
    }
    
    @Test
    public void testAddAuthor(){
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        AddAuthorPage addAuthorPage = page(AddAuthorPage.class);
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);        
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");
        
        AuthorHelper.createNewAuthor(uuid, uuid, uuid, uuid);
        assertEquals("Författare är add  ", "Gödkänt add Författare"); 
        sleep(200);
                   
    }
    @Test
    public void testAddBookwithEmptyData(){
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        AddBookPage addBookPage = page(AddBookPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);

        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);        
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");
        menuPage.navigateToAddBook();
        sleep(200);
        addBookPage.clickAddBookButton();
        assertEquals("message är 'Invalid data, try again.'", "Invalid data, try again.");
        sleep(2000);
    }
    
    @Test
    public void testAddBook(){
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        AddBookPage addBookPage = page(AddBookPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        BookPage bookPage = page(BookPage.class); 

        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);        
       sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");
        menuPage.navigateToAddBook();
        sleep(200);

        BookHelper.createNewBook(uuid, uuid, "120", "2", "2000-2-20","12345");
        addBookPage.clickAddBookButton(); 
        sleep(200); 
        assertEquals("message är 'Added book:'", "Added book:");
        sleep(200); 

    
    }

@Test//test Delet user admin 
    public void testDeletUserAdmin(){
        open("http://localhost:8080/librarytest");
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");

        menuPage.navigateToMyProfile();

        myProfilePage.clickDeleteUserButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("Gödkänt delet admin ","Gödkänt delet admin ");
    }

    @Test
    public void testEditUserDisplaynameAdmin(){
        open("http://localhost:8080/librarytest");
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200);
        UserHelper.logInAsUser("admin", "1234567890");

        menuPage.navigateToMyProfile();

        myProfilePage.clickEditUserButton();
        
        String displayname =  myProfilePage. getdisplayName(uuid); 
        assertEquals("bok ny title är ", myProfilePage. getdisplayName(uuid));  
        myProfilePage.clickSaveUserButton(); 
        
}
}