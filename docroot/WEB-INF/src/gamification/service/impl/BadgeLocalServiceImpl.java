/**
 * Copyright (c) 2013 Sebastien Le Marchand. All rights reserved.
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

import gamification.model.Badge;
import gamification.service.base.BadgeLocalServiceBaseImpl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the badge local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link gamification.service.BadgeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sebastien Le Marchand
 * 
 * @see gamification.service.base.BadgeLocalServiceBaseImpl
 * @see gamification.service.BadgeLocalServiceUtil
 */
public class BadgeLocalServiceImpl extends BadgeLocalServiceBaseImpl {

	public Badge addBadge(long userId, String badgeName) throws SystemException {
		
		long badgeId = counterLocalService.increment();

		Badge badge = badgePersistence.create(badgeId);
		
		badge.setUserId(userId);
		badge.setBadgeName(badgeName);
		badge.setBadgeLevel(0);
		badge.setData(null);
		
		badge = badgePersistence.update(badge, false);
		
		return badge;
	}
	
	public Badge checkBadge(long userId, String badgeName) throws SystemException {
		
		Badge badge = fetchBadge(userId, badgeName);
		
		if(badge == null) {
			
			badge = addBadge(userId, badgeName);
		}
		
		return badge;
	}
	
	public Badge fetchBadge(long userId, String badgeName) throws SystemException {
		return badgePersistence.fetchByUserIdBadgeName(userId, badgeName);
	}
	
	public List<Badge> getBadges(long userId) throws SystemException {

			return badgePersistence.findByUserId(userId);
	}

	@Override
	public Badge updateBadge(Badge badge)
		throws SystemException {

		// TODO Auto-generated method stub
		return super.updateBadge(badge);
	}

	@Override
	public Badge updateBadge(Badge badge, boolean merge)
		throws SystemException {

		// TODO Auto-generated method stub
		return super.updateBadge(badge, merge);
	}
	
	
}