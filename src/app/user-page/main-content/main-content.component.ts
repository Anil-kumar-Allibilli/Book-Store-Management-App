import { Component } from '@angular/core';
import { BookService } from 'src/app/Service/book.service';
import { CartService } from 'src/app/Service/cart.service';
import { Cart } from 'src/app/cart';

@Component({
  selector: 'app-main-content',
  templateUrl: './main-content.component.html',
  styleUrls: ['./main-content.component.css'],
})
export class MainContentComponent {
  __bookService: BookService;
  __cartService: CartService;
  books: any = [];
  constructor(__bookService: BookService, __cartService: CartService) {
    this.__bookService = __bookService;
    this.__cartService = __cartService;
  }
  ngOnInit() {
    this.__bookService.doLoadBooks().subscribe(
      (data) => {
        console.log(data);
        this.books = [...data];
        for (let book of this.books) {
          this.__bookService.doLoadFeedbacks(book.title).subscribe(
            (data) => {
              console.log(data);
              let rating = 0;
              for (let review of data) {
                rating += review.ratings;
                // console.log(rating);
              }
              if (data.length != 0) {
                rating = rating / data.length;
              }
              // console.log(data.length);
              book.review = Math.round(rating);
              console.log(book.review);
            },
            (err) => {
              console.log(err);
            }
          );
        }
      },
      (err) => {
        console.log(err);
      }
    );
  }

  doAddToCart(bookName: string, price: number) {
    let units = 1;
    let item: Cart = { bookName, price, units };
    this.__cartService.setItem(item);
    console.log(localStorage.getItem('cart'));
  }
}
