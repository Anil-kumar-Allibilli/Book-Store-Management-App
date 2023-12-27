export class ResetPassword {
  password: string;
  otp: string;
  username: string;
  constructor(otp: string, password: string, username: string) {
    this.otp = otp;
    this.password = password;
    this.username = username;
  }
}
