<%--
/**
 * Copyright (c) 2013-present Sebastien Le Marchand.
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
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.model.Group" %><%@
page import="com.liferay.portal.model.User" %><%@
page import="com.liferay.portal.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.service.UserLocalServiceUtil" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

User user2 = null;

if (group.isUser()) {
	user2 = UserLocalServiceUtil.getUserById(group.getClassPK());
}

String contextPath = request.getContextPath();
%>