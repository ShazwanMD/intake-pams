import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class IntakeActions {

  static FIND_ASSIGNED_INTAKE_TASKS = '[Intake] Find Assigned Intake Tasks';
  findAssignedIntakeTasks(): Action {
    return {
      type: IntakeActions.FIND_ASSIGNED_INTAKE_TASKS
    };
  }

  static FIND_ASSIGNED_INTAKE_TASKS_SUCCESS = '[Intake] Find Assigned Intake Tasks Success';
  findAssignedIntakeTasksSuccess(tasks): Action {
    console.log("findAssignedIntakeTasksSuccess");
    return {
      type: IntakeActions.FIND_ASSIGNED_INTAKE_TASKS_SUCCESS,
      payload: tasks
    };
  }

  static FIND_POOLED_INTAKE_TASKS = '[Intake] Find Pooled Intake Tasks';
  findPooledIntakeTasks(): Action {
    return {
      type: IntakeActions.FIND_POOLED_INTAKE_TASKS
    };
  }

  static FIND_POOLED_INTAKE_TASKS_SUCCESS = '[Intake] Find Pooled Intake Tasks Success';
  findPooledIntakeTasksSuccess(tasks): Action {
    console.log("findAssignedIntakeTasksSuccess");
    return {
      type: IntakeActions.FIND_POOLED_INTAKE_TASKS_SUCCESS,
      payload: tasks
    };
  }
  static FIND_INTAKE_TASK_BY_TASK_ID = '[Intake] Find Intake Task By Task Id';
  findIntakeTaskByTaskId(taskId): Action {
    console.log("findIntakeTaskByTaskId");
    return {
      type: IntakeActions.FIND_INTAKE_TASK_BY_TASK_ID,
      payload: taskId
    };
  }

  static FIND_INTAKE_TASK_BY_TASK_ID_SUCCESS = '[Intake] Find Intake Task By Task Id Success';
  findIntakeTaskByTaskIdSuccess(task): Action {
    console.log("findIntakeTaskByTaskIdSuccess");
    return {
      type: IntakeActions.FIND_INTAKE_TASK_BY_TASK_ID_SUCCESS,
      payload: task
    };
  }

  static START_INTAKE_TASK = '[Intake] Start Intake Task';
  startIntakeTask(intake): Action {
    return {
      type: IntakeActions.START_INTAKE_TASK,
      payload: intake
    };
  }

  static START_INTAKE_TASK_SUCCESS = '[Intake] Start Intake Task Success';
  startIntakeTaskSuccess(task): Action {
    return {
      type: IntakeActions.START_INTAKE_TASK_SUCCESS,
      payload: task
    };
  }

  static COMPLETE_INTAKE_TASK = '[Intake] Complete Intake Task';
  completeIntakeTask(intake): Action {
    return {
      type: IntakeActions.COMPLETE_INTAKE_TASK,
      payload: intake
    };
  }

  static COMPLETE_INTAKE_TASK_SUCCESS = '[Intake] Complete Intake Task Success';
  completeIntakeTaskSuccess(task): Action {
    return {
      type: IntakeActions.COMPLETE_INTAKE_TASK_SUCCESS,
      payload: task
    };
  }

  static ASSIGN_INTAKE_TASK = '[Intake] Assign Intake Task';
  assignIntakeTask(intake): Action {
    return {
      type: IntakeActions.ASSIGN_INTAKE_TASK,
      payload: intake
    };
  }

  static ASSIGN_INTAKE_TASK_SUCCESS = '[Intake] Assign Intake Task Success';
  assignIntakeTaskSuccess(task): Action {
    return {
      type: IntakeActions.ASSIGN_INTAKE_TASK_SUCCESS,
      payload: task
    };
  }

  static RELEASE_INTAKE_TASK = '[Intake] Release Intake Task';
  releaseIntakeTask(intake): Action {
    return {
      type: IntakeActions.RELEASE_INTAKE_TASK,
      payload: intake
    };
  }

  static RELEASE_INTAKE_TASK_SUCCESS = '[Intake] Release Intake Task Success';
  releaseIntakeTaskSuccess(task): Action {
    return {
      type: IntakeActions.RELEASE_INTAKE_TASK_SUCCESS,
      payload: task
    };
  }

  static FIND_INTAKE_BY_ID = '[Intake] Find Intake By Id';
  findIntakeById(id): Action {
    return {
      type: IntakeActions.FIND_INTAKE_BY_ID,
      payload: id
    };
  }

  static FIND_INTAKE_BY_ID_SUCCESS = '[Intake] Find Intake By Id Success';
  findIntakeByIdSuccess(intake): Action {
    return {
      type: IntakeActions.FIND_INTAKE_BY_ID_SUCCESS,
      payload: intake
    };
  }

  static FIND_INTAKE_BY_REFERENCE_NO = '[Intake] Find Intake By Reference No';
  findIntakeByReferenceNo(referenceNo): Action {
    return {
      type: IntakeActions.FIND_INTAKE_BY_REFERENCE_NO,
      payload: referenceNo
    };
  }

  static FIND_INTAKE_BY_REFERENCE_NO_SUCCESS = '[Intake] Find Intake By Reference No Success';
  findIntakeByReferenceNoSuccess(intake): Action {
    return {
      type: IntakeActions.FIND_INTAKE_BY_REFERENCE_NO_SUCCESS,
      payload: intake
    };
  }

  static FIND_PROGRAM_OFFERINGS = '[Intake] Find Program Offerings';
  findProgramOfferings(intake): Action {
    return {
      type: IntakeActions.FIND_PROGRAM_OFFERINGS,
      payload: intake
    };
  }

  static FIND_PROGRAM_OFFERINGS_SUCCESS = '[Intake] Find Program Offerings Success';
  findProgramOfferingsSuccess(items): Action {
    console.log("findProgramOfferingsSuccess");
    return {
      type: IntakeActions.FIND_PROGRAM_OFFERINGS_SUCCESS,
      payload: items
    };
  }

  static FIND_SUPERVISOR_OFFERINGS = '[Intake] Find Supervisor Offerings';
  findSupervisorOfferings(intake): Action {
    return {
      type: IntakeActions.FIND_SUPERVISOR_OFFERINGS,
      payload: intake
    };
  }

  static FIND_SUPERVISOR_OFFERINGS_SUCCESS = '[Intake] Find Supervisor Offering Success';
  findSupervisorOfferingsSuccess(offerings): Action {
    console.log("findSupervisorOfferingsSuccess");
    return {
      type: IntakeActions.FIND_SUPERVISOR_OFFERINGS_SUCCESS,
      payload: offerings
    };
  }

  static FIND_STUDY_MODE_OFFERINGS = '[Intake] Find Study Mode Offerings';
  findStudyModeOfferings(intake): Action {
    return {
      type: IntakeActions.FIND_STUDY_MODE_OFFERINGS,
      payload: intake
    };
  }

  static FIND_STUDY_MODE_OFFERINGS_SUCCESS = '[Intake] Find Study Mode Offering Success';
  findStudyModeOfferingsSuccess(offerings): Action {
    console.log("findStudyModeOfferingsSuccess");
    return {
      type: IntakeActions.FIND_STUDY_MODE_OFFERINGS_SUCCESS,
      payload: offerings
    };
  }

  static UPDATE_INTAKE = '[Intake] Update Intake';
  updateIntake(intake): Action {
    return {
      type: IntakeActions.UPDATE_INTAKE,
      payload: intake
    };
  }

  static UPDATE_INTAKE_SUCCESS = '[Intake] Update Intake Success';
  updateIntakeSuccess(intake): Action {
    return {
      type: IntakeActions.UPDATE_INTAKE_SUCCESS,
      payload: intake
    };
  }

  static REMOVE_INTAKE = '[Intake] Remove Intake';
  removeIntake(intake): Action {
    return {
      type: IntakeActions.REMOVE_INTAKE,
      payload: intake
    };
  }

  static REMOVE_INTAKE_SUCCESS = '[Intake] Remove Intake Success';
  removeIntakeSuccess(intake): Action {
    return {
      type: IntakeActions.REMOVE_INTAKE_SUCCESS,
      payload: intake
    };
  }
}
