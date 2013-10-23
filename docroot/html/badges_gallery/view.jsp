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

<h1></h1>

<table>
<% 
for(BadgeDefinition badge: BadgesEngine.getBadgeDefinitions()) { 
	String name = badge.getName();
	boolean masked = false;
%>
	<tr>
		<td>
			<%@ include file="/html/badge.jspf" %>
		</td>
		
		<td>
			<p class="description">
				<%= LanguageUtil.get(pageContext, "badges." + name + ".description") %>
			</p>
		</td>
	<tr>
<%
} 
%>
</table>

<div class="attributions"><a href="<%= contextPath %>/attributions.html" target="_blank">Attributions</a></div>