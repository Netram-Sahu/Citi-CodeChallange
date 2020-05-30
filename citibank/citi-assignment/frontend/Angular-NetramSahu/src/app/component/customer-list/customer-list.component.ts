import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/model/customer';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/service/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  loginForm: FormGroup;
  submitted:boolean=false;
  productList: Observable<any>[]=[];
  prod: Customer =new Customer();
  productId: number;
  brand:String="";
  delRec: String = '';
  active:boolean = false;

  constructor( private productService: CustomerService, private router: Router) { }
  
  //ngOnInit(): void {
    //if(localStorage.getItem("productId")!=null){
      //localStorage.removeItem("productId");
    //}
    //this.reloadData();
 // }

  reloadData() {
    this.productService.getAllProducts().subscribe(data => {
      this.productList = data;
      console.log(this.productList);
    });
  }

  ngOnInit(): void {
   this.getAllProductsInfo();
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

  getAllProductsInfo(){
    this.productService.getAllProducts().subscribe(data => {
      this.productList = data;
      this.delRec = '';
      this.active = true;
      console.log(this.productList);
      
    })
  }


  deleteProduct(id: number) {
    let result = confirm('Do you want to delete the product?')
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
    console.log("inside update method"+id.toString());
    localStorage.setItem("productId", id.toString());
    this.router.navigate(['edit-customer']);
  }

  
}
