
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>



<HEAD>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css"
	type="text/css">
</HEAD>
<TABLE border="0" align="center" width="300">
	<TBODY>
		<TR>
			<TD colspan="2" align="center"><SPAN class="checkoutTitle">sign in <SPAN
				class="checkoutSubTitle">|</SPAN></SPAN><SPAN
				class="checkoutSubTitle"> control panel</SPAN></TD></TR>
		<TR>
			<TD colspan="2">

<center><jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include> </center>
			</TD>
		</TR>
	</TBODY>
</TABLE>
	
				
<TABLE align="center" border="0" style="border-color: #cccccc; border-width: thin; border-style: solid;" width="300">
	<html:form action="signin.do" focus="userId">
	<TBODY>
		<TR>
			<td colspan="3" >				
				
			</td>
		</TR>	
		<TR>
			<TD colspan="3" style="background-color: #efefef;" align="center">

			<B>Please enter the information below</B>
			</TD>
		</TR>
		<TR>
			<td rowspan=5>
				<img src="/ElCocoWeb/img/login.gif">
			</td>
		</TR>

		<TR>
			<TD align="right">
				<logic:messagesPresent property="userId"><span class="daterror">User name:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="userId">User name:</logic:messagesNotPresent></B>				
			</TD>
			<TD>				
				<html:text property="userId" size="35" />				
			</TD>
		</TR>
		<TR>
			<TD align="right">
				<logic:messagesPresent property="password" ><span class="daterror">Password:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="password">Password:</logic:messagesNotPresent></B>
			</TD>
			<TD><INPUT type="password" name="password" size="35"></TD>
		</TR>
		
		<TR>		
			<TD></TD>
			<TD>
				<INPUT type="image" name="continue" src="/ElCocoWeb/img/singin.jpg" onclick="this.form.submit();" >
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>Forgot your password? <A href="/ElCocoWeb/admin/showforgotpwd.do">Click here</A>.<BR>
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<td></td>
			<TD><a href="http://realtynica.com/cgi-bin/openwebmail/openwebmail.pl">Check your Email</TD>
		</TR>
	</TBODY>
</TABLE>
			
</html:form>
			
		<center><SPAN> Go to <a href="http://www.playaelcoco.com.ni">playaelcoco.com.ni</a></SPAN></center>
				
			</TD></TR>
	</TBODY>
</TABLE>


