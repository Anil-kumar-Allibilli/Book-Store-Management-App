import { Component } from '@angular/core';
import { LoginService } from '../Service/login.service';
import { Router } from '@angular/router';
import { AuthorService } from '../Service/author.service';

@Component({
  selector: 'app-author-page',
  templateUrl: './author-page.component.html',
  styleUrls: ['./author-page.component.css'],
})
export class AuthorPageComponent {
  __authorService: AuthorService;
  router: Router;
  username: string | null;
  authorStatus: string | null;
  constructor(__authorService: AuthorService, router: Router) {
    this.__authorService = __authorService;
    this.router = router;
    this.username = localStorage.getItem('Username');
    this.authorStatus = '';
    if (this.username != null) {
      __authorService.doAuthorStatusCheck(this.username).subscribe(
        (data) => {
          this.authorStatus = data.status;
          console.log(data.status);
        },
        (err) => {
          console.log('error:' + err);
        }
      );
    }
  }
}
