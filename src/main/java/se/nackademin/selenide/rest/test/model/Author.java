/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package se.nackademin.librarytest.model;

/**
 *
 * @author alhasan
 */
public class Author {
    private String firstname;
    private String lastname;
    private String country;
    private String biography;
    
    public String getFirstName() {
        return firstname;
    }
    
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
   
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getBiography() {
        return biography;
    }

    public void setBiography(String country) {
        this.country = biography;
    }

}


