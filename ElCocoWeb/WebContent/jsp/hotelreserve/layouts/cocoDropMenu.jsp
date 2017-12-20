      
<% String lan = (String) request.getSession().getAttribute("idioma");
   if (null != lan && lan.equalsIgnoreCase("es") ){%>
		<div id="chromemenu">
		<ul> 
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu1')" href="http://www.playaelcoco.com.ni/es/parque" title="">El Parque</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu2')" href="http://www.playaelcoco.com.ni/es/information" title="">Se Alquila</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu3')" href="http://www.playaelcoco.com.ni/es/restaurant" title="">Restaurante</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu4')" href="http://www.playaelcoco.com.ni/es/aboutNicaragua" title="">Sobre Nicaragua</a></li>
			<li><a onmouseover="cssdropdown.dropit(this,event,'dropmenu5')" href="http://www.playaelcoco.com.ni/es/socialProject" title="">Proyecto social</a></li>
			<li><a href="http://www.playaelcoco.com.ni/es/contact" title="">Contacto</a></li>  
		</ul></div> 
		<div id="dropmenu1" class="dropmenudiv">
			<a href="http://www.playaelcoco.com.ni/es/parque" title="">El Parque</a>
			<a href="http://www.playaelcoco.com.ni/es/gettingThere" title="">Como se llega</a>
			<a href="http://www.playaelcoco.com.ni/es/activities" title="">Actividades en el Parque</a>
			<a href="http://www.playaelcoco.com.ni/es/activitiesEnvironment" title="">Actividades en los alrededores</a>
			<a href="http://www.playaelcoco.com.ni/es/seaTurtles" title="">Tortugas de mar</a>
			<a href="http://www.playaelcoco.com.ni/es/historyParque" title="">Historia del Parque</a>
			<a href="http://www.playaelcoco.com.ni/es/fincaEsperanza" title="">Finca &quot;La Esperanza&quot;</a>
			<a href="http://www.playaelcoco.com.ni/es/infrastructure" title="">Infraestructura</a>
			<a href="http://www.playaelcoco.com.ni/es/links" title="">Enlaces</a>
		</div>
		<div id="dropmenu2" class="dropmenudiv">
			<a href="http://www.playaelcoco.com.ni/es/information" title="">Información</a>
			<a href="http://www.playaelcoco.com.ni/es/ostoche" title="">Bungalows Ostoche</a>
			<a href="http://www.playaelcoco.com.ni/es/carina" title="">Casa Carina</a>
			<a href="http://www.playaelcoco.com.ni/es/carinita" title="">Casa Carinita</a>
			<a href="http://www.playaelcoco.com.ni/es/cangrejos" title="">Apartamentos &quot;Los Cangrejos&quot;</a>
			<a href="http://www.playaelcoco.com.ni/es/gerardo" title="">Casa Gerardo</a>
			<a href="http://www.playaelcoco.com.ni/es/payacalli" title="">Casa Payacalli</a>
			<a href="http://www.playaelcoco.com.ni/es/almendros" title="">Apartamento &quot;Los Almendros&quot;</a>
			<a href="http://www.playaelcoco.com.ni/es/tortuga" title="">Casa Tortuga</a>
			<a href="http://www.playaelcoco.com.ni/es/malinche" title="">Casa Malinche</a>
			<a href="http://www.playaelcoco.com.ni/es/panama" title="">Casa Panama</a>
			<a href="http://www.playaelcoco.com.ni/es/piancito" title="">Casa Piancito</a>
			<a href="http://www.playaelcoco.com.ni/es/conventionCenter" title="">&gt;&gt; Centro de Convenciones &lt;&lt;</a>
		</div>
		<div id="dropmenu3" class="dropmenudiv">
			<a href="http://www.playaelcoco.com.ni/es/restaurant" title="">Puesta del Sol</a>
			<a href="http://www.playaelcoco.com.ni/es/menu" title="">Menú</a>
		</div>
		<div id="dropmenu4" class="dropmenudiv">
			<a href="http://www.playaelcoco.com.ni/es/aboutNicaragua" title="">Sobre Nicaragua</a>
			<a href="http://www.playaelcoco.com.ni/es/tipsForTravellers" title="">Recomendaciones para viajeros</a>
			<a href="http://www.playaelcoco.com.ni/es/travellingInNicaragua" title="">Viajar en Nicaragua</a>
		</div>
		<div id="dropmenu5" class="dropmenudiv">
			<a href="http://www.playaelcoco.com.ni/es/socialProject" title="">Descripción</a>
			<a href="http://www.playaelcoco.com.ni/es/escuelitaStart" title="">Escuelita</a>
		</div>


	<% } else {%>

	<DIV id=chromemenu>
      <UL>
        <LI><A onmouseover="cssdropdown.dropit(this,event,'dropmenu1')" title="" 
        href="http://www.playaelcoco.com.ni/en/parque">The Parque</A>
        <LI><A onmouseover="cssdropdown.dropit(this,event,'dropmenu2')" title="" 
        href="http://www.playaelcoco.com.ni/en/information">For Rent</A>
        <LI><A onmouseover="cssdropdown.dropit(this,event,'dropmenu3')" title="" 
        href="http://www.playaelcoco.com.ni/en/restaurant">Restaurant</A>
        <LI><A onmouseover="cssdropdown.dropit(this,event,'dropmenu4')" title="" 
        href="http://www.playaelcoco.com.ni/en/aboutNicaragua">About Nicaragua</A>
        <LI><A onmouseover="cssdropdown.dropit(this,event,'dropmenu5')" title="" 
        href="http://www.playaelcoco.com.ni/en/socialProject">Social Project</A>
        <LI><A title="" 
        href="http://www.playaelcoco.com.ni/en/contact">Contact</A> 
      </LI></UL></DIV>
      <DIV class=dropmenudiv id=dropmenu1><A title="" 
      href="http://www.playaelcoco.com.ni/en/parque">The Parque</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/gettingThere">Getting there</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/activities">Activities in 
      the Parque</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/activitiesEnvironment">Activities 
      in the Environment</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/seaTurtles">Sea turtles</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/historyParque">History of 
      the Parque</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/fincaEsperanza">Finca "La 
      Esperanza"</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/infrastructure">Infrastructure</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/links">Links</A></DIV>
      <DIV class=dropmenudiv id=dropmenu2><A title="" 
      href="http://www.playaelcoco.com.ni/en/information">Information</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/ostoche">Bungalows 
      Ostoche</A><A title="" href="http://www.playaelcoco.com.ni/en/carina">Casa 
      Carina</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/carinita">Casa Carinita</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/cangrejos">Apartamentos 
      "Los Cangrejos"</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/gerardo">Casa Gerardo</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/payacalli">Casa 
      Payacalli</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/almendros">Apartamento "Los 
      Almendros"</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/tortuga">Casa Tortuga</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/malinche">Casa 
      Malinche</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/panama">Casa Panama</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/piancito">Casa Piancito</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/conventionCenter">&gt;&gt; 
      Convention Center &lt;&lt;</A></DIV>
      <DIV class=dropmenudiv id=dropmenu3><A title="" 
      href="http://www.playaelcoco.com.ni/en/restaurant">Puesta del Sol</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/menu">Menu</A></DIV>
      <DIV class=dropmenudiv id=dropmenu4><A title="" 
      href="http://www.playaelcoco.com.ni/en/aboutNicaragua">About 
      Nicaragua</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/tipsForTravellers">Tips for 
      Travellers</A><A title="" 
      href="http://www.playaelcoco.com.ni/en/travellingInNicaragua">Travelling 
      in Nicaragua</A></DIV>
      <DIV class=dropmenudiv id=dropmenu5><A title="" 
      href="http://www.playaelcoco.com.ni/en/socialProject">Description</A><A 
      title="" href="http://www.playaelcoco.com.ni/en/escuelitaStart">School 
      "Escuelita"</A></DIV>
<%}%>

	