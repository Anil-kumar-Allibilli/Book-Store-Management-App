import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ResetPassword } from 'src/app/DTO/reset-password';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-new-password',
  templateUrl: './new-password.component.html',
  styleUrls: ['./new-password.component.css'],
})
export class NewPasswordComponent {
  dto: ResetPassword = new ResetPassword('', '', '');
  confirmpassword: string = '';
  router: Router;
  __loginService: LoginService;
  constructor(__loginService: LoginService, router: Router) {
    this.__loginService = __loginService;
    this.router = router;
  }
  changePassword() {
    if (this.dto.password === this.confirmpassword) {
      console.log('new password:' + this.dto.password);
      console.log('new otp:' + this.dto.otp);
      console.log('username: ' + this.__loginService.getLoginInfo());
      this.dto.username = this.__loginService.getLoginInfo();
      this.__loginService.doUpdatePassword(this.dto).subscribe(
        (data) => {
          console.log(data);
          if (data) {
            this.router.navigate(['login']);
          }
        },
        (err) => {
          console.log('Error ' + err);
        }
      );
    }
  }
}
