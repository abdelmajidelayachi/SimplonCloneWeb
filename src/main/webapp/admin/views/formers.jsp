<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="../../component/navBar.jsp">
    <jsp:param name="currentPage" value="former"/>
</jsp:include>
<jsp:include page="../tables/formers.jsp"/>
<jsp:include page="../modals/add.jsp">
    <jsp:param name="target" value="former"/>
</jsp:include>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/add.js"></script>
</html>
