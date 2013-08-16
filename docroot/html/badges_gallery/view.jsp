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