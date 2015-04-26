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

package gamification.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BadgeInstance}.
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see BadgeInstance
 * @generated
 */
public class BadgeInstanceWrapper implements BadgeInstance,
	ModelWrapper<BadgeInstance> {
	public BadgeInstanceWrapper(BadgeInstance badgeInstance) {
		_badgeInstance = badgeInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return BadgeInstance.class;
	}

	@Override
	public String getModelClassName() {
		return BadgeInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("badgeInstanceId", getBadgeInstanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("badgeName", getBadgeName());
		attributes.put("badgeLevel", getBadgeLevel());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long badgeInstanceId = (Long)attributes.get("badgeInstanceId");

		if (badgeInstanceId != null) {
			setBadgeInstanceId(badgeInstanceId);
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
	* Returns the primary key of this badge instance.
	*
	* @return the primary key of this badge instance
	*/
	@Override
	public long getPrimaryKey() {
		return _badgeInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this badge instance.
	*
	* @param primaryKey the primary key of this badge instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_badgeInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the badge instance ID of this badge instance.
	*
	* @return the badge instance ID of this badge instance
	*/
	@Override
	public long getBadgeInstanceId() {
		return _badgeInstance.getBadgeInstanceId();
	}

	/**
	* Sets the badge instance ID of this badge instance.
	*
	* @param badgeInstanceId the badge instance ID of this badge instance
	*/
	@Override
	public void setBadgeInstanceId(long badgeInstanceId) {
		_badgeInstance.setBadgeInstanceId(badgeInstanceId);
	}

	/**
	* Returns the company ID of this badge instance.
	*
	* @return the company ID of this badge instance
	*/
	@Override
	public long getCompanyId() {
		return _badgeInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this badge instance.
	*
	* @param companyId the company ID of this badge instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_badgeInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this badge instance.
	*
	* @return the user ID of this badge instance
	*/
	@Override
	public long getUserId() {
		return _badgeInstance.getUserId();
	}

	/**
	* Sets the user ID of this badge instance.
	*
	* @param userId the user ID of this badge instance
	*/
	@Override
	public void setUserId(long userId) {
		_badgeInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this badge instance.
	*
	* @return the user uuid of this badge instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this badge instance.
	*
	* @param userUuid the user uuid of this badge instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_badgeInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this badge instance.
	*
	* @return the create date of this badge instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _badgeInstance.getCreateDate();
	}

	/**
	* Sets the create date of this badge instance.
	*
	* @param createDate the create date of this badge instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_badgeInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this badge instance.
	*
	* @return the modified date of this badge instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _badgeInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this badge instance.
	*
	* @param modifiedDate the modified date of this badge instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_badgeInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the badge name of this badge instance.
	*
	* @return the badge name of this badge instance
	*/
	@Override
	public java.lang.String getBadgeName() {
		return _badgeInstance.getBadgeName();
	}

	/**
	* Sets the badge name of this badge instance.
	*
	* @param badgeName the badge name of this badge instance
	*/
	@Override
	public void setBadgeName(java.lang.String badgeName) {
		_badgeInstance.setBadgeName(badgeName);
	}

	/**
	* Returns the badge level of this badge instance.
	*
	* @return the badge level of this badge instance
	*/
	@Override
	public int getBadgeLevel() {
		return _badgeInstance.getBadgeLevel();
	}

	/**
	* Sets the badge level of this badge instance.
	*
	* @param badgeLevel the badge level of this badge instance
	*/
	@Override
	public void setBadgeLevel(int badgeLevel) {
		_badgeInstance.setBadgeLevel(badgeLevel);
	}

	/**
	* Returns the data of this badge instance.
	*
	* @return the data of this badge instance
	*/
	@Override
	public java.lang.String getData() {
		return _badgeInstance.getData();
	}

	/**
	* Sets the data of this badge instance.
	*
	* @param data the data of this badge instance
	*/
	@Override
	public void setData(java.lang.String data) {
		_badgeInstance.setData(data);
	}

	@Override
	public boolean isNew() {
		return _badgeInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_badgeInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _badgeInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_badgeInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _badgeInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _badgeInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_badgeInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _badgeInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_badgeInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_badgeInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_badgeInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BadgeInstanceWrapper((BadgeInstance)_badgeInstance.clone());
	}

	@Override
	public int compareTo(gamification.model.BadgeInstance badgeInstance) {
		return _badgeInstance.compareTo(badgeInstance);
	}

	@Override
	public int hashCode() {
		return _badgeInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<gamification.model.BadgeInstance> toCacheModel() {
		return _badgeInstance.toCacheModel();
	}

	@Override
	public gamification.model.BadgeInstance toEscapedModel() {
		return new BadgeInstanceWrapper(_badgeInstance.toEscapedModel());
	}

	@Override
	public gamification.model.BadgeInstance toUnescapedModel() {
		return new BadgeInstanceWrapper(_badgeInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _badgeInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _badgeInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_badgeInstance.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeInstanceWrapper)) {
			return false;
		}

		BadgeInstanceWrapper badgeInstanceWrapper = (BadgeInstanceWrapper)obj;

		if (Validator.equals(_badgeInstance, badgeInstanceWrapper._badgeInstance)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BadgeInstance getWrappedBadgeInstance() {
		return _badgeInstance;
	}

	@Override
	public BadgeInstance getWrappedModel() {
		return _badgeInstance;
	}

	@Override
	public void resetOriginalValues() {
		_badgeInstance.resetOriginalValues();
	}

	private BadgeInstance _badgeInstance;
}