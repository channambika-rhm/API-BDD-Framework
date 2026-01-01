package demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {
	public static void main(String[] args) {
		RestAssured
			.given().pathParam("org","orgchannambikab110")
			.when().log().all().get("https://api.github.com/orgs/{org}/repos")
			.then().statusCode(200);
		
		System.out.println("------------------------------------------------------");
		
		RequestSpecification req = RestAssured.given().pathParam("org","orgchannambikab110");
		Response res = req.when().log().all().get("https://api.github.com/orgs/{org}/repos");
		res.then().statusCode(200);
	}

}
