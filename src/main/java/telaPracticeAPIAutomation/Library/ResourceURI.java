package telaPracticeAPIAutomation.Library;

public enum ResourceURI {
	CREATE_USER("/users/{{id}}"),
	Provider_Admin_Login("/user/auth/token"),
	RA_Logout("/user/auth/logout"),
	RA_Forget("/user/send-forgot-password-email"),
	RA_SetPass("/user/set-password"),
	RA_CreateEnterprise("/admin/enterprise"),
	CreatePatient("/patient"),
	Update_Patient("/patient"),
	GetAll_Patient("/patient");
	
	
	String uri;
	ResourceURI(String uri)
	{
		this.uri = uri;
	}
	
	
	public String getUri()
	{
		return this.uri;
	}

}
