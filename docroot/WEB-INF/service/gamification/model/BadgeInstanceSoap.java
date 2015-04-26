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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link gamification.service.http.BadgeInstanceServiceSoap}.
 *
 * @author Sebastien Le Marchand
 * @see gamification.service.http.BadgeInstanceServiceSoap
 * @generated
 */
public class BadgeInstanceSoap implements Serializable {
	public static BadgeInstanceSoap toSoapModel(BadgeInstance model) {
		BadgeInstanceSoap soapModel = new BadgeInstanceSoap();

		soapModel.setBadgeInstanceId(model.getBadgeInstanceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBadgeName(model.getBadgeName());
		soapModel.setBadgeLevel(model.getBadgeLevel());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static BadgeInstanceSoap[] toSoapModels(BadgeInstance[] models) {
		BadgeInstanceSoap[] soapModels = new BadgeInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BadgeInstanceSoap[][] toSoapModels(BadgeInstance[][] models) {
		BadgeInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BadgeInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BadgeInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BadgeInstanceSoap[] toSoapModels(List<BadgeInstance> models) {
		List<BadgeInstanceSoap> soapModels = new ArrayList<BadgeInstanceSoap>(models.size());

		for (BadgeInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BadgeInstanceSoap[soapModels.size()]);
	}

	public BadgeInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _badgeInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setBadgeInstanceId(pk);
	}

	public long getBadgeInstanceId() {
		return _badgeInstanceId;
	}

	public void setBadgeInstanceId(long badgeInstanceId) {
		_badgeInstanceId = badgeInstanceId;
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

	private long _badgeInstanceId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _badgeName;
	private int _badgeLevel;
	private String _data;
}