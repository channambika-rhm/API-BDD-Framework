@POST
Feature: Create organization repositories Endpoint Scenarios
  This feature file has both positive and negative scenarios for POST create organization repositories endpoint

#	Background:
#		Given input is ""
#		When I do post request with url ""
#		Then extract token from response

	
  Scenario: Create repo with json file input    
    Given Header "Authorization" with value "Bearer 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"
    And path param "org" with value "orgchandra"
    And body param from file "createrepo.json"
    When I do POST request with URL "orgs/{org}/repos"
    Then validate status code is 201
    
 	@current
  Scenario: Create repo with serialization
    Given path param "org" with value "orgchandra"
    And Header "Authorization" with value "Bearer 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"
    And create repo with input keys "name,description,private" and values "repo_23_mar_01,This is a repo,true"
    When I do POST request with URL "orgs/{org}/repos"
    Then validate status code is 201
    And validate response "name" is "repo_23_mar_01"
    And validate create repo response "name,description,private" is "repo_23_mar_01,This is a repo,true"
    
    
    
    
    