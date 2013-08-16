package gamification.hook.model;

import gamification.badges.BadgesEngine;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.social.model.SocialActivity;


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
