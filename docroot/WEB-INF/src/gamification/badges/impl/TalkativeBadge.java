package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;
import gamification.social.MBActivityKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityConstants;


public class TalkativeBadge extends BaseActivityCountBadge {
	
	@Override
	public String getName() {
		return "talkative";
	}

	@Override
	public int getRequiredCount() {
		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws SystemException, PortalException {

		boolean match = (activity.getType() == SocialActivityConstants.TYPE_ADD_COMMENT)
						|| (activity.getClassName().equals(MBMessage.class.getName()) &&
										(activity.getType() == MBActivityKeys.ADD_MESSAGE)
										|| activity.getType() == MBActivityKeys.REPLY_MESSAGE);
		
		return match;
	}
}
