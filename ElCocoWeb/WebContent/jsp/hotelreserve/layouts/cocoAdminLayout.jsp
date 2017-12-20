
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html>
<HEAD>
<TITLE>Reservas en linea - Parque Marítimo el Coco</TITLE>

<META http-equiv=Content-Style-Type content=text/css>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css media=all>@import url( /ElCocoWeb/misc/drupal.css );
</STYLE>

<SCRIPT 
src="/ElCocoWeb/modules/playaelcoco_menus/playaelcoco_menus.js" 
type=text/javascript></SCRIPT>

<STYLE type=text/css media=all>@import url( /ElCocoWeb/modules/playaelcoco_menus/playaelcoco_menus.css );
</STYLE>

<STYLE type=text/css media=all>@import url( /ElCocoWeb/themes/playaelcoco2/style.css );
</STYLE>

</HEAD>

<BODY>

<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
  	<TD class=header>&nbsp;</TD>
    <TD class=header_center></TD>
    <TD class=header>&nbsp;</TD>
   </TR>
   </TBODY>
</TABLE>

<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="maintable">
	<TBODY>
		<TR>
		    <TD class=main_vertical_border>&nbsp;</TD>
			<TD><tiles:insert attribute="header.layout" ignore="true"/></TD>
		    <TD class=main_vertical_border>&nbsp;</TD>
    	</TR>
		<TR>
			<TD class=main_horizontal_border colSpan="3"></TD>
		</TR>
		<TR>
		    <TD class=main_vertical_border>&nbsp;</TD>
		    <TD class=content><tiles:insert attribute="body-content" ignore="true"/></TD>
			<TD class=main_vertical_border>&nbsp;</TD>		
		</TR>
		<TR>
			<TD class=footer colSpan="3"><STRONG>Tel:</STRONG> (00505) 8920124, <STRONG>Fax:</STRONG>
			(001) 801-812-8456 <STRONG><A
				href="mailto:parquemaritimo@playaelcoco.com.ni">parquemaritimo@playaelcoco.com.ni</A><BR>
			</STRONG></TD>
		</TR>
	</TBODY>
</TABLE>





</BODY>
</html>
