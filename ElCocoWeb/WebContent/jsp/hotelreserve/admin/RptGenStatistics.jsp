<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<SCRIPT language="javascript" type="text/javascript" src="/ElCocoWeb/js/datetimepicker.js"></SCRIPT>

<LINK rel="stylesheet" href="/ElCocoWeb/css/adminStyle.css" type="text/css">

<form action="showStatistics.do" method="POST" >
<table width="700" cellspacing=0 border="0" cellpadding="0" align="center" summary="">
	  <tr>
	  	<td colspan="2" align="center">
	  		<div class="subtitle"><h1>Reporte Estadistico</h1></div>	
	  	
	  	</td>
	  </tr>

	  <tr>
	  <td>Fecha Inicial</td>
	  	<td>
	  		<input type="Text" id="dateIni" name="dateIniN" maxlength="25" size="25"><a href="javascript:NewCal('dateIni','ddmmyyyy',false,24)"><img src="/ElCocoWeb/img/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<span class="descriptions"></span>
	  	</td>
	  </tr>
	  <tr>
	  	<td>Fecha Final</td>
	  	<td>
	  		<input type="Text" id="dateFin" name="dateFinN" maxlength="25" size="25"><a href="javascript:NewCal('dateFin','ddmmyyyy',false,24)"><img src="/ElCocoWeb/img/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
	  		<span class="descriptions"></span>
	  	</td>
	  </tr>
	  <tr>
	  <td>Por Cliente</td>
	  	<td>
	  		<select name="cliente">
			<option value = Todos>Todos</option>
			<c:forEach items="${clientes}" var="clients" >
				<option value = "<c:out value='${clients.email}' />" ><c:out value="${clients.name}" />,<c:out value="${clients.lastName}" /></option>
			</c:forEach>
		 </td>
	  </tr>
	  <tr>
	  	<td>Por habitacion</td>
	  	<td>
	  		<select name="rooms">
			<option value = Todos>Todos</option>
			<c:forEach items="${habitacion}" var="room" >
				<option value = "<c:out value='${room.roomid}' />" ><c:out value="${room.briefdescription}" /></option>
			</c:forEach>
		 </td>
	  </tr>
	  <tr>
	  	<td><input type="submit" value = "Generar" /></td>
	  </tr>
</table>
</form>
