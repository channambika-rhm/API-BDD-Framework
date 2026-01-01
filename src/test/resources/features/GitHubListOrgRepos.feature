@GET
Feature: List organization repositories Endpoint Scenarios
  This feature file has both positive and negative scenarios for List organization repositories GET endpoint

	@smoke
	Scenario: Fetch all public repos for org
    Given path param "org" with value "orgchandra"
		When I do GET request with URL "orgs/{org}/repos"
		Then validate status code is 200
		
	@p2
	Scenario: Fetch all public repos for invalid org
    Given path param "org" with value "asdfdas"
		When I do GET request with URL "orgs/{org}/repos"
		Then validate status code is 404
		
	@p1	
	Scenario: Fetch all public repos for org with per page query param
		Given path param "org" with value "orgchandra"
		And query param "per_page" with value "1"
		When I do GET request with URL "orgs/{org}/repos"
		Then validate status code is 200
		
	@p1	
	Scenario: Fetch all private repos for org with type query param without token
		Given path param "org" with value "orgchandra"
		And query param "type" with value "private"
		When I do GET request with URL "orgs/{org}/repos"
		Then validate status code is 200
		
	@smoke
	Scenario: Fetch all private repos for valid org with token
    Given path param "org" with value "orgchandra"
    And query param "type" with value "private"
    And Header "Authorization" with value "Bearer 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"
		When I do GET request with URL "orgs/{org}/repos"
		Then validate status code is 200	
		
	
	Scenario Outline: Fetch all public and private repos for valid org with examples
    Given path param "org" with value "<orgName>"
    And Header "Authorization" with value "<token>"
    And query param "type" with value "<type>"
		When I do GET request with URL "orgs/{org}/repos"
		Then validate status code is <statusCode>		
		
	Examples:
	|orgName|token|statusCode|type|
	|orgchandra|Bearer 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|200|public|
	|asdfasdfasd|Bearer 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|404|public|
	|orgchandra|Bearer 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|200|private|
	