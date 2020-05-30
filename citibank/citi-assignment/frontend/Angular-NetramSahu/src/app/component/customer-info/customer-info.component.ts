import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-customer-info',
  templateUrl: './customer-info.component.html',
  styleUrls: ['./customer-info.component.css']
})
export class CustomerInfoComponent implements OnInit {
  loginForm: FormGroup;
  submitted: boolean = false;
  productList: Observable<any>[] = [];
  prod: Customer = new Customer();
  productId: number;
  brand:String;
  delRec: String = '';
  active:boolean = false;

  constructor(private productService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    if(localStorage.getItem("productId")!=null){
      localStorage.removeItem("productId");
    }
    this.reloadData();
  }

  reloadData() {
    this.productService.getProducts().subscribe(data => {
      this.productList = data;
      console.log(this.productList);
    });
  }

  getProduct(productId) {
    this.productService.getProduct(productId).subscribe(data => {
      this.prod = data;
      this.delRec = '';
      this.active = true;
      console.log(this.prod);
    })
  }

  

  deleteProduct(id: number) {
    let result = confirm('Do you want to delete?')
    if (result) {
      this.productService.deleteProduct(id)
        .subscribe(
          data => {
            this.delRec = data;
            this.prod = new Customer();
            this.active = false;
            console.log(data);
            this.reloadData();
          },
          error => console.log(error));
    }
  }

  updateProduct(id: number) {
    localStorage.setItem("productId", id.toString());
    this.router.navigate(['edit-customer']);
  }

  addProduct(): void {
    this.router.navigate(['add-customer']);
  }
  idProduct() {
   
    this.router.navigate(['customer-info']);
  }
  
  getAllProducts() {
    
    this.router.navigate(['customer-list']);
  }


  
}
