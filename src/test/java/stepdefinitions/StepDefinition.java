package stepdefinitions;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import pojo.GitHubCreateRepoPOJO;
//import utils.PojoHelper;

public class StepDefinition {

	String token;
	BaseUtils baseUtils;
	
	//picocontainer creates object and injects to different classes through constructor
	//using constructor, we are injecting dependency(BaseUtils) 
	//by passing object of common class which has all the required variables as parameter to the constructor into the class "StepDefinition"
	public StepDefinition(BaseUtils utils) { //constructor based dependency injection using picocontainer
		this.baseUtils = utils;
	}
	
	@Given("input is {string}") //runs from Background part of Feature file same as Before hook
	public void inputIs(String string) {
//		baseUtils.reqSpec = RestAssured.given();
		System.out.println("------from background Given------");
	}
	
	@Then("extract token with response")
	public void extractTokenWithResponse() {
		System.out.println("------from background Then------");
	}

//	@Given("path param {string} with value {string}")
//	public void pathParamWithValue(String paramName, String paramValue) {
////		baseUtils.reqSpec = RestAssured.given().pathParam(paramName,paramValue); //pathparam return type is RequestSpecification
//		baseUtils.reqSpec.pathParam(paramName,paramValue);
//	}
	
	@Given("query param {string} with value {string}")
	public void queryParamWithValue(String queryParamName, String queryParamValue) {
		baseUtils.reqSpec.queryParam(queryParamName, queryParamValue);
	}
	
	@Given("Header {string} with value {string}")
	public void header_with_value(String headerName, String headerValue) {
		baseUtils.reqSpec.header(headerName, headerValue);
	}
	
	@When("I do GET request with URL {string}")
	public void iDoGETRequestWithURL(String url) {
		baseUtils.resSpec = baseUtils.reqSpec.when().log().all().get(url); //get request return type is Response
	}
	
	@Then("validate status code is {int}")
	public void validateStatusCodeIs(Integer statusCode) {
		baseUtils.resSpec.then().statusCode(statusCode);
	}

	@Then("validate response {string} is {string}")
	public void validateNameIs(String key, String expName) {
		//JsonPath body validation
		JsonPath jpath = baseUtils.resSpec.then().extract().jsonPath();
		String actualName = jpath.getString(key);
		MatcherAssert.assertThat(actualName, Matchers.equalTo(expName));
		
		//Inline body validation
		baseUtils.resSpec.then().body(key, Matchers.equalTo(expName));
	}



}
