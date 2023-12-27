import { Component } from '@angular/core';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css'],
})
export class InventoryComponent {
  // author: any[] = [];
  // allauthor: any[] = [];
  // __authorService: AuthorService;
  // constructor(__authorService: AuthorService) {
  //   this.__authorService = __authorService;
  // }
  // ngOnInit() {
  //   this.__authorService.doGetAllAuthorByStatus('pending').subscribe(
  //     (data) => {
  //       this.author = [...data];
  //     },
  //     (err) => {
  //       console.log(err);
  //     }
  //   );
  //   this.__authorService.doGetAllAuthor().subscribe(
  //     (data) => {
  //       this.allauthor = [...data];
  //     },
  //     (err) => {
  //       console.log(err);
  //     }
  //   );
  // }
}
