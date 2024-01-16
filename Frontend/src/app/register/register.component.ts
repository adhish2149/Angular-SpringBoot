import { Component, OnInit } from '@angular/core';
import { GlobalConstants } from '../shared/global-constants';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  loginForm: any = FormGroup;
  responseMessage : any;
  errorOutput : string = '';

  constructor(
    private formBuilder: FormBuilder,
    private  router : Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      firstName: new FormControl('',[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]),
      lastName: new FormControl('',[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]),
      email: new FormControl('',[Validators.required,Validators.email]),
      pincode: new FormControl('',[Validators.required,Validators.minLength(6)]),
      password: new FormControl('',[Validators.required,Validators.minLength(3)])
    })
    // this.loginForm = this.formBuilder.group({
    //   firstName: [null,[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]],
    //   lastName: [null,[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]],
    //   email: [null,Validators.required,Validators.email],
    //   pincode: [null,[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]],
    //   password: [null,Validators.required]
    // })
  }

  getControl(name : any) : AbstractControl | null{
    return this.loginForm.get(name);
  }

  handleSubmit(){
    var formData = this.loginForm.value;

    var data = {
      firstName : formData.firstName,
      lastName : formData.lastName,
      password : formData.password,
      pincode : formData.pincode
    }
    var data2 = {
      name : formData.firstName,
      password : formData.password
    }
    this.loginService.registerCustomer(data).subscribe((response : any)=>{
      //this.router.navigate(['Login']);
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message; 
        this.errorOutput = "wrong credentials";
      }
      else{
        this.responseMessage = GlobalConstants.genericError;
      }
    })

    this.loginService.addUser(data2).subscribe((response : any)=>{
      this.router.navigate(['Login']);
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message; 
        this.errorOutput = "wrong credentials";
      }
      else{
        this.responseMessage = GlobalConstants.genericError;
      }
    })
    
  }

}