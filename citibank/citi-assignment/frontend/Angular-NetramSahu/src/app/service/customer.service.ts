import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../model/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8080/customer/';
  invalidLogin = false;
  constructor(private http: HttpClient) { }

    getProducts() {
      console.log("-----Netram inside------get method------------");
           console.log(this.http.get<any[]>(this.baseUrl + 'allCustomers'));
    return this.http.get<any[]>(this.baseUrl + 'allCustomers');
       }

    getAllProducts() {
      console.log("-----Netram inside------get all method------------");
       console.log(this.http.get<any[]>(this.baseUrl + 'getAllCustomerDetails'));
       return this.http.get<any[]>(this.baseUrl + 'getAllCustomerDetails');
     }

    getProduct(id: number) {
      console.log("-----Netram inside------get by id method------------"+id);
       return this.http.get<Customer>(this.baseUrl + 'customerBy/' + id);
     }

   addProduct(product: Customer): Observable<Object> {
    console.log("-----Netram inside------add method------------");
       return this.http.post(this.baseUrl + 'addCustomer/', product);
     }

  
   deleteProduct(id: number): Observable<any> {
    console.log("-----Netram inside------delete method------------");
     return this.http.delete(this.baseUrl + 'deleteCustomer/' + id, { responseType: 'text' });
   }

     updateProduct(product: Customer) {
      console.log("-----Netram inside------update method------------");
       return this.http.put(this.baseUrl + 'editCustomer/' + product.custId, product);
     }

    }