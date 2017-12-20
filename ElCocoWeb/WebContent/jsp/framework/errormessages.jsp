<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %><HEAD>

<STYLE type="text/css">
<!--
#tableRed {
	color: black;
	font-family: Tahoma;
	background-color: #fffff2;
	font-weight: normal;
	font-size: 13px;
	border-color: red;
	padding: 5px;
	border-width: thin;
	border-style: solid	
}

#tableRed TH {
	background-color: red;
}

#tableRed TD {
	color: red
}


#tableGreen {
	color: black;
	font-family: Tahoma;
	background-color: #fffff2;
	font-weight: normal;
	font-size: 13px;
	border-color: green;
	padding: 5px;
	border-width: thin;
	border-style: solid	
}

#tableGreen TH {
	background-color: green;
}

#tableGreen TD {
	color: green;
}
-->
</STYLE>

</HEAD>
<c:set var="printed" value="false" />
 
  	      	<logic:messagesPresent property="GLOBAL_ERROR">


<table id="tableRed" width="100%">
	<tr>
		<td>

		      			<html:messages id="error">
	    	  				<c:out value="${error}"/>
	      				</html:messages>	      	
	      				<c:set var="printed" value="true" />

		</td>
	</tr>
</table>

	      	</logic:messagesPresent>
	      
  	      	<logic:messagesPresent property="GLOBAL_MSG">

<table id="tableGreen" width="100%">
	<tr>
		<td>

		      			<html:messages id="error">
	    	  				<c:out value="${error}"/>
	      				</html:messages>	      	
	      				<c:set var="printed" value="true" />

		</td>
	</tr>
</table>

	      	</logic:messagesPresent>	      
	      
		      		<logic:messagesPresent>
<c:if test="${not printed}">		      		
<table id="tableRed" width="100%">
	<tr>
		<td>
		      			<html:messages id="error">
	    	  				<c:out value="${error}"/>
	      				</html:messages>
	      				
		</td>
	</tr>
</table>
</c:if>	      				
	      			</logic:messagesPresent>