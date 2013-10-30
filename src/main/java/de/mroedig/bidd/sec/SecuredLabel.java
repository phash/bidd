package de.mroedig.bidd.sec;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;

@AuthorizeAction(action = Action.RENDER)
public class SecuredLabel extends Label {

	public SecuredLabel(String id, String label) {
		super(id, label);

	}

}
