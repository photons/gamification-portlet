
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