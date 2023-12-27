import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/DTO/login-request';
import { SendMail } from 'src/app/DTO/send-mail';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css'],
})
export class ForgotPasswordComponent {
  dto: Login = new Login('', '');
  maildto: SendMail = new SendMail('', '', '');
  __loginService: LoginService;
  router: Router;
  constructor(__loginService: LoginService, router: Router) {
    this.__loginService = __loginService;
    this.router = router;
  }
  checkUserName() {
    this.__loginService.doUserNameCheck(this.dto).subscribe(
      (data) => {
        console.log('in data!');
        if (data != null) {
          console.log(data.isUsername + '  ' + data.email);
          if (data.isUsername) {
            console.log(data.isUsername + '  ' + data.email);
            this.maildto.recipient = data.email;
            this.__loginService.setLoginInfo(data.username);
            console.log(this.maildto.recipient);
            this.__loginService.doSendMail(this.maildto).subscribe(
              (data) => {
                console.log(data);
              },
              (err) => {
                console.log('Error ' + err);
              }
            );
            this.router.navigate(['newpassword']);
          }
        }
      },
      (err) => {
        console.log('Error ' + err);
      }
    );
  }
}
