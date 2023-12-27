import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './LoginModule/registration/registration.component';
import { LoginPageComponent } from './LoginModule/login-page/login-page.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ForgotPasswordComponent } from './LoginModule/forgot-password/forgot-password.component';
import { NewPasswordComponent } from './LoginModule/new-password/new-password.component';
import { UserPageComponent } from './user-page/user-page.component';
import { AuthorPageComponent } from './author-page/author-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { MainContentComponent } from './user-page/main-content/main-content.component';
import { AdminMainComponent } from './admin-page/admin-main/admin-main.component';
import { InventoryComponent } from './admin-page/inventory/inventory.component';
import { CartComponent } from './user-page/cart/cart.component';
import { OrdersComponent } from './user-page/orders/orders.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationComponent,
    LoginPageComponent,
    ForgotPasswordComponent,
    NewPasswordComponent,
    UserPageComponent,
    AuthorPageComponent,
    AdminPageComponent,
    MainContentComponent,
    AdminMainComponent,
    InventoryComponent,
    CartComponent,
    OrdersComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
