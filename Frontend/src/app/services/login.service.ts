import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment'; 

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url=environment.apiURL;
    

  constructor(private http: HttpClient) { }

  //calling server to generate

LoginCheck(data:any){
   
    return this.http.post(this.url + "/token",data)
}


// login user
loginUser(token:any){
  localStorage.setItem("token", token)
  return true;
}

isLoggedIn(){
  let token = localStorage.getItem("token");
  if(token === undefined || token === '' || token === null){
    return false;
  }
  return true;
}

logout(){
  localStorage.removeItem("token");
  return true;
}

getToken(){
  return localStorage.getItem("token");
}

registerCustomer(data : any){
    //let headers = new HttpHeaders().set("Authorization",`Bearer ${localStorage.getItem('token')}`)
    //console.log(headers.get("Authorization"));
    //return this.http.post(this.url + "/api/customers/register",data,{});
    return this.http.post(this.url + "/api/customers/register",data)
}

addUser(data: any){
    //let headers = new HttpHeaders().set("Authorization",`Bearer ${localStorage.getItem('token')}`)
    return this.http.post(this.url + "/api/Users/addUser",data)
}

searchByName(data: any){
   const _url = `${this.url}/api/Products/${data}`;
   return this.http.get(_url); 
}

searchByCode(data: any){
  const _url = `${this.url}/api/Products/proCode/${data}`;
   return this.http.get(_url);
}

searchByBrand(data : any){
  const _url = `${this.url}/api/Products/proBrand/${data}`;
  return this.http.get(_url);
  
}

searchByPrice(data : any){
  const _url = `${this.url}/api/Products/proPrice/${data}`;
  return this.http.get(_url);
}

checkServicibility(data: any){
  const _url = `${this.url}/api/customers/custName/${data}`;
  return this.http.get(_url);
}

isItServicible(data : any,data2 : any){
  const _url = `${this.url}/api/pincode/pin/${data}/${data2}`;
  return this.http.get(_url);
}

}