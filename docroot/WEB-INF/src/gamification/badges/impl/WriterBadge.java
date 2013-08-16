
package gamification.badges.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.badges.base.BaseActivityCountBadge;
import gamification.social.BlogsActivityKeys;

public class WriterBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {

		return "writer";
	}

	@Override
	public int getRequiredCount() {

		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws SystemException, PortalException {

		boolean match = 
			activity.getClassName().equals(BlogsEntry.class) && activity.getType() == BlogsActivityKeys.ADD_ENTRY;
		
		return match;
	}
	
}
