import { Component } from '@angular/core';
import { LoginService } from '../Service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  __loginService: LoginService;
  router: Router;
  username: string | null;
  constructor(__loginService: LoginService, router: Router) {
    this.__loginService = __loginService;
    this.router = router;
    this.username = localStorage.getItem('Username');
  }
  logout() {
    localStorage.setItem('LoginStatus', 'false');
    this.__loginService.setLoginState(false);
    localStorage.setItem('Username', '');
    this.router.navigate(['']);
  }
}
