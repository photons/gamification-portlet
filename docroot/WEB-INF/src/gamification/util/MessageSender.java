/**
 * Copyright (c) 2013-present Sébastien Le Marchand, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gamification.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.messaging.DestinationNames;
public class MessageSender {

	public static void resendMessage(Message message) {

		int retryCount = message.getInteger("retryCount");
		retryCount++;
		message.put("retryCount", retryCount);

		MessageBusUtil.sendMessage(DestinationNames.SOCIAL_ACTIVITY_PROCESSOR, message);
	}

	public static void sendMessage(SocialActivity model) throws SystemException {
		com.liferay.portal.kernel.messaging.Message message =
				new com.liferay.portal.kernel.messaging.Message();

			AssetEntry assetEntry = model.getAssetEntry();

			message.put("retryCount", 0);
			message.put("activity", model);

			if (assetEntry != null) {
				message.put("assetEntry", assetEntry);
			}

			sendMessage(message);
	}

	private static void sendMessage(Message message) {
		MessageBusUtil.sendMessage(DestinationNames.SOCIAL_ACTIVITY_PROCESSOR, message);
	}

}