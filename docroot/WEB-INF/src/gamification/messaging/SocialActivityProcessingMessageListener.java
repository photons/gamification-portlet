package gamification.messaging;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;

import gamification.hook.model.SocialActivityListener;
import gamification.service.BadgeInstanceLocalServiceUtil;
import gamification.util.MessageSender;

public class SocialActivityProcessingMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		
		if(_log.isDebugEnabled()) {
			_log.debug("doReceive(message = " + JSONFactoryUtil.serialize(message) + ")");
		}
		
		SocialActivity activity = (SocialActivity)message.get("activity");
		AssetEntry assetEntry = (AssetEntry)message.get("assetEntry");
		
		long activityId = activity.getActivityId();
		
		SocialActivity fetchedActivity = SocialActivityLocalServiceUtil.fetchSocialActivity(activityId);
		
		boolean consistent = fetchedActivity != null;
		
		consistent = consistent 
				&& (assetEntry == null || assetEntry.equals(fetchedActivity.getAssetEntry()));
			
		
		if(consistent) {
		
			BadgeInstanceLocalServiceUtil.processSocialActivity(activityId);
		
		} else {
			
			MessageSender.resendMessage(message);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(SocialActivityListener.class);
}
