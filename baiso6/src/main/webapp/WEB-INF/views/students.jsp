<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sinh viên</title></head>
<body>
    <h2>Danh sách sinh viên</h2>

    <form action="/students" method="get">
        <input type="text" name="keyword" value="${keyword}" placeholder="Tìm kiếm..." />
        <button type="submit">Tìm</button>
    </form>

    <table border="1">
        <tr><th>ID</th><th>Tên</th><th>Email</th><th>Điểm</th></tr>
        <c:forEach items="${studentPage.content}" var="s">
            <tr>
                <td>${s.id}</td>
            
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.score}</td>
            </tr>
        </c:forEach>
    </table>

    <div>
        <c:if test="${studentPage.totalPages > 1}">
            <c:forEach begin="0" end="${studentPage.totalPages - 1}" var="i">
                <a href="/students?page=${i}&keyword=${keyword}">
                    [${i + 1}]
                </a>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>
