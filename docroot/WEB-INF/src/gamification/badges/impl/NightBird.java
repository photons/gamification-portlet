package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;

import java.util.Calendar;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.social.model.SocialActivity;



public class NightBird extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "nightbird";
	}

	@Override
	public int getRequiredCount() {
		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws SystemException, PortalException {
		
		Calendar date = Calendar.getInstance();
		date.setTimeInMillis(activity.getCreateDate());
		int hour = date.get(Calendar.HOUR_OF_DAY);
		
		boolean match = hour > 22 || hour < 6;
		
		return match;
	}

	
}
