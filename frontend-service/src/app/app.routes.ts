import {Routes} from '@angular/router';
import {HomeComponent} from './views/home/home.component';
import {RegisterComponent} from "./views/wide/register/register.component";
import {LoginComponent} from "./views/wide/login/login.component";

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },

  {
    path: 'home',
    component: HomeComponent,
  }

]