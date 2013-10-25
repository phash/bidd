package de.mroedig.bidd;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class RegisterPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4443294994962993748L;

	@Override
	protected void onInitialize() {
		add(new RegistrationForm("registerForm"));
		add(new FeedbackPanel("feedbackPanel"));
	}

}
