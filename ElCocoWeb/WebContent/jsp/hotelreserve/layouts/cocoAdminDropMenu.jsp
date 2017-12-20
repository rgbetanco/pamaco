      
<% String lan = (String) request.getSession().getAttribute("idioma");
   if (null != lan && lan.equalsIgnoreCase("es") ){%>
		<div id="chromemenu">
		<ul> 
			<li><a href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Inicio</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu1')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Autorizaciones</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu2')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Alojamientos</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu3')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Reportes</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu4')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Seguridad</a></li>
			<li><a href="/ElCocoWeb/admin/signout.do" title="">Salir</a></li>  
		</ul></div> 
		<div id="dropmenu1" class="dropmenudiv">
			<a href="#" title="">Por Confirmar</a>
			<a href="#" title="">Confirmadas</a>
			<a href="#" title="">Historial</a>
		</div>
		<div id="dropmenu2" class="dropmenudiv">
			<a href="/ElCocoWeb/admin/showRoomTypeMain.do" title="">Habitaciones</a>
			<a href="/ElCocoWeb/admin/showPlanRateMain.do" title="">Planes Tarifas</a>
		</div>
		<div id="dropmenu3" class="dropmenudiv">
			<a href="#" title="">Reporte 1</a>
			<a href="#" title="">Reporte 2</a>
		</div>
		<div id="dropmenu4" class="dropmenudiv">
			<a href="/ElCocoWeb/admin/showUserMain.do" title="">Usuarios</a>
			<a href="/ElCocoWeb/admin/showUserGroupInsert.do" title="">Grupos</a>			
		</div>

	<% } else {%>

		<div id="chromemenu">
		<ul> 
			<li><a href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Inicio</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu1')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Autorizaciones</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu2')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Alojamientos</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu3')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Reportes</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu4')" href="/ElCocoWeb/admin/showcontrolpanel.do" title="">Seguridad</a></li>
			<li><a href="/ElCocoWeb/admin/signout.do" title="">Salir</a></li>  
		</ul></div> 
		<div id="dropmenu1" class="dropmenudiv">
			<a href="#" title="">Por Confirmar</a>
			<a href="#" title="">Confirmadas</a>
			<a href="#" title="">Historial</a>
		</div>
		<div id="dropmenu2" class="dropmenudiv">
			<a href="/ElCocoWeb/admin/showRoomTypeMain.do" title="">Habitaciones</a>
			<a href="/ElCocoWeb/admin/showPlanRateMain.do" title="">Planes Tarifas</a>
		</div>
		<div id="dropmenu3" class="dropmenudiv">
			<a href="#" title="">Reporte 1</a>
			<a href="#" title="">Reporte 2</a>
		</div>
		<div id="dropmenu4" class="dropmenudiv">
			<a href="/ElCocoWeb/admin/showUserMain.do" title="">Usuarios</a>
			<a href="/ElCocoWeb/admin/showUserGroupInsert.do" title="">Grupos</a>			
		</div>
<%}%>

	