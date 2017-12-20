

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<script>
	function setIframeSrcParam(){
		document.all.edit.src = "showPlanRateInsert.do";
		//document.all.info.src = "showPlanRateDetail.do";
	}
	
</script>


<BODY onload = "setIframeSrcParam();">

<iframe id="edit"
		frameborder="0" 
		src="";
		name="edit" 
		align="middle" 
		scrolling="no" 
		width="100%"
		height="1000"
		marginwidth="0"
		marginheight="0">
</iframe>





</BODY>

