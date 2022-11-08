<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="../../component/navBar.jsp">
    <jsp:param name="currentPage" value="promo"/>
</jsp:include>
<jsp:include page="../tables/promos.jsp"/>
<jsp:include page="../modals/add.jsp">
    <jsp:param name="target" value="promo"/>
</jsp:include>
<%
    if (session.getAttribute("success") != null){
        String messageSuccess = (String)session.getAttribute("success");
%>
<jsp:include page="/component/success.jsp">
    <jsp:param name="success" value="<%=messageSuccess%>"/>
</jsp:include>
<%
        session.removeAttribute("success");
    }%>
<% if (session.getAttribute("error") != null){
    String messageError = (String)session.getAttribute("error");

%>
<jsp:include page="/component/error.jsp">
    <jsp:param name="error" value="<%=messageError%>"/>
</jsp:include>
<%
        session.removeAttribute("error");
    }%>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/add.js"></script>
</html>
