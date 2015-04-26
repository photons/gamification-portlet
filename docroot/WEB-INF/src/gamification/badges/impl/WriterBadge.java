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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.badges.base.BaseActivityCountBadge;

import gamification.social.BlogsActivityKeys;

/**
 * @author Sebastien Le Marchand
 */
public class WriterBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {

		return "writer";
	}

	@Override
	public int getRequiredCount() {

		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws PortalException, SystemException {

		boolean match =
			activity.getClassName().equals(BlogsEntry.class) && activity.getType() == BlogsActivityKeys.ADD_ENTRY;

		return match;
	}

}