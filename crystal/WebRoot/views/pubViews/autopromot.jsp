<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<words>
    <c:forEach items="${words}" var="word">
        <word>${word}</word>
    </c:forEach>
</words>