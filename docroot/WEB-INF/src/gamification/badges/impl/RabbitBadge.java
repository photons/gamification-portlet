package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;



public class RabbitBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "rabbit";
	}

	@Override
	public int getRequiredCount() {
		return 20;
	}

	@Override
	protected long getCountPeriod() {

		return 12 * HOUR;
	}
	
	

}
