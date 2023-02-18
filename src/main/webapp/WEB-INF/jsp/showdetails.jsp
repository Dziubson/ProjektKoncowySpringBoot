
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container">
<link href="css.css" rel="stylesheet" type="text/css">
    <c:choose>
        <c:when test="${choose=='1'}">
            <jsp:include page="emp-header.jsp"></jsp:include>
            <br />
        </c:when>
        <c:when test="${choose=='2'}">
            <jsp:include page="admin-header.jsp"></jsp:include>
            <br />
        </c:when>
        <c:otherwise>
            <jsp:include page="home-header.jsp"></jsp:include>
            <br />
        </c:otherwise>
    </c:choose>
<div id="content-container">
<div id="content" style="text-align: center;">
<marquee><h2 style="color: red;"><i>--- Welcome ${username} ---</i></h2></marquee>
    <br/><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    <table cellpadding="10" border="1">
    <c:forEach items="${user}" var="user">
        <tr><td><b>Name</b></td><td>${user.name}</td></tr>
        <tr><td><b>Email</b></td><td>${user.email}</td></tr>
        <tr><td><b>Account No.</b></td><td>${user.accno}</td></tr>
         <tr><td><b>Balance</b></td><td>${user.balance}</td></tr>
         <tr><td><b>Address</b></td><td>${user.address}</td></tr>
         <tr><td><b>Contact No</b></td><td>${user.mobno}</td></tr>
    </c:forEach>
    </table>

</div>

</div>

<jsp:include page="footer.jsp"></jsp:include>
</div>
