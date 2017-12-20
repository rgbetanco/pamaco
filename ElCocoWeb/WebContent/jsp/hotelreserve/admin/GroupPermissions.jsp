<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>

<SPAN class="checkoutTitle">Permisos</SPAN> <SPAN class="checkoutSubTitle">| Grupo <c:out value="${userGroupForm.groupName}"/> </SPAN>
<div align="right"><a href="/ElCocoWeb/admin/showUserGroupInsert.do">Regresar</a></div>				
<html:form action="updateGroupPermissions.do">
<c:forEach items="${options}" var="opt">
				<TABLE>
					<TBODY>
						<TR>
							<TH colspan="3"><c:out value="${opt.description}"/> </TH>
						</TR>
						<TR>
							<TD colspan="3">
							<c:forEach items="${opt.permissions}" var="perm" varStatus="stat1">
								<html:multibox property="selectedPermissions">
									<c:out value='${perm.permId}'/>_<c:out value='${perm.optionId}'/>
								</html:multibox>
									<c:out value="${perm.permission}"/>
							</c:forEach>							

							</TD>
						</TR>
					
					</TBODY>
				</TABLE>
				<p>&nbsp;</p>
</c:forEach>
<html:hidden property="groupId"/>
<html:submit value="Actualizar"></html:submit>
</html:form>