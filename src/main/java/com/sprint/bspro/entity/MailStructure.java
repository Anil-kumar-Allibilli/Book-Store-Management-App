package com.sprint.bspro.entity;

public class MailStructure {
	private String recipient;
    private String msgBody;
    private String subject;
    
    /**
     * Retrieves the recipient of the message.
     *
     * @return The recipient of the message.
     */
	public String getRecipient() {
		return recipient;
	}
	/**
     * Sets the recipient for the message.
     *
     * @param recipient The recipient to be set for the message.
     */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	/**
     * Retrieves the message body content.
     *
     * @return The message body content.
     */
	public String getMsgBody() {
		return msgBody;
	}
	/**
     * Sets the message body content.
     *
     * @param msgBody The message body content to be set.
     */
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	/**
     * Retrieves the subject of the message.
     *
     * @return The subject of the message.
     */
	public String getSubject() {
		return subject;
	}
	/**
     * Sets the subject for the message.
     *
     * @param subject The subject to be set for the message.
     */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public MailStructure(String recipient, String msgBody, String subject) {
		super();
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
	}
	public MailStructure() {
		super();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
    
}
