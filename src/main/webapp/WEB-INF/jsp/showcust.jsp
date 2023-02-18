
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="container">
<link href="css.css" rel="stylesheet" type="text/css">
<jsp:include page="admin-header.jsp"></jsp:include>

<div id="content-container">
<div id="content" style="text-align: center;">
<marquee><h2 style="color: red;"><i>--- Welcome ${username} ---</i></h2></marquee>
	<br/><br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<table cellpadding="10" border="1">
			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>Account No.</td>
				<td>Balance</td>
				<td>Address</td>
				<td>Contact No</td>
			</tr>
	<c:forEach items="${allcust}" var="allcust">
		<tr>
			<td>${allcust.name}</td>
			<td>${allcust.email}</td>
			<td>${allcust.accno}</td>
			<td>${allcust.balance}</td>
			<td>${allcust.address}</td>
			<td>${allcust.mobno}</td>
		 </tr>
	</c:forEach>
	</table>

</div>

</div>
</div>
