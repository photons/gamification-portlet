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

package gamification.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Badge service. Represents a row in the &quot;GM_Badge&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link gamification.model.impl.BadgeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link gamification.model.impl.BadgeImpl}.
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see Badge
 * @see gamification.model.impl.BadgeImpl
 * @see gamification.model.impl.BadgeModelImpl
 * @generated
 */
public interface BadgeModel extends BaseModel<Badge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a badge model instance should use the {@link Badge} interface instead.
	 */

	/**
	 * Returns the primary key of this badge.
	 *
	 * @return the primary key of this badge
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this badge.
	 *
	 * @param primaryKey the primary key of this badge
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the badge ID of this badge.
	 *
	 * @return the badge ID of this badge
	 */
	public long getBadgeId();

	/**
	 * Sets the badge ID of this badge.
	 *
	 * @param badgeId the badge ID of this badge
	 */
	public void setBadgeId(long badgeId);

	/**
	 * Returns the company ID of this badge.
	 *
	 * @return the company ID of this badge
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this badge.
	 *
	 * @param companyId the company ID of this badge
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this badge.
	 *
	 * @return the user ID of this badge
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this badge.
	 *
	 * @param userId the user ID of this badge
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this badge.
	 *
	 * @return the user uuid of this badge
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this badge.
	 *
	 * @param userUuid the user uuid of this badge
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this badge.
	 *
	 * @return the create date of this badge
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this badge.
	 *
	 * @param createDate the create date of this badge
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this badge.
	 *
	 * @return the modified date of this badge
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this badge.
	 *
	 * @param modifiedDate the modified date of this badge
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the badge name of this badge.
	 *
	 * @return the badge name of this badge
	 */
	@AutoEscape
	public String getBadgeName();

	/**
	 * Sets the badge name of this badge.
	 *
	 * @param badgeName the badge name of this badge
	 */
	public void setBadgeName(String badgeName);

	/**
	 * Returns the badge level of this badge.
	 *
	 * @return the badge level of this badge
	 */
	public int getBadgeLevel();

	/**
	 * Sets the badge level of this badge.
	 *
	 * @param badgeLevel the badge level of this badge
	 */
	public void setBadgeLevel(int badgeLevel);

	/**
	 * Returns the data of this badge.
	 *
	 * @return the data of this badge
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this badge.
	 *
	 * @param data the data of this badge
	 */
	public void setData(String data);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Badge badge);

	public int hashCode();

	public CacheModel<Badge> toCacheModel();

	public Badge toEscapedModel();

	public String toString();

	public String toXmlString();
}