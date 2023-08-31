import { Component } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { LoginComponent } from '../login/login.component';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
];

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  
    constructor(private router: Router) {}
    
  
    onSubmit() {
        this.router.navigate(['/login']);
      
    }
}
