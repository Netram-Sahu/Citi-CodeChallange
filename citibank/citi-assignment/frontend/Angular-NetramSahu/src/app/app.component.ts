import { Component, OnInit } from '@angular/core';
import {formatDate } from '@angular/common';
import { CustomerService } from 'src/app/service/customer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  today= new Date();
  jstoday = '';
  logoutflag = true;
  title = formatDate(this.today, 'dd-MM-yyyy hh:mm:ss a', 'en-US', '+0530');
  constructor(
    private productService: CustomerService,private router: Router,) { }
  ngOnInit() { 

    // if(localStorage.getItem("email"))
    //this.logoutflag =  this.productService.logoutflag;
  }

  logout(){
    localStorage.setItem("email", "");
   //if(localStorage.getItem("email");
    this.logoutflag = true;
    this.router.navigate(['']);
  }
}
