import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginPageComponent } from './LoginModule/login-page/login-page.component';
import { RegistrationComponent } from './LoginModule/registration/registration.component';
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

const routes: Routes = [
  {
    path: '',
    component: LoginPageComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'userhome',
        component: UserPageComponent,
        children: [
          {
            path: '',
            component: MainContentComponent,
          },
          {
            path: 'cart',
            component: CartComponent,
          },
          {
            path: 'orders',
            component: OrdersComponent,
          },
        ],
      },
      {
        path: 'authorhome',
        component: AuthorPageComponent,
      },
      {
        path: 'adminhome',
        component: AdminPageComponent,
        children: [
          {
            path: '',
            component: AdminMainComponent,
          },
          {
            path: 'inventory',
            component: InventoryComponent,
          },
        ],
      },
    ],
  },
  {
    path: 'register',
    component: RegistrationComponent,
  },
  {
    path: 'forgotpassword',
    component: ForgotPasswordComponent,
  },
  {
    path: 'newpassword',
    component: NewPasswordComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
