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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import gamification.NoSuchBadgeInstanceException;

import gamification.model.BadgeInstance;

import gamification.model.impl.BadgeInstanceImpl;
import gamification.model.impl.BadgeInstanceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the badge instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see BadgeInstancePersistence
 * @see BadgeInstanceUtil
 * @generated
 */
public class BadgeInstancePersistenceImpl extends BasePersistenceImpl<BadgeInstance>
	implements BadgeInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeInstanceUtil} to access the badge instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED,
			BadgeInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED,
			BadgeInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDBADGENAME = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED,
			BadgeInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdBadgeName",
			new String[] { Long.class.getName(), String.class.getName() },
			BadgeInstanceModelImpl.USERID_COLUMN_BITMASK |
			BadgeInstanceModelImpl.BADGENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDBADGENAME = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdBadgeName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the badge instance where userId = &#63; and badgeName = &#63; or throws a {@link gamification.NoSuchBadgeInstanceException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the matching badge instance
	 * @throws gamification.NoSuchBadgeInstanceException if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance findByUserIdBadgeName(long userId, String badgeName)
		throws NoSuchBadgeInstanceException, SystemException {
		BadgeInstance badgeInstance = fetchByUserIdBadgeName(userId, badgeName);

		if (badgeInstance == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", badgeName=");
			msg.append(badgeName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBadgeInstanceException(msg.toString());
		}

		return badgeInstance;
	}

	/**
	 * Returns the badge instance where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the matching badge instance, or <code>null</code> if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance fetchByUserIdBadgeName(long userId, String badgeName)
		throws SystemException {
		return fetchByUserIdBadgeName(userId, badgeName, true);
	}

	/**
	 * Returns the badge instance where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching badge instance, or <code>null</code> if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance fetchByUserIdBadgeName(long userId, String badgeName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, badgeName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
					finderArgs, this);
		}

		if (result instanceof BadgeInstance) {
			BadgeInstance badgeInstance = (BadgeInstance)result;

			if ((userId != badgeInstance.getUserId()) ||
					!Validator.equals(badgeName, badgeInstance.getBadgeName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BADGEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERIDBADGENAME_USERID_2);

			boolean bindBadgeName = false;

			if (badgeName == null) {
				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_1);
			}
			else if (badgeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_3);
			}
			else {
				bindBadgeName = true;

				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindBadgeName) {
					qPos.add(badgeName);
				}

				List<BadgeInstance> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BadgeInstancePersistenceImpl.fetchByUserIdBadgeName(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BadgeInstance badgeInstance = list.get(0);

					result = badgeInstance;

					cacheResult(badgeInstance);

					if ((badgeInstance.getUserId() != userId) ||
							(badgeInstance.getBadgeName() == null) ||
							!badgeInstance.getBadgeName().equals(badgeName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
							finderArgs, badgeInstance);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BadgeInstance)result;
		}
	}

	/**
	 * Removes the badge instance where userId = &#63; and badgeName = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the badge instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance removeByUserIdBadgeName(long userId, String badgeName)
		throws NoSuchBadgeInstanceException, SystemException {
		BadgeInstance badgeInstance = findByUserIdBadgeName(userId, badgeName);

		return remove(badgeInstance);
	}

	/**
	 * Returns the number of badge instances where userId = &#63; and badgeName = &#63;.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the number of matching badge instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdBadgeName(long userId, String badgeName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDBADGENAME;

		Object[] finderArgs = new Object[] { userId, badgeName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BADGEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERIDBADGENAME_USERID_2);

			boolean bindBadgeName = false;

			if (badgeName == null) {
				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_1);
			}
			else if (badgeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_3);
			}
			else {
				bindBadgeName = true;

				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindBadgeName) {
					qPos.add(badgeName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDBADGENAME_USERID_2 = "badgeInstance.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_BADGENAME_1 = "badgeInstance.badgeName IS NULL";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_BADGENAME_2 = "badgeInstance.badgeName = ?";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_BADGENAME_3 = "(badgeInstance.badgeName IS NULL OR badgeInstance.badgeName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED,
			BadgeInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED,
			BadgeInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			BadgeInstanceModelImpl.USERID_COLUMN_BITMASK |
			BadgeInstanceModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the badge instances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching badge instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BadgeInstance> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BadgeInstance> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

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
	@Override
	public List<BadgeInstance> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<BadgeInstance> list = (List<BadgeInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BadgeInstance badgeInstance : list) {
				if ((userId != badgeInstance.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BADGEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BadgeInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<BadgeInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BadgeInstance>(list);
				}
				else {
					list = (List<BadgeInstance>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first badge instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge instance
	 * @throws gamification.NoSuchBadgeInstanceException if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeInstanceException, SystemException {
		BadgeInstance badgeInstance = fetchByUserId_First(userId,
				orderByComparator);

		if (badgeInstance != null) {
			return badgeInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeInstanceException(msg.toString());
	}

	/**
	 * Returns the first badge instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge instance, or <code>null</code> if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BadgeInstance> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge instance
	 * @throws gamification.NoSuchBadgeInstanceException if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeInstanceException, SystemException {
		BadgeInstance badgeInstance = fetchByUserId_Last(userId,
				orderByComparator);

		if (badgeInstance != null) {
			return badgeInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeInstanceException(msg.toString());
	}

	/**
	 * Returns the last badge instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge instance, or <code>null</code> if a matching badge instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<BadgeInstance> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BadgeInstance[] findByUserId_PrevAndNext(long badgeInstanceId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchBadgeInstanceException, SystemException {
		BadgeInstance badgeInstance = findByPrimaryKey(badgeInstanceId);

		Session session = null;

		try {
			session = openSession();

			BadgeInstance[] array = new BadgeInstanceImpl[3];

			array[0] = getByUserId_PrevAndNext(session, badgeInstance, userId,
					orderByComparator, true);

			array[1] = badgeInstance;

			array[2] = getByUserId_PrevAndNext(session, badgeInstance, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BadgeInstance getByUserId_PrevAndNext(Session session,
		BadgeInstance badgeInstance, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGEINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BadgeInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badgeInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BadgeInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the badge instances where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (BadgeInstance badgeInstance : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(badgeInstance);
		}
	}

	/**
	 * Returns the number of badge instances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching badge instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGEINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "badgeInstance.userId = ?";

	public BadgeInstancePersistenceImpl() {
		setModelClass(BadgeInstance.class);
	}

	/**
	 * Caches the badge instance in the entity cache if it is enabled.
	 *
	 * @param badgeInstance the badge instance
	 */
	@Override
	public void cacheResult(BadgeInstance badgeInstance) {
		EntityCacheUtil.putResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceImpl.class, badgeInstance.getPrimaryKey(),
			badgeInstance);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
			new Object[] { badgeInstance.getUserId(), badgeInstance.getBadgeName() },
			badgeInstance);

		badgeInstance.resetOriginalValues();
	}

	/**
	 * Caches the badge instances in the entity cache if it is enabled.
	 *
	 * @param badgeInstances the badge instances
	 */
	@Override
	public void cacheResult(List<BadgeInstance> badgeInstances) {
		for (BadgeInstance badgeInstance : badgeInstances) {
			if (EntityCacheUtil.getResult(
						BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
						BadgeInstanceImpl.class, badgeInstance.getPrimaryKey()) == null) {
				cacheResult(badgeInstance);
			}
			else {
				badgeInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badge instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BadgeInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BadgeInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BadgeInstance badgeInstance) {
		EntityCacheUtil.removeResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceImpl.class, badgeInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(badgeInstance);
	}

	@Override
	public void clearCache(List<BadgeInstance> badgeInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BadgeInstance badgeInstance : badgeInstances) {
			EntityCacheUtil.removeResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
				BadgeInstanceImpl.class, badgeInstance.getPrimaryKey());

			clearUniqueFindersCache(badgeInstance);
		}
	}

	protected void cacheUniqueFindersCache(BadgeInstance badgeInstance) {
		if (badgeInstance.isNew()) {
			Object[] args = new Object[] {
					badgeInstance.getUserId(), badgeInstance.getBadgeName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
				args, badgeInstance);
		}
		else {
			BadgeInstanceModelImpl badgeInstanceModelImpl = (BadgeInstanceModelImpl)badgeInstance;

			if ((badgeInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDBADGENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeInstance.getUserId(), badgeInstance.getBadgeName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
					args, badgeInstance);
			}
		}
	}

	protected void clearUniqueFindersCache(BadgeInstance badgeInstance) {
		BadgeInstanceModelImpl badgeInstanceModelImpl = (BadgeInstanceModelImpl)badgeInstance;

		Object[] args = new Object[] {
				badgeInstance.getUserId(), badgeInstance.getBadgeName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME, args);

		if ((badgeInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDBADGENAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					badgeInstanceModelImpl.getOriginalUserId(),
					badgeInstanceModelImpl.getOriginalBadgeName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
				args);
		}
	}

	/**
	 * Creates a new badge instance with the primary key. Does not add the badge instance to the database.
	 *
	 * @param badgeInstanceId the primary key for the new badge instance
	 * @return the new badge instance
	 */
	@Override
	public BadgeInstance create(long badgeInstanceId) {
		BadgeInstance badgeInstance = new BadgeInstanceImpl();

		badgeInstance.setNew(true);
		badgeInstance.setPrimaryKey(badgeInstanceId);

		return badgeInstance;
	}

	/**
	 * Removes the badge instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param badgeInstanceId the primary key of the badge instance
	 * @return the badge instance that was removed
	 * @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance remove(long badgeInstanceId)
		throws NoSuchBadgeInstanceException, SystemException {
		return remove((Serializable)badgeInstanceId);
	}

	/**
	 * Removes the badge instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge instance
	 * @return the badge instance that was removed
	 * @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance remove(Serializable primaryKey)
		throws NoSuchBadgeInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BadgeInstance badgeInstance = (BadgeInstance)session.get(BadgeInstanceImpl.class,
					primaryKey);

			if (badgeInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badgeInstance);
		}
		catch (NoSuchBadgeInstanceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BadgeInstance removeImpl(BadgeInstance badgeInstance)
		throws SystemException {
		badgeInstance = toUnwrappedModel(badgeInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(badgeInstance)) {
				badgeInstance = (BadgeInstance)session.get(BadgeInstanceImpl.class,
						badgeInstance.getPrimaryKeyObj());
			}

			if (badgeInstance != null) {
				session.delete(badgeInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (badgeInstance != null) {
			clearCache(badgeInstance);
		}

		return badgeInstance;
	}

	@Override
	public BadgeInstance updateImpl(
		gamification.model.BadgeInstance badgeInstance)
		throws SystemException {
		badgeInstance = toUnwrappedModel(badgeInstance);

		boolean isNew = badgeInstance.isNew();

		BadgeInstanceModelImpl badgeInstanceModelImpl = (BadgeInstanceModelImpl)badgeInstance;

		Session session = null;

		try {
			session = openSession();

			if (badgeInstance.isNew()) {
				session.save(badgeInstance);

				badgeInstance.setNew(false);
			}
			else {
				session.merge(badgeInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BadgeInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((badgeInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						badgeInstanceModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { badgeInstanceModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
			BadgeInstanceImpl.class, badgeInstance.getPrimaryKey(),
			badgeInstance);

		clearUniqueFindersCache(badgeInstance);
		cacheUniqueFindersCache(badgeInstance);

		return badgeInstance;
	}

	protected BadgeInstance toUnwrappedModel(BadgeInstance badgeInstance) {
		if (badgeInstance instanceof BadgeInstanceImpl) {
			return badgeInstance;
		}

		BadgeInstanceImpl badgeInstanceImpl = new BadgeInstanceImpl();

		badgeInstanceImpl.setNew(badgeInstance.isNew());
		badgeInstanceImpl.setPrimaryKey(badgeInstance.getPrimaryKey());

		badgeInstanceImpl.setBadgeInstanceId(badgeInstance.getBadgeInstanceId());
		badgeInstanceImpl.setCompanyId(badgeInstance.getCompanyId());
		badgeInstanceImpl.setUserId(badgeInstance.getUserId());
		badgeInstanceImpl.setCreateDate(badgeInstance.getCreateDate());
		badgeInstanceImpl.setModifiedDate(badgeInstance.getModifiedDate());
		badgeInstanceImpl.setBadgeName(badgeInstance.getBadgeName());
		badgeInstanceImpl.setBadgeLevel(badgeInstance.getBadgeLevel());
		badgeInstanceImpl.setData(badgeInstance.getData());

		return badgeInstanceImpl;
	}

	/**
	 * Returns the badge instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge instance
	 * @return the badge instance
	 * @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBadgeInstanceException, SystemException {
		BadgeInstance badgeInstance = fetchByPrimaryKey(primaryKey);

		if (badgeInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBadgeInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return badgeInstance;
	}

	/**
	 * Returns the badge instance with the primary key or throws a {@link gamification.NoSuchBadgeInstanceException} if it could not be found.
	 *
	 * @param badgeInstanceId the primary key of the badge instance
	 * @return the badge instance
	 * @throws gamification.NoSuchBadgeInstanceException if a badge instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance findByPrimaryKey(long badgeInstanceId)
		throws NoSuchBadgeInstanceException, SystemException {
		return findByPrimaryKey((Serializable)badgeInstanceId);
	}

	/**
	 * Returns the badge instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge instance
	 * @return the badge instance, or <code>null</code> if a badge instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BadgeInstance badgeInstance = (BadgeInstance)EntityCacheUtil.getResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
				BadgeInstanceImpl.class, primaryKey);

		if (badgeInstance == _nullBadgeInstance) {
			return null;
		}

		if (badgeInstance == null) {
			Session session = null;

			try {
				session = openSession();

				badgeInstance = (BadgeInstance)session.get(BadgeInstanceImpl.class,
						primaryKey);

				if (badgeInstance != null) {
					cacheResult(badgeInstance);
				}
				else {
					EntityCacheUtil.putResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
						BadgeInstanceImpl.class, primaryKey, _nullBadgeInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BadgeInstanceModelImpl.ENTITY_CACHE_ENABLED,
					BadgeInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return badgeInstance;
	}

	/**
	 * Returns the badge instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param badgeInstanceId the primary key of the badge instance
	 * @return the badge instance, or <code>null</code> if a badge instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BadgeInstance fetchByPrimaryKey(long badgeInstanceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)badgeInstanceId);
	}

	/**
	 * Returns all the badge instances.
	 *
	 * @return the badge instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BadgeInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BadgeInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<BadgeInstance> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<BadgeInstance> list = (List<BadgeInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BADGEINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGEINSTANCE;

				if (pagination) {
					sql = sql.concat(BadgeInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BadgeInstance>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BadgeInstance>(list);
				}
				else {
					list = (List<BadgeInstance>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the badge instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BadgeInstance badgeInstance : findAll()) {
			remove(badgeInstance);
		}
	}

	/**
	 * Returns the number of badge instances.
	 *
	 * @return the number of badge instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGEINSTANCE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the badge instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.gamification.model.BadgeInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BadgeInstance>> listenersList = new ArrayList<ModelListener<BadgeInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BadgeInstance>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BadgeInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BADGEINSTANCE = "SELECT badgeInstance FROM BadgeInstance badgeInstance";
	private static final String _SQL_SELECT_BADGEINSTANCE_WHERE = "SELECT badgeInstance FROM BadgeInstance badgeInstance WHERE ";
	private static final String _SQL_COUNT_BADGEINSTANCE = "SELECT COUNT(badgeInstance) FROM BadgeInstance badgeInstance";
	private static final String _SQL_COUNT_BADGEINSTANCE_WHERE = "SELECT COUNT(badgeInstance) FROM BadgeInstance badgeInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badgeInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BadgeInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BadgeInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BadgeInstancePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"data"
			});
	private static BadgeInstance _nullBadgeInstance = new BadgeInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BadgeInstance> toCacheModel() {
				return _nullBadgeInstanceCacheModel;
			}
		};

	private static CacheModel<BadgeInstance> _nullBadgeInstanceCacheModel = new CacheModel<BadgeInstance>() {
			@Override
			public BadgeInstance toEntityModel() {
				return _nullBadgeInstance;
			}
		};
}