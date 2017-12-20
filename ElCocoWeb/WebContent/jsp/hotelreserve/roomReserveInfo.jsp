
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!--LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css"-->
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />

<p>

<html:form action="paymentinfo.do" focus="firstName">

<TABLE border="0">
	<TBODY>
		<TR>
				<TD colspan="4" class="daterror"><INPUT type="hidden"
					name="initDate"
					value="<fmt:formatDate value="${reserveForm.initDateCal.time}" pattern="dd/MM/yyyy" />">
				<INPUT type="hidden" name="endDate"
					value="<fmt:formatDate value="${reserveForm.endDateCal.time}" pattern="dd/MM/yyyy" />">
				</TD>
			</TR>	
	
		<TR>
				<TH align="left" nowrap colspan="4"><img
					src="/ElCocoWeb/img/common/sir.gif" valign="middle">&nbsp; <fmt:message key="label.common.personalInfo" /> &nbsp; &nbsp;
				</TH>
			</TR>

		<TR>
				<TD colspan="4" align="center" class="content"><FONT color="red">*</FONT> <fmt:message
					key="label.common.required" /></TD>
			</TR>
		
		<TR>
				<TD class="daterror" colspan="4"><FONT color="red">
				<ul>
					<logic:messagesPresent>
						<html:messages id="error">
							<li><c:out value="${error}" /></li>
						</html:messages>
					</logic:messagesPresent>
				</ul>
				</FONT></TD>
			</TR>
		
		<TR valign="top"> 
			<TD align="left" class="content"><fmt:message key="label.common.firstname" />:<FONT
				color="red">*</FONT></TD>
			<TD class="content"><html:text property="firstName" size="20" maxlength="64" tabindex="1"/></TD>
			<TD rowspan="2" class="content"><fmt:message key="label.common.address" />:<FONT
					color="red"></FONT></TD>
				<TD rowspan="2" valign="top" class="content"><html:textarea property="address" cols="28" rows="2" tabindex="6"/></TD>
			</TR>

			<TR>
				<TD align="left" class="content"><fmt:message
					key="label.common.lastname" />:<FONT color="red">*</FONT></TD>
				<TD class="content"><html:text property="lastName" size="20" maxlength="64" tabindex="2"/></TD></TR>
			<TR>
				<TD align="left" class="content"><fmt:message
					key="label.common.email" />:<FONT color="red">*</FONT></TD>
				<TD class="content"><html:text property="email1" size="20" maxlength="150" tabindex="3"/></TD>
				<TD class="content"><fmt:message key="label.common.city" />:<FONT
					color="red"></FONT></TD>
				<TD class="content"><html:text property="city" size="20" maxlength="64" tabindex="7"/></TD>
			</TR>
			<TR>
				<TD align="left" class="content"><fmt:message
					key="label.common.emailconfirm" />:<FONT color="red">*</FONT></TD>
				<TD class="content"><html:text property="email2" size="20" maxlength="150" tabindex="4"/></TD>
				<TD class="content"><fmt:message key="label.common.zip" />:
					<FONT color="red"></FONT>
				</TD>
				<TD class="content"><html:text property="zip" size="20" maxlength="10" tabindex="9"/></TD>
			</TR>
			<TR>
				<TD align="left" class="content"><fmt:message
					key="label.common.phone" />:<FONT color="red"></FONT></TD>
				<TD class="content"><html:text property="phone" size="20" maxlength="25" tabindex="5"/></TD>
				<TD class="content"><fmt:message key="label.common.country" />:<FONT color="red">*</FONT>
				</TD>
				<TD class="content"><SELECT name="country" tabindex="10">
					<OPTION value=""> -- <fmt:message
						key="label.common.countryselect" /> -- </OPTION>
					<c:forEach items="${countries}" var="countryLocal">
						<OPTION value="<c:out value='${countryLocal.value}' />">
							<c:out value="${countryLocal.label}"/>
						</OPTION>
					</c:forEach>
				</SELECT></TD>
			</TR>

			<TR>
				<TD></TD>
				<TD colspan="2" align="left"></TD>
				<TD></TD>
				
			</TR>

			<TR>
				<TD colspan="4" align="center">
				<TABLE style="border-width: 0.0pt">
					<TBODY>
					<TR>
						<TD class="content"><fmt:message key="text.common.message2" /></TD>
					</TR>
					<TR>
						<TD class="content">
							<html:textarea property="comment" cols="60" rows="5" tabindex="11"></html:textarea>
						</TD>
					</TR>
					</TBODY>
				</TABLE>
				</td>
			</TR>
		<TR>
			<TD colspan="4" align="center">
				<input type="submit" value="<fmt:message key="button.label.continue" />">
		
			</TD>
		</TR>

	</TBODY>
</TABLE>


</html:form>

