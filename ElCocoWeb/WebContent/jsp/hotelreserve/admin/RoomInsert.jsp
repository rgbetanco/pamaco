<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include> 
<html:form action="/insertRoom">
<TABLE border="1">
	<TBODY>
	
		<TR>
			<TD>Descripción</TD>
			<TD><html:text property="description" size="32"/></TD>		
		</TR>
			<TR>
			<TD>Plan</TD>
			<TD>
				<html:select property="planNo">
					<html:options collection="planRates" property="value" labelProperty="label"/>
				</html:select>
			</TD>

			</TR>
			<TR>
			<TD>Bloquear</TD>
			<TD><html:checkbox property="blocked" value="1"/> Si</TD>		
		</TR>		
		<TR>
			<TD colspan="2">
				<html:hidden property="roomTypeId"/>
				<html:hidden property="roomTypeName"/>
				<html:submit value="Insertar" />
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>
<div align="right"><a href="/ElCocoWeb/admin/showRoomTypeMain.do">Regresar</a></div>

<iframe id="info"
		frameborder="0" 
		src="showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&roomTypeName=<c:out value='${roomForm.roomTypeName}'/>";
		name="info" 
		align="middle" 
		scrolling="no" 
		width="100%"
		height="370"
		marginwidth="0"
		marginheight="0">
</iframe>
