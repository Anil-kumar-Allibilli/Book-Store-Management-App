import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/DTO/login-request';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
})
export class LoginPageComponent {
  invalidLogin: boolean = false;
  dto: Login = new Login('', '');
  __loginService: LoginService;
  @Output() loginDone = new EventEmitter<Boolean>();

  router: Router;
  constructor(__loginService: LoginService, router: Router) {
    this.__loginService = __loginService;
    this.router = router;
  }
  doLogin() {
    console.log(
      'submit called with username: ' +
        this.dto.username +
        ' password: ' +
        this.dto.password
    );
    this.__loginService.doLoginCheck(this.dto).subscribe(
      (data) => {
        console.log('in data!');
        if (data != null) {
          console.log(data.role);
          console.log(data.token);
          console.log('data.username--------' + data.username);
          if (data.role === 'customer' && data.token != null) {
            localStorage.setItem('LoginStatus', 'true');
            localStorage.setItem('Username', data.username);
            this.loginDone.emit(true);
            this.router.navigate(['home/userhome']);
          }
          if (data.role === 'author' && data.token != null) {
            localStorage.setItem('LoginStatus', 'true');
            localStorage.setItem('Username', data.username);
            this.router.navigate(['home/authorhome']);
          }
          if (data.role === 'admin' && data.token != null) {
            localStorage.setItem('LoginStatus', 'true');
            localStorage.setItem('Username', data.username);
            this.router.navigate(['home/adminhome']);
          }
        }
      },
      (err) => {
        console.log('Error ' + err);
        this.invalidLogin = true;
      }
    );
  }
  doValid() {
    this.invalidLogin = false;
  }
}
