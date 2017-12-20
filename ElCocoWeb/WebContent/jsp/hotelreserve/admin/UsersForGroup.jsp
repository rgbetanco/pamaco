<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>
<table border="1">
	<tr>
		<td>Id Grupo:</td>
		<td><c:out value="${userGroupForm.groupId}"/></td>
	</tr>
	<tr>
		<td>Nombre:</td>
		<td><c:out value="${userGroupForm.groupName}"/></td>
	</tr>
	
</table>
<div align="right"><a href="/ElCocoWeb/admin/showUserGroupInsert.do" title="">Regresar</a> </div>
<TABLE border="1">
	<TBODY>
		<TR>
			<TD>Id Usuario</a></TD>
			<TD>Nombre</TD>
			<TD>Estado*</TD>			

		</TR>
		<c:forEach items="${result}" var="bean" varStatus="stat">
	<c:choose>
	<c:when test="${stat.index % 2 == 0}">
		<TR style="background-color: white">
	</c:when>
	<c:otherwise>
		<TR style="background-color: #cccccc">
	</c:otherwise>
	</c:choose>
			<TD>
				<a href="/ElCocoWeb/admin/showUserUpdate.do?userId=<c:out value='${bean.userId}'/>&name=<c:out value="${bean.name}"/>&status=<c:out value="${bean.status}"/>&email=<c:out value='${bean.email}'/>&groupId=<c:out value='${bean.groupId}'/>" 
					target="_parent"
					>
					<c:out value="${bean.userId}"/>
				</a>
							
			</TD>
			<TD><c:out value="${bean.name}"/></TD>
			<TD><c:out value="${bean.status}"/></TD>			

		</TR>
		</c:forEach>					
	</TBODY>
</TABLE>
<strong>*Estados</strong><br>
0=Desahabilitado<br>
1=Habilitado<br>
3=Forzado a cambiar contrase&ntilde;a<br>

