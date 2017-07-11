package my.edu.umk.pams.intake.identity.model;

import my.edu.umk.pams.intake.application.model.InRefereeType;

/**
 * @author canang.technologies
 */
public enum InActorType {

    STAFF, //0
    APPLICANT, //1
    SPONSOR; //2

	   public static InActorType get(int index) {
	        return values()[index];
	    }
	   
	}
