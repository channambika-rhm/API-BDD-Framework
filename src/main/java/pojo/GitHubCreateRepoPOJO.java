package pojo; //should be under src/main/java since POJO classes considered to be part of development 

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubCreateRepoPOJO {
	private String name;
	private String description;
	private boolean privateVal;
	
	//----------getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean isPrivateVal() {
		return privateVal;
	}
	//----------setters
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty(value="private")
	public void setPrivateVal(boolean privateVal) {
		this.privateVal = privateVal;
	}

}
