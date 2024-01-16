import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';
//import { AuthGuardService } from './auth.guard';


@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  // constructor(private inject :Injector) { }
  constructor(

    private _userService: AuthService,

    private _router: Router

  ) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    //   if(!req.url.endsWith('Login')){

    //     const headers = req.headers.set("token",localStorage.getItem("token")!);
    //     const jwtToken = req.clone({headers});
    //     return next.handle(jwtToken);
    //     // let authservice = this.inject.get(AuthService)
    //     // let jwtToken = req.clone({
    //     // setHeaders:{
    //     //   Authorization : 'Bearer ' + authservice.GetToken()
    //     // }
    //   //});
    //  // return next.handle(jwtToken);

    //   }
    //   else{
    //     return next.handle(req);
    //   }
    const token = this._userService.GetToken();

    const auth = 'Bearer ' + token;

    let tokenizedReq = req;

     if (token != null) {

       tokenizedReq = req.clone({

         headers: req.headers.set('Authorization', auth)

       })

     }

    return next.handle(tokenizedReq);

  }





}
