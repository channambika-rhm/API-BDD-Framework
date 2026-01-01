package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions {
	private boolean admin;
	private boolean maintain;
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isMaintain() {
		return maintain;
	}
	public void setMaintain(boolean maintain) {
		this.maintain = maintain;
	}

}
