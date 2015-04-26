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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import gamification.service.BadgeInstanceLocalServiceUtil;
import gamification.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sebastien Le Marchand
 */
public class BadgeInstanceClp extends BaseModelImpl<BadgeInstance>
	implements BadgeInstance {
	public BadgeInstanceClp() {
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
	public long getPrimaryKey() {
		return _badgeInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBadgeInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _badgeInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getBadgeInstanceId() {
		return _badgeInstanceId;
	}

	@Override
	public void setBadgeInstanceId(long badgeInstanceId) {
		_badgeInstanceId = badgeInstanceId;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setBadgeInstanceId", long.class);

				method.invoke(_badgeInstanceRemoteModel, badgeInstanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_badgeInstanceRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_badgeInstanceRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_badgeInstanceRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_badgeInstanceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBadgeName() {
		return _badgeName;
	}

	@Override
	public void setBadgeName(String badgeName) {
		_badgeName = badgeName;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setBadgeName", String.class);

				method.invoke(_badgeInstanceRemoteModel, badgeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBadgeLevel() {
		return _badgeLevel;
	}

	@Override
	public void setBadgeLevel(int badgeLevel) {
		_badgeLevel = badgeLevel;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setBadgeLevel", int.class);

				method.invoke(_badgeInstanceRemoteModel, badgeLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData() {
		return _data;
	}

	@Override
	public void setData(String data) {
		_data = data;

		if (_badgeInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _badgeInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setData", String.class);

				method.invoke(_badgeInstanceRemoteModel, data);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBadgeInstanceRemoteModel() {
		return _badgeInstanceRemoteModel;
	}

	public void setBadgeInstanceRemoteModel(
		BaseModel<?> badgeInstanceRemoteModel) {
		_badgeInstanceRemoteModel = badgeInstanceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _badgeInstanceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_badgeInstanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BadgeInstanceLocalServiceUtil.addBadgeInstance(this);
		}
		else {
			BadgeInstanceLocalServiceUtil.updateBadgeInstance(this);
		}
	}

	@Override
	public BadgeInstance toEscapedModel() {
		return (BadgeInstance)ProxyUtil.newProxyInstance(BadgeInstance.class.getClassLoader(),
			new Class[] { BadgeInstance.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BadgeInstanceClp clone = new BadgeInstanceClp();

		clone.setBadgeInstanceId(getBadgeInstanceId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBadgeName(getBadgeName());
		clone.setBadgeLevel(getBadgeLevel());
		clone.setData(getData());

		return clone;
	}

	@Override
	public int compareTo(BadgeInstance badgeInstance) {
		int value = 0;

		if (getUserId() < badgeInstance.getUserId()) {
			value = -1;
		}
		else if (getUserId() > badgeInstance.getUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreateDate(),
				badgeInstance.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BadgeInstanceClp)) {
			return false;
		}

		BadgeInstanceClp badgeInstance = (BadgeInstanceClp)obj;

		long primaryKey = badgeInstance.getPrimaryKey();

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

		sb.append("{badgeInstanceId=");
		sb.append(getBadgeInstanceId());
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

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("gamification.model.BadgeInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>badgeInstanceId</column-name><column-value><![CDATA[");
		sb.append(getBadgeInstanceId());
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

	private long _badgeInstanceId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _badgeName;
	private int _badgeLevel;
	private String _data;
	private BaseModel<?> _badgeInstanceRemoteModel;
}