
package se.nackademin.selenide.rest.test.pages;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author alhasan
 */
public class AuthorPage extends MenuPage {
    
    
    @FindBy(css = "#gwt-uid-6")
    SelenideElement firstnameField;
    @FindBy(css = "#gwt-uid-8")
    SelenideElement lastnameField;
    @FindBy(css = "#gwt-uid-2")
    SelenideElement countryField;
    @FindBy(css = "#delet-author-button")
    SelenideElement deletAuthorButton;
    
    @FindBy(css = "#gwt-uid-3") 
     SelenideElement authorsNameField; 
     @FindBy(css = "#gwt-uid-5") 
     SelenideElement authorsCountryField; 
     @FindBy(css = "#gwt-uid-7") 
     SelenideElement authorsBiographyField; 
     @FindBy(css = "#edit-author-button") 
     SelenideElement editAuthorButton; 
     @FindBy(css = "#delete-author-button") 
     SelenideElement deleteAuthorButton; 
     
 
    
    public String getFirstName() {
        return firstnameField.getText();
    }

    public String getLastName() {
        return lastnameField.getText();
    }

    public String getCountry() {
        return countryField.getText();
    }
    public void clickDeletAuthorButton() {
        clickButton("delet author button", deletAuthorButton);
    }
     
    public String getAuthorsName() { 
         return authorsNameField.getText(); 
     } 

 
    public String getAuthorsCountry() { 
         return authorsCountryField.getText(); 
     } 
    public String getAuthorsBiography() { 
        return authorsBiographyField.getText(); 
    } 
      
    public void clickEditAuthorButton() { 
         clickButton("edit author button", editAuthorButton); 
     }   
   
     public void clickDeleteAuthorButton() { 
         clickButton("delete author button", deleteAuthorButton); 
     }   
}

