<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>
<html:form action="/updateRoomType">
<TABLE border="0">
	<TBODY>
		<TR>
			<TD>Código</TD>
			<TD><html:text property="roomTypeId" size="5" readonly="true"/></TD>
		</TR>
		<TR>
			<TD>Descripción</TD>
			<TD><html:text property="description" size="32"/></TD>		
		</TR>
		<TR>
			<TD colspan="2">
				<html:submit value="Actualizar" />
				<INPUT type="button" onclick="window.location.replace('showRoomTypeInsert.do')" value="Cancelar">
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>


<iframe id="info"
		frameborder="0" 
		src="showRoomTypeDetail.do";
		name="info" 
		align="middle" 
		scrolling="no" 
		width="100%"
		height="370"
		marginwidth="0"
		marginheight="0">
</iframe>
