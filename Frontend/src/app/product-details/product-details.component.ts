import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { GlobalConstants } from '../shared/global-constants';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  vals = JSON.parse(localStorage.getItem('resultValues')!);
  img : any;
  price : any;
  procode : any;
  brand : any;
  details : any;
  code : any;
  name : any;
  responseMessage : any;
  result : any;
  formDetails : any;
  constructor(private loginService : LoginService,
    private router : Router,
    private formBuilder : FormBuilder) { }

  ngOnInit(): void {
    this.code = localStorage.getItem("prCode");
    this.loginService.searchByCode(this.code).subscribe((response :any)=>{
      this.img = response[0].image;
      this.price = response[0].price;
      this.procode = response[0].productCode;
      this.brand = response[0].brand;
      this.details = response[0].details;
      this.name = response[0].productName;
      console.log("result ");
      console.log(response[0]);
    },(error)=>{
      if(error.error?.message){
        this.responseMessage = error.error?.message;
      }
      else{
        this.responseMessage = GlobalConstants.genericError;
      }
    })

    this.formDetails = this.formBuilder.group({
      pincode : ['']
    })
  }

  handleSubmit(){
    var pin = this.formDetails.value.pincode;
    console.log(pin);
    this.loginService.isItServicible(pin,this.procode).subscribe((response : any)=>{
      console.log(response);
      if(response.length != 0)
      this.result = `Serviciable within ` + response[0].days + ` days`;
      else
      this.result = "Product is not serviciable";
    })
    // var data = localStorage.getItem("custName");
    // console.log(data);
    // this.loginService.checkServicibility(data).subscribe((response : any)=>{
    //   if(response == -1){
    //       this.result = "PRODUCT IS NOT SERVICIBLE";
    //   }
    //   else{
    //     this.result = "PRODUCT IS SERVICIBLE";
    //   }
    // })
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['']);
  }

}
