package gamification.badges;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.model.SocialActivityAchievement;
import com.liferay.portlet.social.model.SocialActivityCounter;


public interface BadgeDefinition {
	
	public String getName();

	public void processActivity(SocialActivity socialActivity) throws SystemException, PortalException;
}
