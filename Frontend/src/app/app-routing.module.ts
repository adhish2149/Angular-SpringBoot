import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProductSearchComponent } from './product-search/product-search.component';
import { ResultComponent } from './result/result.component';
import { AuthGuard } from './shared/auth.guard';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ErrorComponent } from './error/error.component';

const routes: Routes = [
  {path : '', component: WelcomeComponent},
  {path : 'Login', component: LoginComponent},
  {path : 'Register', component: RegisterComponent},
  {path : 'Search', component: ProductSearchComponent,canActivate:[AuthGuard]},
  {path : 'Result', component : ResultComponent,canActivate:[AuthGuard]},
  {path : 'Details', component : ProductDetailsComponent,canActivate:[AuthGuard]},
  {path :'**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
