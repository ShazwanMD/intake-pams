package my.edu.umk.pams.intake.web.module.account.vo;

import my.edu.umk.pams.intake.web.module.common.vo.CountryCode;
import my.edu.umk.pams.intake.web.module.common.vo.StateCode;

/**
 */
public class AddressChange {
    private String currentAddress;
    private String newAddress1;
    private String newAddress2;
    private String newAddress3;
    private String newPostcode;
    private StateCode mailingStateCode;
    private CountryCode mailingCountryCode;
    
    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getNewAddress1() {
        return newAddress1;
    }

    public void setNewAddress1(String newAddress1) {
        this.newAddress1 = newAddress1;
    }
    
    public String getNewAddress2() {
		return newAddress2;
	}

	public void setNewAddress2(String newAddress2) {
		this.newAddress2 = newAddress2;
	}
    
    public String getNewAddress3() {
        return newAddress3;
    }

    public void setNewAddress3(String newAddress3) {
        this.newAddress3 = newAddress3;
    }

//	public String getNewCountryCode() {
//		return newCountryCode;
//	}
//
//	public void setNewCountryCode(String newCountryCode) {
//		this.newCountryCode = newCountryCode;
//	}
//
//	public String getNewStateCode() {
//		return newStateCode;
//	}
//
//	public void setNewStateCode(String newStateCode) {
//		this.newStateCode = newStateCode;
//	}

	public String getNewPostcode() {
		return newPostcode;
	}

	public void setNewPostcode(String newPostcode) {
		this.newPostcode = newPostcode;
	}

	public StateCode getMailingStateCode() {
		// TODO Auto-generated method stub
		return mailingStateCode;
	}

	public CountryCode getMailingCountryCode() {
		// TODO Auto-generated method stub
		return mailingCountryCode;
	}
	
}
