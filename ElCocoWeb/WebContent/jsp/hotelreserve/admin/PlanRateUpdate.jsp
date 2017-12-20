<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle 
	basename="com.nicahost.module.hotelreserve.admin.resource.AdminMessageResource" />

<SCRIPT language=JavaScript src="/ElCocoWeb/js/datepicker.js"></SCRIPT>
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


<h3>Planes de Tarifas de Alquiler</h3>
<jsp:include page="/jsp/framework/errormessages.jsp" flush="true"></jsp:include>
<LINK rel="stylesheet" href="/ElCocoWeb/css/datepickerStyle.css" type="text/css">
<html:form action="/updatePlanRate">
<TABLE border="1">
	<TBODY>
		<TR>
			<TD>Plan No.</TD>
			<TD><html:text property="planNo" readonly="true" size="9"></html:text> </TD>
		</TR>
		<TR>
			<TD>Descripción</TD>
			<TD><html:text property="name" size="56"></html:text> </TD>		
		</TR>
			<TR>
				<TD>Precio</TD>
				<TD>$ <html:text property="price"></html:text> USD</TD>
			</TR>
			<TR>
				<TD>Max. Hu&eacute;spedes</TD>
				<TD>
					<html:select property="maxGuests">
						<html:options collection="guests" property="value" labelProperty="label"/>
					</html:select>
				</TD>
			</TR>
			<TR>
				<TD>Hu&eacute;spede adiccional</TD>
				<TD>$ <html:text property="additional" value="20"></html:text> USD </TD>
			</TR>
			<TR>
				<TD>M&iacute;nimo de noches</TD>
				<TD>
					<html:select property="minNights">
						<html:options collection="nights" property="value" labelProperty="label"/>
					</html:select>
				</TD>
			</TR>
			<TR>
				<TD>Fecha Inicio</TD>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0>
                	<TBODY>
                    <TR>
						<td style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid" 
			                onclick="displayDatePicker('iniDate', false, 'dd/MM/yyyy', '/');" 
			                vAlign=top            			    
			                height=22>
			                	<html:text property="iniDate" readonly="readonly" 
				            			    style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" 
				            			    size="14"				            			    
				            			    />
				            	<SPAN>&nbsp;</SPAN>
				            	<IMG style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; MARGIN-BOTTOM: 1px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" height=19 alt="" src="/ElCocoWeb/img/common/comboButton.gif" width=18 border=0 name=select2>
				       </td>
					</TR>
					</TBODY>
				</TABLE>			
				</TD>
			</TR>
			<TR>
				<TD>Fecha Final</TD>
				<TD>
					<TABLE cellSpacing=0 cellPadding=0>
                	<TBODY>
                    <TR>
						<td style="BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid" 
			                onclick="displayDatePicker('endDate', false, 'dd/MM/yyyy', '/');" 
			                vAlign=top            			    
			                height=22>
			                	<html:text property="endDate" readonly="readonly" 
				            			    style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" 
				            			    size="14"				            			    
				            			    />
				            	<SPAN>&nbsp;</SPAN>
				            	<IMG style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; MARGIN-BOTTOM: 1px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px" height=19 alt="" src="/ElCocoWeb/img/common/comboButton.gif" width=18 border=0 name=select2>
				       </td>
					</TR>
					</TBODY>
				</TABLE>					
				</TD>
			</TR>
			<TR>
				<TD>Activo</TD>
				<TD>
					<html:checkbox property="active" value="1">S&iacute;</html:checkbox>
				</TD>
			</TR>
			<TR>
			<TD colspan="2">
				<html:submit value="Actualizar" />
				<input type="button" value="Cancelar">
			</TD>
		</TR>
	</TBODY>
</TABLE>
</html:form>

<iframe id="info"
		frameborder="0" 
		src="showPlanRateDetail.do";
		name="info" 
		align="middle" 
		scrolling="auto" 
		width="100%"
		height="800"
		marginwidth="0"
		marginheight="0">
</iframe>