package gamification.badges.impl;

import gamification.badges.base.BaseActivityCountBadge;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;



public class HumanBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "human";
	}

	@Override
	public int getRequiredCount() {
		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity) throws SystemException {

		AssetEntry entry = activity.getAssetEntry();
		
		String[] tags = entry.getTagNames();
		
		boolean match = false;
		
		for (int i = 0; i < tags.length && !match; i++) {
			String tag = tags[i];
			match = tag.equalsIgnoreCase("humanresources")
							|| tag.equalsIgnoreCase("human resources")
							|| tag.equalsIgnoreCase("hr");
		}
		
		return match;
	}
	
	

}
