import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  constructor(private api: HttpClient) {}
  contextPath = 'http://localhost:2002/';
  loadBooksEndPoint = this.contextPath + 'user/allbooks';
  loadFeedBackEndPoint = this.contextPath + 'user/viewreview/book';

  doLoadBooks(): Observable<any> {
    return this.api.get<any>(`${this.loadBooksEndPoint}`);
  }

  doLoadFeedbacks(title: string): Observable<any> {
    return this.api.get<any>(`${this.loadFeedBackEndPoint}`, {
      params: {
        bookname: title,
      },
    });
  }
}
