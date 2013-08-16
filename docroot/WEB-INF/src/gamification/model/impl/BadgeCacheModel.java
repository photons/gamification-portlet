/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package gamification.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import gamification.model.Badge;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Badge in entity cache.
 *
 * @author Sebastien Le Marchand
 * @see Badge
 * @generated
 */
public class BadgeCacheModel implements CacheModel<Badge>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{badgeId=");
		sb.append(badgeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", badgeName=");
		sb.append(badgeName);
		sb.append(", badgeLevel=");
		sb.append(badgeLevel);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	public Badge toEntityModel() {
		BadgeImpl badgeImpl = new BadgeImpl();

		badgeImpl.setBadgeId(badgeId);
		badgeImpl.setCompanyId(companyId);
		badgeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			badgeImpl.setCreateDate(null);
		}
		else {
			badgeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			badgeImpl.setModifiedDate(null);
		}
		else {
			badgeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (badgeName == null) {
			badgeImpl.setBadgeName(StringPool.BLANK);
		}
		else {
			badgeImpl.setBadgeName(badgeName);
		}

		badgeImpl.setBadgeLevel(badgeLevel);

		if (data == null) {
			badgeImpl.setData(StringPool.BLANK);
		}
		else {
			badgeImpl.setData(data);
		}

		badgeImpl.resetOriginalValues();

		return badgeImpl;
	}

	public long badgeId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String badgeName;
	public int badgeLevel;
	public String data;
}