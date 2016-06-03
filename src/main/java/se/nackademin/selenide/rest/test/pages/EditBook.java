
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
public class EditBook extends MenuPage {
    @FindBy(css = "#gwt-uid-7")
    SelenideElement datepublishedField;
    @FindBy(css = "#gwt-uid-3")
    SelenideElement titleField;
    @FindBy(css = "#gwt-uid-11")
    SelenideElement noofpageField;
    @FindBy(css = "#gwt-uid-5")
    SelenideElement numininventoryField;
    @FindBy(css = "#save-book-button")
    private SelenideElement saveBookButton;
    @FindBy(css = "#edit-book-button")
    SelenideElement editdateField;
    


    public void TryckEditField() {
        editdateField.click();
    }
    public String getdatepublishedField() {
        return datepublishedField.getText();
    }
    public String getTitleField(String title) {
        return titleField.getText();
    }
    public String getNoofpageField(String noofpage) {
        return noofpageField.getText();
    }
    public String getNumininventoryField(String numininventory) {
        return numininventoryField.getText();
    }
    public void clickSaveBookButton() {
        saveBookButton.click();
    }
    public void newTitle(String newTitle) { 
        setTextFieldValue("Title: ", newTitle, titleField); 
    } 
    public void newNoofPage(String newnoofpage) { 
        setTextFieldValue("NoofPage: ", newnoofpage, noofpageField); 
    }
    public void newPubDate(String newdatepublished) { 
        setTextFieldValue("date published: ", newdatepublished, datepublishedField); 
    }
    public void newNuminInventory(String newnumininventory) { 
        setTextFieldValue("NuminInventory: ", newnumininventory, numininventoryField); 
    }
 
}
