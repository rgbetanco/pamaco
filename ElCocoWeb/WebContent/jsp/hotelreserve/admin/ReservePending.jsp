
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>


<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<SCRIPT LANGUAGE="JavaScript">
	function irA(menu){
    	window.location.href = menu.options[menu.selectedIndex].value;
    }
    
</SCRIPT>



<H2 align="center">Reservaciones pendientes de aprobaci&oacute;n</H2>

<DIV align="right">
	<FORM name="formulario">
	  <SELECT NAME="menu" SIZE=1 onChange ="irA(this)">
		    <OPTION VALUE="">-- Ordenar por --
		    <OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=reserveDate">Fecha
		    <OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=roomName">Alojamiento
		    <OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=iniDate">Check-In
    		<OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=endDate">Check-Out
			<OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=subTotal">Monto
			<OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=lastName">Solicitante
			<OPTION VALUE="/ElCocoWeb/admin/showPendingReserve.do?ob=guests">Acompa&ntilde;antes
		</SELECT>
	</FORM>
</DIV>
<p>&nbsp;</p>
<FORM action="/ElCocoWeb/admin/approveDenyReserve.do">
<c:forEach items="${resultHandler}" var="reserve">
<TABLE border="1">
	<TBODY align="center">
		
		<TR class="tableTitle">
			<TH>Fecha</TH>
			<TH>Alojamiento</TH>
			<TH>Check-In</TH>
			<TH>Check-Out</TH>
			<TH>Monto</TH>
			<TH>Solicitante</TH>
			<TH>Acompañantes</TH>
			<TH>Confirmar</TH>
			<TH>Denegar</TH>
		</TR>
		
		<TR>
			<TD><fmt:formatDate value="${reserve.reserveDate.time}" pattern="dd/MM/yyyy hh:mm a"/></TD>
			<TD><c:out value="${reserve.roomName}"/></TD>
			<TD><fmt:formatDate value="${reserve.iniDate.time}" pattern="EE dd MMM, yyyy"/></TD>
			<TD><fmt:formatDate value="${reserve.endDate.time}" pattern="EE dd MMM, yyyy"/></TD>
			<TD>$<fmt:formatNumber value="${reserve.total}" type="number" maxFractionDigits="2" minFractionDigits="2"/></TD>
			<TD>
				<a href="/ElCocoWeb/jsp/hotelreserve/admin/SendMail.jsp?emailParm=<c:out value='${reserve.email}'/>" target="_blank">
					<c:out value="${reserve.lastName}"/>, <c:out value="${reserve.firstName}"/>
				</a>
			</TD>
			<TD><c:out value="${reserve.guests}"/></TD>
			<TD><INPUT type="radio" name="CBconfirmed<c:out value="${reserve.code}"/><c:out value="${reserve.roomId}"/>" value=0></TD>
			<TD><INPUT type="radio" name="CBconfirmed<c:out value="${reserve.code}"/><c:out value="${reserve.roomId}"/>" value=1></TD>
		</TR>
		<TR>
			<TH colspan="9">Comentarios adicionales</TH>			
		</TR>
		<TR>
			<TD colspan="9" align="left"><c:out value="${reserve.comments}"/></TD>		
		</TR>
		
		<TR>
			<TD colspan="9">
				<INPUT type="hidden" name="idRemote"  value="<c:out value="${reserve.code}"/>">
				<INPUT type="hidden" name="roomIds"  value="<c:out value="${reserve.roomId}"/>">
			</TD>
		</TR>
		
	</TBODY>
</TABLE>
<P></P>
</c:forEach>	


<table width="650" border="0" cellpadding="5" cellspacing="0">		    
   		<tr>
   			<th colspan="4">
   				<c:choose>
   					<c:when test="${hasPrevious}" >
   						<a href="/ElCocoWeb/admin/showPendingReserve.do?ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage - 1}'/>"> &lt; Anterior</a>
   						&nbsp;
   					</c:when>
   					<c:otherwise>   						
   							
   					</c:otherwise>
				</c:choose>   						
						<%
						try {
							int maxLastPage = Integer.parseInt((String) request.getAttribute("maxLastPage"));
							int minLastPage = Integer.parseInt((String) request.getAttribute("minLastPage"));
							int currentPage = Integer.parseInt((String) request.getAttribute("currentPage"));
							for (int i=minLastPage;i<=maxLastPage;i++) {
								if(maxLastPage == 1) break;
						%>						
							<a href="/ElCocoWeb/admin/showPendingReserve.do?ob=<c:out value='${ob}'/>&page=<%=i%>">
						<%	
								if (currentPage == i) {
						%>
									<font color="red">
								<%}%>
										<%=i%>
						<%
								if (currentPage == i) {
						%>
									</font>
								<%}%>
										</a>

						<%								
							}
						} catch (Exception ex) {
						}
						%>
   					<c:choose>
   						<c:when test="${hasNext}" >
   							&nbsp; <a href="/ElCocoWeb/admin/showPendingReserve.do?ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage + 1}'/>">Siguiente &gt;</a>
   						</c:when>
   						<c:otherwise>
   							
   						</c:otherwise>
					</c:choose>   						
   					</th>
   				</tr>
</table>


<DIV align="center">
	<html:submit value="Procesar los seleccionados"></html:submit>
</DIV>
</form>

<P></P>
