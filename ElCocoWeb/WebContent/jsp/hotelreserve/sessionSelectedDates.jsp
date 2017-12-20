
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!--LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css"-->



<LINK rel="stylesheet" href="/ElCocoWeb/themes/playaelcoco2/style.css" type="text/css">

<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>


<TABLE border="0" cellpadding="0" cellspacing="0">
	<TBODY>
<c:if test="${not empty reserveForm.roomTypeName and not empty reserveForm.roomName}">	
		<TR>
			<TD class="block_headline" colspan="2"><fmt:message key="label.common.roomtype" /></TD>
		</TR>
		<TR>
			<TD class="block_content" colspan="2">
				<c:out value="${reserveForm.roomTypeName}" /> <c:out value="${reserveForm.roomName}" />
			</TD>
		</TR>	
</c:if>	

<c:if test="${not empty reserveForm.initDateCal.time and not empty reserveForm.endDateCal.time}">	
		<TR>
			<TD colspan="2" class="block_headline">
				<fmt:message key="label.common.reservation"/>
			</TD>
		</TR>
		
		<TR>
			<TD class="block_content" colspan="2">
				<fmt:message key="label.common.initdate"/>:<br>
				<strong><fmt:formatDate value="${reserveForm.initDateCal.time}" pattern="EE MMM dd yyyy"/></strong>
			</TD>
		</TR>
		<TR>
			<TD class="block_content" colspan="2">
				<fmt:message key="label.common.enddate"/>:<br>
				<strong><fmt:formatDate value="${reserveForm.endDateCal.time}" pattern="EE MMM dd yyyy"/></strong>
			</TD>
		</TR>
	<c:if test="${empty code}">		
		<TR>
			<TD class="block_content" colspan="2">
				<center><a href="/ElCocoWeb/hotelreserve/showfilter.do?roomId=<c:out value='${reserveForm.roomId}'/>&roomTypeId=<c:out value='${reserveForm.roomTypeId}'/>"><font size="-1"><fmt:message key="label.common.change"/></font></a></center>
			</TD>
		</TR>		
	</c:if>	
</c:if>	
		<TR>
			<TD colspan="2" class="block_headline">
				<fmt:message key="label.common.total"/>
			</TD>
		</TR>
		<TR>
			<TD class="block_content" colspan="2">				
				<c:set var="grandtotal" value="0"/>
				<c:forEach items="${reserveForm.selectedRooms}" var="roomCheckedBean">				
					<c:set var="grandtotal" value="${roomCheckedBean.total + grandtotal}"/>
				</c:forEach>				
				<fmt:message key="label.common.totaloccupancy"/>:<div align="right"><strong>$ <fmt:formatNumber value="${grandtotal}" type="number" maxFractionDigits="2" minFractionDigits="2"/></strong><br></div>
				<fmt:message key="label.common.reservedownpayment"/>:<div align="right"><strong>$<fmt:formatNumber value="${grandtotal * 0.50}" type="number" maxFractionDigits="2" minFractionDigits="2" /></strong></div>
			</TD>
		</TR>
<c:if test="${not empty reserveForm.cardNumber}">
		<TR>
			<TD colspan="2" class="block_headline">
				<fmt:message key="label.common.paymentmethod"/>
			</TD>
		</TR>
		<TR>
			<TD class="block_content" colspan="2">
				<fmt:message key="label.common.creditcard"/>: 
				<c:set var="cc" value="${reserveForm.cardNumber}" scope="request"/>
				<% 
					int i=4; 
					String x="0000";
					try{ 
						x = (String) request.getAttribute("cc");
						i = x.length();
					} catch (Exception ex) {}
			  %>
						  ***-<%=x.substring(i-4)%>
				<br>
				<fmt:message key="label.common.creditcardexp"/>: <c:out value="${reserveForm.cardMonth}" /> / <c:out value="${reserveForm.cardYear}" />
			</TD>
		</TR>
	<c:if test="${empty code}">				
		<TR>
			<TD class="block_content" colspan="2">
				<center><a href="/ElCocoWeb/hotelreserve/paymentinfo.do"><font size="-1"><fmt:message key="label.common.change"/></font></a></center>
			</TD>
		</TR>		
	</c:if>
</c:if>
						
</TBODY>
</TABLE>