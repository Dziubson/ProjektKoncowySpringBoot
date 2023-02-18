<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script type="text/javascript">
    
    function check()
    {
    if(document.f1.username.value=="")
    {
        alert("plz enter username!");
        return false;
    }

    if(document.f1.password.value=="")
    {
        alert("plz enter password!");
        return false;
    }

    if(document.f1.password.value!=document.f1.repassword.value)
    {
        alert("password does not match!");
        return false;
    }

    if(document.f1.amount.value=="")
    {
        alert("plz enter amount!");
        return false;
    }

    if(document.f1.address.value=="")
    {
        alert("plz enter address!");
        return false;
    }

    if(document.f1.phone.value=="")
    {
        alert("plz enter phone no.!");
        return false;
    }
    }
</script>
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

</div>
<div style="text-align: center;">
<br/><h2>Open Account :-</h2><br/><br/>
    <form name="f1" action="addcust" onsubmit="return check();" method="post">
		<b>		 
		Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"/><br/><br/>		 
		Username: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="username"/><br/><br/>
		Acc. No.: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="accno"/><br/><br/>
		Password: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password"/><br/><br/>
		Re-Password: &nbsp;<input type="password" name="repassword"/><br/><br/>
		Balance: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="balance"/><br/><br/>
		Address: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="address"/><br/><br/>
		IFSC: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="ifsc"/><br/><br/>
		Phone No: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="mobno"/><br/><br/></b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Submit"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear"/>
</form></div>

<jsp:include page="footer.jsp"></jsp:include>
</div>
