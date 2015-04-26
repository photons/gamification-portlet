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
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.badges.base.BaseActivityCountBadge;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sebastien Le Marchand
 */
public class LibrarianBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {

		return "librarian";
	}

	@Override
	public int getRequiredCount() {

		return 1000;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws PortalException, SystemException {

		boolean match = _CLASSNAMES.contains(activity.getClassName());

		return match;
	}

	private static final Set<String >_CLASSNAMES = new HashSet<String>();

	static {
		_CLASSNAMES.add(DLFileEntry.class.toString());
		_CLASSNAMES.add(DLFileVersion.class.toString());
		_CLASSNAMES.add(DLFileShortcut.class.toString());
		_CLASSNAMES.add(DLFolder.class.toString());
	}
}