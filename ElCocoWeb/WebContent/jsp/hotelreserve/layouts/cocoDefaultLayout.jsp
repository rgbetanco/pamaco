
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html>
<HEAD>
<TITLE>Reservas en linea - Parque Mar�timo el Coco</TITLE>

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

<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="maintable">
	<TBODY>
		<TR>
		    <TD class=main_content_side_block>&nbsp;</TD>
		    <TD class=main_vertical_border>&nbsp;</TD>
			<TD colspan=2><tiles:insert attribute="header.layout" ignore="true"/></TD>
		    <TD class=main_vertical_border>&nbsp;</TD>
    		<TD class=main_content_side_block>&nbsp;</TD>
    	</TR>
		<TR>
		    <TD class=main_content_side_block></TD>
		    <TD class=main_horizontal_border colSpan=4></TD>
		    <TD class=main_content_side_block>
		</TR>
		<TR>
		    <TD class=main_content_side_block>&nbsp;</TD>
		    <TD class=main_vertical_border>&nbsp;</TD>
		    <TD class=content><tiles:insert attribute="body-content" ignore="true"/></TD>
			<TD class=navibar>
							<tiles:insert attribute="sessionSelectedDates" ignore="true"/><br>
							<tiles:insert attribute="sessionSelectedRooms" ignore="true"/><br>
							<tiles:insert attribute="sessionSelectedGuestInfo" ignore="true"/><br>
							<tiles:insert attribute="sessionSelectedCardInfo" ignore="true"/><br>			
			</TD>
			<TD class=main_vertical_border>&nbsp;</TD>
			<TD class=main_content_side_block>&nbsp;</TD>		
		</TR>
		<TR>
    <TD class=footer colSpan=6><STRONG>Tel:</STRONG> (00505) 8920124, 
      <STRONG>Fax:</STRONG> (001) 801-812-8456 <STRONG><A 
      href="mailto:parquemaritimo@playaelcoco.com.ni">parquemaritimo@playaelcoco.com.ni</A><BR></STRONG></TD>
		</TR>
	</TBODY>
</TABLE>





</BODY>
</html>
