import { Injectable } from '@angular/core';
import { Cart } from '../cart';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  itemList: Cart[] = JSON.parse(localStorage.getItem('cart') || '[]');
  contextPath = 'http://localhost:2002/';
  orderBooksEndPoint = this.contextPath + 'user/placeorder';
  constructor(private api: HttpClient) {}
  setItem(book: Cart) {
    let itemexists: boolean = false;
    for (let item of this.itemList) {
      if (item.bookName === book.bookName) {
        item.units += 1;
        itemexists = true;
        localStorage.setItem('cart', JSON.stringify(this.itemList));
        break;
      }
    }
    if (!itemexists) {
      this.itemList = [...this.itemList, book];
      localStorage.setItem('cart', JSON.stringify(this.itemList));
    }
  }
  getItem() {
    return this.itemList;
  }

  doOrder(orderDetails: Cart[], orderValue: number) {
    let username = localStorage.getItem('Username');
    let orderDto = { orderValue, orderDetails, username };
    console.log(orderDto);
    return this.api.post<any>(`${this.orderBooksEndPoint}`, orderDto);
  }
}
