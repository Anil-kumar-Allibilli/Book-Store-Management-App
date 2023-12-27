import { Component } from '@angular/core';
import { AuthorService } from 'src/app/Service/author.service';

@Component({
  selector: 'app-admin-main',
  templateUrl: './admin-main.component.html',
  styleUrls: ['./admin-main.component.css'],
})
export class AdminMainComponent {
  author: any[] = [];
  allauthor: any[] = [];
  __authorService: AuthorService;
  constructor(__authorService: AuthorService) {
    this.__authorService = __authorService;
  }
  ngOnInit() {
    this.__authorService.doGetAllAuthorByStatus('pending').subscribe(
      (data) => {
        this.author = [...data];
      },
      (err) => {
        console.log(err);
      }
    );
    this.__authorService.doGetAllAuthor().subscribe(
      (data) => {
        this.allauthor = [...data];
      },
      (err) => {
        console.log(err);
      }
    );
  }
  doApprove(userCode: number) {
    console.log(userCode);
    this.__authorService.doApprove(userCode, 'approved').subscribe(
      (data) => {
        console.log(data);
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
