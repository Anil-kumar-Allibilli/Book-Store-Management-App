export class Cart {
  bookName: string;
  price: number;
  units: number;
  constructor(bookName: string, price: number, units: number) {
    this.bookName = bookName;
    this.price = price;
    this.units = units;
  }
}
