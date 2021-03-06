
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<!--LINK rel="stylesheet" href="/NicahostWeb/css/ebacStyle.css" type="text/css"-->
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/imgloader.js"></SCRIPT>
<SCRIPT language="JavaScript" src="/ElCocoWeb/js/utils.js"></SCRIPT>


<fmt:setBundle basename="com.nicahost.module.hotelreserve.resource.HotelReserveMessageResource" />
<html:base/>
<html:form action="review.do">
	<TABLE border="0" width="400" align="center">
		<TBODY>
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

			<TR>
				<TH align="left" nowrap="nowrap" colspan="4"><img
					src="/ElCocoWeb/img/common/sir.gif" valign="middle">&nbsp; <fmt:message
					key="label.common.crditcardinfo" /></TH>

			</TR>

			<TR>
				<TD class="content"><fmt:message key="label.common.cardnumber" />:</TD>
				<TD colspan="3"><html:text property="cardNumber" size="32"
					maxlength="25" /></TD>

			</TR>
			<TR>
				<TD class="content"><fmt:message key="label.common.cardholder" />:</TD>
				<TD><html:text property="cardHolder" size="32" maxlength="96" /></TD>
				<TD colspan="2" rowspan="2"></TD>
			</TR>

			<TR>
				<TD class="content"><fmt:message key="label.common.expirationdate" />:</TD>
				<TD colspan="3"><html:select property="cardMonth">
					<OPTION value="">--</OPTION>
					<html:options collection="cardMonths" property="value"
						labelProperty="label" />
				</html:select> / <html:select property="cardYear">
					<OPTION value="">--</OPTION>
					<html:options collection="cardYears" property="value"
						labelProperty="label" />
				</html:select></TD>
			</TR>

			<TR>
				<TD colspan="4">&nbsp;</TD>
			</TR>

			<TR>
				<TD colspan="4" class="content"><html:checkbox
					property="policyCancelation">
					<fmt:message key="text.common.cancelationpolicy" />
				</html:checkbox></TD>
			</TR>
			<TR>
				<TD colspan="4" align="center"><input type="submit"
					value="<fmt:message key="button.label.continue" />"></TD>
			</TR>
		</TBODY>
	</TABLE>


	<br />



</html:form>



