/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author alhasan
 */
public class AddBookPage extends MenuPage {
    @FindBy(css = "#gwt-uid-3")    
    SelenideElement titleField;
    @FindBy(css = "#gwt-uid-9")    
    SelenideElement desecriptionField;
    @FindBy(css = "#gwt-uid-11")    
    SelenideElement numofpagesField;
    @FindBy(css = "#gwt-uid-13")    
    SelenideElement isbnField;
    @FindBy(css = "#gwt-uid-5")    
    SelenideElement numininventoryField;
     @FindBy(css = "#gwt-uid-7")    
    SelenideElement pubDateField;
    @FindBy(css = "#add-book-button")    
    SelenideElement addbookbuttonField;
   
    
    public void setTitle(String title) {
        setTextFieldValue("Title field", title, titleField);
    }
    public void setDesecription(String desecription) {
        setTextFieldValue("desecription Field", desecription, desecriptionField);
    }
    public void setPubDate(String pubDate) {
        setTextFieldValue("Pub Date Field", pubDate, pubDateField);
    }
    public void setNumofpages(String numofpages) {
        setTextFieldValue("num of pages Field", numofpages, numofpagesField);
    }

    public void setIsbn(String isbn) {
        setTextFieldValue("isbn Field", isbn, isbnField);
    }
      public void setNumininventory(String numininventory) {
        setTextFieldValue("num in inventory Field", numininventory, numininventoryField);
    }
    public void clickAddBookButton() {
        clickButton("add author button", addbookbuttonField);
    }
}
