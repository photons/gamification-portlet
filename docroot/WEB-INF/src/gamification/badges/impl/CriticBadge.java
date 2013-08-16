
package gamification.badges.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityConstants;

import gamification.badges.base.BaseActivityCountBadge;

public class CriticBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {

		return "critic";
	}

	@Override
	public int getRequiredCount() {

		return 50;
	}

	
	@Override
	protected long getCountPeriod() {
		
		return 1 * MONTH;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws SystemException, PortalException {

		boolean match = activity.getType() == SocialActivityConstants.TYPE_ADD_VOTE;
	
		return match;
	}
	
	

}
