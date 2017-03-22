package my.edu.umk.pams.intake.admission.selection;


import my.edu.umk.pams.intake.policy.model.InIntake;

/**
 * @author canang technologies
 */
public interface SelectionStrategy {

    void select(InIntake intake);

}
