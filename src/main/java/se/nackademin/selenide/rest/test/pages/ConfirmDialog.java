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
public class ConfirmDialog extends MenuPage {
    @FindBy (css = "#confirmdialog-ok-button")
    SelenideElement confirmDialogOkButton;

    @FindBy (css = "#confirmdialog-cancel-button")
    SelenideElement confirmDialogCancelButton;

    public void clickYesButton() {
        clickButton("click Yes button", confirmDialogOkButton);
    }
   
    
}


