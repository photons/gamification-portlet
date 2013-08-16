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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BadgeLocalService}.
 * </p>
 *
 * @author    Sebastien Le Marchand
 * @see       BadgeLocalService
 * @generated
 */
public class BadgeLocalServiceWrapper implements BadgeLocalService,
	ServiceWrapper<BadgeLocalService> {
	public BadgeLocalServiceWrapper(BadgeLocalService badgeLocalService) {
		_badgeLocalService = badgeLocalService;
	}

	/**
	* Adds the badge to the database. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was added
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge addBadge(gamification.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.addBadge(badge);
	}

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public gamification.model.Badge createBadge(long badgeId) {
		return _badgeLocalService.createBadge(badgeId);
	}

	/**
	* Deletes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws PortalException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge deleteBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.deleteBadge(badgeId);
	}

	/**
	* Deletes the badge from the database. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was removed
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge deleteBadge(gamification.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.deleteBadge(badge);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _badgeLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.dynamicQueryCount(dynamicQuery);
	}

	public gamification.model.Badge fetchBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.fetchBadge(badgeId);
	}

	/**
	* Returns the badge with the primary key.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws PortalException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge getBadge(long badgeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.getBadge(badgeId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<gamification.model.Badge> getBadges(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.getBadges(start, end);
	}

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	* @throws SystemException if a system exception occurred
	*/
	public int getBadgesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.getBadgesCount();
	}

	/**
	* Updates the badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @return the badge that was updated
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge updateBadge(gamification.model.Badge badge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.updateBadge(badge);
	}

	/**
	* Updates the badge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param badge the badge
	* @param merge whether to merge the badge with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the badge that was updated
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge updateBadge(
		gamification.model.Badge badge, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.updateBadge(badge, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _badgeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_badgeLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _badgeLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public gamification.model.Badge addBadge(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.addBadge(userId, badgeName);
	}

	public gamification.model.Badge checkBadge(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.checkBadge(userId, badgeName);
	}

	public gamification.model.Badge fetchBadge(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.fetchBadge(userId, badgeName);
	}

	public java.util.List<gamification.model.Badge> getBadges(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _badgeLocalService.getBadges(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public BadgeLocalService getWrappedBadgeLocalService() {
		return _badgeLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedBadgeLocalService(BadgeLocalService badgeLocalService) {
		_badgeLocalService = badgeLocalService;
	}

	public BadgeLocalService getWrappedService() {
		return _badgeLocalService;
	}

	public void setWrappedService(BadgeLocalService badgeLocalService) {
		_badgeLocalService = badgeLocalService;
	}

	private BadgeLocalService _badgeLocalService;
}