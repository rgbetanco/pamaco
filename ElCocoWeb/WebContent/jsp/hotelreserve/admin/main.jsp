
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html:html>
<HEAD>

<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css"
	type="text/css">
</HEAD>

<BODY>

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>
<p><br>&nbsp;</p>
<center>

<TABLE width="80%" border="0" id="tableYellow">
	<TBODY>
		<TR>
			<TH colspan="3">Autorizaciones</TH>
		</TR>
		<TR>
			<TD><a href="/ElCocoWeb/admin/showPendingReserve.do"><IMG border="0"
				src="/ElCocoWeb/img/ok3232.jpg" width="32"
				height="32" align="middle">Por Confirmar</a></TD>
			<!--TD><a href="#"><IMG border="0" src="/ElCocoWeb/img/i_licensemanager_med.gif"
				width="32" height="32" align="middle">Confirmadas</a></TD-->
			<TD colspan="1"><a href="/ElCocoWeb/admin/reserveQuery.do"><IMG border="0" src="/ElCocoWeb/img/i_crontab_med.gif" width="32"
				height="32" align="middle">Historial</a></TD>
		</TR>
		<TR>
			<TD colspan="3"><P><BR></P></TD>
		</TR>

		<TR>
			<TH colspan="3">Alojamientos</TH>
		</TR>
		<TR>
			<TD><a href="/ElCocoWeb/admin/showRoomTypeMain.do"> <IMG border="0"
				src="/ElCocoWeb/img/i_system_tab.gif" width="32" height="32" align="middle"> Habitaciones</a></TD>
			<TD><a href="/ElCocoWeb/admin/showPlanRateMain.do"> <IMG border="0"
				src="/ElCocoWeb/img/i_actionlog_med.gif" width="32" height="32" align="middle">Planes Tarifas</a></TD>
			<TD><a href="/ElCocoWeb/admin/showAvailability.do"><IMG border="0"
				src="/ElCocoWeb/img/reservation.gif" width="32"
				height="32" align="middle">Bloquear/Desbloquear</a></TD>				
		</TR>
		<TR>
			<TD colspan="3"><P><BR></P></TD>
		</TR>
		<TR>
			<TH colspan="3">Usuarios &amp; Grupos</TH>
		</TR>
		<TR>
			<TD><a href="/ElCocoWeb/admin/showUserMain.do"><IMG border="0" src="/ElCocoWeb/img/users_med.gif"
				width="32" height="32" align="middle">Usuarios</a></TD>
			<TD><a href="/ElCocoWeb/admin/showUserGroupInsert.do"><IMG border="0" src="/ElCocoWeb/img/i_groups_med.gif"
				width="32" height="32" align="middle"> Grupos</A></TD>
			<TD></TD>
		</TR>
		<TR>
			<TD colspan="3"><P><BR></P></TD>
		</TR>
		<TR>
			<TH colspan="3">Reportess</TH>
		</TR>
		<TR>
			<TD><A href="/ElCocoWeb/admin/showGenStatistics.do"><IMG border="0"
				src="/ElCocoWeb/img/i_vzpp_med.gif" width="32"
				height="32" align="middle">Reporte Estadistico</A></TD>
				<TD></TD>
		</TR>
	
	
	</TBODY>
</TABLE>



</center>
</BODY>
</html:html>
