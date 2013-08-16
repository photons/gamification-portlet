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

package gamification;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Sebastien Le Marchand
 */
public class NoSuchBadgeException extends NoSuchModelException {

	public NoSuchBadgeException() {
		super();
	}

	public NoSuchBadgeException(String msg) {
		super(msg);
	}

	public NoSuchBadgeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBadgeException(Throwable cause) {
		super(cause);
	}

}