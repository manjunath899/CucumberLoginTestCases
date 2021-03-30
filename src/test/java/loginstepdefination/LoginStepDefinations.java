package loginstepdefination;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginStepDefinations {
	
	
	private  static  final  String  BASE_URL  =  "https://www.login.com";
	String email = "hello@xxx.com";
	String password = "123";
	private RequestSpecification request;
	private  static  Response response;
	private  static  String  jsonString;

    @Given("Post Login API ")
    public void post_login_api() {
	    RestAssured.baseURI  =  BASE_URL;
		request  =  RestAssured.given();
		request.header("Content-Type",  "application/json");    
    }
    
   @When("Provide Valid Credential")
    public void provide_valid_credential() {
      response  =  request.body("{ \"userName\":\""  +  email  +  "\", \"password\":\""  +  password  +  "\"}")
						  .post("/user/login");	
    }

   @Then("Status_code equals {int}")
    public void statuscode_equals_(int agr) {
	    Assert.assertEquals(agr, response.getStatusCode());
    }
	
	@And("response contains IsPosted equals {string}")
    public void response_contains_IsPosted_equals_(String message) {
	    Assert.assertEquals(message, getJsonPath(response, "IsPosted"));
    }	

   @And("response contains message equals {string}")
    public void response_contains_equals_(String message) {
	    Assert.assertEquals(message, getJsonPath(response, "message"));
    }
    
	@When("Provide different combinations to {string}, {string}")
    public void provide_different_combinations_to_somethingsomething(String email, String password){
	    response = request.body("{ \"userName\":\"" + email + "\", \"password\":\"" + password + "\"}") .post("/user/login");
    }

	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}


}
