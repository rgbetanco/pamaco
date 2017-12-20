
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<SCRIPT language="JavaScript" src="/ElCocoWeb/js/popup.js"></SCRIPT>
<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>

<TABLE border="0">
	<TBODY>

		<TR>
			<TD></TD>
			<TD class="ct_price_head">
		<c:choose>
			<c:when test="${empty code}">			
				<html:form action="placeorder.do">
				<fmt:message key="label.common.review" /> <input type="submit" value="<fmt:message key="button.label.reserve" />">
				</html:form>
			</c:when>
			<c:otherwise>
				<h3><fmt:message key="label.common.confirmcode" />&nbsp;<c:out value="${code}"/></h3>
			</c:otherwise>						
		</c:choose>
			</TD>
			<TD></TD>
		</TR>

		<TR>
			<TD></TD>
			<TD class="block_content"><fmt:message key="label.common.reviewundername" />:</TD>
			<TD rowspan="6"></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD class="content">
				<c:out value="${reserveForm.firstName}" /> <c:out value="${reserveForm.lastName}" /><br>
				<c:out value="${reserveForm.address}" /><br>
				<c:out value="${reserveForm.country}" />
				<c:if test="${not empty reserveForm.city}"><c:out value="${reserveForm.city}" /></c:if>						  		
				<c:if test="${not empty reserveForm.zip}"><c:out value="${reserveForm.zip}" /></c:if><br>
				<c:if test="${not empty reserveForm.phone}">
					<fmt:message key="label.common.phone" />:
					<c:out value="${reserveForm.phone}" />
				</c:if><br>
				<fmt:message key="label.common.email" />: <c:out value="${reserveForm.email1}" />				
			</TD></TR>
		<TR>
			<TD></TD>
			<TD class="block_content"><fmt:message key="label.common.reviewrooms" />:</TD></TR>
		<TR>
		<TR>
			<TD></TD>
			<TD>
			<center><a onclick="vtn('/jsp/hotelreserve/roomReserveInvoice.jsp','800','320')" style="cursor: pointer; color: blue; font-variant: small-caps;"><u><fmt:message key="label.common.viewdetail" /></u></a></center>
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD>
			
<c:set var="grandtotal" value="0"/>
<c:forEach items="${reserveForm.selectedRooms}" var="roomCheckedBean">
	<TABLE border="0">
		<TBODY>
			<TR>
				<TD colspan="2">
					<table border="0">
						<tr>
							<td class="ct_price_content"><fmt:message key="label.common.lodging" />:</td>
							<td class="ct_price_content"><c:out value="${roomCheckedBean.roomName}"/></td>
						</tr>
						<tr>
							<td class="ct_price_content"><fmt:message key="label.common.arrival" />:</td>
							<td class="ct_price_content"><fmt:formatDate value="${roomCheckedBean.iniDate.time}" pattern="dd/MM/yyyy"/></td>
						</tr>
						<tr>
							<td class="ct_price_content"><fmt:message key="label.common.departure" />:</td>
							<td class="ct_price_content"><fmt:formatDate value="${roomCheckedBean.endDate.time}" pattern="dd/MM/yyyy"/></td>
						</tr>
						<tr>
							<td class="ct_price_content"><fmt:message key="label.common.nights" />:</td>
							<td class="ct_price_content"><c:out value="${roomCheckedBean.numNights}"/></td>
						</tr>					
						<tr>
							<td class="ct_price_content"><fmt:message key="label.common.guests" />:</td>
							<td class="ct_price_content"><c:out value="${roomCheckedBean.guests}"/></td>
						</tr>							
					</table>
				</TD>

				<TD class="ct_price_usd">
					<table border="0" height="100%">
						<tr>
							<td nowrap="nowrap" class="ct_price_usd"><fmt:message key="label.common.subtotal" />:</td>
							<td class="ct_price_value"><fmt:formatNumber value="${roomCheckedBean.subTotal}" type="number" maxFractionDigits="2" minFractionDigits="2"/></td>
						</tr>
						<tr>
							<td nowrap="nowrap" class="ct_price_usd"><fmt:message key="label.common.tax" />:</td>
							<td class="ct_price_value"><fmt:formatNumber value="${roomCheckedBean.IVA}" type="number" maxFractionDigits="2" minFractionDigits="2"/></td>
						</tr>
						<tr>
							<td nowrap="nowrap" class="ct_price_usd"><fmt:message key="label.common.roomtotal" />: $</td>
							<td class="ct_price_value">
								<fmt:formatNumber value="${roomCheckedBean.total}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
								<c:set var="grandtotal" value="${roomCheckedBean.total + grandtotal}"/>							
							</td>
						</tr>												
					</table>
				</TD>
			</TR>
			<TR>
				<TD colspan="3" align="right">

				</TD>
			</TR>
		</TBODY>
	</TABLE>
</c:forEach>			
			
			
			</TD></TR>

					
<c:if test="${not empty reserveForm.comment}">		
		<TR>
			<TD></TD>
			<TD class="block_content"><fmt:message key="label.common.comments" />:</TD>
			
		</TR>

		<TR>
			<TD></TD>
			<TD  class="content"><c:out value="${reserveForm.comment}" /></TD></TR>
</c:if>		

		<TR>
			<TD></TD>
			<TD class="ct_price_head">
		<c:choose>
			<c:when test="${empty code}">			
				<html:form action="placeorder.do">
				<fmt:message key="label.common.review" /> <input type="submit" value="<fmt:message key="button.label.reserve" />">
				</html:form>
			</c:when>
			<c:otherwise>
				<h3><fmt:message key="label.common.confirmcode" />&nbsp;<c:out value="${code}"/></h3>
			</c:otherwise>						
		</c:choose>
			</TD>
			<TD></TD>
		</TR>

	</TBODY>
</TABLE>