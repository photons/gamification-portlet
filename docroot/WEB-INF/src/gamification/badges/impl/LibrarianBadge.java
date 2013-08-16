
package gamification.badges.impl;

import java.util.HashSet;
import java.util.Set;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.badges.base.BaseActivityCountBadge;

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
		throws SystemException, PortalException {

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
