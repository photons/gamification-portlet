package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;


public class SuperstarBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "superstar";
	}

	@Override
	public int getRequiredCount() {
		return 100;
	}
}
