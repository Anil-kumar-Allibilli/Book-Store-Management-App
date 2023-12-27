export class RegisterUser {
  password: string;
  username: string;
  userrole: string;
  name: string;
  houseAddress: string;
  city: string;
  country: string;
  email: string;
  phone: number;
  region: string;
  nativeLanguage: string;
  fullName: string;
  constructor(
    password: string,
    username: string,
    userrole: string,
    name: string,
    houseAddress: string,
    city: string,
    country: string,
    email: string,
    phone: number,
    region: string,
    nativeLanguage: string,
    fullName: string
  ) {
    this.city = city;
    this.country = country;
    this.email = email;
    this.fullName = fullName;
    this.houseAddress = houseAddress;
    this.name = name;
    this.nativeLanguage = nativeLanguage;
    this.password = password;
    this.phone = phone;
    this.region = region;
    this.username = username;
    this.userrole = userrole;
  }
}
