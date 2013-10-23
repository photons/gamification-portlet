/**
 * Copyright (c) 2013 Sébastien Le Marchand, All rights reserved.
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

package gamification.hook.model;

import gamification.badges.BadgesEngine;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.social.model.SocialActivity;

/**
 * @author Sebastien Le Marchand
 */
public class SocialActivityListener extends BaseModelListener<SocialActivity> {

	public SocialActivityListener() {
		_log.debug("Instantiating " + this.getClass().getName());
	}

	@Override
	public void onAfterCreate(SocialActivity model)
		throws ModelListenerException {

		try {
			BadgesEngine.processActivity(model);
		}
		catch (SystemException e) {
			_log.error(e);
		}
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(SocialActivityListener.class);
	
}
