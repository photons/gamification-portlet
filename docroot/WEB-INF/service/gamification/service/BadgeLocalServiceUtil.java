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

package gamification.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the badge local service. This utility wraps {@link gamification.service.impl.BadgeLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see BadgeLocalService
 * @see gamification.service.base.BadgeLocalServiceBaseImpl
 * @see gamification.service.impl.BadgeLocalServiceImpl
 * @generated
 */
public class BadgeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link gamification.service.impl.BadgeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the badge to the database. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was added
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.Badge addBadge(
		gamification.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBadge(badge);
	}

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public static gamification.model.Badge createBadge(long badgeId) {
		return getService().createBadge(badgeId);
	}

	/**
	* Deletes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws PortalException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.Badge deleteBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBadge(badgeId);
	}

	/**
	* Deletes the badge from the database. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.Badge deleteBadge(
		gamification.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBadge(badge);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static gamification.model.Badge fetchBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBadge(badgeId);
	}

	/**
	* Returns the badge with the primary key.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws PortalException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.Badge getBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadge(badgeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of badges
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gamification.model.Badge> getBadges(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadges(start, end);
	}

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	* @throws SystemException if a system exception occurred
	*/
	public static int getBadgesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadgesCount();
	}

	/**
	* Updates the badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.Badge updateBadge(
		gamification.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBadge(badge);
	}

	/**
	* Updates the badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @param merge whether to merge the badge with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the badge that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.Badge updateBadge(
		gamification.model.Badge badge, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBadge(badge, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static gamification.model.Badge addBadge(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBadge(userId, badgeName);
	}

	public static gamification.model.Badge checkBadge(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().checkBadge(userId, badgeName);
	}

	public static gamification.model.Badge fetchBadge(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBadge(userId, badgeName);
	}

	public static java.util.List<gamification.model.Badge> getBadges(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadges(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BadgeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BadgeLocalService.class.getName());

			if (invokableLocalService instanceof BadgeLocalService) {
				_service = (BadgeLocalService)invokableLocalService;
			}
			else {
				_service = new BadgeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BadgeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(BadgeLocalService service) {
	}

	private static BadgeLocalService _service;
}