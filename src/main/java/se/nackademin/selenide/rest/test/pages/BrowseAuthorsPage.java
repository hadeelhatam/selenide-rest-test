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
public class BrowseAuthorsPage extends MenuPage {
  //  private String nameAuthor;
    
    @FindBy(css = "#gwt-uid-2")
    SelenideElement nameAuthor;
    @FindBy(css = "#gwt-uid-3")
    SelenideElement authorsTitleField;
    @FindBy(css = "#gwt-uid-2")
    private SelenideElement nameField;
    @FindBy(css = "#search-authors-button")
    private SelenideElement searchAuthorsButton;
    @FindBy(css = "#gwt-uid-3")
    private SelenideElement firstResultName;
    @FindBy(css = ".v-grid-cell-focused > a:nth-child(1)")  
    private SelenideElement authorsFirstResultTitle; 
    @FindBy(css = ".v-grid-tablewrapper")  
    private SelenideElement authorsTable; 
  

    public void clickFirstResultName() {
        firstResultName.click();
    }
     
    public void setAuthorsNameField(String title) { 
         setTextFieldValue("authors title field", title, authorsTitleField); 
     }
    public void setNameField(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }
    public String getNameField() {
        return nameAuthor.getText();
    }
    public void clickSearchAuthorsButton() {
        searchAuthorsButton.click();
    }
    public void clickAuthorsFirstResultTitle() {
        authorsFirstResultTitle.click();
    }
}
    
  

