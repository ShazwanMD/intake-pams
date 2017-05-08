import {MetaObject} from "../../core/meta-object.interface";
import {IntakeSession} from "../intake-sessions/intake-session.interface";
import {GraduateCentre} from "../../common/graduate-centres/graduate-centre.interface";
import {ProgramLevel} from "../program-levels/program-level.interface";

export interface Program extends MetaObject{

  code:string;
  descriptionMs:string;
  descriptionEn:string;
  

  // transient
  applied?:boolean;
}
