import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  addForm: FormGroup;
  submitted: boolean = false;

  constructor(private formBuilder: FormBuilder, private productService: CustomerService, private router: Router) { }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      id: [],
      // custName: ['', Validators.required],
      // unitsConsumed: ['', Validators.required],
      // billAmout: ['', Validators.required],

      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      ssn: ['', Validators.required],

    });
  }

  onSubmit() {
    debugger;
    console.log("====add onSubmit=========");
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    this.productService.addProduct(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['customer-list']);
        console.log(data);
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
