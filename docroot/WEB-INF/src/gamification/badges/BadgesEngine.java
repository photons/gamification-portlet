package gamification.badges;


import gamification.badges.impl.CleanerBadge;
import gamification.badges.impl.CriticBadge;
import gamification.badges.impl.HumanBadge;
import gamification.badges.impl.LibrarianBadge;
import gamification.badges.impl.NewbieBadge;
import gamification.badges.impl.NightBird;
import gamification.badges.impl.PhotographerBadge;
import gamification.badges.impl.RabbitBadge;
import gamification.badges.impl.RegularBadge;
import gamification.badges.impl.SuperstarBadge;
import gamification.badges.impl.TalkativeBadge;
import gamification.badges.impl.ThumbAddictBadge;
import gamification.badges.impl.WriterBadge;

import java.util.LinkedList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;


public class BadgesEngine {
	
	public static void processActivity(SocialActivity activity) throws SystemException {
		
		if(_log.isDebugEnabled()) {
			_log.debug("Processing SocialActivity " 
							+ _toString(activity));	
		}
		
		for (BadgeDefinition badgeDefinition : getBadgeDefinitions()) {
			
			if(_log.isDebugEnabled()) {
				_log.debug("Processing SocialActivity "
								+ activity.getActivityId()
								+ " for " + badgeDefinition.getName());
			}
			
			try {
				badgeDefinition.processActivity(activity);
			}
			catch (SystemException e) {
				_log.error(e);
			}
			catch (PortalException e) {
				_log.error(e);
			}
		}
	}
	
	public static List<BadgeDefinition> getBadgeDefinitions() {
		return _badgeDefinitions;	
	}
	
	private static String _toString(SocialActivity activity) throws SystemException {
		
		AssetEntry entry = activity.getAssetEntry();
		
		String string = String.format(
			"activityId:%1$d, assetEntry.entryId:%2$d, type:%3$d, className:%4$s, assetEntry.className:%5$s, classPK:%6$d, assetEntry.classPK:%7$d, "
			+ "createDate:%8$d, assetEntry.createDate:%9$d, userId:%10$d, assetEntry.userId: %11$d, receiverUserId:%12$d,"
			+ "mirrorActivityId:%13$d, groupId:%14$d, assetEntry.groupId:%15$d, extraData:%16$s",				
			activity.getActivityId(),
			entry.getEntryId(),
			activity.getType(),
			activity.getClassName(),
			entry.getClassName(),
			activity.getClassPK(),
			entry.getClassPK(),
			activity.getCreateDate(),
			entry.getCreateDate().getTime(),
			activity.getUserId(),
			entry.getUserId(),
			activity.getReceiverUserId(),
			activity.getMirrorActivityId(),
			activity.getGroupId(),
			entry.getGroupId(),
			activity.getExtraData());
		
		return string;
	}
	
	private static List<BadgeDefinition> _badgeDefinitions;
	
	static {
		_badgeDefinitions = new LinkedList<BadgeDefinition>();
		_badgeDefinitions.add(new NewbieBadge());
		_badgeDefinitions.add(new RegularBadge());
		_badgeDefinitions.add(new SuperstarBadge());
		_badgeDefinitions.add(new HumanBadge());
		_badgeDefinitions.add(new NightBird());
		_badgeDefinitions.add(new TalkativeBadge());
		//_badgeDefinitions.add(new ThumbAddictBadge());
		_badgeDefinitions.add(new LibrarianBadge());
		_badgeDefinitions.add(new WriterBadge());
		//_badgeDefinitions.add(new CriticBadge());
		//_badgeDefinitions.add(new CleanerBadge());
		_badgeDefinitions.add(new RabbitBadge());
		_badgeDefinitions.add(new PhotographerBadge());
	}
	
	private static final Log _log = LogFactoryUtil.getLog(BadgesEngine.class);

}
