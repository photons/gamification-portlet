package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;



public class RegularBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "regular";
	}

	@Override
	public int getRequiredCount() {
		return 10;
	}
}
