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

package gamification.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import gamification.model.BadgeInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BadgeInstance in entity cache.
 *
 * @author Sebastien Le Marchand
 * @see BadgeInstance
 * @generated
 */
public class BadgeInstanceCacheModel implements CacheModel<BadgeInstance>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{badgeInstanceId=");
		sb.append(badgeInstanceId);
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

	@Override
	public BadgeInstance toEntityModel() {
		BadgeInstanceImpl badgeInstanceImpl = new BadgeInstanceImpl();

		badgeInstanceImpl.setBadgeInstanceId(badgeInstanceId);
		badgeInstanceImpl.setCompanyId(companyId);
		badgeInstanceImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			badgeInstanceImpl.setCreateDate(null);
		}
		else {
			badgeInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			badgeInstanceImpl.setModifiedDate(null);
		}
		else {
			badgeInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (badgeName == null) {
			badgeInstanceImpl.setBadgeName(StringPool.BLANK);
		}
		else {
			badgeInstanceImpl.setBadgeName(badgeName);
		}

		badgeInstanceImpl.setBadgeLevel(badgeLevel);

		if (data == null) {
			badgeInstanceImpl.setData(StringPool.BLANK);
		}
		else {
			badgeInstanceImpl.setData(data);
		}

		badgeInstanceImpl.resetOriginalValues();

		return badgeInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		badgeInstanceId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		badgeName = objectInput.readUTF();
		badgeLevel = objectInput.readInt();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(badgeInstanceId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (badgeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(badgeName);
		}

		objectOutput.writeInt(badgeLevel);

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public long badgeInstanceId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String badgeName;
	public int badgeLevel;
	public String data;
}