<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<SCRIPT language="javascript" type="text/javascript" src="/ElCocoWeb/js/datetimepicker.js"></SCRIPT>

<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<html:form action="/reserveQuery">
<table cellspacing=0 border="0" cellpadding="0" summary="">
	  <tr>
	  	<td colspan="2">
	  		<h2>Consultar Reservaciones</h2>	  	
	  	</td>
	  </tr>

	  <tr>
	  <td>Check-In</td>
	  	<td>
	  		<html:text property="checkIn" maxlength="25" size="25"/><a href="javascript:NewCal('checkIn','ddmmyyyy',false,24)"><img src="/ElCocoWeb/img/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<!--input type="text" name="checkIn" id="checkIn" maxlength="25" size="25"></a-->
	  		<span class="descriptions"></span>
	  	</td>
	  </tr>
	  <tr>
	  	<td>Check-Out</td>
	  	<td>
		  	<html:text property="checkOut" maxlength="25" size="25"/><a href="javascript:NewCal('checkOut','ddmmyyyy',false,24)"><img src="/ElCocoWeb/img/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<!--input type="text" name="checkOut" id="checkOut" maxlength="25" size="25"></a-->
	  		<span class="descriptions"></span>
	  	</td>
	  </tr>
	  <tr>
	  <td>Estado</td>
	  	<td>
	  		<html:select property="status">
	  			<option value="">Todos</option>
	  			<html:options collection="status" property="code" labelProperty="description" />
	  		</html:select>
		 </td>
	  </tr>
	  <tr>
	  	<td><input type="submit" value = "Consultar" /></td>
	  </tr>
</table>
</html:form>

<p><br></p>
<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include> 

<TABLE border="1">
	<TBODY align="center">
		
		<TR class="tableTitle">			
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=roomName&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Alojamiento</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=iniDate&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Check-In</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=endDate&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Check-Out</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=subTotal&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Monto</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=lastName&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Solicitante</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=code&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Confirmaci&oacute;n</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=statusName&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Estado</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=approver&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Aprobador</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=approverDate&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Fecha aprobaci&oacute;n</a></TH>
			<TH><a href="/ElCocoWeb/admin/reserveQuery.do?ob=reference&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Referencia</a></TH>
		</TR>
<c:forEach items="${resultHandler}" var="reserve">		
		<TR>
			<TD><c:out value="${reserve.roomName}"/></TD>						
			<TD><fmt:formatDate value="${reserve.iniDate.time}" pattern="EE dd MMM, yyyy"/></TD>
			<TD><fmt:formatDate value="${reserve.endDate.time}" pattern="EE dd MMM, yyyy"/></TD>
			<TD>$<fmt:formatNumber value="${reserve.total}" type="number" maxFractionDigits="2" minFractionDigits="2"/></TD>
			<TD>
				<a href="/ElCocoWeb/jsp/hotelreserve/admin/SendMail.jsp?emailParm=<c:out value='${reserve.email}'/>" target="_blank">
					<c:out value="${reserve.lastName}"/>, <c:out value="${reserve.firstName}"/>
				</a>
			</TD>
			<TD><c:out value="${reserve.code}"/></TD>
			<TD><c:out value="${reserve.statusName}"/></TD>
			<TD><c:out value="${reserve.approver}"/></TD>
			<TD><c:out value="${reserve.approverDate}"/></TD>
			<TD><c:out value="${reserve.reference}"/></TD>
		</TR>
</c:forEach>		
	</TBODY>
</TABLE>
<P></P>
	


<table width="650" border="0" cellpadding="5" cellspacing="0">		    
   		<tr>
   			<th colspan="4">
   				<c:choose>
   					<c:when test="${hasPrevious}" >
   						<a href="/ElCocoWeb/admin/reserveQuery.do?ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage - 1}'/>&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>"> &lt; Anterior</a>
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
							<a href="/ElCocoWeb/admin/reserveQuery.do?ob=<c:out value='${ob}'/>&page=<%=i%>&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">
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
   							&nbsp; <a href="/ElCocoWeb/admin/reserveQuery.do?ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage + 1}'/>&checkIn=<c:out value='${queryForm.checkIn}'/>&checkOut=<c:out value='${queryForm.checkOut}'/>&status=<c:out value='${queryForm.status}'/>">Siguiente &gt;</a>
   						</c:when>
   						<c:otherwise>
   							
   						</c:otherwise>
					</c:choose>   						
   					</th>
   				</tr>
</table>



