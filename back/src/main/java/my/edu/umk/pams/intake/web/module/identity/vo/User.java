package my.edu.umk.pams.intake.web.module.identity.vo;

/**
 * @author PAMS
 */
public class User extends Principal {

    private String email;
    private String password;
    private String realName;
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
