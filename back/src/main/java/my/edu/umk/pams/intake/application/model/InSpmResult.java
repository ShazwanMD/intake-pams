package my.edu.umk.pams.intake.application.model;

/**
 * @author PAMS
 */
public interface InSpmResult extends InResult {

    Integer getYear();

    void setYear(Integer year);

    Integer getAggregate();

    void setAggregate(Integer aggregate);

	void SetMalay(String malay);

	String getMalay();

	String getEnglish();

	void SetEnglish(String english);

	String getMath();

	void setMath(String math);

	void setAddmath(String addMath);

	String getAddMath();

	void setIslamEduc(String islamEduc);

	String getIslamEduc();

	void setChemist(String chemist);

	String getChemist();

	void setPhysic(String physic);

	String getPhysic();

	void setBiology(String bio);

	String getBiology();

	void setHistory(String history);

	String getHistory();

	


	
}
