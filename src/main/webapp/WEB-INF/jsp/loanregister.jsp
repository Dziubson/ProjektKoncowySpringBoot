    <script type="text/javascript">
    
    function check()
    {
    if(document.f1.accno.value=="")
    {
        alert("plz enter account number!");
        return false;
    }

    if(document.f1.intrestval.value=="")
    {
        alert("plz enter intrest value!");
        return false;
    }

    if(document.f1.amount.loanval=="")
    {
        alert("plz enter amount!");
        return false;
    }

    }
</script>
<div id="container">
<link href="css.css" rel="stylesheet" type="text/css">
<jsp:include page="emp-header.jsp"></jsp:include>

<div id="content-container">
<div id="content" style="text-align: center;">
<marquee><h2 style="color: red;"><i>--- Welcome ${username} ---</i></h2></marquee>
	<br/><br/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

</div>
<div style="text-align: center;">
<br/><h2>Loan :-</h2><br/><br/>
	<div id="messageBox">
		${message}
	</div>
	<form name="f1" action="loanregister" onsubmit="return check();" method="post">
		<b>		 
		Account number: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="accno"/><br/><br/>
		Intrest rate: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="intrestval"/><br/><br/>
		Loan value: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="loanval"/><br/><br/>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Submit"/>
    	&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="Clear"/>
		</b>
</form></div>
</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
