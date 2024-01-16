import { Component, OnInit } from '@angular/core';
import { GlobalConstants } from '../shared/global-constants';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: any = FormGroup;
  responseMessage : any;
  errorOutput : string = '';
  loginUser: any ;

  constructor(
    private formBuilder: FormBuilder,
    private  router : Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      name: [null,[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]],
      password: [null,Validators.required]
    })
  }
  handleSubmit(){
    var formData = this.loginForm.value;

    var data = {
      username : formData.name,
      password : formData.password
    }
    console.log(data);
    this.loginService.LoginCheck(data).subscribe((response : any)=>{
      console.log(response.token)
      this.loginService.loginUser(response.token)
      localStorage.setItem("custName",formData.name);
      this.router.navigate(['Search']);
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message;
        this.errorOutput = this.responseMessage;
      }
      else{
        this.responseMessage = "Something went wrong! please try again later";
        this.errorOutput = "Wrong Credentials";
      }
    
    })


  }

}
