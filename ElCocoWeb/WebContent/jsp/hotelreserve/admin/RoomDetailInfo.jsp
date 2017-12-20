<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>
<TABLE border="1">
	<TBODY>
		<TR>
			<TH><a href="/ElCocoWeb/admin/showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&ob=roomId">Código</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&ob=description">Descripción</a></TH>
			<TH><a href="/ElCocoWeb/admin/showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&ob=blocked">Bloqueado</a></TH>
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
				<a href="/ElCocoWeb/admin/showRoomUpdate.do?roomId=<c:out value='${bean.roomId}'/>&description=<c:out value="${bean.description}"/>&blocked=<c:out value="${bean.blocked}"/>&roomTypeId=<c:out value='${roomForm.roomTypeId}'/>" 
					target="_parent"
					>
					<c:out value="${bean.roomId}"/>
				</a>
							
			</TD>
			<TD><c:out value="${bean.description}"/></TD>
			<TD><c:out value="${bean.blocked}"/></TD>
			<TD>
				<a href="/ElCocoWeb/admin/showRoomPlanMain.do?roomId=<c:out value='${bean.roomId}'/>&roomName=<c:out value="${bean.description}"/>&roomTypeName=<c:out value="${roomForm.roomTypeName}"/>&roomTypeId=<c:out value='${roomForm.roomTypeId}'/>" 
					target="_top"
					>
			
				asociar planes
			</TD>
		</TR>
		</c:forEach>					
	</TBODY>
</TABLE>


<table width="650" border="0" cellpadding="5" cellspacing="0">		    
   		<tr>
   			<th colspan="4">
   				<c:choose>
   					<c:when test="${hasPrevious}" >
   						<a href="/ElCocoWeb/admin/showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage - 1}'/>"> &lt; Anterior</a>
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
							<a href="/ElCocoWeb/admin/showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&ob=<c:out value='${ob}'/>&page=<%=i%>">
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
   							&nbsp; <a href="/ElCocoWeb/admin/showRoomDetail.do?roomTypeId=<c:out value='${roomForm.roomTypeId}'/>&ob=<c:out value='${ob}'/>&page=<c:out value='${currentPage + 1}'/>">Siguiente &gt;</a>
   						</c:when>
   						<c:otherwise>
   							
   						</c:otherwise>
					</c:choose>   						
   					</th>
   				</tr>
</table>

