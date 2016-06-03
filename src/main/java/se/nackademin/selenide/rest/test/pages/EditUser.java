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
public class EditUser extends MenuPage {
    @FindBy(css = "#gwt-uid-3")
    SelenideElement displayNameField;
    @FindBy(css = "#gwt-uid-5")
    SelenideElement passWordField;
    @FindBy(css = "#gwt-uid-7")
    SelenideElement firstNameField;
    @FindBy(css = "#gwt-uid-9")
    SelenideElement lastNameField;
    @FindBy(css = "#gwt-uid-11")
    SelenideElement phoneField;
    @FindBy(css = "#gwt-uid-13")
    SelenideElement userEmailField;
    @FindBy(css = "#save-user-button")
    SelenideElement saveuserButton;
    @FindBy(css = "#gwt-uid-17")
    SelenideElement LoanerRadioButton;
    @FindBy(css = "#gwt-uid-16")
    SelenideElement LibrRadioButton;
       
    public String getdisplayName() {
        return displayNameField.getText();
    }
    public String getpassWord() {
        return passWordField.getText();
    }
    public String getfirstName() {
        return firstNameField.getText();
    }
    public String getlastName() {
        return lastNameField.getText();
    }
    public String getphone() {
        return  phoneField.getText();
    }
    
    public String getUserEmail(String useremail) {
        return userEmailField.getText();
    }
    public void clickSaveUserButton() {
        saveuserButton.click();
    }
  
   
    public void newUsersDisplayName(String newDisplayName) { 
        setTextFieldValue("display name", newDisplayName, displayNameField);        
    } 
    public void newPassword(String newPassword) { 
        setTextFieldValue("password", newPassword, passWordField);        
    } 
    public void newEmail(String newEmail) { 
         setTextFieldValue("email field", newEmail, userEmailField);         
    } 
    public void newUsersFirstName(String newFirstName) { 
         setTextFieldValue("first name", newFirstName, firstNameField);        
    }    
    public void newUsersLastName(String newLastName) { 
         setTextFieldValue("last name", newLastName, lastNameField);         
    }    
     public void newPhone(String newPhone) { 
         setTextFieldValue("phone", newPhone, phoneField);         
    }    
}