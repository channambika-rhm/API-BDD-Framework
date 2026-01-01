package utils;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import pojo.GitHubCreateRepoPOJO;
import pojo.GitHubRepoResponseRootPOJO;

public class PojoHelper {
	
	public static GitHubCreateRepoPOJO getGitHubCreateRepoPOJOObject(String keys, String values) {
		GitHubCreateRepoPOJO obj = new GitHubCreateRepoPOJO();
		String[] inputKeys = keys.split(",");
		String[] inputValues = values.split(",");
		for(int i=0;i<inputKeys.length;i++) {
			System.out.println(inputKeys[i]);
			System.out.println(inputValues[i]);	
			
			if(inputKeys[i].equalsIgnoreCase("name")) {
				obj.setName(inputValues[i]);
			} else if(inputKeys[i].equalsIgnoreCase("description")) {
				obj.setDescription(inputValues[i]);
			} else if(inputKeys[i].equalsIgnoreCase("private")) {
				String privateVal = inputValues[i];
				obj.setPrivateVal(Boolean.valueOf(privateVal));
			}
		}
		return obj;
	}
	
	public static void validateCreateRepo(GitHubRepoResponseRootPOJO obj,String keys, String values) {
		String[] inputKeys = keys.split(",");
		String[] inputValues = values.split(",");
		for(int i=0;i<inputKeys.length;i++) {
			System.out.println(inputKeys[i]);
			System.out.println(inputValues[i]);	
			
			if(inputKeys[i].equalsIgnoreCase("name")) {
				String actualName = obj.getName();
				MatcherAssert.assertThat(actualName, Matchers.equalTo(inputValues[i]));
			} else if(inputKeys[i].equalsIgnoreCase("description")) {
				String actualDescription = obj.getDescription();
				MatcherAssert.assertThat(actualDescription, Matchers.equalTo(inputValues[i]));
			} else if(inputKeys[i].equalsIgnoreCase("private")) {
				boolean actualPrivateVal = obj.isPrivateVal();
				MatcherAssert.assertThat(actualPrivateVal, Matchers.equalTo(Boolean.valueOf(inputValues[i])));
			}
		}
	}

}
