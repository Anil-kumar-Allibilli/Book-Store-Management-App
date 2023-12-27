import { Component } from '@angular/core';
import { OrderService } from 'src/app/Service/order.service';


@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent {
  __orderService: OrderService;
  currentOrders: any[] = [];
  allOrders: any[] = [];
  constructor(__orderService: OrderService) {
    this.__orderService = __orderService;
  }
  ngOnInit() {
    this.__orderService.doGetAllCustomerOrders().subscribe(
      (data) => {
        console.log(data);
        this.allOrders = [...data];
        for (let order of data) {
          if (order.orderStatus === 'placed successfully') {
            this.currentOrders = [...this.currentOrders, order];
          }
        }
        console.log(this.currentOrders);
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
