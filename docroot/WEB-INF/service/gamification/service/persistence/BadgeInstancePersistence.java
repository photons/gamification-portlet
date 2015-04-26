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

package gamification.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import gamification.model.BadgeInstance;

/**
 * The persistence interface for the badge instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see BadgeInstancePersistenceImpl
 * @see BadgeInstanceUtil
 * @generated
 */
public interface BadgeInstancePersistence extends BasePersistence<BadgeInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeInstanceUtil} to access the badge instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the badge instance where userId = &#63; and badgeName = &#63; or throws a {@link gamification.NoSuchBadgeInstanceException} if it could not be found.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the matching badge instance
	* @throws gamification.NoSuchBadgeInstanceException if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance findByUserIdBadgeName(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	/**
	* Returns the badge instance where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the matching badge instance, or <code>null</code> if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance fetchByUserIdBadgeName(
		long userId, java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge instance where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching badge instance, or <code>null</code> if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance fetchByUserIdBadgeName(
		long userId, java.lang.String badgeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the badge instance where userId = &#63; and badgeName = &#63; from the database.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the badge instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance removeByUserIdBadgeName(
		long userId, java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	/**
	* Returns the number of badge instances where userId = &#63; and badgeName = &#63;.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the number of matching badge instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdBadgeName(long userId, java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the badge instances where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching badge instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.BadgeInstance> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the badge instances where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gamification.model.impl.BadgeInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badge instances
	* @param end the upper bound of the range of badge instances (not inclusive)
	* @return the range of matching badge instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.BadgeInstance> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the badge instances where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gamification.model.impl.BadgeInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badge instances
	* @param end the upper bound of the range of badge instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badge instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.BadgeInstance> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first badge instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge instance
	* @throws gamification.NoSuchBadgeInstanceException if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	/**
	* Returns the first badge instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge instance, or <code>null</code> if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last badge instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge instance
	* @throws gamification.NoSuchBadgeInstanceException if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	/**
	* Returns the last badge instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge instance, or <code>null</code> if a matching badge instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge instances before and after the current badge instance in the ordered set where userId = &#63;.
	*
	* @param badgeInstanceId the primary key of the current badge instance
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge instance
	* @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance[] findByUserId_PrevAndNext(
		long badgeInstanceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	/**
	* Removes all the badge instances where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badge instances where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching badge instances
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the badge instance in the entity cache if it is enabled.
	*
	* @param badgeInstance the badge instance
	*/
	public void cacheResult(gamification.model.BadgeInstance badgeInstance);

	/**
	* Caches the badge instances in the entity cache if it is enabled.
	*
	* @param badgeInstances the badge instances
	*/
	public void cacheResult(
		java.util.List<gamification.model.BadgeInstance> badgeInstances);

	/**
	* Creates a new badge instance with the primary key. Does not add the badge instance to the database.
	*
	* @param badgeInstanceId the primary key for the new badge instance
	* @return the new badge instance
	*/
	public gamification.model.BadgeInstance create(long badgeInstanceId);

	/**
	* Removes the badge instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeInstanceId the primary key of the badge instance
	* @return the badge instance that was removed
	* @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance remove(long badgeInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	public gamification.model.BadgeInstance updateImpl(
		gamification.model.BadgeInstance badgeInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge instance with the primary key or throws a {@link gamification.NoSuchBadgeInstanceException} if it could not be found.
	*
	* @param badgeInstanceId the primary key of the badge instance
	* @return the badge instance
	* @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance findByPrimaryKey(
		long badgeInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeInstanceException;

	/**
	* Returns the badge instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeInstanceId the primary key of the badge instance
	* @return the badge instance, or <code>null</code> if a badge instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.BadgeInstance fetchByPrimaryKey(
		long badgeInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the badge instances.
	*
	* @return the badge instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.BadgeInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gamification.model.BadgeInstance> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the badge instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gamification.model.impl.BadgeInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of badge instances
	* @param end the upper bound of the range of badge instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badge instances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.BadgeInstance> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the badge instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badge instances.
	*
	* @return the number of badge instances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}