export class SendMail {
  recipient: string;
  msgBody: string;
  subject: string;
  constructor(recipient: string, msgBody: string, subject: string) {
    this.recipient = recipient;
    this.msgBody = msgBody;
    this.subject = subject;
  }
}
