package gamification.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.messaging.DestinationNames;

public class MessageSender {

	public static void sendMessage(SocialActivity model) throws SystemException {
		com.liferay.portal.kernel.messaging.Message message =
				new com.liferay.portal.kernel.messaging.Message();
			
			AssetEntry assetEntry = model.getAssetEntry();
		
			message.put("retryCount", 0);
			message.put("activity", model);
			if(assetEntry != null) {
				message.put("assetEntry", assetEntry);
			}
			
			sendMessage(message);
	}
	
	public static void resendMessage(Message message) {
		
		int retryCount = message.getInteger("retryCount");
		retryCount++;
		message.put("retryCount", retryCount);
		
		MessageBusUtil.sendMessage(DestinationNames.SOCIAL_ACTIVITY_PROCESSOR, message);
	}
	
	private static void sendMessage(Message message) {
		MessageBusUtil.sendMessage(DestinationNames.SOCIAL_ACTIVITY_PROCESSOR, message);
	}

}
