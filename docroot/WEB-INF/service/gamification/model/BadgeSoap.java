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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Sebastien Le Marchand
 * @generated
 */
public class BadgeSoap implements Serializable {
	public static BadgeSoap toSoapModel(Badge model) {
		BadgeSoap soapModel = new BadgeSoap();

		soapModel.setBadgeId(model.getBadgeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBadgeName(model.getBadgeName());
		soapModel.setBadgeLevel(model.getBadgeLevel());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static BadgeSoap[] toSoapModels(Badge[] models) {
		BadgeSoap[] soapModels = new BadgeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BadgeSoap[][] toSoapModels(Badge[][] models) {
		BadgeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BadgeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BadgeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BadgeSoap[] toSoapModels(List<Badge> models) {
		List<BadgeSoap> soapModels = new ArrayList<BadgeSoap>(models.size());

		for (Badge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BadgeSoap[soapModels.size()]);
	}

	public BadgeSoap() {
	}

	public long getPrimaryKey() {
		return _badgeId;
	}

	public void setPrimaryKey(long pk) {
		setBadgeId(pk);
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

	private long _badgeId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _badgeName;
	private int _badgeLevel;
	private String _data;
}