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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Badge}.
 * </p>
 *
 * @author    Sebastien Le Marchand
 * @see       Badge
 * @generated
 */
public class BadgeWrapper implements Badge, ModelWrapper<Badge> {
	public BadgeWrapper(Badge badge) {
		_badge = badge;
	}

	public Class<?> getModelClass() {
		return Badge.class;
	}

	public String getModelClassName() {
		return Badge.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("badgeId", getBadgeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("badgeName", getBadgeName());
		attributes.put("badgeLevel", getBadgeLevel());
		attributes.put("data", getData());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long badgeId = (Long)attributes.get("badgeId");

		if (badgeId != null) {
			setBadgeId(badgeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String badgeName = (String)attributes.get("badgeName");

		if (badgeName != null) {
			setBadgeName(badgeName);
		}

		Integer badgeLevel = (Integer)attributes.get("badgeLevel");

		if (badgeLevel != null) {
			setBadgeLevel(badgeLevel);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	* Returns the primary key of this badge.
	*
	* @return the primary key of this badge
	*/
	public long getPrimaryKey() {
		return _badge.getPrimaryKey();
	}

	/**
	* Sets the primary key of this badge.
	*
	* @param primaryKey the primary key of this badge
	*/
	public void setPrimaryKey(long primaryKey) {
		_badge.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the badge ID of this badge.
	*
	* @return the badge ID of this badge
	*/
	public long getBadgeId() {
		return _badge.getBadgeId();
	}

	/**
	* Sets the badge ID of this badge.
	*
	* @param badgeId the badge ID of this badge
	*/
	public void setBadgeId(long badgeId) {
		_badge.setBadgeId(badgeId);
	}

	/**
	* Returns the company ID of this badge.
	*
	* @return the company ID of this badge
	*/
	public long getCompanyId() {
		return _badge.getCompanyId();
	}

	/**
	* Sets the company ID of this badge.
	*
	* @param companyId the company ID of this badge
	*/
	public void setCompanyId(long companyId) {
		_badge.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this badge.
	*
	* @return the user ID of this badge
	*/
	public long getUserId() {
		return _badge.getUserId();
	}

	/**
	* Sets the user ID of this badge.
	*
	* @param userId the user ID of this badge
	*/
	public void setUserId(long userId) {
		_badge.setUserId(userId);
	}

	/**
	* Returns the user uuid of this badge.
	*
	* @return the user uuid of this badge
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badge.getUserUuid();
	}

	/**
	* Sets the user uuid of this badge.
	*
	* @param userUuid the user uuid of this badge
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_badge.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this badge.
	*
	* @return the create date of this badge
	*/
	public java.util.Date getCreateDate() {
		return _badge.getCreateDate();
	}

	/**
	* Sets the create date of this badge.
	*
	* @param createDate the create date of this badge
	*/
	public void setCreateDate(java.util.Date createDate) {
		_badge.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this badge.
	*
	* @return the modified date of this badge
	*/
	public java.util.Date getModifiedDate() {
		return _badge.getModifiedDate();
	}

	/**
	* Sets the modified date of this badge.
	*
	* @param modifiedDate the modified date of this badge
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_badge.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the badge name of this badge.
	*
	* @return the badge name of this badge
	*/
	public java.lang.String getBadgeName() {
		return _badge.getBadgeName();
	}

	/**
	* Sets the badge name of this badge.
	*
	* @param badgeName the badge name of this badge
	*/
	public void setBadgeName(java.lang.String badgeName) {
		_badge.setBadgeName(badgeName);
	}

	/**
	* Returns the badge level of this badge.
	*
	* @return the badge level of this badge
	*/
	public int getBadgeLevel() {
		return _badge.getBadgeLevel();
	}

	/**
	* Sets the badge level of this badge.
	*
	* @param badgeLevel the badge level of this badge
	*/
	public void setBadgeLevel(int badgeLevel) {
		_badge.setBadgeLevel(badgeLevel);
	}

	/**
	* Returns the data of this badge.
	*
	* @return the data of this badge
	*/
	public java.lang.String getData() {
		return _badge.getData();
	}

	/**
	* Sets the data of this badge.
	*
	* @param data the data of this badge
	*/
	public void setData(java.lang.String data) {
		_badge.setData(data);
	}

	public boolean isNew() {
		return _badge.isNew();
	}

	public void setNew(boolean n) {
		_badge.setNew(n);
	}

	public boolean isCachedModel() {
		return _badge.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_badge.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _badge.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _badge.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_badge.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _badge.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_badge.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BadgeWrapper((Badge)_badge.clone());
	}

	public int compareTo(gamification.model.Badge badge) {
		return _badge.compareTo(badge);
	}

	@Override
	public int hashCode() {
		return _badge.hashCode();
	}

	public com.liferay.portal.model.CacheModel<gamification.model.Badge> toCacheModel() {
		return _badge.toCacheModel();
	}

	public gamification.model.Badge toEscapedModel() {
		return new BadgeWrapper(_badge.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _badge.toString();
	}

	public java.lang.String toXmlString() {
		return _badge.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_badge.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Badge getWrappedBadge() {
		return _badge;
	}

	public Badge getWrappedModel() {
		return _badge;
	}

	public void resetOriginalValues() {
		_badge.resetOriginalValues();
	}

	private Badge _badge;
}