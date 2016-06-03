/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author alhasan
 */
public class LoanOperations {
  private static final String BASE_URL ="http://localhost:8080/librarytest/rest/";    
    private String jsonString = "";
    private Integer id;
    private Integer idb;
    private String book;
    private String user ;
    private String dateBorrowed;
    private String dateDue ; 
    private String displayName;
    private String title; 
    
    public Response getLoan(int id) {
        String resourceName = "loans" +id;
        Response response = given().accept(ContentType.JSON).get(BASE_URL + resourceName);
        return response;
    }
  
    public Integer getId() { 
         return id; 
    } 
  
    public Response get(int id) { 
        String resourseName="loans/"+id; 
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+resourseName); 
        System.out.println("Status code: " + getResponse.getStatusCode()); 
        return getResponse;                
    } 
    
    public Response getLoansloanidUsers(Integer loanId) { 
        ///loans/{loan_id}/users 
        String resourceName = "loans/"+ loanId; 
        Response response = given().accept(ContentType.JSON).get(BASE_URL+resourceName+"/users").prettyPeek(); 
        return response; 
    }
    public Response getLoansUser(Integer userId) { 
        ///loans/ofuser/{user_id} 
        String resourceName = "loans/ofuser/"+ userId; 
        Response response = given().accept(ContentType.JSON).get(BASE_URL+resourceName).prettyPeek(); 
        return response; 
    } 
    public Response createRandomLoan(){
        String resourceName = "loans";
        title = UUID.randomUUID().toString();  
        book = UUID.randomUUID().toString();  
        dateBorrowed = UUID.randomUUID().toString();  
        dateDue = UUID.randomUUID().toString();
        idb = new Random().nextInt(6000);  
        id = new Random().nextInt(6000);  
        user = UUID.randomUUID().toString();        
        displayName = UUID.randomUUID().toString(); 
        String postBodyTemplate =""
                +"  {\n"
                +"     \"loan\":\n"
                +"     {\n"
                +"        \"book\":\n"
                +"           {\n"
                +"              \"idb\":\"%s\",\n"
                +"              \"title\":\"%s\",\n"
                +"           }\n"
                +"           \"dateBorrowed\":\"%s\",\n"
                +"           \"dateDue\":\"%s\",\n"
                +"           \"user\":\"%s\",\n"
                +"              {\n"
                +"                 \"id\":\"%s\",\n"
                +"                 \"displayName\":\"%s\",\n"
                +"              }\n"
                +"           }\n"
                +"     }\n"
                +"  }";
        
        String postBody = String.format(postBodyTemplate,idb, title, dateBorrowed, dateDue, user, id, displayName); 
        jsonString = postBody;
        Response postResponse = given() .contentType(ContentType.JSON) .body(postBody) .post(BASE_URL + resourceName);
        return postResponse;    
    }
   
    public String createRandomLoanTemplate(String templateUser) {  
        title = UUID.randomUUID().toString();  
        book = UUID.randomUUID().toString();  
        dateBorrowed = UUID.randomUUID().toString();  
        dateDue = UUID.randomUUID().toString();
        idb = new Random().nextInt(6000);  
        id = new Random().nextInt(6000);  
        user = UUID.randomUUID().toString();        
        displayName = UUID.randomUUID().toString(); 
        String postBodyTemplate = ""  
                       +"  {\n"
                +"     \"loan\":\n"
                +"     {\n"
                +"        \"book\":\n"
                +"           {\n"
                +"              \"idb\":\"%s\",\n"
                +"              \"title\":\"%s\",\n"
                +"           }\n"
                +"           \"dateBorrowed\":\"%s\",\n"
                +"           \"dateDue\":\"%s\",\n"
                +"           \"user\":\"%s\",\n"
                +"              {\n"
                +"                 \"id\":\"%s\",\n"
                +"                 \"displayName\":\"%s\",\n"
                +"              }\n"
                +"           }\n"
                +"     }\n"
                +"  }";
        String postBody = String.format(postBodyTemplate,idb, title, dateBorrowed, dateDue, user, id, displayName, ""+getId()); 
        return postBody;   
    }  

  public Response createLoan(String loanTemplate) {  
       String resourseName="loans";  
       Response postResponse = given().contentType(ContentType.JSON).body(loanTemplate).post(BASE_URL + resourseName);  
       System.out.println("Status code: " + postResponse.getStatusCode());  
       return postResponse;          
    }  

/* public Response put(String booksTemplate) {  
        String resourseName="books";  
        Response putResponse = given().contentType(ContentType.JSON).body(booksTemplate).put(BASE_URL + resourseName);  
        System.out.println("Status code: " + putResponse.getStatusCode());  
        return putResponse;              
    }  
  */ 
    public String getLatestJsonString(){
        return jsonString;
    }
    public Response getAllLoans(){
    String resourceName = "loans";
    Response getResponse = given() .accept(ContentType.JSON) .get(BASE_URL + resourceName).prettyPeek();
    return getResponse;    
    }
  
    public Response deleteLoan(int id){
    String deleteResourceName = "loans/"+ id;
    Response deleteResponse =  given().delete(BASE_URL + deleteResourceName);
    return deleteResponse;  
    }

}

  
