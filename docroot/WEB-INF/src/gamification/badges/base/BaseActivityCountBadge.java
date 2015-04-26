/**
 * Copyright (c) 2013 Sébastien Le Marchand, All rights reserved.
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

package gamification.badges.base;

import gamification.badges.BadgeDefinition;
import gamification.model.BadgeInstance;
import gamification.service.BadgeInstanceLocalServiceUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.social.model.SocialActivity;

/**
 * @author Sebastien Le Marchand
 */
public abstract class BaseActivityCountBadge implements BadgeDefinition {

	protected final static long SECOND = 1000;
	
	protected final static long MINUTE = 60 * SECOND;
	
	protected final static long HOUR = 60 * MINUTE;
	
	protected final static long DAY = 24* HOUR;
	
	protected final static long WEEK = 7 * DAY;
	
	protected final static long MONTH = 30 * DAY;
	 
	protected static class Data {
		
		public LinkedList<Long> dates  = new LinkedList<Long>();
	}
	
	@Override
	public void processActivity(SocialActivity activity) throws SystemException, PortalException {
		if(match(activity)) {
			
			if(_log.isDebugEnabled()) {
				_log.debug(String.format("Matching SocialActivity %1$d and badge %2$s", activity.getActivityId(), getName()));
			}
			
			long userId = activity.getUserId();
			long createDate = activity.getCreateDate();
			
			_processUserBadge(userId, createDate);
		}
	}
	
	protected void _processUserBadge(long userId, long createDate) throws SystemException, PortalException {
			
		String badgeName = getName();
		
		BadgeInstance badgeInstance = BadgeInstanceLocalServiceUtil.checkBadgeInstance(userId, badgeName);
		
		int level = badgeInstance.getBadgeLevel();
		
		if(level < getMaximumLevel()) {
		
			List<Long >dates = _deserializeDates(badgeInstance.getData());
			
			if(!dates.isEmpty()) {
				
				long countPeriod = getCountPeriod();
				
				Iterator<Long> it = dates.iterator();
				
				while(it.hasNext()) {
					long date = it.next();
					if(createDate - date > countPeriod) {
						it.remove();
					}
				}
			}
			
			dates.add(createDate);
			
			if(dates.size() >= getRequiredCount()) {
				level += 1;
				badgeInstance.setBadgeLevel(level);
				dates.clear();
			}
			
			badgeInstance.setData(_serializeDates(dates));
			
			BadgeInstanceLocalServiceUtil.updateBadgeInstance(badgeInstance);
		}
	}
	
	protected boolean match(SocialActivity activity) throws SystemException, PortalException {
		return true;
	}

	protected int getMaximumLevel() {
		return 1;
	}
	
	protected long getCountPeriod() {
		return Long.MAX_VALUE;
	}
	
	public abstract int getRequiredCount();
	
	private String _serializeDates(List<Long> dates ) {
		return JSONFactoryUtil.serialize(dates.toArray(new Long[]{}));
	}
	
	private List<Long> _deserializeDates(String json) {
		List<Long> dates = new LinkedList<Long>();
		
		if(Validator.isNotNull(json)) {
			dates.addAll(Arrays.asList((Long[])JSONFactoryUtil.deserialize(json)));
		} 
		
		return dates;
	}

	private Log _log = LogFactoryUtil.getLog(BaseActivityCountBadge.class);
}
