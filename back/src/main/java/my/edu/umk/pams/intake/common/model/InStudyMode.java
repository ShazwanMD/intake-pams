package my.edu.umk.pams.intake.common.model;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * STUDY MODE :-
 * UNDECIDED
 * FULL-TIME
 * PART-TIME
 *
 */
public interface InStudyMode extends InMetaObject{

    String getCode();

    void setCode(String code);

    String getDescriptionMs();

    void setDescriptionMs(String descriptionMs);

	String getDescriptionEn();

	void setDescriptionEn(String descriptionEn);

	String getPrefix();

	void setPrefix(String prefix);
}
