import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Authorinfo } from '../authorinfo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthorService {
  author: Authorinfo = new Authorinfo();
  constructor(private api: HttpClient) {}
  contextPath = 'http://localhost:2002/';
  checkAuthorStatusEndPoint = this.contextPath + 'author/viewauthorbyname';
  getAuthorsByStatusEndPoint = this.contextPath + 'admin/viewauthor/status';
  updateAuthorStatusEndPoint = this.contextPath + 'admin/updateauthorstatus';
  getAllAuthorsEndPoint = this.contextPath + 'admin/viewallauthor';
  doAuthorStatusCheck(username: string): Observable<any> {
    return this.api.get<any>(`${this.checkAuthorStatusEndPoint}`, {
      params: { username: username },
    });
  }
  doGetAllAuthorByStatus(status: string): Observable<any> {
    return this.api.get<any>(`${this.getAuthorsByStatusEndPoint}`, {
      params: { status },
    });
  }
  doGetAllAuthor(): Observable<any> {
    return this.api.get<any>(`${this.getAllAuthorsEndPoint}`, {
      params: { status },
    });
  }
  doApprove(usercode: number, status: string): Observable<any> {
    console.log(usercode + '--------' + status);
    // const params = new HttpParams()
    //   .set('usercode', usercode)
    //   .set('status', status);
    return this.api.put<any>(
      `${
        this.updateAuthorStatusEndPoint +
        '?usercode=' +
        usercode +
        '&status=' +
        status
      }`,
      ''
    );
  }
}
