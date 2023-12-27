import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  contextPath = 'http://localhost:2002/';
  getCustomerOrdersEndPoint = this.contextPath + 'user/allplacedorders';
  constructor(private api: HttpClient) {}
  doGetAllCustomerOrders() {
    let username = localStorage.getItem('Username') || '';
    return this.api.get<any>(`${this.getCustomerOrdersEndPoint}`, {
      params: { username },
    });
  }
}
