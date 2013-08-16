package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;

/**
 * 
 * @author Sebastien
 *
 * NOT YET IMPLEMENTED
 */
public class ThumbAddictBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "thumbaddict";
	}

	@Override
	public int getRequiredCount() {
		return 20;
	}

}
