package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _cocoAdminDropMenu extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _cocoAdminDropMenu( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp";

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

      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp";from=(0,0);to=(1,0)]
        out.write("      \r\n");

      // end
      // ##DEBUG## ##SCRIPTLET## "/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp" 2,2-"/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp" 3,51  LineMapIndex:1
         String lan = (String) request.getSession().getAttribute("idioma");
           if (null != lan && lan.equalsIgnoreCase("es") ){
      // end
      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp";from=(2,53);to=(30,1)]
        out.write("\r\n\t\t<div id=\"chromemenu\">\r\n\t\t<ul> \r\n\t\t\t<li><a href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Inicio</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu1')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Autorizaciones</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu2')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Alojamientos</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu3')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Reportes</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu4')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Seguridad</a></li>\r\n\t\t\t<li><a href=\"/ElCocoWeb/admin/signout.do\" title=\"\">Salir</a></li>  \r\n\t\t</ul></div> \r\n\t\t<div id=\"dropmenu1\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"#\" title=\"\">Por Confirmar</a>\r\n\t\t\t<a href=\"#\" title=\"\">Confirmadas</a>\r\n\t\t\t<a href=\"#\" title=\"\">Historial</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu2\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showRoomTypeMain.do\" title=\"\">Habitaciones</a>\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showPlanRateMain.do\" title=\"\">Planes Tarifas</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu3\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"#\" title=\"\">Reporte 1</a>\r\n\t\t\t<a href=\"#\" title=\"\">Reporte 2</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu4\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showUserMain.do\" title=\"\">Usuarios</a>\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showUserGroupInsert.do\" title=\"\">Grupos</a>\t\t\t\r\n\t\t</div>\r\n\r\n\t");

      // end
      // ##DEBUG## ##SCRIPTLET## "/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp" 31,3-"/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp" 31,12  LineMapIndex:3
         } else {
      // end
      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp";from=(30,14);to=(58,0)]
        out.write("\r\n\r\n\t\t<div id=\"chromemenu\">\r\n\t\t<ul> \r\n\t\t\t<li><a href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Inicio</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu1')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Autorizaciones</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu2')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Alojamientos</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu3')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Reportes</a></li>\r\n\t\t\t<li><a onmouseover=\"cssdropdown.dropit(this,event,'dropmenu4')\" href=\"/ElCocoWeb/admin/showcontrolpanel.do\" title=\"\">Seguridad</a></li>\r\n\t\t\t<li><a href=\"/ElCocoWeb/admin/signout.do\" title=\"\">Salir</a></li>  \r\n\t\t</ul></div> \r\n\t\t<div id=\"dropmenu1\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"#\" title=\"\">Por Confirmar</a>\r\n\t\t\t<a href=\"#\" title=\"\">Confirmadas</a>\r\n\t\t\t<a href=\"#\" title=\"\">Historial</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu2\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showRoomTypeMain.do\" title=\"\">Habitaciones</a>\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showPlanRateMain.do\" title=\"\">Planes Tarifas</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu3\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"#\" title=\"\">Reporte 1</a>\r\n\t\t\t<a href=\"#\" title=\"\">Reporte 2</a>\r\n\t\t</div>\r\n\t\t<div id=\"dropmenu4\" class=\"dropmenudiv\">\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showUserMain.do\" title=\"\">Usuarios</a>\r\n\t\t\t<a href=\"/ElCocoWeb/admin/showUserGroupInsert.do\" title=\"\">Grupos</a>\t\t\t\r\n\t\t</div>\r\n");

      // end
      // ##DEBUG## ##SCRIPTLET## "/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp" 59,2-"/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp" 59,3  LineMapIndex:4
        }
      // end
      // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp";from=(58,5);to=(60,1)]
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
  "/jsp/hotelreserve/layouts/cocoAdminDropMenu.jsp", 
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
  "31", 
  "59", 
  },
  };
}
