package cafe.jjdev.mall.vo;

public class Email {
	private String subject;
	private String recipient;
	private String text;

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Email [subject=" + subject + ", recipient=" + recipient + ", text=" + text + "]";
	}


	
	

}
