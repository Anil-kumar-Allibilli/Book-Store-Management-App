import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'BookStoreApp';
  // router: Router;
  // isLogin: boolean | null;
  // username: string | null;
  constructor(router: Router) {
    // this.router = router;
    // this.isLogin =
    //   localStorage.getItem('LoginStatus') === 'true' ? true : false;
    // this.username = localStorage.getItem('Username');
  }
  // showLoginPage() {
  //   this.router.navigate(['login']);
  // }
}
