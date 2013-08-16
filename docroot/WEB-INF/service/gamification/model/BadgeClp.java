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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import gamification.service.BadgeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sebastien Le Marchand
 */
public class BadgeClp extends BaseModelImpl<Badge> implements Badge {
	public BadgeClp() {
	}

	public Class<?> getModelClass() {
		return Badge.class;
	}

	public String getModelClassName() {
		return Badge.class.getName();
	}

	public long getPrimaryKey() {
		return _badgeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBadgeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_badgeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getBadgeId() {
		return _badgeId;
	}

	public void setBadgeId(long badgeId) {
		_badgeId = badgeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getBadgeName() {
		return _badgeName;
	}

	public void setBadgeName(String badgeName) {
		_badgeName = badgeName;
	}

	public int getBadgeLevel() {
		return _badgeLevel;
	}

	public void setBadgeLevel(int badgeLevel) {
		_badgeLevel = badgeLevel;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	public BaseModel<?> getBadgeRemoteModel() {
		return _badgeRemoteModel;
	}

	public void setBadgeRemoteModel(BaseModel<?> badgeRemoteModel) {
		_badgeRemoteModel = badgeRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BadgeLocalServiceUtil.addBadge(this);
		}
		else {
			BadgeLocalServiceUtil.updateBadge(this);
		}
	}

	@Override
	public Badge toEscapedModel() {
		return (Badge)Proxy.newProxyInstance(Badge.class.getClassLoader(),
			new Class[] { Badge.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BadgeClp clone = new BadgeClp();

		clone.setBadgeId(getBadgeId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBadgeName(getBadgeName());
		clone.setBadgeLevel(getBadgeLevel());
		clone.setData(getData());

		return clone;
	}

	public int compareTo(Badge badge) {
		int value = 0;

		if (getUserId() < badge.getUserId()) {
			value = -1;
		}
		else if (getUserId() > badge.getUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(), badge.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BadgeClp badge = null;

		try {
			badge = (BadgeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = badge.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{badgeId=");
		sb.append(getBadgeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", badgeName=");
		sb.append(getBadgeName());
		sb.append(", badgeLevel=");
		sb.append(getBadgeLevel());
		sb.append(", data=");
		sb.append(getData());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("gamification.model.Badge");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>badgeId</column-name><column-value><![CDATA[");
		sb.append(getBadgeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>badgeName</column-name><column-value><![CDATA[");
		sb.append(getBadgeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>badgeLevel</column-name><column-value><![CDATA[");
		sb.append(getBadgeLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _badgeId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _badgeName;
	private int _badgeLevel;
	private String _data;
	private BaseModel<?> _badgeRemoteModel;
}