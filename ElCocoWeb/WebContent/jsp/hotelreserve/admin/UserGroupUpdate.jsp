<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include> 
<html:form action="/updateUserGroup">
<TABLE border="1">
	<TBODY>
		<TR>
			<TD>Group Id:</TD>
			<TD><c:out value="${userGroupForm.groupId}"/></TD>
		</TR>
		<TR>
			<TD>Nombre del Grupo:</TD>
			<TD><html:text property="groupName" size="45"/></TD>		
		</TR>
			<TR>
				<TD>Descripci&oacute;n:</TD>
				<TD><html:textarea property="description" cols="35" rows="4"/></TD>
			</TR>
			<TR>
			<TD colspan="2">
				<html:hidden property="groupId"/>
				<html:submit value="Actualizar" />
				<html:cancel></html:cancel>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>

<iframe id="info"
		frameborder="0" 
		src="showUserGroupDetail.do";
		name="info" 
		align="middle" 
		scrolling="no" 
		width="100%"
		height="370"
		marginwidth="0"
		marginheight="0">
</iframe>
