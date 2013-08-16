
package gamification.badges.impl;

import java.util.HashSet;
import java.util.Set;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivity;

import gamification.badges.base.BaseActivityCountBadge;
import gamification.social.DLActivityKeys;

public class PhotographerBadge extends BaseActivityCountBadge {

	@Override
	public String getName() {

		return "photographer";
	}

	@Override
	public int getRequiredCount() {

		return 20;
	}

	@Override
	protected boolean match(SocialActivity activity)
		throws SystemException, PortalException {

		boolean match = false;
		
		if(activity.getClassName().equals(DLFileEntry.class.getName()) && activity.getType() == DLActivityKeys.ADD_FILE_ENTRY ) {
			long fileEntryId = activity.getClassPK();
			DLFileEntry entry = DLFileEntryLocalServiceUtil.getFileEntry(fileEntryId);
			match = _PICTURE_MIMETYPES.contains(entry.getMimeType().toLowerCase());
		}
		
		return match;
	}
	
	private static Set<String> _PICTURE_MIMETYPES = new HashSet<String>();
	
	static {
		_PICTURE_MIMETYPES.add("image/bmp");
		_PICTURE_MIMETYPES.add("image/cgm");
		_PICTURE_MIMETYPES.add("image/cmu-raster");
		_PICTURE_MIMETYPES.add("image/g3fax");
		_PICTURE_MIMETYPES.add("image/gif");
		_PICTURE_MIMETYPES.add("image/ief");
		_PICTURE_MIMETYPES.add("image/jpeg");
		_PICTURE_MIMETYPES.add("image/naplps");
		_PICTURE_MIMETYPES.add("image/png");
		_PICTURE_MIMETYPES.add("image/targa");
		_PICTURE_MIMETYPES.add("image/tiff");
		_PICTURE_MIMETYPES.add("image/vnd.dwg");
		_PICTURE_MIMETYPES.add("image/vnd.dxf");
		_PICTURE_MIMETYPES.add("image/vnd.fpx");
		_PICTURE_MIMETYPES.add("image/vnd.net.fpx");
		_PICTURE_MIMETYPES.add("image/vnd.svf");
		_PICTURE_MIMETYPES.add("image/x-xbitmap");
		_PICTURE_MIMETYPES.add("image/x-cmu-raster");
		_PICTURE_MIMETYPES.add("image/x-pict");
		_PICTURE_MIMETYPES.add("image/x-portable-anymap");
		_PICTURE_MIMETYPES.add("image/x-portable-bitmap");
		_PICTURE_MIMETYPES.add("image/x-portable-graymap");
		_PICTURE_MIMETYPES.add("image/x-portable-pixmap");
		_PICTURE_MIMETYPES.add("image/x-rgb");
		_PICTURE_MIMETYPES.add("image/x-tiff");
		_PICTURE_MIMETYPES.add("image/x-win-bmp");
		_PICTURE_MIMETYPES.add("image/x-xbitmap");
		_PICTURE_MIMETYPES.add("image/x-xbm");
		_PICTURE_MIMETYPES.add("image/x-xpixmap");
		_PICTURE_MIMETYPES.add("image/x-windowdump");
		_PICTURE_MIMETYPES.add("image/x-ms-bmp");
	}
}
