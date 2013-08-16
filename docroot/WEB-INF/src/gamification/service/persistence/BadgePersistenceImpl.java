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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import gamification.NoSuchBadgeException;

import gamification.model.Badge;

import gamification.model.impl.BadgeImpl;
import gamification.model.impl.BadgeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the badge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Sebastien Le Marchand
 * @see BadgePersistence
 * @see BadgeUtil
 * @generated
 */
public class BadgePersistenceImpl extends BasePersistenceImpl<Badge>
	implements BadgePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BadgeUtil} to access the badge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BadgeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDBADGENAME = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdBadgeName",
			new String[] { Long.class.getName(), String.class.getName() },
			BadgeModelImpl.USERID_COLUMN_BITMASK |
			BadgeModelImpl.BADGENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDBADGENAME = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdBadgeName",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			BadgeModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, BadgeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the badge in the entity cache if it is enabled.
	 *
	 * @param badge the badge
	 */
	public void cacheResult(Badge badge) {
		EntityCacheUtil.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
			new Object[] { Long.valueOf(badge.getUserId()), badge.getBadgeName() },
			badge);

		badge.resetOriginalValues();
	}

	/**
	 * Caches the badges in the entity cache if it is enabled.
	 *
	 * @param badges the badges
	 */
	public void cacheResult(List<Badge> badges) {
		for (Badge badge : badges) {
			if (EntityCacheUtil.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, badge.getPrimaryKey()) == null) {
				cacheResult(badge);
			}
			else {
				badge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all badges.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BadgeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BadgeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the badge.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Badge badge) {
		EntityCacheUtil.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(badge);
	}

	@Override
	public void clearCache(List<Badge> badges) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Badge badge : badges) {
			EntityCacheUtil.removeResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, badge.getPrimaryKey());

			clearUniqueFindersCache(badge);
		}
	}

	protected void clearUniqueFindersCache(Badge badge) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
			new Object[] { Long.valueOf(badge.getUserId()), badge.getBadgeName() });
	}

	/**
	 * Creates a new badge with the primary key. Does not add the badge to the database.
	 *
	 * @param badgeId the primary key for the new badge
	 * @return the new badge
	 */
	public Badge create(long badgeId) {
		Badge badge = new BadgeImpl();

		badge.setNew(true);
		badge.setPrimaryKey(badgeId);

		return badge;
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge that was removed
	 * @throws gamification.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge remove(long badgeId)
		throws NoSuchBadgeException, SystemException {
		return remove(Long.valueOf(badgeId));
	}

	/**
	 * Removes the badge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge that was removed
	 * @throws gamification.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge remove(Serializable primaryKey)
		throws NoSuchBadgeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Badge badge = (Badge)session.get(BadgeImpl.class, primaryKey);

			if (badge == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(badge);
		}
		catch (NoSuchBadgeException nsee) {
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
	protected Badge removeImpl(Badge badge) throws SystemException {
		badge = toUnwrappedModel(badge);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, badge);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(badge);

		return badge;
	}

	@Override
	public Badge updateImpl(gamification.model.Badge badge, boolean merge)
		throws SystemException {
		badge = toUnwrappedModel(badge);

		boolean isNew = badge.isNew();

		BadgeModelImpl badgeModelImpl = (BadgeModelImpl)badge;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, badge, merge);

			badge.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BadgeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(badgeModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { Long.valueOf(badgeModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
			BadgeImpl.class, badge.getPrimaryKey(), badge);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
				new Object[] {
					Long.valueOf(badge.getUserId()),
					
				badge.getBadgeName()
				}, badge);
		}
		else {
			if ((badgeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDBADGENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(badgeModelImpl.getOriginalUserId()),
						
						badgeModelImpl.getOriginalBadgeName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
					new Object[] {
						Long.valueOf(badge.getUserId()),
						
					badge.getBadgeName()
					}, badge);
			}
		}

		return badge;
	}

	protected Badge toUnwrappedModel(Badge badge) {
		if (badge instanceof BadgeImpl) {
			return badge;
		}

		BadgeImpl badgeImpl = new BadgeImpl();

		badgeImpl.setNew(badge.isNew());
		badgeImpl.setPrimaryKey(badge.getPrimaryKey());

		badgeImpl.setBadgeId(badge.getBadgeId());
		badgeImpl.setCompanyId(badge.getCompanyId());
		badgeImpl.setUserId(badge.getUserId());
		badgeImpl.setCreateDate(badge.getCreateDate());
		badgeImpl.setModifiedDate(badge.getModifiedDate());
		badgeImpl.setBadgeName(badge.getBadgeName());
		badgeImpl.setBadgeLevel(badge.getBadgeLevel());
		badgeImpl.setData(badge.getData());

		return badgeImpl;
	}

	/**
	 * Returns the badge with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge
	 * @throws com.liferay.portal.NoSuchModelException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the badge with the primary key or throws a {@link gamification.NoSuchBadgeException} if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge
	 * @throws gamification.NoSuchBadgeException if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge findByPrimaryKey(long badgeId)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchByPrimaryKey(badgeId);

		if (badge == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + badgeId);
			}

			throw new NoSuchBadgeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				badgeId);
		}

		return badge;
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Badge fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the badge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param badgeId the primary key of the badge
	 * @return the badge, or <code>null</code> if a badge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge fetchByPrimaryKey(long badgeId) throws SystemException {
		Badge badge = (Badge)EntityCacheUtil.getResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
				BadgeImpl.class, badgeId);

		if (badge == _nullBadge) {
			return null;
		}

		if (badge == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				badge = (Badge)session.get(BadgeImpl.class,
						Long.valueOf(badgeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (badge != null) {
					cacheResult(badge);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BadgeModelImpl.ENTITY_CACHE_ENABLED,
						BadgeImpl.class, badgeId, _nullBadge);
				}

				closeSession(session);
			}
		}

		return badge;
	}

	/**
	 * Returns the badge where userId = &#63; and badgeName = &#63; or throws a {@link gamification.NoSuchBadgeException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the matching badge
	 * @throws gamification.NoSuchBadgeException if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge findByUserIdBadgeName(long userId, String badgeName)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchByUserIdBadgeName(userId, badgeName);

		if (badge == null) {
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

			throw new NoSuchBadgeException(msg.toString());
		}

		return badge;
	}

	/**
	 * Returns the badge where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the matching badge, or <code>null</code> if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge fetchByUserIdBadgeName(long userId, String badgeName)
		throws SystemException {
		return fetchByUserIdBadgeName(userId, badgeName, true);
	}

	/**
	 * Returns the badge where userId = &#63; and badgeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching badge, or <code>null</code> if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge fetchByUserIdBadgeName(long userId, String badgeName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, badgeName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
					finderArgs, this);
		}

		if (result instanceof Badge) {
			Badge badge = (Badge)result;

			if ((userId != badge.getUserId()) ||
					!Validator.equals(badgeName, badge.getBadgeName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_USERIDBADGENAME_USERID_2);

			if (badgeName == null) {
				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_1);
			}
			else {
				if (badgeName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_2);
				}
			}

			query.append(BadgeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (badgeName != null) {
					qPos.add(badgeName);
				}

				List<Badge> list = q.list();

				result = list;

				Badge badge = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
						finderArgs, list);
				}
				else {
					badge = list.get(0);

					cacheResult(badge);

					if ((badge.getUserId() != userId) ||
							(badge.getBadgeName() == null) ||
							!badge.getBadgeName().equals(badgeName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
							finderArgs, badge);
					}
				}

				return badge;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDBADGENAME,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Badge)result;
			}
		}
	}

	/**
	 * Returns all the badges where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching badges
	 * @throws SystemException if a system exception occurred
	 */
	public List<Badge> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Badge> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

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
	public List<Badge> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Badge> list = (List<Badge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Badge badge : list) {
				if ((userId != badge.getUserId())) {
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

			query.append(_SQL_SELECT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BadgeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Badge>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge
	 * @throws gamification.NoSuchBadgeException if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchByUserId_First(userId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the first badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching badge, or <code>null</code> if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Badge> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge
	 * @throws gamification.NoSuchBadgeException if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeException, SystemException {
		Badge badge = fetchByUserId_Last(userId, orderByComparator);

		if (badge != null) {
			return badge;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBadgeException(msg.toString());
	}

	/**
	 * Returns the last badge in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching badge, or <code>null</code> if a matching badge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Badge fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<Badge> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Badge[] findByUserId_PrevAndNext(long badgeId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBadgeException, SystemException {
		Badge badge = findByPrimaryKey(badgeId);

		Session session = null;

		try {
			session = openSession();

			Badge[] array = new BadgeImpl[3];

			array[0] = getByUserId_PrevAndNext(session, badge, userId,
					orderByComparator, true);

			array[1] = badge;

			array[2] = getByUserId_PrevAndNext(session, badge, userId,
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

	protected Badge getByUserId_PrevAndNext(Session session, Badge badge,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BADGE_WHERE);

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
			query.append(BadgeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(badge);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Badge> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the badges.
	 *
	 * @return the badges
	 * @throws SystemException if a system exception occurred
	 */
	public List<Badge> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Badge> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Badge> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Badge> list = (List<Badge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BADGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BADGE.concat(BadgeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Badge>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the badge where userId = &#63; and badgeName = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the badge that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Badge removeByUserIdBadgeName(long userId, String badgeName)
		throws NoSuchBadgeException, SystemException {
		Badge badge = findByUserIdBadgeName(userId, badgeName);

		return remove(badge);
	}

	/**
	 * Removes all the badges where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (Badge badge : findByUserId(userId)) {
			remove(badge);
		}
	}

	/**
	 * Removes all the badges from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Badge badge : findAll()) {
			remove(badge);
		}
	}

	/**
	 * Returns the number of badges where userId = &#63; and badgeName = &#63;.
	 *
	 * @param userId the user ID
	 * @param badgeName the badge name
	 * @return the number of matching badges
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdBadgeName(long userId, String badgeName)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, badgeName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_USERIDBADGENAME_USERID_2);

			if (badgeName == null) {
				query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_1);
			}
			else {
				if (badgeName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERIDBADGENAME_BADGENAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (badgeName != null) {
					qPos.add(badgeName);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDBADGENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of badges where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching badges
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BADGE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of badges.
	 *
	 * @return the number of badges
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BADGE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the badge persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.gamification.model.Badge")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Badge>> listenersList = new ArrayList<ModelListener<Badge>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Badge>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BadgeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BadgePersistence.class)
	protected BadgePersistence badgePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_BADGE = "SELECT badge FROM Badge badge";
	private static final String _SQL_SELECT_BADGE_WHERE = "SELECT badge FROM Badge badge WHERE ";
	private static final String _SQL_COUNT_BADGE = "SELECT COUNT(badge) FROM Badge badge";
	private static final String _SQL_COUNT_BADGE_WHERE = "SELECT COUNT(badge) FROM Badge badge WHERE ";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_USERID_2 = "badge.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_BADGENAME_1 = "badge.badgeName IS NULL";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_BADGENAME_2 = "badge.badgeName = ?";
	private static final String _FINDER_COLUMN_USERIDBADGENAME_BADGENAME_3 = "(badge.badgeName IS NULL OR badge.badgeName = ?)";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "badge.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "badge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Badge exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Badge exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BadgePersistenceImpl.class);
	private static Badge _nullBadge = new BadgeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Badge> toCacheModel() {
				return _nullBadgeCacheModel;
			}
		};

	private static CacheModel<Badge> _nullBadgeCacheModel = new CacheModel<Badge>() {
			public Badge toEntityModel() {
				return _nullBadge;
			}
		};
}