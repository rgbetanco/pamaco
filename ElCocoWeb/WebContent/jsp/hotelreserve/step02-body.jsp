<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle 	basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />


<LINK rel="stylesheet" href="/ElCocoWeb/css/ebacStyle.css" type="text/css">

<SCRIPT language="JavaScript" src="/ElCocoWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/utils.js"></SCRIPT>

<SCRIPT language=Javascript1.1 type=text/javascript>
<!--

var submitCount = 0;

var redirectLabel = replaceCharacterEntities('<fmt:message key="msg.redirect" />');


function fCheckBox(valor,index,count) {	
	
	document.forms["reserveForm"].elements["selectedIdRooms"].value = valor;
	
	var ele = document.reserveForm.selectedIdRooms.length
	
	if (ele > 1) {
		document.reserveForm.selectedIdRooms[index].click();
	} else if (count = 1) {
		document.reserveForm.selectedIdRooms.click();
	}
	
	return true;
}


//-->
</SCRIPT>



<TABLE width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
	<TBODY>
		<!-- /RUTA NAVEGACION -->
		<TR>
			<TD class="tableTitle">
				<fmt:message key="label.common.availability"/>
			</TD>
		</TR>
	</TBODY>
</TABLE>	
<br/>
	
<CENTER><TABLE border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>
		<TR>
			<TH colspan="2"><fmt:message key="label.hotelreserve.reservation"/></TH>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.initdate"/>:</TD>
			<TD>
				<fmt:formatDate value="${initDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.enddate"/>:</TD>
			<TD>
				<fmt:formatDate value="${endDateCal.time}" dateStyle="full"/>
			</TD>
		</TR>
		<TR>
			<TD class="bold"><fmt:message key="label.common.totalnights"/>:</TD>
			<TD>
				<c:out value="${numNights}"/>
			</TD>
		</TR>
		
		<TR>
			<TD class="bold"><fmt:message key="label.common.roomtype"/>:</TD>
			<TD>
				<fmt:message key="${roomTypeName}" />
			</TD>
		</TR>
		
				
	</TBODY>
</TABLE></CENTER>

<P>
<TABLE width="80%" border="0" cellpadding="0" cellspacing="0" align="center"  id="sessionTable" style="border-width: 0px">
	<TBODY>
		<TR>
			<TD><fmt:message key="msg.common.availability"/>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</P>			



<CENTER>

<html:form action="step02.do" >
			<INPUT type="hidden" name="initDate" value="<fmt:formatDate value="${initDateCal.time}" pattern="dd/MM/yyyy"/>" >
			<INPUT type="hidden" name="endDate" value="<fmt:formatDate value="${endDateCal.time}" pattern="dd/MM/yyyy"/>" >
			<INPUT type="hidden" name="roomTypeId" value="<c:out value='${roomTypeId}' />" >		
			<INPUT type="hidden" name="adult" value="<c:out value='${adult}' />" >		
			<INPUT type="hidden" name="child" value="<c:out value='${child}' />" >		
			
<TABLE width="80%" border="0" cellpadding="0" cellspacing="0" id="sessionTable" style="border-width: 0px">
	<TBODY>
	<TR>
		<TD class="daterror">
		      		<logic:messagesPresent>
		      			<html:messages id="error">
	    	  				<li><c:out value="${error}"/></li>
	      				</html:messages>
	      			</logic:messagesPresent>
	      </TD>
	 </TR>
</TABLE>


			
<c:forEach items="${roomAvailability}" var="roomBean" varStatus="position">

<TABLE width="80%" border="0" cellpadding="0" cellspacing="0" id="sessionTable">
	<TBODY>

	<TR>
		<TH align="left">
			<img src="/ElCocoWeb/img/common/sir.gif" valign="middle">&nbsp;
			<c:out value="${roomBean.id}"/>
		</TH>
		<TH align="right">
			<fmt:message key="label.common.currency"/> 
			<fmt:formatNumber value="${roomBean.price}" type="number" maxFractionDigits="2" minFractionDigits="2"/>&nbsp;
		</TH>
		
	</TR>	
	<TR>
		<TD colspan="2">
			<c:forEach items="${roomBean.features}" var="feature" varStatus="item">
				<img src="<fmt:message key='${feature}.img' />" alt="<fmt:message key="${feature}"/>">
			</c:forEach><br/>
			<c:set var="desc" value="${roomBean.description}" />
			<fmt:message key="${desc}" />
						
				<ul>
					<c:forEach items="${roomBean.features}" var="feature" varStatus="item">
						<li><fmt:message key="${feature}"/></li>
					</c:forEach>				
				</ul>			
		</TD>
	</TR>
	<TR>
		<TD class="footer">
			<a href="/ElCocoWeb/hotelreserve/showGallery.do?idParm=<c:out value='${roomBean.id}'/>" target="_blank"><fmt:message key="label.common.photogallery"/></a>
		</TD>
	
		<TD class="footer" align="right">
			<c:set var="imgname" value="reserve${position.index}"/> 
			<INPUT type="image" class="HandPointer" 
					src="<fmt:message key="common.resource.image.reserve"/>" 
					name="<c:out value='${imgname}' />" 
					onmouseover="MM_swapImage('<c:out value='${imgname}' />','','<fmt:message key="common.resource.image.reserveON"/>',1);"
					onmouseout="MM_swapImgRestore();"					
					onclick="singleSubmit(this.form) & fCheckBox(<c:out value='${roomBean.id}'/>, <c:out value='${position.index}' />, <c:out value='${position.count}'/> );">
		</TD>
	</TR>
	
	<TR>
		<TD colspan="2" align="right">
			<fmt:message key="label.common.select"/> &gt; &gt;
			<!--INPUT type="checkbox" name="selectedIdRooms" value="<c:out value='${roomBean.id}'/>" >-->
			<html:multibox property="selectedIdRooms" ><c:out value='${roomBean.id}'/></html:multibox>
		</TD>
	</TR>
	
	</TBODY>
</TABLE>
<br/>
</c:forEach>


</CENTER>



<P align="center">
				<INPUT type="image" class="HandPointer" 
					src="<fmt:message key="common.resource.image.accept"/>" 
					name="aceptar"
					width="70" height="20" 
					onmouseover="MM_swapImage('aceptar','','<fmt:message key="common.resource.image.acceptOn"/>',1);"
					onmouseout="MM_swapImgRestore();"					
					onclick="singleSubmit(this.form);">
</P>

</html:form>