/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package gamification.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.social.model.SocialActivity;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;

import java.util.List;

import gamification.badges.BadgesEngine;
import gamification.model.BadgeInstance;
import gamification.service.base.BadgeInstanceLocalServiceBaseImpl;

/**
 * The implementation of the badgeInstance instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link gamification.service.BadgeInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see gamification.service.base.BadgeInstanceLocalServiceBaseImpl
 * @see gamification.service.BadgeInstanceLocalServiceUtil
 */
public class BadgeInstanceLocalServiceImpl
	extends BadgeInstanceLocalServiceBaseImpl {

	public void processSocialActivity(long activityId) throws SystemException, PortalException {
		SocialActivity socialActivity = SocialActivityLocalServiceUtil.getSocialActivity(activityId);
		BadgesEngine.processActivity(socialActivity);
	}
	
	public BadgeInstance addBadgeInstance(long userId, String badgeInstanceName) throws SystemException {
		
		long badgeInstanceId = counterLocalService.increment();

		BadgeInstance badgeInstance = badgeInstancePersistence.create(badgeInstanceId);
		
		badgeInstance.setUserId(userId);
		badgeInstance.setBadgeName(badgeInstanceName);
		badgeInstance.setBadgeLevel(0);
		badgeInstance.setData(null);
		
		badgeInstance = badgeInstancePersistence.update(badgeInstance);
		
		return badgeInstance;
	}
	
	public BadgeInstance checkBadgeInstance(long userId, String badgeInstanceName) throws SystemException {
		
		BadgeInstance badgeInstance = fetchBadgeInstance(userId, badgeInstanceName);
		
		if(badgeInstance == null) {
			
			badgeInstance = addBadgeInstance(userId, badgeInstanceName);
		}
		
		return badgeInstance;
	}
	
	public BadgeInstance fetchBadgeInstance(long userId, String badgeName) throws SystemException {
		return badgeInstancePersistence.fetchByUserIdBadgeName(userId, badgeName);
	}
	
	public List<BadgeInstance> getBadges(long userId) throws SystemException {

			return badgeInstancePersistence.findByUserId(userId);
	}	
}