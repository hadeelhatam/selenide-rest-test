/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test.helpers;

//package se.nackademin.librarytest.helpers;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.page;
import se.nackademin.selenide.rest.test.model.Author;
import se.nackademin.selenide.rest.test.pages.AddAuthorPage;
import se.nackademin.selenide.rest.test.pages.AuthorPage;
import se.nackademin.selenide.rest.test.pages.BrowseAuthorsPage;
import se.nackademin.selenide.rest.test.pages.MenuPage;
import static com.codeborne.selenide.Selenide.page;
/*import se.nackademin.model.Author;
import se.nackademin.model.Book;
import se.nackademin.pages.AddAuthorPage;
import se.nackademin.pages.*;//AddUserPage;
import se.nackademin.pages.BookPage;
import se.nackademin.pages.BrowseAuthorsPage;
import se.nackademin.pages.BrowseBooksPage;
import se.nackademin.pages.MenuPage;
import se.nackademin.pages.SignInPage;
import se.nackademin.selenide.rest.test.pages.AuthorPage;
*/
public class AuthorHelper {
    
    public static void addNewAuthor(Author author) {

    }
                                     
    public static Author fetchAuthor(String searchQuery) {
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToBrowseAuthors();
        BrowseAuthorsPage browseAuthorsPage = page(BrowseAuthorsPage.class);
        browseAuthorsPage.setNameField("Hadeel!");
       // browseAuthorsPage.setLastNameField("Alhasan!");

        browseAuthorsPage.clickSearchAuthorsButton();
        browseAuthorsPage.clickFirstResultName();

        AuthorPage authorPage = page(AuthorPage.class);
        Author author = new Author();
        author.setFirstName(authorPage.getFirstName());
        author.setLastName(authorPage.getLastName());
        author.setCountry(authorPage.getCountry());
        return author;
    }

public static void createNewAuthor(String firstname, String lastname, String biographyname, String countryname) {
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToAddAuthor();

        AddAuthorPage addAuthorPage = page(AddAuthorPage.class);
        addAuthorPage.setFirstname(firstname);
        addAuthorPage.setLastname(lastname);
        addAuthorPage.setBiographyname(biographyname);
        addAuthorPage.setCountryname(countryname);
        addAuthorPage.clickAddAuthorButton();
            
    }
}
 /*   public static void logInAsUser(String username, String password) {
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToSignIn();
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUsername(username);
        signInPage.setPassword(password);
        signInPage.clickLogIn();

    }
*/


