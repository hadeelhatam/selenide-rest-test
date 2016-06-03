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
public class UserOperation {
    private static final String BASE_URL ="http://localhost:8080/librarytest/rest/";    
    private String jsonString = "";
    private Integer id; 
    private String displayName; 
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String role;

    public Response getUser(int id) {
        String resourceName = "User" +id;
        Response response = given().accept(ContentType.JSON).get(BASE_URL + resourceName);
        return response;
    }
    public Integer getId() { 
        return id; 
    } 
    public String prepareNewUserSpec() { 
        setId((Integer) new Random().nextInt(7000)); 
        displayName = UUID.randomUUID().toString();
        email = UUID.randomUUID().toString();
        firstName = UUID.randomUUID().toString();
        lastName = UUID.randomUUID().toString();
        password = UUID.randomUUID().toString();
        phone = UUID.randomUUID().toString();
        role = UUID.randomUUID().toString();
        String postBodyTemplate = ""+ 
                 "\"user\":\n" + 
                 "  {\n" + 
                 "    \"displayName\":\"%s\",\n" + 
                 "    \"email\":%s\n" + 
                 "    \"firstName\":\"%s\",\n" + 
                 "    \"lastName\":%s\n" + 
                 "    \"password\":\"%s\",\n" + 
                 "    \"phone\":%s\n" + 
                 "    \"role\":\"%s\",\n" + 
                 "  }"; 
            {
        String postBody = String.format(postBodyTemplate, displayName, email, firstName, lastName, password, phone, role, ""+id); 
        return postBody;         
        }
    } 

    public Response createRandomUser(){
        String resourceName = "user";
        String displayName1 = UUID.randomUUID().toString();
        String email1 = UUID.randomUUID().toString();
        String firstName1 = UUID.randomUUID().toString();
        String lastName1 = UUID.randomUUID().toString();
        String password1 = UUID.randomUUID().toString();
        String phone1 = UUID.randomUUID().toString();
        String role1 = UUID.randomUUID().toString();
        String postBodyTemplate =""
                +"\"user\":\n" 
                + "  {\n" 
                +"    \"displayName\":\"%s\",\n"  
                +"    \"email\":%s\n"  
                +"    \"firstName\":\"%s\",\n"  
                +"    \"lastName\":%s\n" 
                +"    \"password\":\"%s\",\n"  
                +"    \"phone\":%s\n"  
                +"    \"role\":\"%s\",\n"  
                +"  }"; 
        String postBody; 
        postBody = String.format(postBodyTemplate, displayName1, email1, firstName1, lastName1, password1, phone1, role1, "" +new Random());
        jsonString = postBody;
        Response postResponse = given() .contentType(ContentType.JSON) .body(postBody) .post(BASE_URL + resourceName);
        return postResponse;    
    }
    
    public String getLatestJsonString(){
        return jsonString;
    }
    
    public Response getAllUsers(){
        String resourceName = "users";
        Response getResponse = given() .accept(ContentType.JSON) .get(BASE_URL + resourceName).prettyPeek();
        return getResponse;    
    }
  
    public Response deleteUser(int id){
        String deleteResourceName = "users/"+ id;
        Response deleteResponse =  given().delete(BASE_URL + deleteResourceName);
        return deleteResponse;  
    }
    public String getdisplayName() { 
        return displayName; 
    } 
    public void setdisplayName(String displayName) { 
        this.displayName = displayName; 
    }
    public String getdemail() { 
        return email; 
    } 
    public void setemail(String email) { 
        this.email = email; 
    }
    public String getfirstName() { 
        return firstName; 
    } 
    public void setfirstName(String firstName) { 
        this.firstName = firstName; 
    }
    public String getlastName() { 
        return lastName; 
    } 
    public void setlastName(String lastName) { 
        this.lastName = lastName; 
    }
    public String getpassword() { 
        return password; 
    } 
    public void setpassword(String password) { 
        this.password = password; 
    }
    public String getphone() { 
        return phone; 
    } 
    public void setphone(String phone) { 
        this.phone = phone; 
    }
    public String getrole() { 
        return role; 
    } 
    public void setrole(String role) { 
        this.role = role; 
    }
   
    public Response createNewUserTemplate(String nameTemplate, Integer idTemplate) {  
        String resourseName="users";  
        String postBodyTemplate = ""
                +"\"user\":\n" 
                + "  {\n" 
                +"    \"displayName\":\"%s\",\n"  
                +"    \"email\":%s\n"  
                +"    \"firstName\":\"%s\",\n"  
                +"    \"lastName\":%s\n" 
                +"    \"password\":\"%s\",\n"  
                +"    \"phone\":%s\n"  
                +"    \"role\":\"%s\",\n"  
                +"  }"; 
        String postBody = String.format(postBodyTemplate, nameTemplate, ""+idTemplate);  
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName).prettyPeek();   
        System.out.println("Status code: " + postResponse.getStatusCode());  
        return postResponse;          
    }  

 
    public Response createNewUser() {  
        String resourseName="users";  
        String postBody = prepareNewUserRandom();  
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName).prettyPeek();  
        System.out.println("Status code: " + postResponse.getStatusCode());  
        return postResponse;          
  
    }  
    public String prepareNewUserRandom() {  
        displayName = UUID.randomUUID().toString();
        email = UUID.randomUUID().toString();
        firstName = UUID.randomUUID().toString();
        lastName = UUID.randomUUID().toString();
        password = UUID.randomUUID().toString();
        phone = UUID.randomUUID().toString();
        role = UUID.randomUUID().toString();
        setId((Integer) new Random().nextInt(6000));  
        String postBodyTemplate = ""
                +"\"user\":\n" 
                + "  {\n" 
                +"    \"displayName\":\"%s\",\n"  
                +"    \"email\":%s\n"  
                +"    \"firstName\":\"%s\",\n"  
                +"    \"lastName\":%s\n" 
                +"    \"password\":\"%s\",\n"  
                +"    \"phone\":%s\n"  
                +"    \"role\":\"%s\",\n"  
                +"  }"; 
       
        String postBody = String.format(postBodyTemplate, displayName, email, firstName, lastName, password, phone, role, "" +id);
        return postBody;          
    }  

    public void setId(Integer id) { 
       this.id = id; 
    } 

    public Response addbooksBookidUsers (Integer bookId) { 
         //books/{book_id}/authors 
         String resourseName="users"; 
         String resourseName1="books/"; 
       //  name = UUID.randomUUID().toString(); 
        displayName = UUID.randomUUID().toString();
        email = UUID.randomUUID().toString();
        firstName = UUID.randomUUID().toString();
        lastName = UUID.randomUUID().toString();
        password = UUID.randomUUID().toString();
        phone = UUID.randomUUID().toString();
        role = UUID.randomUUID().toString();
        setId((Integer) new Random().nextInt(5000)); 
 
        String postBodyTemplate = ""
                +"\"user\":\n" 
                + "  {\n" 
                +"    \"displayName\":\"%s\",\n"  
                +"    \"email\":%s\n"  
                +"    \"firstName\":\"%s\",\n"  
                +"    \"lastName\":%s\n" 
                +"    \"password\":\"%s\",\n"  
                +"    \"phone\":%s\n"  
                +"    \"role\":\"%s\",\n"  
                +"  }"; 
        String postBody = String.format(postBodyTemplate, displayName, email, firstName, lastName, password, phone, role, "" +id);
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
                
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/users"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
    public Response addAdditionalUserAlreadyUsedToBookN(Integer bookId) { 
        String resourseName="users"; 
        String resourseName1="books/"; 
        displayName = UUID.randomUUID().toString();
        email = UUID.randomUUID().toString();
        firstName = UUID.randomUUID().toString();
        lastName = UUID.randomUUID().toString();
        password = UUID.randomUUID().toString();
        phone = UUID.randomUUID().toString();
        role = UUID.randomUUID().toString();
        //name = UUID.randomUUID().toString(); 
        setId((Integer) new Random().nextInt(5000)); 
        String postBodyTemplate = ""
                 +"\"user\":\n" 
                + "  {\n" 
                +"    \"displayName\":\"%s\",\n"  
                +"    \"email\":%s\n"  
                +"    \"firstName\":\"%s\",\n"  
                +"    \"lastName\":%s\n" 
                +"    \"password\":\"%s\",\n"  
                +"    \"phone\":%s\n"  
                +"    \"role\":\"%s\",\n"  
                +"  }"; 
        String postBody = String.format(postBodyTemplate, displayName, email, firstName, lastName, password, phone, role, "" +id);
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
                  
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/users"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
          
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/users"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
    
    public String addbooksBookidUsers() {//add Additional Author Without Id Template 
        //books/{book_id}/authors 
        String resourseName="users"; 
        displayName = UUID.randomUUID().toString();
        email = UUID.randomUUID().toString();
        firstName = UUID.randomUUID().toString();
        lastName = UUID.randomUUID().toString();
        password = UUID.randomUUID().toString();
        phone = UUID.randomUUID().toString();
        role = UUID.randomUUID().toString();
        String postBodyTemplate = ""
                +"\"user\":\n" 
                + "  {\n" 
                +"    \"displayName\":\"%s\",\n"  
                +"    \"email\":%s\n"  
                +"    \"firstName\":\"%s\",\n"  
                +"    \"lastName\":%s\n" 
                +"    \"password\":\"%s\",\n"  
                +"    \"phone\":%s\n"  
                +"    \"role\":\"%s\",\n"  
                +"  }"; 
        String postBody = String.format(postBodyTemplate, displayName, email, firstName, lastName, password, phone, role);
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postBody;        
    }

 public Response addAdditionalUserWithoutIdToBookN(Integer bookId) { 
        //books/{book_id}/users 
        String resourseName1="books/"; 
        String postBody = addbooksBookidUsers (); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/users"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
   } 
}
   
