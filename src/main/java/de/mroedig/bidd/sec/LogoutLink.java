package de.mroedig.bidd.sec;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.Link;

@AuthorizeAction(action = Action.RENDER, roles = { "ADMIN", "USER" })
public class LogoutLink extends Link<Void> {

	public LogoutLink(String id) {
		super(id);

	}

	@Override
	public void onClick() {
		getSession().invalidate();

	}

}
