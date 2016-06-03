/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.selenide.rest.test;

//package se.nackademin.rest.test;

import static com.codeborne.selenide.Condition.name;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
//import static groovy.xml.dom.DOMCategory.name;
import java.util.Random;
import java.util.UUID;
//import static org.apache.http.client.methods.RequestBuilder.delete;


public class AuthorOperations {
    private static final String BASE_URL ="http://localhost:8080/librarytest/rest/";    
    private String jsonString = "";
    private Integer id; 
    private String firstName;
    private String lastName;
    private String country;
    private String bio;

    public Response getAuthor(int id) {
        String resourceName = "authors" +id;
        Response response = given().accept(ContentType.JSON).get(BASE_URL + resourceName);
        return response;
    }
    public Integer getId() { 
        return id; 
    } 
    public String prepareNewAuthorSpec() { 
        setId((Integer) new Random().nextInt(7000)); 
        firstName = UUID.randomUUID().toString(); 
        lastName = UUID.randomUUID().toString(); 
        country = UUID.randomUUID().toString(); 
        bio = UUID.randomUUID().toString(); 
        String postBodyTemplate = "" 
                + "\"author\":\n"  
                +"   {\n"  
                + "  \"bio\":\"%s\",\n"
                +"  \"country\":\"%s\",\n"
                +"  \"firstName\":\"%s\",\n"
                +"  \"lastName\":\"%s\",\n"
                +"  }\n"
                +"  }"; 
                
               
        String postBody = String.format(postBodyTemplate, firstName, ""+id, ""+lastName, ""+country, ""+bio); 
        return postBody;         
  } 

    
    public Response createRandomAuthor(){
        String resourceName = "authors";
        //String name1 = UUID.randomUUID().toString();
        String firstName1 = UUID.randomUUID().toString(); 
        String lastName1 = UUID.randomUUID().toString(); 
        String country1 = UUID.randomUUID().toString(); 
        String  bio1 = UUID.randomUUID().toString();
        String postBodyTemplate =""
                +"  {\n"
                +"  \"author\":\n"
                +"  {\n"
                +"  \"bio\":\"%s\",\n"
                +"  }\n"
                +"  \"country\":\"%s\",\n"
                +"  }\n"
                +"  \"firstName\":\"%s\",\n"
                +"  }\n"
                +"  \"lastName\":\"%s\",\n"
                +"  }\n"
                +"  }";
        String postBody; 
        postBody = String.format(postBodyTemplate, firstName1, "" +new Random(),lastName1, "" +new Random(),bio, "" +new Random(),country, ""+new Random());
        jsonString = postBody;
        Response postResponse = given() .contentType(ContentType.JSON) .body(postBody) .post(BASE_URL + resourceName);
        return postResponse;    
    }
    
    public String getLatestJsonString(){
        return jsonString;
    }
    
    public Response getAllAuthors(){
        String resourceName = "authors";
        Response getResponse = given() .accept(ContentType.JSON) .get(BASE_URL + resourceName).prettyPeek();
        return getResponse;    
    }
  
    public Response deleteAuthor(int id){
        String deleteResourceName = "authors/"+ id;
        Response deleteResponse =  given().delete(BASE_URL + deleteResourceName);
        return deleteResponse;  
    }
    public String getFirstName() { 
        return firstName; 
    } 
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    } 
    public String getLasttName() { 
        return lastName; 
    } 
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    } 
   public String getBio() { 
        return bio; 
    } 
    public void setBio(String bio) { 
        this.bio = bio; 
    } 
    public String getCountry() { 
        return country; 
    } 
    public void setCountry(String country) { 
        this.country = country; 
    } 
    
    public Response createNewAuthorTemplate(String nameTemplate, Integer idTemplate) {  
        String resourseName="authors";  
        String postBodyTemplate = ""+"{\n" +  
                 "\"author\":\n"   
                +"  {\n"   
                +"  \"bio\":\"%s\",\n"
                +"  \"country\":\"%s\",\n"
                +"  \"firstName\":\"%s\",\n"
                +"  \"lastName\":\"%s\",\n"
                +"  }\n"
                +"  }";
               
        String postBody = String.format(postBodyTemplate, nameTemplate, ""+idTemplate);  
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName).prettyPeek();   
        System.out.println("Status code: " + postResponse.getStatusCode());  
        return postResponse;          
   
    }  

 
    public Response createNewAuthor() {  
        String resourseName="authors";  
        String postBody = prepareNewAuthorRandom();  
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName).prettyPeek();  
        System.out.println("Status code: " + postResponse.getStatusCode());  
        return postResponse;          
  
    }  
    public String prepareNewAuthorRandom() {  
        //String resourseName="authors";  
        //name = UUID.randomUUID().toString();  
        firstName = UUID.randomUUID().toString(); 
        lastName = UUID.randomUUID().toString(); 
        country = UUID.randomUUID().toString(); 
        bio = UUID.randomUUID().toString(); 
        setId((Integer) new Random().nextInt(6000));  
        String postBodyTemplate = ""+"{\n" +  
                "\"author\":\n"   
                +"  {\n"   
                +"  \"bio\":\"%s\",\n"
                +"  \"country\":\"%s\",\n"
                +"  \"firstName\":\"%s\",\n"
                +"  \"lastName\":\"%s\",\n"
                +"  }\n"
                +"  }";
               
        String postBody = String.format(postBodyTemplate, firstName,lastName,country,bio, ""+id);  
        return postBody;          
    }  

    public void setId(Integer id) { 
       this.id = id; 
    } 

    public Response addbooksBookidAuthors (Integer bookId) { 
         //books/{book_id}/authors 
         String resourseName="authors"; 
         String resourseName1="books/"; 
       //  name = UUID.randomUUID().toString(); 
        firstName = UUID.randomUUID().toString(); 
        lastName = UUID.randomUUID().toString(); 
        country = UUID.randomUUID().toString(); 
        bio = UUID.randomUUID().toString(); 
        setId((Integer) new Random().nextInt(5000)); 
 
 
        String postBodyTemplate = ""+"{\n" + 
                "\"author\":\n" + 
                "  {\n" 
                +"  \"bio\":\"%s\",\n"
                +"  \"country\":\"%s\",\n"
                +"  \"firstName\":\"%s\",\n"
                +"  \"lastName\":\"%s\",\n"
                +"  }\n"
                +"  }";
                        
        String postBody = String.format(postBodyTemplate, firstName,lastName,country,bio, ""+id); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
                
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
    
    public Response addAdditionalAuthorAlreadyUsedToBookN(Integer bookId) { 
        String resourseName="authors"; 
        String resourseName1="books/"; 
        //name = UUID.randomUUID().toString(); 
        firstName = UUID.randomUUID().toString(); 
        lastName = UUID.randomUUID().toString(); 
        country = UUID.randomUUID().toString(); 
        bio = UUID.randomUUID().toString(); 
        setId((Integer) new Random().nextInt(5000)); 
        String postBodyTemplate = ""+"{\n" + 
                "\"author\":\n" + 
                "  {\n" + 
                "  \"bio\":\"%s\",\n"
                +"  \"country\":\"%s\",\n"
                +"  \"firstName\":\"%s\",\n"
                +"  \"lastName\":\"%s\",\n"
                +"  }\n"
                +"  }";
                          
        String postBody = String.format(postBodyTemplate,firstName,lastName,country,bio, ""+id); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
                  
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
          
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
    
    public String addbooksBookidAuthors() {//add Additional Author Without Id Template 
        //books/{book_id}/authors 
        String resourseName="authors"; 
        firstName = UUID.randomUUID().toString(); 
        lastName = UUID.randomUUID().toString(); 
        country = UUID.randomUUID().toString(); 
        bio = UUID.randomUUID().toString(); 
        String postBodyTemplate = ""+"{\n" + 
                 "\"author\":\n" + 
                 "  {\n" + 
                 "    \"firstName\":\"%s\"\n" + 
                 "    \"lastName\":\"%s\"\n" + 
                 "  }\n" + 
                 "}"; 
        String postBody = String.format(postBodyTemplate, firstName, lastName); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postBody;        
    }

    public Response addAdditionalAuthorWithoutIdToBookN(Integer bookId) { 
        //books/{book_id}/authors 
        String resourseName1="books/"; 
        String postBody = addbooksBookidAuthors (); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
}

