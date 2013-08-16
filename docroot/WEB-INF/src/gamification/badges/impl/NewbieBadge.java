package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;


public class NewbieBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "newbie";
	}

	@Override
	public int getRequiredCount() {
		return 1;
	}
}
