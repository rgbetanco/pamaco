<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">


<html:base/>


<TABLE border="0">
	<TBODY>
	</TBODY>
</TABLE>

<html:form action="/updatepwd">
	<TABLE border="0" id="sessionTable" align="center">
		<TBODY>
		<TR>
			<TD colspan="2"><SPAN class="checkoutTitle">manejo de contraseñas</SPAN> <SPAN
				class="checkoutSubTitle">| cambiar</SPAN></TD>
		</TR>
		<TR>
			<TD colspan="2">Ingrese la contraseña</TD>
		</TR>

		
			<TR>				
				<TD colspan="2"><html:hidden property="userId" /></TD>
			</TR>
			<TR>
				<TD>
				<logic:messagesPresent property="oldPassword" ><span class="daterror">Nueva contraseña:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="oldPassword">Nueva contraseña:</logic:messagesNotPresent></B>
				
				</TD>
				<TD>
					<input type="password" name="password" size="35" value="">
				</TD>
			</TR>
			<TR>
				<TD>
				<logic:messagesPresent property="password" ><span class="daterror">Reescribir contraseña:</span></logic:messagesPresent>
				<B><logic:messagesNotPresent property="password">Reescribir contraseña:</logic:messagesNotPresent></B>
				
				</TD>
				<TD>
					<input type="password" name="password2" size="35" value="">
				</TD>
			</TR>
		<TR>
			<td colspan="2" class="daterror">
				<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>

			</td>
		</TR>
			
			<TR>
				<TD>
					<input type="hidden" name="userId" value="<c:out value='${userId}'/>">
					<INPUT type="image" name="continue" src="/ElCocoWeb/img/continue.jpg">
				</TD>
				<TD></TD>
			</TR>
		</TBODY>
	</TABLE>
</html:form>
