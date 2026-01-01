package stepdefinitions;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import utils.GenericUtils;

public class BaseClass {
	BaseUtils baseUtils;
	static String url =null;

	public BaseClass(BaseUtils utils) {
		this.baseUtils = utils;
	}

	@BeforeAll
	public static void beforeAllScenarios() {
		System.out.println("--------Executes before any scenario--------");
		String envValue = GenericUtils.getPropertyValue("src/test/resources/global.properties", "ENV");
		url = GenericUtils.getPropertyValue("src/test/resources/"+envValue+".properties", "URL");
	}
	
	@Before
	public void beforeScenario() {
		// Header validation through response specification
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectHeader("Server", Matchers.equalTo("github.com"));
		builder.expectHeader("Content-Type", Matchers.equalTo("application/json; charset=utf-8"));
		
		RestAssured.responseSpecification = builder.build();
		RestAssured.baseURI = url;
		System.out.println("----------This executes before scenario----------");
		baseUtils.reqSpec = RestAssured.given();

		// Example: Connect to DB and get some info to use in the scenario
		// Example: Extract token from the response
		/*
		 * JsonPath jpath = RestAssured .given() .body("") .when() .post("") .then()
		 * .extract().jsonPath(); token = jPath.get("token");
		 */
	}

	@After
	public void afterScenario() {
		System.out.println("----------This executes after scenario----------");
		// Example: Connect to DB and check if data exists
	}

	@Before(value = "@smoke")
	public void beforeScenarioOne() {
		System.out.println("------------before scenario one------------");
	}

	@After(value = "@smoke")
	public void afterScenarioOne() {
		System.out.println("------------after scenario one------------");
	}
}
