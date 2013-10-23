<%
/**
 * Copyright (c) 2013 Sebastien Le Marchand.
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
%>

<%@ include file="../init.jsp" %>

<% 
if(user2 == null) {
%>
	<liferay-ui:message key="this-application-will-only-function-when-placed-on-a-user-page" />
<%
} else {
%>
	<%@ include file="/html/my_badges/view_my_badges.jspf" %>
<%
}
%>