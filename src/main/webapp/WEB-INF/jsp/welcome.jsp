<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page session="false" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<head>
<title>Welcome</title>
</head>
<body>
<jsp:include page="menu.jsp"/>

<h3 style="color: red;">Hello User <%= request.getUserPrincipal() == null ? "null"
        : ((AttributePrincipal) request.getUserPrincipal()).getName()%>
</h3>

<h3>Request headers</h3>
<dl>
    <%
        Enumeration en = request.getHeaderNames();
        while (en.hasMoreElements()) {
            String parameterName = (String) en.nextElement();
            String parameterValue = request.getHeader(parameterName);
            out.println("<dd>" + parameterName + " <b>" + parameterValue + "</b></dd>");
        }
    %>
</dl>

<h3>Single Sign On data</h3>
<dl>
    <%
        for (Map.Entry<String, Object> entry : ((AttributePrincipal) request.getUserPrincipal()).getAttributes().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            out.println("<p><b>" + key + "</b>:" + value);
        }
    %>
</dl>
</body>
</html>
