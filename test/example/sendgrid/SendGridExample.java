package example.sendgrid;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

/**
 * Created by 1002702 on 2016. 1. 11..
 */
public class SendGridExample {
	public static void main(String[] args) {
		SendGrid sendgrid = new SendGrid("Pyohwan", "acamp1234");

		SendGrid.Email email = new SendGrid.Email();

		email.addTo("pyohwan.jang@sk.com");
		email.setFrom("pyohwan.jang@sk.com");
		email.setSubject("Sending with SendGrid is Fun");
		email.setHtml("and easy to do anywhere, even with Java");

		try {
			SendGrid.Response response = sendgrid.send(email);
			System.out.println(response.getMessage());
		}
		catch (SendGridException e) {
			System.err.println(e);
		}
	}
}
