package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;

import com.liferay.portlet.social.model.SocialActivity;

/**
 * 
 * @author Sebastien Le Marchand
 * 
 * NOT YET IMPLEMENTED
 *
 */
public class CleanerBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "cleaner";
	}

	@Override
	protected boolean match(SocialActivity activity) {
		return true; // TODO
	}

	@Override
	public int getRequiredCount() {

		return 10;
	}
	
	

}
