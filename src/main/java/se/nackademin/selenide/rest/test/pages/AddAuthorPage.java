/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AddAuthorPage extends MenuPage {
    @FindBy(css = "#gwt-uid-6")    
    SelenideElement userFirstnameField;
    @FindBy(css = "#gwt-uid-8")    
    SelenideElement userLastnameField;
    @FindBy(css = " #gwt-uid-3")    
    SelenideElement countryField;
    @FindBy(css = " #gwt-uid-5")    
    SelenideElement biographyField;
  
    @FindBy(css = "#add-author-button")
    SelenideElement addAuthorButton;


    public void setFirstname(String firstname) {
        setTextFieldValue("first name field", firstname, userFirstnameField);
    }

    public void setLastname(String lastname) {
        setTextFieldValue("lastname field", lastname, userLastnameField);
    }
    
    public void setBiographyname(String biographyname) {
        setTextFieldValue("biography field", biographyname, biographyField);
    }
    
    public void setCountryname(String countryname) {
        setTextFieldValue("country name field", countryname, countryField);
    }

    public void clickAddAuthorButton() {
        clickButton("add author button", addAuthorButton);
    }
}
    



