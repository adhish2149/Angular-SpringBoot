import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { GlobalConstants } from '../shared/global-constants';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  searchHere: any;
  results1: any;
  results2: any;
  responseMessage: any;
  ok1: boolean = false;
  ok2: boolean = false;
  errorMessage: String = '';

  constructor(private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router) { }

  ngOnInit(): void {
    this.searchHere = this.formBuilder.group({
      search: ['']
    })
  }

  handleSubmit() {
    this.errorMessage = "";
    var formData = this.searchHere.value;
    const data = formData.search;
    this.loginService.searchByBrand(data).subscribe((response: any) => {
      this.results1 = response;
      console.log(this.results1);
      if (response.length == 0) {
        this.ok1 = true;
      }
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message;
       // this.errorMessage = this.responseMessage;
        
      }
      else{
        this.responseMessage = "Something went wrong! please try again later";
       // this.errorMessage = this.responseMessage;
      }
    });
    this.loginService.searchByName(data).subscribe((response: any) => {
      this.results2 = response;
      console.log(response);
      if (response.length == 0) {
        this.ok2 = true;
      }
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message;
       // this.errorMessage = this.responseMessage;
        
      }
      else{
        this.responseMessage = "Something went wrong! please try again later";
       // this.errorMessage = this.responseMessage;
      }
    });
    if (this.ok1 == true && this.ok2 == true){
      this.errorMessage = "no result found";
      
    }
    else{
      this.errorMessage = "";
    }
    this.ok1 = false;
    this.ok2 = false;
      

  }
}
