
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<html>
<HEAD>

<STYLE type=text/css media=all>@import url( /ElCocoWeb/misc/drupal.css );</STYLE>
<STYLE type=text/css media=all>@import url( /ElCocoWeb/modules/playaelcoco_menus/playaelcoco_menus.css );</STYLE>
<STYLE type=text/css media=all>@import url( /ElCocoWeb/themes/playaelcoco2/style.css );
</STYLE>
<TITLE></TITLE>

<script language="JavaScript">

    function printReceipt() {
        window.print();
    }

</script>

</HEAD>

<BODY>
<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" /><SCRIPT type="text/javascript"></SCRIPT>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD class=header>&nbsp;</TD>
    <TD class=header_center><BR>
	    <A  href="/ElCocoWeb/hotelreserve/switchLang.do?lang=en">
    		<IMG class=i18n-flag  height=12 alt=English src="/ElCocoWeb/img/en.png" width=16></A>
	    <A href="#">
     		<IMG class=i18n-flag height=12 alt=German src="/ElCocoWeb/img/de.png" width=16></A>
     	<A href="/ElCocoWeb/hotelreserve/switchLang.do?lang=es">
     		<IMG class=i18n-flag height=12 alt=Spanish src="/ElCocoWeb/img/es.png" width=16></A>
    
    </TD>
    <TD class=header>&nbsp;</TD>
   </TR>
   </TBODY>
</TABLE>
<p>&nbsp;</p>

<TABLE border="0" cellpadding="0" cellspacing="0" class="maintable" align="center" >
	<TBODY>
		
		
		<TR>
			<TD align="center">
				
				<a class="ItemMenuNavCuartoNivel" href="javascript:self.print();"><fmt:message key="label.common.print" /></a>&nbsp; | &nbsp;
				<a class="ItemMenuNavCuartoNivel" href="javascript:self.close();"><fmt:message key="label.common.closewindow" /></a>
			</TD>
		</TR>	
	
		<TR>
			<TD class="ct_price_head"><fmt:message key="label.common.detailinfo" /></TD>
		</TR>	
		<TR>
			<TD class=content>
<c:set var="total" value="0"/>			
<c:forEach items="${reserveForm.selectedRooms}" var="roomCheckedBean">	
			<TABLE border="0" width="750">
				<TBODY>
					<TR>
						<TD colspan="5" class="ct_price_content">
							<c:out value="${roomCheckedBean.roomName}"/><BR>
							<fmt:message key="label.common.guests" />: <c:out value="${roomCheckedBean.guests}"/> <fmt:message key="label.common.nights" />: <c:out value="${roomCheckedBean.numNights}"/>
							<c:if test="${roomCheckedBean.rooms gt 1}">
								Hab.: <c:out value="${roomCheckedBean.rooms}"/>
							</c:if>
						</TD>
					</TR>
					<TR>
						<TD class="block_headline"><fmt:message key="label.common.date" /></TD>
						<TD class="block_headline"><fmt:message key="label.common.planrate" /></TD>
						
						<TD class="block_headline"><fmt:message key="label.common.occupancyrate" /></TD>
						<TD class="block_headline"><fmt:message key="label.common.extraguest" /></TD>
						<TD class="block_headline"><fmt:message key="label.common.daytotal" /></TD>
					</TR>

	<c:forEach items="${roomCheckedBean.detail}" var="detail">
					<TR class="block_content">
						<TD class="content"><fmt:formatDate value="${detail.fecha.time}" pattern="dd/MM/yyyy"/></TD>
						<TD class="content"><c:out value="${detail.planRate.name}"/></TD>

						<TD align="right" class="content" style="text-align: right;">$<fmt:formatNumber value="${detail.planRate.price * roomCheckedBean.rooms}" type="number" maxFractionDigits="2" minFractionDigits="2"/></TD>
						<TD align="right" class="content" style="text-align: right;">
							<c:choose>
								<c:when test="${roomCheckedBean.guests - detail.planRate.maxGuests > 0}">
									$<fmt:formatNumber value="${(roomCheckedBean.guests - detail.planRate.maxGuests) * detail.planRate.additional}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
								</c:when>
								<c:otherwise>
									$0.00
								</c:otherwise>
							</c:choose>
						</TD>
						<TD align="right" class="content" style="text-align: right;">
							<c:choose>
								<c:when test="${roomCheckedBean.guests - detail.planRate.maxGuests > 0}">
									$<fmt:formatNumber value="${(detail.planRate.price * roomCheckedBean.rooms) + (roomCheckedBean.guests - detail.planRate.maxGuests) * detail.planRate.additional}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
								</c:when>
								<c:otherwise>
									$<fmt:formatNumber value="${detail.planRate.price * roomCheckedBean.rooms}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
								</c:otherwise>
							</c:choose>						
						</TD>
					</TR>
	</c:forEach>														
					<TR>
						<TD colspan="3"></TD>
						<TD align="right" class="ct_price_usd"><fmt:message key="label.common.subtotal" />:</TD>
						<TD align="right" class="ct_price_value">
							$<fmt:formatNumber value="${roomCheckedBean.subTotal}" type="number" maxFractionDigits="2" minFractionDigits="2"/>							
						</TD>
					</TR>
						<TR>
							<TD colspan="3"></TD>
							<TD align="right" class="ct_price_usd"><fmt:message key="label.common.tax" />:</TD>
							<TD align="right" class="ct_price_value">$<fmt:formatNumber value="${roomCheckedBean.IVA}" type="number" maxFractionDigits="2" minFractionDigits="2"/></TD>
						</TR>
						<TR>
							<TD colspan="3"></TD>
							<TD align="right" class="ct_price_usd"><fmt:message key="label.common.roomtotal" />:</TD>
							<TD align="right" class="ct_price_value">
								$<fmt:formatNumber value="${roomCheckedBean.total}" type="number" maxFractionDigits="2" minFractionDigits="2"/>
								<c:set var="total" value="${roomCheckedBean.total + total}"/>
							</TD>
						</TR>
					</TBODY>
			</TABLE>
			<br>
</c:forEach>
			</TD>
		</TR>
		
		<TR>
			<TD class="ct_price_head"><fmt:message key="label.common.totalizing" /></TD>
		</TR>


		<TR>
			<TD>
			<TABLE border="0" cellspacing="8">
				<TBODY>
					<TR>
						<TD class="ct_price_head"><fmt:message key="label.common.totaloccupancy" /></TD>
						<TD class="ct_price_value"><strong>$ <fmt:formatNumber value="${total}" type="number"
							maxFractionDigits="2" minFractionDigits="2" /></strong></TD>
						<TD class="ct_price_head"><fmt:message key="label.common.downpayment" /><BR>
						(50%)</TD>
						<TD class="ct_price_value"><strong>$ <fmt:formatNumber value="${total * 0.50}" type="number"
							maxFractionDigits="2" minFractionDigits="2" /></strong></TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		
		
		<TR>
			<TD align="center">
				
				<a class="ItemMenuNavCuartoNivel" href="javascript:self.print();"><fmt:message key="label.common.print" /></a>&nbsp; | &nbsp;
				<a class="ItemMenuNavCuartoNivel" href="javascript:self.close();"><fmt:message key="label.common.closewindow" /></a>
			</TD>
		</TR>
		
	</TBODY>
</TABLE>
					
</BODY>
</html>
