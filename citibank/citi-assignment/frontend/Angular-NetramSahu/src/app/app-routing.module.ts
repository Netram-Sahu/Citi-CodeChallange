import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { CustomerListComponent } from './component/customer-list/customer-list.component';
import { CustomerInfoComponent } from './component/customer-info/customer-info.component';
import { AddCustomerComponent } from './component/add-customer/add-customer.component';
import { EditCustomerComponent } from './component/edit-customer/edit-customer.component';


const routes: Routes = [
{path:'', component:HomeComponent},
{path:'customer-list', component:CustomerListComponent},
{path:'customer-info', component:CustomerInfoComponent},
{path:'add-customer', component:AddCustomerComponent},
{path:'edit-customer', component:EditCustomerComponent},
{path:'**', component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
