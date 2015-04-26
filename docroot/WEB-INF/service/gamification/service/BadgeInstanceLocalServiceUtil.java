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

package gamification.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BadgeInstance. This utility wraps
 * {@link gamification.service.impl.BadgeInstanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Sebastien Le Marchand
 * @see BadgeInstanceLocalService
 * @see gamification.service.base.BadgeInstanceLocalServiceBaseImpl
 * @see gamification.service.impl.BadgeInstanceLocalServiceImpl
 * @generated
 */
public class BadgeInstanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link gamification.service.impl.BadgeInstanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the badge instance to the database. Also notifies the appropriate model listeners.
	*
	* @param badgeInstance the badge instance
	* @return the badge instance that was added
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.BadgeInstance addBadgeInstance(
		gamification.model.BadgeInstance badgeInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBadgeInstance(badgeInstance);
	}

	/**
	* Creates a new badge instance with the primary key. Does not add the badge instance to the database.
	*
	* @param badgeInstanceId the primary key for the new badge instance
	* @return the new badge instance
	*/
	public static gamification.model.BadgeInstance createBadgeInstance(
		long badgeInstanceId) {
		return getService().createBadgeInstance(badgeInstanceId);
	}

	/**
	* Deletes the badge instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeInstanceId the primary key of the badge instance
	* @return the badge instance that was removed
	* @throws PortalException if a badge instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.BadgeInstance deleteBadgeInstance(
		long badgeInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBadgeInstance(badgeInstanceId);
	}

	/**
	* Deletes the badge instance from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeInstance the badge instance
	* @return the badge instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.BadgeInstance deleteBadgeInstance(
		gamification.model.BadgeInstance badgeInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBadgeInstance(badgeInstance);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gamification.model.impl.BadgeInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gamification.model.impl.BadgeInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static gamification.model.BadgeInstance fetchBadgeInstance(
		long badgeInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBadgeInstance(badgeInstanceId);
	}

	/**
	* Returns the badge instance with the primary key.
	*
	* @param badgeInstanceId the primary key of the badge instance
	* @return the badge instance
	* @throws PortalException if a badge instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.BadgeInstance getBadgeInstance(
		long badgeInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadgeInstance(badgeInstanceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the badge instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gamification.model.impl.BadgeInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge instances
	* @param end the upper bound of the range of badge instances (not inclusive)
	* @return the range of badge instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<gamification.model.BadgeInstance> getBadgeInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadgeInstances(start, end);
	}

	/**
	* Returns the number of badge instances.
	*
	* @return the number of badge instances
	* @throws SystemException if a system exception occurred
	*/
	public static int getBadgeInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadgeInstancesCount();
	}

	/**
	* Updates the badge instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param badgeInstance the badge instance
	* @return the badge instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static gamification.model.BadgeInstance updateBadgeInstance(
		gamification.model.BadgeInstance badgeInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBadgeInstance(badgeInstance);
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

	public static void processSocialActivity(long activityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().processSocialActivity(activityId);
	}

	public static gamification.model.BadgeInstance addBadgeInstance(
		long userId, java.lang.String badgeInstanceName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBadgeInstance(userId, badgeInstanceName);
	}

	public static gamification.model.BadgeInstance checkBadgeInstance(
		long userId, java.lang.String badgeInstanceName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().checkBadgeInstance(userId, badgeInstanceName);
	}

	public static gamification.model.BadgeInstance fetchBadgeInstance(
		long userId, java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBadgeInstance(userId, badgeName);
	}

	public static java.util.List<gamification.model.BadgeInstance> getBadges(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBadges(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BadgeInstanceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BadgeInstanceLocalService.class.getName());

			if (invokableLocalService instanceof BadgeInstanceLocalService) {
				_service = (BadgeInstanceLocalService)invokableLocalService;
			}
			else {
				_service = new BadgeInstanceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BadgeInstanceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BadgeInstanceLocalService service) {
	}

	private static BadgeInstanceLocalService _service;
}