import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot } from "@angular/router";
import { LoginService } from "./login.service";


@Injectable()
export class AuthGuardService implements CanActivate {
    
    constructor(private loginService: LoginService, private router: Router){

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if(this.loginService.isLoggedIn()) {
            return true;
        }
        else {
          this.router.navigate(['login'])
            return false;
        }
    }
   

}