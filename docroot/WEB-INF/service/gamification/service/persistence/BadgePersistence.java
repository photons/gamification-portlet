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

package gamification.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import gamification.model.Badge;

/**
 * The persistence interface for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see BadgePersistenceImpl
 * @see BadgeUtil
 * @generated
 */
public interface BadgePersistence extends BasePersistence<Badge> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the badge in the entity cache if it is enabled.
	*
	* @param badge the badge
	*/
	public void cacheResult(gamification.model.Badge badge);

	/**
	* Caches the badges in the entity cache if it is enabled.
	*
	* @param badges the badges
	*/
	public void cacheResult(java.util.List<gamification.model.Badge> badges);

	/**
	* Creates a new badge with the primary key. Does not add the badge to the database.
	*
	* @param badgeId the primary key for the new badge
	* @return the new badge
	*/
	public gamification.model.Badge create(long badgeId);

	/**
	* Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param badgeId the primary key of the badge
	* @return the badge that was removed
	* @throws gamification.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge remove(long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	public gamification.model.Badge updateImpl(gamification.model.Badge badge,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge with the primary key or throws a {@link gamification.NoSuchBadgeException} if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge
	* @throws gamification.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge findByPrimaryKey(long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	/**
	* Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param badgeId the primary key of the badge
	* @return the badge, or <code>null</code> if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge fetchByPrimaryKey(long badgeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge where userId = &#63; and badgeName = &#63; or throws a {@link gamification.NoSuchBadgeException} if it could not be found.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the matching badge
	* @throws gamification.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge findByUserIdBadgeName(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	/**
	* Returns the badge where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge fetchByUserIdBadgeName(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badge where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge fetchByUserIdBadgeName(long userId,
		java.lang.String badgeName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the badges where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.Badge> findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the badges where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @return the range of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.Badge> findByUserId(long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the badges where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.Badge> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge
	* @throws gamification.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	/**
	* Returns the first badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge
	* @throws gamification.NoSuchBadgeException if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	/**
	* Returns the last badge in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching badge, or <code>null</code> if a matching badge could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the badges before and after the current badge in the ordered set where userId = &#63;.
	*
	* @param badgeId the primary key of the current badge
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next badge
	* @throws gamification.NoSuchBadgeException if a badge with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge[] findByUserId_PrevAndNext(long badgeId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	/**
	* Returns all the badges.
	*
	* @return the badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.Badge> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<gamification.model.Badge> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the badges.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of badges
	* @param end the upper bound of the range of badges (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of badges
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<gamification.model.Badge> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the badge where userId = &#63; and badgeName = &#63; from the database.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the badge that was removed
	* @throws SystemException if a system exception occurred
	*/
	public gamification.model.Badge removeByUserIdBadgeName(long userId,
		java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			gamification.NoSuchBadgeException;

	/**
	* Removes all the badges where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the badges from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badges where userId = &#63; and badgeName = &#63;.
	*
	* @param userId the user ID
	* @param badgeName the badge name
	* @return the number of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdBadgeName(long userId, java.lang.String badgeName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badges where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching badges
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of badges.
	*
	* @return the number of badges
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}