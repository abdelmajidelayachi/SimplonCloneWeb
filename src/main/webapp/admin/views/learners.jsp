<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="../../component/navBar.jsp">
    <jsp:param name="currentPage" value="learner"/>
</jsp:include>
<jsp:include page="../tables/formers.jsp"/>
<jsp:include page="../modals/add.jsp"/>
</body>
<script type="text/javascript" src="../js/add.js"></script>
</html>
