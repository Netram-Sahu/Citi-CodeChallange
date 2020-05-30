import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  loginForm: FormGroup;
  submitted: boolean = false;
  invalidLogin: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router) { }
  onSubmit(){
    this.submitted = true;
    if(this.loginForm.invalid){
      return;
    }

    if(this.loginForm.controls.email.value =="netram.sahu@gmail.com" &&
        this.loginForm.controls.password.value=="netram@123")
        {          
          console.log("===============1==================");
          localStorage.setItem("username",this.loginForm.controls.email.value);
          this.router.navigate(['customer-list']);
    }
    else{
      this.invalidLogin = true;
    }
  }
 
  ngOnInit() {   
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });

  }
}
