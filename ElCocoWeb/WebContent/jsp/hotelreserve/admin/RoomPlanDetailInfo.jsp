<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<SCRIPT LANGUAGE="JavaScript">
  function redireccionar(roomid, planno) {
  var accion = confirm('Desea eliminar este plan de este alojamiento?');
  if (accion) {
	  location.href='/ElCocoWeb/admin/deleteRoomPlan.do?roomId=' + roomid + '&planno=' + planno;
	  return true;
  } else {
		return false;
  }
  
  }
 </SCRIPT>


<table>
			<TR>
				<TD colspan="8">
					<html:form action="insertRoomPlan.do">
						<html:select property="newRoomPlan">
							<html:options collection="planRates" property="value" labelProperty="label"/>
						</html:select>
						<html:hidden property="roomId"/>
						<html:submit value="Agregar"></html:submit>
					</html:form>
				</TD>					
			</TR>
</table>
<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>
<TABLE border="1">
	<TBODY>
		<TR>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=planNo">Plan No.</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=name">Descripción</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=iniDate">Desde</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=endDate">Hasta</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=minNights">Noches<BR>
			Minimas</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=price">Precio</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=active">Activo</a></TH>
			<TH>Acciones</TH>
		</TR>
		<c:forEach items="${resultHandler}" var="bean" varStatus="stat">
	<c:choose>
	<c:when test="${stat.index % 2 == 0}">
		<TR style="background-color: white">
	</c:when>
	<c:otherwise>
		<TR style="background-color: #cccccc">
	</c:otherwise>
	</c:choose>
			<TD>
				<c:out value="${bean.planNo}"/>
						
			</TD>
			<TD><c:out value="${bean.name}"/></TD>
			<TD><fmt:formatDate value="${bean.iniDate.time}" pattern="dd/MMM/yyyy"/></TD>
			<TD><fmt:formatDate value="${bean.endDate.time}" pattern="dd/MMM/yyyy"/></TD>
			<TD><c:out value="${bean.minNights}"/></TD>
			<TD align="right">$ <fmt:formatNumber value="${bean.price}" type="number" maxFractionDigits="2" minFractionDigits="2"/></TD>
			<TD><c:out value="${bean.active}"/></TD>
			<TD>
				<a href="#" onclick="redireccionar(<c:out value='${roomPlanForm.roomId}'/>,<c:out value='${bean.planNo}'/> );">				
					Eliminar
				</a>
					 | Editar</TD>
			</TR>
		</c:forEach>

	</TBODY>
</TABLE>


<table width="650" border="0" cellpadding="5" cellspacing="0">		    
   		<tr>
   			<th colspan="4">
   				<c:choose>
   					<c:when test="${hasPrevious}" >
   						<a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage - 1}'/>"> &lt; Anterior</a>
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
							<a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=<c:out value='${ob}'/>&page=<%=i%>">
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
   							&nbsp; <a href="/ElCocoWeb/admin/showRoomPlanDetail.do?roomId=<c:out value='${roomPlanForm.roomId}'/>&ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage + 1}'/>">Siguiente &gt;</a>
   						</c:when>
   						<c:otherwise>
   							
   						</c:otherwise>
					</c:choose>   						
   					</th>
   				</tr>
</table>
