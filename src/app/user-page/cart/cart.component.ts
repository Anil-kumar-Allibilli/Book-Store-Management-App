import { Component } from '@angular/core';
import { CartService } from 'src/app/Service/cart.service';
import { Cart } from 'src/app/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent {
  itemList: Cart[];
  totalOrderValue: number = 0;
  __cartService: CartService;
  constructor(__cartService: CartService) {
    this.__cartService = __cartService;
    this.itemList = JSON.parse(localStorage.getItem('cart') || '[]');
    for (let item of this.itemList) {
      this.totalOrderValue += item.price * item.units;
    }
  }
  doPlaceOrder(itemList: Cart[], orderValue: number) {
    this.__cartService.doOrder(itemList, orderValue).subscribe(
      (data) => {
        console.log(data);
        localStorage.setItem('cart', '[]');
        itemList = [];
        orderValue = 0;
        window.location.reload();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  doEmptyCart(itemList: Cart[], orderValue: number) {
    localStorage.setItem('cart', '[]');
    itemList = [];
    orderValue = 0;
    window.location.reload();
  }
}
