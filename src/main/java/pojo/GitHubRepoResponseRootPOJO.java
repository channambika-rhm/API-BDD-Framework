package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepoResponseRootPOJO {

	private int id;
	private String name;
	private String full_name;
	private boolean privateVal;
	Owner OwnerObject;
	private String description = null;
	Permissions PermissionsObject;
	Organization OrganizationObject;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public boolean isPrivateVal() {
		return privateVal;
	}
	public void setPrivateVal(boolean privateVal) {
		this.privateVal = privateVal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
