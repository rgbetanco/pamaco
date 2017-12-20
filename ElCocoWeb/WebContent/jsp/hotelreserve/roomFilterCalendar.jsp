
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>



<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle 
	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<LINK rel="stylesheet" href="/ElCocoWeb/css/datepickerStyle.css" type="text/css">

<SCRIPT language=JavaScript src="/ElCocoWeb/js/datepicker.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/utils.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/hotelreserve.js"></SCRIPT>


<SCRIPT language=Javascript1.1 type=text/javascript>
<!--
	var submitCount = 0;
	var redirectLabel = replaceCharacterEntities('<fmt:message key="msg.redirect" />');

dayShort1 = replaceCharacterEntities('<fmt:message key="label.dayShort1" />');
dayShort2 = replaceCharacterEntities('<fmt:message key="label.dayShort2" />');
dayShort3 = replaceCharacterEntities('<fmt:message key="label.dayShort3" />');
dayShort4 = replaceCharacterEntities('<fmt:message key="label.dayShort4" />');
dayShort5 = replaceCharacterEntities('<fmt:message key="label.dayShort5" />');
dayShort6 = replaceCharacterEntities('<fmt:message key="label.dayShort6" />');
dayShort7 = replaceCharacterEntities('<fmt:message key="label.dayShort7" />');

monthLong1 = replaceCharacterEntities('<fmt:message key="label.monthLong1" />');
monthLong2 = replaceCharacterEntities('<fmt:message key="label.monthLong2" />');
monthLong3 = replaceCharacterEntities('<fmt:message key="label.monthLong3" />');
monthLong4 = replaceCharacterEntities('<fmt:message key="label.monthLong4" />');
monthLong5 = replaceCharacterEntities('<fmt:message key="label.monthLong5" />');
monthLong6 = replaceCharacterEntities('<fmt:message key="label.monthLong6" />');
monthLong7 = replaceCharacterEntities('<fmt:message key="label.monthLong7" />');
monthLong8 = replaceCharacterEntities('<fmt:message key="label.monthLong8" />');
monthLong9 = replaceCharacterEntities('<fmt:message key="label.monthLong9" />');
monthLong10 = replaceCharacterEntities('<fmt:message key="label.monthLong10" />');
monthLong11 = replaceCharacterEntities('<fmt:message key="label.monthLong11" />');
monthLong12 = replaceCharacterEntities('<fmt:message key="label.monthLong12" />');

thisDayStr = replaceCharacterEntities('<fmt:message key="label.thisday" />');
closeStr = replaceCharacterEntities('<fmt:message key="label.close" />');

dayArrayShort = new Array(dayShort1, dayShort2, dayShort3, dayShort4, dayShort5, dayShort6, dayShort7);
monthArrayLong = new Array(monthLong1, monthLong2, monthLong3, monthLong4, monthLong5, monthLong6, monthLong7, monthLong8, monthLong9, monthLong10, monthLong11, monthLong12);


//MENSAJES INTERNACIONALIZADOS DE VALIDACION
twoYearWarningStr = replaceCharacterEntities('<fmt:message key="msg.twoyearwarning" />');
emptyInitialDateAlert = replaceCharacterEntities('<fmt:message key="msg.emptyinitialdate" />');
emptyFinalDateAlert = replaceCharacterEntities('<fmt:message key="msg.emptyendingdate" />');
compareDateAlert = replaceCharacterEntities('<fmt:message key="msg.comparedate" />');
invalidDateAlert = replaceCharacterEntities('<fmt:message key="msg.invaliddate" />');
	
//-->

function validate() {
	
	/*if (checkAccountStateDate(step01Form.initDate,step01Form.endDate,step01Form.serverDate,'dd/MM/yyyy') && singleSubmit(step01Form)) {
		step01Form.submit();
	}*/
	if (checkAccountStateDate(reserveForm1.initDate,reserveForm1.endDate,reserveForm1.initDate,'dd/MM/yyyy') && singleSubmit(reserveForm1)) {
		reserveForm1.submit();
	}	

}

function calculateDays() {
	objRef = document.step01Form;
	objRef.txtTotal.value = diffDay(objRef.initDate.value,objRef.endDate.value,'dd/MM/yyyy');

}

</SCRIPT>

<c:choose>
	<c:when test="${param.submitted}">
		<c:set var="totalNights" value="${txtTotal+1}" />
	</c:when>
	<c:otherwise>
		<c:set var="totalNights" value="16" />
	</c:otherwise>
</c:choose>
<table>
	<tr><th><fmt:message key="label.common.checkavailability"/></th></tr>
</table>

		<html:form action="getQuote.do">
		<c:set var="CBreak" value="1" />
		<table border="0">
			<TBODY>				
		<tr>
			<td></td>
			<c:forEach items="${DateRange}" var="Range">
				<td align="center" width="40"><fmt:formatDate value="${Range.daterange.time}" pattern="EE dd" /></td>
			</c:forEach>
		</tr>
			
		<c:forEach items="${ReservationCal}" var="rescal" varStatus="stat">
			
				<c:if test="${stat.count mod totalNights eq 1}">
					<tr>
						<td nowrap><c:out value="${rescal.roomdescription}" /></td>
				</c:if>
						<c:choose>
							<c:when test="${rescal.updateDB}"> 
								<td bgcolor="#00CCCC" align="center"><input type="checkbox" name="dayroom" value="<c:out value='${rescal.roomid},${rescal.checkindate}' />" /></td>
								<c:set var="CBreak" value="${CBreak + 1}" />
							</c:when>
							<c:otherwise>
								<td bgcolor="#FFFF66" align="center"><input type="checkbox" name="<c:out value='${rescal.roomid},${rescal.checkindate}' />" checked disabled/></td>
								<c:set var="CBreak" value="${CBreak + 1}" />
							</c:otherwise>
						</c:choose>
				<c:if test="${stat.count mod totalNights eq 0}">						
					</tr>
				</c:if>
			
		</c:forEach>
		
		</TBODY>
		</table>
		<input type="submit" value="Reservar">
		</html:form>


<form name="reserveForm1" action="showCalendar.do">
<input type="hidden" name="submitted" value="true">

<TABLE border="0" align="center" cellpadding="5" cellspacing="0" id="sessionTable" width="500">
	<TBODY>
				<tr>
					<td class="daterror" colspan="4" >
						<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>	      
					</td>				
				</tr>		

		<TR>
			<TD width="67">&nbsp;</TD>
			<TD class="tableTitle" nowrap width="146">
			<fmt:message key="label.step01.datein" />:</TD>
			
			<TD class="tableTitle">
				<TABLE cellSpacing=0 cellPadding=0>
                	<TBODY>
                    <TR>
						<td style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid" 
			                onclick="displayDatePicker('initDate', false, 'dd/MM/yyyy', '/');" 
			                vAlign=top            			    
			                height=22>
			                	<input type="text"  name="initDate" 			                			
			                			readonly="readonly"
				            			style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" 
				            			size="14"/>
				            	<SPAN>&nbsp;</SPAN>
				            	<IMG style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; MARGIN-BOTTOM: 1px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" height=19 alt="" src="/ElCocoWeb/img/common/comboButton.gif" width=18 border=0 name=select2>
				       </td>
					</TR>
					</TBODY>
				</TABLE>			
			
			</TD>
			<TD>&nbsp;</TD>
		</TR>

		<TR>
			<TD width="67">&nbsp;</TD>
			<TD class="tableTitle" nowrap width="146">
			<fmt:message key="label.step01.dateout" />:</TD>
			
			<TD class="tableTitle">
				<TABLE cellSpacing=0 cellPadding=0>
                	<TBODY>
                    <TR>
						<td style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid"             			    
			                onclick="displayDatePicker('endDate', false, 'dd/MM/yyyy', '/');" 
            			    vAlign=top 
			                height=22>			                	
			                	<input type="text" name="endDate"									   
			                				readonly="readonly"	
				            			    style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" 
				            			    size="14"/>
				            	<SPAN>&nbsp;</SPAN>
				            	<IMG style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; MARGIN-BOTTOM: 1px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" height=19 alt="" src="/ElCocoWeb/img/common/comboButton.gif" width=18 border=0 name=select1>
				        </td>
					</TR>
					</TBODY>
				</TABLE>

			
			</TD>
			<TD>&nbsp;</TD>
		</TR>
<!--
		<TR>
			<TD width="67">&nbsp;</TD>
			<TD class="tableTitle" nowrap width="146">
			<fmt:message key="label.step01.totalnights" />:</TD>
			
			<TD class="tableTitle">
				<INPUT type="text" name="txtTotal" readOnly size="11" 
					  style="font-family: Verdana; font-size: 14px; border: 0 solid #000080"
					<c:choose>
						<c:when test="${empty param.txtTotal}" >					
							value= <c:out value="${defaultNights}" />
						</c:when>
						<c:otherwise>
							value = <c:out value="${param.txtTotal}" />
						</c:otherwise>
					</c:choose>
				>			
			
			</TD>
			<TD>&nbsp;</TD>
		</TR>
-->

	
		<TR align="center">
			<TD class="tableTitle" colspan="4">
				<!--html:hidden property="serverDate" /-->

				</TD>
		</TR>
		
		
		<TR>
			<TD colspan="4" align="center">

				<INPUT type="button" value="<fmt:message key='button.label.availability'/>" onclick="validate();">
		
			</TD>
		</TR>
		
	</TBODY>
</TABLE>
</form>
<!--/DIV-->
