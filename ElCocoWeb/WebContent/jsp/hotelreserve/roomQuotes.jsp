<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/popup.js"></SCRIPT>
<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />
<BR>

<c:set var="grandtotal" value="0"/>
<c:forEach items="${reserveForm.selectedRooms}" var="roomCheckedBean">
<html:form action="updatequote.do" >
	<TABLE border="1" cellpadding="5" cellspacing="3">
		<TBODY>
			<TR>
				<TD colspan="3" class="ct_price_head"><c:out value="${roomCheckedBean.roomName}"/>
				</TD>
			</TR>
			<TR>
				<TD valign="top" class="ct_price_content">
					<table border="0">
						<tr>
							<td class="ct_price_content"></td>
							<td class="ct_price_content"></td>
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
					</table>
				</TD>
				<TD valign="top" class="ct_price_content">
					<table border="0">
						<c:if test="${not empty maxRooms[1]}">
						<tr>
							<td>
							Cuartos: 
							</td>
							<td colspan="2">
							<select name="r">
								<c:forEach items="${maxRooms}" var="val">
									<option value="<c:out value='${val}'/>"
										<c:if test="${roomCheckedBean.rooms eq val}">
											selected="selected"
										</c:if>
									>
										<c:out value='${val}'/>
									</option>
									<c:set value="${val}" var="max" />
								</c:forEach>
							</select>
								<input type="hidden" name="max" value="<c:out value='${max}'/>">										
							</td>
						</tr>
						</c:if>				
						<tr><td>
					<fmt:message key="label.common.guests" />: 					
						</td>
						<td>
						<SELECT name="g">
							<option value="1"
								<c:if test="${roomCheckedBean.guests eq 1}">
									selected="selected"
								</c:if>
							>1</option>
							<option value="2"
								<c:if test="${roomCheckedBean.guests eq 2}">
									selected="selected"
								</c:if>							
							>2</option>
							<option value="3"
								<c:if test="${roomCheckedBean.guests eq 3}">
									selected="selected"
								</c:if>
							>3</option>
							<option value="4"
								<c:if test="${roomCheckedBean.guests eq 4}">
									selected="selected"
								</c:if>
							>4</option>
							<option value="5"
								<c:if test="${roomCheckedBean.guests eq 5}">
									selected="selected"
								</c:if>
							>5</option>
							<option value="6"
								<c:if test="${roomCheckedBean.guests eq 6}">
									selected="selected"
								</c:if>
							>6</option>
							<option value="7"
								<c:if test="${roomCheckedBean.guests eq 7}">
									selected="selected"
								</c:if>
							>7</option>
							<option value="8"
								<c:if test="${roomCheckedBean.guests eq 8}">
									selected="selected"
								</c:if>
							>8</option>
							<option value="9"
								<c:if test="${roomCheckedBean.guests eq 9}">
									selected="selected"
								</c:if>
							>9</option>
							<option value="10"
								<c:if test="${roomCheckedBean.guests eq 10}">
									selected="selected"
								</c:if>
							>10</option>
						</select>
						</td>
						<td>
					<input type="hidden" name="roomId" value="<c:out value='${roomCheckedBean.roomId}' />"/>
					
					<input type="submit" value="<fmt:message key="button.label.update" />">
						</td>
					</tr>
				</table>
				</TD>
				
				<TD valign="top" class="ct_price_usd">
					<table border="0">
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
</html:form>
</c:forEach>

<TABLE border="0" cellspacing="7">
	<TBODY>
		<TR>
			<TD class="ct_price_head"><fmt:message key="label.common.totaloccupancy" /></TD>
			<TD class="ct_price_value"><strong>$<fmt:formatNumber value="${grandtotal}" type="number"
				maxFractionDigits="2" minFractionDigits="2" /></strong></TD>
			<TD class="ct_price_head"><fmt:message key="label.common.downpayment" /><BR>
			(50%)</TD>
			<TD class="ct_price_value"><strong>$<fmt:formatNumber value="${grandtotal * 0.50}" type="number"
				maxFractionDigits="2" minFractionDigits="2" /></strong></TD>
		</TR>
	</TBODY>
</TABLE>
	<center>

		<a onclick="vtn('/jsp/hotelreserve/roomReserveInvoice.jsp','750','520')" style="cursor: pointer; color: blue; font-variant: small-caps;"><u><fmt:message key="label.common.viewdetail" /></u></a>
	</center>

<P><fmt:message key="text.common.message1" /></P>
<html:form action="reserveinfo.do">
	<input type="submit" value="<fmt:message key="button.label.makereservation" />">
</html:form>
