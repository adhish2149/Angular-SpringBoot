import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GlobalConstants } from '../shared/global-constants';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {

  formDetails: any;

  productDetails: any;
  responseMessage: any;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private loginService: LoginService) { }

  ngOnInit(): void {
    this.formDetails = this.formBuilder.group({
      Search: [''],
      details: ['']
    })
  }

  handleSubmit() {
    console.log(this.formDetails.value);
    var formData = this.formDetails.value;
    var searchBy = formData.Search;
    var serchVal = formData.details;
    console.log(searchBy);
    if (searchBy == 'Name') {
      this.loginService.searchByName(serchVal).subscribe((response: any) => {
        this.productDetails = response;
        localStorage.setItem('resultValues',JSON.stringify(response[0]));
        console.log(response);
      }, (error) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        }
        else {
          this.responseMessage = GlobalConstants.genericError;
        }
      })
    }

    else if (searchBy == 'Brand') {
      this.loginService.searchByBrand(serchVal).subscribe((response: any) => {
        this.productDetails = response;
        console.log(response);
        localStorage.setItem('resultValues',JSON.stringify(response[0]));
      }, (error) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        }
        else {
          this.responseMessage = GlobalConstants.genericError;
        }
      })
    }
    else if (searchBy == 'ProductCode') {
      this.loginService.searchByCode(serchVal).subscribe((response: any) => {
        this.productDetails = response;
        console.log(response);
        localStorage.setItem('resultValues',JSON.stringify(response[0]));
      }, (error) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        }
        else {
          this.responseMessage = GlobalConstants.genericError;
        }
      })
    }
    else if(searchBy == 'Price'){
      this.loginService.searchByPrice(serchVal).subscribe((response: any) => {
        this.productDetails = response;
        console.log(response);
        localStorage.setItem('resultValues',JSON.stringify(response[0]));
      }, (error) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        }
        else {
          this.responseMessage = GlobalConstants.genericError;
        }
      })
    }

  }

  add(code : any){
    localStorage.setItem("prCode",code);
    this.router.navigate(['Details']);
    
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['']);
  }

}
