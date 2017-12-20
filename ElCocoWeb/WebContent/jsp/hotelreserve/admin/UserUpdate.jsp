<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include> 
<html:form action="/updateUser">
<TABLE border="1">
	<TBODY>

		<TR>
			<TD>Id Usuario:</TD>
			<TD><c:out value="${userForm.userId}"/></TD>
		</TR>		
		<TR>
			<TD>Nombre Completo:</TD>
			<TD><html:text property="name" size="45"/></TD>		
		</TR>
			<TR>
				<TD>Estado:</TD>
				<TD>
					<html:select property="status">
						<html:option value="3">Forzado a cambiar contraseña</html:option>
						<html:option value="0">Desahabilitado</html:option>
						<html:option value="1">Habilitado</html:option>						
					</html:select>
				</TD>
			</TR>
			<TR>
			<TD>Grupo:</TD>
			<TD>
				<html:select property="groupId">
					<html:options collection="userGroups" property="value" labelProperty="label"/>
				</html:select>
			</TD>

			</TR>
			<TR>
				<TD>Email:</TD>
				<TD><html:text property="email" size="32"></html:text> </TD>
			</TR>
			<TR>
			<TD colspan="2">
				<html:hidden property="userId"/>
				<html:submit value="Actualizar" />
				<html:cancel></html:cancel>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>

<iframe id="info"
		frameborder="0" 
		src="showUserDetail.do";
		name="info" 
		align="middle" 
		scrolling="no" 
		width="100%"
		height="370"
		marginwidth="0"
		marginheight="0">
</iframe>
