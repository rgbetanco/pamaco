
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>



<!-- Aqui indico, el lugar donde están los archivos de propiedades para la internacionalización.  -->
<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />



<!--LINK rel="stylesheet" href="/ElCocoWeb/css/ebacStyle.css" type="text/css"-->

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
	
	if (checkAccountStateDate(reserveForm.initDate,reserveForm.endDate,reserveForm.initDate,'dd/MM/yyyy') && singleSubmit(reserveForm)) {
		reserveForm.submit();
	}

}


</SCRIPT>



<script type="text/javascript">


var tempgrid = new Array();
var grid = new Array();


<c:forEach items="${roomView}" var="dayView">
	registerDate(<c:out value="${dayView.index}"/>,'<fmt:formatDate value="${dayView.value.time}" pattern="dd/MM/yyyy"/>',<c:out value="${dayView.enable}"/>);
</c:forEach>

function registerDate(index, value, enable) {
	grid[index] = new myobject(index,value,enable);
}

function myobject(param,fecha,valid) {
	this.id = param;
	this.sel = false;
	this.value = fecha;
	this.enable = valid;
}

function hasUpperBound(id) {
var val = false;
var obj;
var indexA = id;
var indexB = -1;
	
	for (var i=1;i<tempgrid.length;i++) {
		obj=tempgrid[i];
		if (obj != null) {
			indexB = obj.id;break;
		}
	}	
	
	for (var j=indexA;j<=indexB;j++) {
		if (!grid[j].enable) {
			val = true;
			break;
		}
	}
	
	return val;
}


function hasLowerBound(id) {
var val = false;
var obj;
var indexA = 100;
var indexB = id;
	
	for (var i=1;i<tempgrid.length;i++) {
		obj=tempgrid[i];
		if (obj != null) {
			indexA = obj.id;break;
		}
	}	
	
	for (var j=indexA;j<=indexB;j++) {
		if (!grid[j].enable) {
			val = true;
			break;
		}
	}
	
	return val;
}

function barrer() {	
	var ini = document.getElementsByName("initDate");
	var end = document.getElementsByName("endDate");
	
	var inibool = true;
	var indexA;
	var indexB=-1;
	
	for (var i=1;i<grid.length;i++) {
		var x=grid[i];
		//p(x.id);
		if (x.sel) {			
			if (inibool) {
				indexA = x.id;
				inibool = false;
			} else if(!inibool) {
				indexB = x.id;
			}
		}
	}
	

	indexB = (indexB == -1 ? indexA : indexB);

	ini[0].value = grid[indexA].value;
	end[0].value = grid[indexB].value;

	for (var j=indexA;j<=indexB;j++) {
		var obj = grid[j];

			obj.sel = true;		
			var ele = document.getElementById(j);			
			ele.style.background = "url('/ElCocoWeb/img/ok3232.jpg') no-repeat";			
	}
}

function fill(id) {
	var obj = grid[id];	
	var ele = document.getElementById(id);	
	if (obj.enable) {
		if(!hasUpperBound(id) && !hasLowerBound(id)) {
			if(!obj.sel) {
				obj.sel=true;
				tempgrid[id] = obj;
			} else {
				obj.sel=false;
				tempgrid[id] = null;
				ele.style.background = "white";
			}
			barrer();
		} else {
			alert('Cannot select this element... must be continous');
		}
	} else {
		alert('cannot select this element.. it is already taken');
	}
}


function p(id) {
	var x = grid[id];
	alert('id='+x.id+'\nsel='+x.sel+'\nvalue='+x.value+'\nenable='+x.enable);
}


</script>

<style type="text/css">
<!--
 .header1 {
 	color: white;
 	font-size: 12 pt;
 	font-weight: bold;
 	text-align: center;
 	background-color: navy;
 	
 }
 .active { 	
 	color: black;
 	font-family: sans-serif, arial;
	font-size: 11 pt;
	text-align: center;
 	font-weight: 550;
	cursor: pointer;
	height: 32 px;
	width: 42 px;	
	
 }

 .inactive {
	color: black;
	background-image: url("/ElCocoWeb/img/cancel.jpg");
	background-repeat: no-repeat;
	height: 32 px;
	width: 42 px;
	font-weight: 600;
 }
-->

</style>



<TABLE border="0" align="center" cellpadding="5" cellspacing="0" width="600">
	<TBODY>
		<TR>
			<TH colspan="4"><fmt:message key="label.common.checkavailability"/></TH>
		</TR>

		<TR>
			<TD colspan="4"><h2><c:out value="${reserveForm.roomTypeName}" /> <c:out value="${reserveForm.roomName}" /></h2></TD>
		</TR>		

		<TR>
			<TD colspan="4"><jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include></TD>
		</TR>		
	</TBODY>
</TABLE>

<TABLE cellspacing="3" border="1" align="center">
	<tr>
		<th class="header1"><fmt:message key="label.dayShort1" /></th>
		<th class="header1"><fmt:message key="label.dayShort2" /></th>
		<th class="header1"><fmt:message key="label.dayShort3" /></th>
		<th class="header1"><fmt:message key="label.dayShort4" /></th>
		<th class="header1"><fmt:message key="label.dayShort5" /></th>
		<th class="header1"><fmt:message key="label.dayShort6" /></th>
		<th class="header1"><fmt:message key="label.dayShort7" /></th>
	</tr>

<c:forEach items="${roomView}" var="view" varStatus="stat">
	<c:if test="${stat.count mod 7 eq 1}">
		<tr>
	</c:if>
		<td nowrap="nowrap"
			<c:choose>
				<c:when test="${view.enable}">class="active"</c:when>				
				<c:otherwise>class="inactive"</c:otherwise>
			</c:choose>
			id="<c:out value='${view.index}'/>"
			width="28" height="32" 			
		>
			<div onmouseup="fill(<c:out value='${view.index}'/>);"><fmt:formatDate value="${view.value.time}" pattern="MMM dd"/></div>
		</td>	
	<c:if test="${stat.count mod 7 eq 0}">
		</tr>
	</c:if>
</c:forEach>
	<TR>
		<TD colspan="7">

<table width="100%">
	<tr>
		<td colspan="3">
			<c:if test="${not empty prev}">		
				<html:link page="/showfilter.do" name="plnk">&lt;&lt;</html:link>
			</c:if>
		</td>
		<td colspan="4" align="right">
			<html:link page="/showfilter.do" name="nlnk">&gt;&gt;</html:link>
		</td>
	</tr>
</table>
		
		
		</TD>
	</TR>
</table>



<LINK rel="stylesheet" href="/ElCocoWeb/css/datepickerStyle.css" type="text/css">
<html:form action="showquote.do" onsubmit="return validate();">
<TABLE border="0" align="center" cellpadding="5" cellspacing="0">
	<TBODY>
		<TR>			
			<TD nowrap >
			<fmt:message key="label.common.initdate" />:</TD>
			
			<TD>
			<fmt:message key="label.common.enddate" />:			
			
			</TD>			
		</TR>

		<TR>
			<TD nowrap>
					<TABLE cellSpacing=0 cellPadding=0>
                	<TBODY>
                    <TR>
						<td style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid" 
			                onclick="displayDatePicker('initDate', false, 'dd/MM/yyyy', '/');" 
			                vAlign=top            			    
			                height=22>
			                	<html:text property="initDate" 			                			
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
			
			<TD>
				<TABLE cellSpacing=0 cellPadding=0>
                	<TBODY>
                    <TR>
						<td style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid"             			    
			                onclick="displayDatePicker('endDate', false, 'dd/MM/yyyy', '/');" 
            			    vAlign=top 
			                height=22>			                	
			                	<html:text property="endDate"									   
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
		</TR>

		<TR>
			<TD nowrap width="146"></TD>
			
			<TD>
	
			
			</TD>
		</TR>

		
		<TR>
			<TD colspan="2" align="center">				
				<html:hidden property="roomId"/>
				<html:hidden property="roomTypeId"/>
				<html:hidden property="roomName"/>
				<html:hidden property="roomTypeName"/>
				<input type="submit" value="<fmt:message key="button.label.availability" />">
		
			</TD>
		</TR>
		
	</TBODY>
</TABLE>
</html:form>

<P>


