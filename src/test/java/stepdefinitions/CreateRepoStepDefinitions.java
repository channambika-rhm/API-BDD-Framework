package stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import pojo.GitHubCreateRepoPOJO;
import pojo.GitHubRepoResponseRootPOJO;
import utils.PojoHelper;

public class CreateRepoStepDefinitions {
	BaseUtils baseUtils;
	
	public CreateRepoStepDefinitions(BaseUtils utils) {
		this.baseUtils = utils;
	}
	
	@Given("body param from file {string}")
	public void bodyParamFromFile(String fileName) {
		String filePath = "src/test/resources/json-input/" + fileName;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			baseUtils.reqSpec.body(fis);
			baseUtils.reqSpec.contentType(ContentType.JSON);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Given("create repo with input keys {string} and values {string}")
	public void createRepoWithInputKeysAndValues(String keys, String values) {
		GitHubCreateRepoPOJO obj = PojoHelper.getGitHubCreateRepoPOJOObject(keys, values);
		baseUtils.reqSpec.body(obj);
		baseUtils.reqSpec.contentType(ContentType.JSON);
	}

	@When("I do POST request with URL {string}")
	public void iDoPOSTRequestWithURL(String url) {
		baseUtils.resSpec = baseUtils.reqSpec.when().log().all().post(url);
	}
	
	@Given("path param {string} with value {string}")
	public void pathParamWithValue(String paramName, String paramValue) {
//		baseUtils.reqSpec = RestAssured.given().pathParam(paramName,paramValue); //pathparam return type is RequestSpecification
		baseUtils.reqSpec.pathParam(paramName,paramValue);
	}
	
	@Then("validate create repo response {string} is {string}")
	public void validateCreateRepoResponseIs(String keys, String values) {
		GitHubRepoResponseRootPOJO obj = baseUtils.resSpec.then().extract().as(GitHubRepoResponseRootPOJO.class);
		PojoHelper.validateCreateRepo(obj, keys, values);
	}
}
