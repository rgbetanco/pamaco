package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _cocoDropMenu extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _cocoDropMenu( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/jsp/hotelreserve/layouts/cocoDropMenu.jsp";

  public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    /* Init Method Phase */
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    String  _value = null;
    java.util.Stack _jspxTagObjects = new java.util.Stack();
    /* Service Declaration Phase */

    try {

      if (_jspx_inited == false) {
        synchronized (this) {
          if (_jspx_inited == false) {
            _jspx_init();
            _jspx_inited = true;
          }
        }
      }

      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);

      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();

      /* Service Method Phase */

      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoDropMenu.jsp";from=(0,0);to=(1,0)]
        out.write("      \r\n");

      // end
      // ##DEBUG## ##SCRIPTLET## "/jsp/hotelreserve/layouts/cocoDropMenu.jsp" 2,2-"/jsp/hotelreserve/layouts/cocoDropMenu.jsp" 3,51  LineMapIndex:1
         String lan = (String) request.getSession().getAttribute("idioma");
           if (null != lan && lan.equalsIgnoreCase("es") ){
      // end
      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoDropMenu.jsp";from=(2,53);to=(53,1)]
        out.write("\r\n\t\t<div id=\"chromemenu\">\r\n\t\t<ul> \r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu1')\" href=\"http://www.playaelcoco.com.ni/es/parque\" title=\"\">El Parque</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu2')\" href=\"http://www.playaelcoco.com.ni/es/information\" title=\"\">Se Alquila</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu3')\" href=\"http://www.playaelcoco.com.ni/es/restaurant\" title=\"\">Restaurante</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu4')\" href=\"http://www.playaelcoco.com.ni/es/aboutNicaragua\" title=\"\">Sobre Nicaragua</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu5')\" href=\"http://www.playaelcoco.com.ni/es/socialProject\" title=\"\">Proyecto social</a></li>\r\n\t\t\t<li><a href=\"http://www.playaelcoco.com.ni/es/contact\" title=\"\">Contacto</a></li>  \r\n\t\t</ul></div> \r\n\t\t<div id=\"dropmenu1\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/parque\" title=\"\">El Parque</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/gettingThere\" title=\"\">Como se llega</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/activities\" title=\"\">Actividades en el Parque</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/activitiesEnvironment\" title=\"\">Actividades en los alrededores</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/seaTurtles\" title=\"\">Tortugas de mar</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/historyParque\" title=\"\">Historia del Parque</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/fincaEsperanza\" title=\"\">Finca &quot;La Esperanza&quot;</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/infrastructure\" title=\"\">Infraestructura</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/links\" title=\"\">Enlaces</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu2\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/information\" title=\"\">Información</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/ostoche\" title=\"\">Bungalows Ostoche</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/carina\" title=\"\">Casa Carina</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/carinita\" title=\"\">Casa Carinita</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/cangrejos\" title=\"\">Apartamentos &quot;Los Cangrejos&quot;</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/gerardo\" title=\"\">Casa Gerardo</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/payacalli\" title=\"\">Casa Payacalli</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/almendros\" title=\"\">Apartamento &quot;Los Almendros&quot;</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/tortuga\" title=\"\">Casa Tortuga</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/malinche\" title=\"\">Casa Malinche</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/panama\" title=\"\">Casa Panama</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/piancito\" title=\"\">Casa Piancito</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/conventionCenter\" title=\"\">&gt;&gt; Centro de Convenciones &lt;&lt;</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu3\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/restaurant\" title=\"\">Puesta del Sol</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/menu\" title=\"\">Menú</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu4\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/aboutNicaragua\" title=\"\">Sobre Nicaragua</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/tipsForTravellers\" title=\"\">Recomendaciones para viajeros</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/travellingInNicaragua\" title=\"\">Viajar en Nicaragua</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu5\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/socialProject\" title=\"\">Descripción</a>\r\n\t\t\t<a href=\"http://www.playaelcoco.com.ni/es/escuelitaStart\" title=\"\">Escuelita</a>\r\n\t\t</div>\r\n\r\n\r\n\t");

      // end
      // ##DEBUG## ##SCRIPTLET## "/jsp/hotelreserve/layouts/cocoDropMenu.jsp" 54,3-"/jsp/hotelreserve/layouts/cocoDropMenu.jsp" 54,12  LineMapIndex:3
         } else {
      // end
      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoDropMenu.jsp";from=(53,14);to=(118,0)]
        out.write("\r\n\r\n\t<DIV id=chromemenu>\r\n      <UL>\r\n        <LI><A onmouseover=\"cssdropdown.dropit(this,event,'dropmenu1')\" title=\"\" \r\n        href=\"http://www.playaelcoco.com.ni/en/parque\">The Parque</A>\r\n        <LI><A onmouseover=\"cssdropdown.dropit(this,event,'dropmenu2')\" title=\"\" \r\n        href=\"http://www.playaelcoco.com.ni/en/information\">For Rent</A>\r\n        <LI><A onmouseover=\"cssdropdown.dropit(this,event,'dropmenu3')\" title=\"\" \r\n        href=\"http://www.playaelcoco.com.ni/en/restaurant\">Restaurant</A>\r\n        <LI><A onmouseover=\"cssdropdown.dropit(this,event,'dropmenu4')\" title=\"\" \r\n        href=\"http://www.playaelcoco.com.ni/en/aboutNicaragua\">About Nicaragua</A>\r\n        <LI><A onmouseover=\"cssdropdown.dropit(this,event,'dropmenu5')\" title=\"\" \r\n        href=\"http://www.playaelcoco.com.ni/en/socialProject\">Social Project</A>\r\n        <LI><A title=\"\" \r\n        href=\"http://www.playaelcoco.com.ni/en/contact\">Contact</A> \r\n      </LI></UL></DIV>\r\n      <DIV class=dropmenudiv id=dropmenu1><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/parque\">The Parque</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/gettingThere\">Getting there</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/activities\">Activities in \r\n      the Parque</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/activitiesEnvironment\">Activities \r\n      in the Environment</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/seaTurtles\">Sea turtles</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/historyParque\">History of \r\n      the Parque</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/fincaEsperanza\">Finca \"La \r\n      Esperanza\"</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/infrastructure\">Infrastructure</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/links\">Links</A></DIV>\r\n      <DIV class=dropmenudiv id=dropmenu2><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/information\">Information</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/ostoche\">Bungalows \r\n      Ostoche</A><A title=\"\" href=\"http://www.playaelcoco.com.ni/en/carina\">Casa \r\n      Carina</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/carinita\">Casa Carinita</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/cangrejos\">Apartamentos \r\n      \"Los Cangrejos\"</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/gerardo\">Casa Gerardo</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/payacalli\">Casa \r\n      Payacalli</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/almendros\">Apartamento \"Los \r\n      Almendros\"</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/tortuga\">Casa Tortuga</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/malinche\">Casa \r\n      Malinche</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/panama\">Casa Panama</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/piancito\">Casa Piancito</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/conventionCenter\">&gt;&gt; \r\n      Convention Center &lt;&lt;</A></DIV>\r\n      <DIV class=dropmenudiv id=dropmenu3><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/restaurant\">Puesta del Sol</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/menu\">Menu</A></DIV>\r\n      <DIV class=dropmenudiv id=dropmenu4><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/aboutNicaragua\">About \r\n      Nicaragua</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/tipsForTravellers\">Tips for \r\n      Travellers</A><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/travellingInNicaragua\">Travelling \r\n      in Nicaragua</A></DIV>\r\n      <DIV class=dropmenudiv id=dropmenu5><A title=\"\" \r\n      href=\"http://www.playaelcoco.com.ni/en/socialProject\">Description</A><A \r\n      title=\"\" href=\"http://www.playaelcoco.com.ni/en/escuelitaStart\">School \r\n      \"Escuelita\"</A></DIV>\r\n");

      // end
      // ##DEBUG## ##SCRIPTLET## "/jsp/hotelreserve/layouts/cocoDropMenu.jsp" 119,2-"/jsp/hotelreserve/layouts/cocoDropMenu.jsp" 119,3  LineMapIndex:4
        }
      // end
      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoDropMenu.jsp";from=(118,5);to=(120,1)]
        out.write("\r\n\r\n\t");

      // end

    } catch (Throwable t) {
      if (out != null && out.getBufferSize() != 0)
        out.clearBuffer();
      if (pageContext != null) pageContext.handlePageException(t);
    } finally {
      while (_jspxTagObjects.empty() == false){
        ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
      }
      if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);

      /* Service Finally Phase */
    }
  }
  public static String[][] _jspx_debug_FileMapping = {
  {
  "/jsp/hotelreserve/layouts/cocoDropMenu.jsp", 
  },
  {
  "0", 
  },
  };
  public static String[][] _jspx_debug_LineMapping = {
  {
  "0", 
  "0", 
  "0", 
  "0", 
  "0", 
  },
  {
  "1", 
  "2", 
  "3", 
  "54", 
  "119", 
  },
  };
}
