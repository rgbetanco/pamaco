

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<script>
	function setIframeSrcParam(){
		document.all.info.src = "showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>";
	}
	
</script>


<BODY onload = "setIframeSrcParam();">


<h3>Detalle Planes</h3>

<TABLE border="1">
	<TBODY>

		<TR>
			<TD>Código</TD>
			<TD><c:out value="${roomPlanForm.roomId}"/></TD>
		</TR>
		<TR>
			<TD>Descripción</TD>
			<TD><c:out value="${roomPlanForm.roomName}"/></TD>
		</TR>
		<TR>
			<TD>Grupo</TD>
			<TD><c:out value="${roomPlanForm.roomTypeName}"/></TD>
		</TR>		
	</TBODY>
</TABLE>
<a href="/ElCocoWeb/admin/showPlanRateMain.do">Crear nuevo plan</a>

<div align="right"><a href="/ElCocoWeb/admin/showRoomMain.do?roomTypeId=<c:out value='${roomPlanForm.roomTypeId}'/>&roomTypeName=<c:out value='${roomPlanForm.roomTypeName}'/>">Regresar</a></div>

<iframe id="info" 
		frameborder="0" 
		name="info" 
		align="middle"
		scrolling="no" 
		width="100%" 
		height="700"
		marginwidth="0"
		marginheight="0"> 
	
	</iframe>

</BODY>

