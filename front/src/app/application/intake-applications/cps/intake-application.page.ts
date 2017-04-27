import {Component, ViewContainerRef, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {FormBuilder} from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';
import {Store} from "@ngrx/store";
import {IntakeApplication} from "../intake-application.interface";
import {ApplicationModuleState} from "../../index";
import {IntakeApplicationPersonal} from "./intake-application.interface";
import {ProgramLevel} from "../../../policy/program-levels/program-level.interface";


@Component({
  selector: 'pams-intake-application',
  templateUrl: './intake-application.page.html',
})

export class IntakeApplicationPage implements OnInit {


  private createForm: FormGroup;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private viewContainerRef: ViewContainerRef,
              private store: Store<ApplicationModuleState>) {
  }

  ngOnInit(): void {
  }
  
   expandedEvent(): void {
   
  }

  collapsedEvent(): void {
    
  }
  
  next(application:IntakeApplication , isValid: boolean) {
  }
}
