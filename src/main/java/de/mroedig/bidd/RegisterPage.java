package de.mroedig.bidd;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class RegisterPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4443294994962993748L;

	public RegisterPage(PageParameters parameters) {
		add(new RegistrationForm("registerForm"));
		add(new FeedbackPanel("feedback"));
	}

}
