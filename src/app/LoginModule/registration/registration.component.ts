import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/DTO/login-request';
import { RegisterUser } from 'src/app/DTO/register-user';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent {
  role: string;
  checkpassword: string = '';
  passwordMatch: boolean = false;
  formValid: boolean = false;
  __loginService: LoginService;
  router: Router;
  isExisting: boolean = false;
  dto: RegisterUser = new RegisterUser(
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    '',
    0,
    '',
    '',
    ''
  );

  constructor(__loginService: LoginService, router: Router) {
    this.__loginService = __loginService;
    this.role = '';
    this.router = router;
  }

  doPasswordCheck() {
    if (this.dto.password === this.checkpassword) {
      this.passwordMatch = true;
    } else {
      this.passwordMatch = false;
    }
  }

  doRegister() {
    this.dto.name = this.dto.fullName;
    this.dto.userrole = this.role;
    console.log(this.dto);
    if (this.dto.password === this.checkpassword) {
      this.__loginService.doRegister(this.dto).subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['']);
        },
        (err) => {
          console.log('Error ' + err);
        }
      );
    }
  }

  doCheckUsername() {
    let dto: Login = new Login('', '');
    dto.username = this.dto.username;
    this.__loginService.doUserNameCheck(dto).subscribe(
      (data) => {
        console.log('in data!');
        if (data != null) {
          if (data.isUsername) {
            console.log(data.isUsername);
            this.isExisting = true;
          } else {
            this.isExisting = false;
          }
        }
      },
      (err) => {
        // console.log('Error ' + err);
      }
    );
  }
}
