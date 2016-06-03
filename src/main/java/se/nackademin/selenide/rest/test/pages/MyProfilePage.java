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
 * @author testautomatisering
 */
public class MyProfilePage extends MenuPage {
    @FindBy(css = "#gwt-uid-5")
    SelenideElement displayNameField;
    @FindBy(css = "#delete-user-button")
    SelenideElement deleteUserbutton;
    
  /*  @FindBy(css = "#gwt-uid-5")
    SelenideElement passWordField;
    @FindBy(css = "#gwt-uid-7")
    SelenideElement firstNameField;
    @FindBy(css = "#gwt-uid-9")
    SelenideElement lastNameField;
    @FindBy(css = "#gwt-uid-11")
    SelenideElement phoneField;
    @FindBy(css = "#gwt-uid-13")
    SelenideElement userEmailField;
    
    */
    @FindBy(css = "#save-user-button")
    SelenideElement saveuserButton;
   
    @FindBy(css = "#edit-user")
    SelenideElement editUserButton;


    
    
   public String getdisplayName(String displayName) {
        return displayNameField.getText();
    }
 /*   public String getUserEmail(String useremail) {
        return userEmailField.getText();
    }*/
    public void clickEditUserButton() {
        clickButton("edit user button", editUserButton);
    }
    public void clickSaveUserButton() {
        clickButton("Save User Button", saveuserButton);
    }
    public void clickDeleteUserButton () {
        clickButton("delete User button", deleteUserbutton);
    }
    
}


