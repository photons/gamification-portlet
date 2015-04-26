/**
 * Copyright (c) 2013-present Sébastien Le Marchand, All rights reserved.
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

package gamification.badges.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.badges.base.BaseActivityCountBadge;

/**
 * @author Sebastien Le Marchand
 */
public class HumanBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {
		return "human";
	}

	@Override
	public int getRequiredCount() {
		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity) throws SystemException {

		AssetEntry entry = activity.getAssetEntry();

		String[] tags = entry.getTagNames();

		boolean match = false;

		for (int i = 0; i < tags.length && !match; i++) {
			String tag = tags[i];
			match = tag.equalsIgnoreCase("humanresources") ||
							 tag.equalsIgnoreCase("human resources") ||
							 tag.equalsIgnoreCase("hr");
		}

		return match;
	}
}