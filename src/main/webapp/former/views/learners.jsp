<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/component/nav.jsp">
    <jsp:param name="currentPage" value="learner"/>
</jsp:include>

<jsp:include page="../tables/learners.jsp"/>
