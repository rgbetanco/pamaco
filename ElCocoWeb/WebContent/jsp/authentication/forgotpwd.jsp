<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>



<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css"
	type="text/css">




<TABLE border="0">
	<TBODY>

	</TBODY>
</TABLE>

<html:form action="/forgotpwd">
	<TABLE border="0" id="sessionTable" align="center">
		<TBODY>
		<TR>
			<TD colspan="3"><SPAN class="checkoutTitle">password management</SPAN> <SPAN
				class="checkoutSubTitle">| regenerate</SPAN></TD>
		</TR>
		<TR>
			<TD colspan="3">Type your user name to send you the new password.</TD>
		</TR>		
		
			<TR>	
			<TD align="right">
				<logic:messagesPresent property="userId"><span class="daterror">User name:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="userId">User name:</logic:messagesNotPresent></B>				
			</TD>						
			<TD>
				<html:text property="userId" size="35"/>
			</TD>
			<TD><INPUT type="image" name="continue" src="/ElCocoWeb/img/continue.jpg"></TD>			
			</TR>
		<TR>
			<td colspan="3" class="daterror">
				<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>

			</td>
		</TR>
			
		</TBODY>
	</TABLE>
</html:form>
