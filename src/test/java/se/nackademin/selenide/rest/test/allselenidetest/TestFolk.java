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
import se.nackademin.selenide.rest.test.model.Author;
import se.nackademin.selenide.rest.test.model.Book;
import se.nackademin.selenide.rest.test.pages.AuthorPage;
import se.nackademin.selenide.rest.test.pages.BookPage;
import se.nackademin.selenide.rest.test.pages.BrowseAuthorsPage;
import se.nackademin.selenide.rest.test.pages.BrowseBooksPage;
import se.nackademin.selenide.rest.test.pages.ConfirmDialog;
import se.nackademin.selenide.rest.test.pages.EditBook;
import se.nackademin.selenide.rest.test.pages.EditUser;
import se.nackademin.selenide.rest.test.pages.MenuPage;
import se.nackademin.selenide.rest.test.pages.MyProfilePage;

/**
 *
 * @author alhasan
 */
public class TestFolk extends TestBase {
    
    @Test
    public void testsökEnvissBok(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        EditBook editBook = page(EditBook.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        BookPage bookPage = page(BookPage.class); 
                
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com"); 
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToBrowseBooks();
        Book book = BookHelper.fetchBook("Rendezvous with Rama");
        //browseBooksPage.setTitleField("Rendezvous with Rama");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();

        assertEquals("bok title är 'Rendezvous with Rama'", "Rendezvous with Rama", bookPage.getTitle());
        assertEquals("förfatare namn är 'Arthur C. Clarke","Arthur C. Clarke", bookPage.getAuthor());
        assertEquals("bok ISBN är '0-575-01587-X", "0-575-01587-X", bookPage.getIsbn());
        assertEquals("bok desecription är'After a meteorite falls in Northeast Italy in 2077, creating a major disaster, the government of "
            + "   Earth sets up the Spaceguard system as an early warning of arrivals from deep space.","After a meteorite falls in Northeast "
            + "Italy in 2077, creating a major disaster, the government of Earth sets up the Spaceguard system as an early warning of arrivals from deep space. ", bookPage.getDescription());
        assertEquals("bok pubdate är '1973-06-28'", "1973-06-28", bookPage.getpubDate());
        assertEquals("no of page är  '200'", "200", bookPage.getNumberofCopies());
        sleep(200); 
    } 
        
    
    @Test
    public void testsökEnvissFörfattare(){
        open("http://localhost:8080/librarytest");
        MenuPage menuPage = page(MenuPage.class);
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        AuthorPage authorPage = page(AuthorPage.class);        
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com"); 
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToBrowseAuthors();
       // browseAuthorsPage.setAuthorsNameField("Stephen Baxter"); 
        Author author = AuthorHelper.fetchAuthor("Stephen Baxter");
        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickAuthorsFirstResultTitle();
        sleep(200); 
        assertEquals("Author's name 'Stephen Baxter'", "Stephen Baxter", authorPage.getAuthorsName()); 
        assertEquals("Author's country 'Great Britain'", "Great Britain", authorPage.getAuthorsCountry()); 
        assertEquals("Author's biography 'Stephen Baxter (born 13 November 1957) is a prolific British hard science fiction author. He has "
                + "degrees in mathematics and engineering. Strongly influenced by SF pioneer H. G. Wells, Baxter has been a distinguished Vice-President"
                + " of the international H. G. Wells Society since 2006.'", "Stephen Baxter (born 13 November 1957) is a prolific British hard science "
                + "fiction author. He has degrees in mathematics and engineering. Strongly influenced by SF pioneer H. G. Wells, Baxter has been a "
                + "distinguished Vice-President of the international H. G. Wells Society since 2006.", authorPage.getAuthorsBiography());  
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
    public void testLånaEnBok(){
        open("http://localhost:8080/librarytest");
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com"); 
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToBrowseBooks();
        sleep(200);
        Book book = BookHelper.fetchBook("American");
        //browseBooksPage.setTitleField("American");
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickBorrowBookButton(); 
        sleep(200); 
        confirmDialog.clickYesButton(); 
        sleep(200);        
        assertEquals("Book's name should be 'American Gods'", "American Gods", bookPage.getTitle()); 
        }   
    
    
   /* @Test//test låna bok depent on Author namn
    public void testLånaBokOnAuthor(){
        open("http://localhost:8080/librarytest");
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);
        sleep(200); 
        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com"); 
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToBrowseAuthors();
        sleep(200);
        browseAuthorsPage.setNameField("Terry Pratchett");
        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickFirstResultName();
        browseBooksPage.clickFirstResultTitle();
        bookPage.clickBorrowBookButton();
        confirmDialog.clickYesButton();
        sleep(2000);
        assertEquals("Gödkänt löna bok ","Gödkänt löna bok ");
    }
*/
    @Test
    public void testLämnaBok(){
        open("http://localhost:8080/librarytest");
        ConfirmDialog confirmDialog = page(ConfirmDialog.class);
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class); 
        String uuid = (UUID.randomUUID().toString()).substring(0, 10);

        UserHelper.createNewUser(uuid, uuid, uuid+"@example.com"); 
        UserHelper.logInAsUser(uuid, uuid);
        
        menuPage.navigateToMyProfile();
        sleep(200);
        String borrowBooksName = bookPage.getTitle();
        Table table = new Table($(".v-grid-tablewrapper"));
        table.searchAndClick(borrowBooksName, 0);
        
        bookPage.clickReturnBookButton();
        confirmDialog.clickYesButton(); 
        sleep(200); 
        assertEquals("Bok är lämnat", bookPage.getTitle()); 
        
    }
}
     