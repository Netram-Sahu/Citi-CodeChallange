import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';
@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  product: Customer;
  editForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router,
    private productService: CustomerService) { }

    ngOnInit(): void {
      let productId = localStorage.getItem("productId");
      console.log("===edit product====="+productId);
      this.populateData(+productId);
    }
  
    populateData(productId: number) {
      this.editForm = this.formBuilder.group({
        custId: [],
        // custName: ['', Validators.required],
        // unitsConsumed: ['', Validators.required],
        // billAmout: ['', Validators.required],

        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        address: ['', Validators.required],
        phoneNumber: ['', Validators.required],
        ssn: ['', Validators.required],
      });
  
      this.productService.getProduct(productId)
        .subscribe(data => {
          this.editForm.setValue(data);
        })
    }
  

  onSubmit() {
    this.submitted = true;
    console.log("-----------");
    debugger;
    if (this.editForm.invalid) {
      return;
    }
    this.productService.updateProduct(this.editForm.value)
    .subscribe(data => {
      console.log(data);
      this.router.navigate(['customer-list']);
    },
    error => {
      alert(error);
    });
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
