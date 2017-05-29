package my.edu.umk.pams.intake.application.model;

public interface InIeltsResult extends InResult{

	void setYear(int year);

	int getYear();

	String getRegistrationNo();

	void setRegistrationNo(String registrationNo);

	Integer getPoint();

	void setPoint(Integer point);

	

}
