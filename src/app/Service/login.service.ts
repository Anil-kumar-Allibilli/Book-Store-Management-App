import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../DTO/login-request';
import { Observable } from 'rxjs';
import { ResetPassword } from '../DTO/reset-password';
import { SendMail } from '../DTO/send-mail';
import { Logininfo } from '../logininfo';
import { RegisterUser } from '../DTO/register-user';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  login: Logininfo = new Logininfo();
  constructor(private api: HttpClient) {}
  contextPath = 'http://localhost:2002/';
  checkUserEndPoint = this.contextPath + 'login/check';
  checkUserNameEndPoint = this.contextPath + 'login/check/username';
  sendMailEndPoint = this.contextPath + 'login/sendmail';
  updatePasswordEndPoint = this.contextPath + 'login/changepassword';
  createAuthorEndPoint = this.contextPath + 'login/createauthor';
  createCustomerEndPoint = this.contextPath + 'login/addcustomer';
  doLoginCheck(dto: Login): Observable<any> {
    return this.api.post<any>(`${this.checkUserEndPoint}`, dto);
  }
  doUserNameCheck(dto: Login): Observable<any> {
    return this.api.post<any>(`${this.checkUserNameEndPoint}`, dto);
  }
  doSendMail(dto: SendMail): Observable<any> {
    return this.api.post<any>(`${this.sendMailEndPoint}`, dto);
  }
  doUpdatePassword(dto: ResetPassword): Observable<any> {
    console.log(dto);
    return this.api.put<any>(`${this.updatePasswordEndPoint}`, dto);
  }
  setLoginInfo(username: string) {
    this.login.username = username;
  }
  getLoginInfo() {
    return this.login.username;
  }
  setLoginState(isLogin: boolean) {
    this.login.isLogin = isLogin;
  }
  getLoginState(){
    return this.login.username;
  }
  doRegister(dto: RegisterUser): Observable<any> {
    if (dto.userrole === 'author') {
      return this.api.post<any>(`${this.createAuthorEndPoint}`, dto);
    } else {
      return this.api.post<any>(`${this.createCustomerEndPoint}`, dto);
    }
  }
}
