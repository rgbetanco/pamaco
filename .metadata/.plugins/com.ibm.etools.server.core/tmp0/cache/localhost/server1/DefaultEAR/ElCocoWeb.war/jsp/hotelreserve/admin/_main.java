package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _main extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _main( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/jsp/hotelreserve/admin/main.jsp";

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
      /* ------  html:html ------ */
      org.apache.struts.taglib.html.HtmlTag _jspx_th_html_html_0 = new org.apache.struts.taglib.html.HtmlTag();

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

        // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(0,0);to=(2,0)]
          out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

        // end
        // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(2,58);to=(3,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(3,58);to=(4,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(4,60);to=(5,0)]
          out.write("\r\n");

        // end
        // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(5,60);to=(7,0)]
          out.write("\r\n\r\n");

        // end
        // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/main.jsp" 8,0-"/jsp/hotelreserve/admin/main.jsp" 8,11  LineMapIndex:1
          _jspx_th_html_html_0.setPageContext(pageContext);
          _jspx_th_html_html_0.setParent(null);
          _jspxTagObjects.push(_jspx_th_html_html_0);
            int _jspx_eval_html_html_0 = _jspx_th_html_html_0.doStartTag();
            if (_jspx_eval_html_html_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
              // end
              // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(7,11);to=(16,0)]
                out.write("\r\n<HEAD>\r\n\r\n<LINK rel=\"stylesheet\" href=\"/ElCocoWeb/css/adminStyle.css\"\r\n\ttype=\"text/css\">\r\n</HEAD>\r\n\r\n<BODY>\r\n\r\n");

              // end
              // ##DEBUG## "/jsp/hotelreserve/admin/main.jsp" 17,0-"/jsp/hotelreserve/admin/main.jsp" 17,80  LineMapIndex:2
                {
                  String _jspx_qStr = "";
                  JspRuntimeLibrary.include(request, response, "/jsp/framework/errormessages.jsp" + _jspx_qStr, out, true);
                  if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                    return;
                }
              // end
              // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(16,80);to=(84,0)]
                out.write("\r\n<p><br>&nbsp;</p>\r\n<center>\r\n\r\n<TABLE width=\"80%\" border=\"0\" id=\"tableYellow\">\r\n\t<TBODY>\r\n\t\t<TR>\r\n\t\t\t<TH colspan=\"3\">Autorizaciones</TH>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD><a href=\"/ElCocoWeb/admin/showPendingReserve.do\"><IMG border=\"0\"\r\n\t\t\t\tsrc=\"/ElCocoWeb/img/ok3232.jpg\" width=\"32\"\r\n\t\t\t\theight=\"32\" align=\"middle\">Por Confirmar</a></TD>\r\n\t\t\t<!--TD><a href=\"#\"><IMG border=\"0\" src=\"/ElCocoWeb/img/i_licensemanager_med.gif\"\r\n\t\t\t\twidth=\"32\" height=\"32\" align=\"middle\">Confirmadas</a></TD-->\r\n\t\t\t<TD colspan=\"1\"><a href=\"/ElCocoWeb/admin/reserveQuery.do\"><IMG border=\"0\" src=\"/ElCocoWeb/img/i_crontab_med.gif\" width=\"32\"\r\n\t\t\t\theight=\"32\" align=\"middle\">Historial</a></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD colspan=\"3\"><P><BR></P></TD>\r\n\t\t</TR>\r\n\r\n\t\t<TR>\r\n\t\t\t<TH colspan=\"3\">Alojamientos</TH>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD><a href=\"/ElCocoWeb/admin/showRoomTypeMain.do\"> <IMG border=\"0\"\r\n\t\t\t\tsrc=\"/ElCocoWeb/img/i_system_tab.gif\" width=\"32\" height=\"32\" align=\"middle\"> Habitaciones</a></TD>\r\n\t\t\t<TD><a href=\"/ElCocoWeb/admin/showPlanRateMain.do\"> <IMG border=\"0\"\r\n\t\t\t\tsrc=\"/ElCocoWeb/img/i_actionlog_med.gif\" width=\"32\" height=\"32\" align=\"middle\">Planes Tarifas</a></TD>\r\n\t\t\t<TD><a href=\"/ElCocoWeb/admin/showAvailability.do\"><IMG border=\"0\"\r\n\t\t\t\tsrc=\"/ElCocoWeb/img/reservation.gif\" width=\"32\"\r\n\t\t\t\theight=\"32\" align=\"middle\">Bloquear/Desbloquear</a></TD>\t\t\t\t\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD colspan=\"3\"><P><BR></P></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TH colspan=\"3\">Usuarios &amp; Grupos</TH>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD><a href=\"/ElCocoWeb/admin/showUserMain.do\"><IMG border=\"0\" src=\"/ElCocoWeb/img/users_med.gif\"\r\n\t\t\t\twidth=\"32\" height=\"32\" align=\"middle\">Usuarios</a></TD>\r\n\t\t\t<TD><a href=\"/ElCocoWeb/admin/showUserGroupInsert.do\"><IMG border=\"0\" src=\"/ElCocoWeb/img/i_groups_med.gif\"\r\n\t\t\t\twidth=\"32\" height=\"32\" align=\"middle\"> Grupos</A></TD>\r\n\t\t\t<TD></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD colspan=\"3\"><P><BR></P></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TH colspan=\"3\">Reportess</TH>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD><A href=\"/ElCocoWeb/admin/showGenStatistics.do\"><IMG border=\"0\"\r\n\t\t\t\tsrc=\"/ElCocoWeb/img/i_vzpp_med.gif\" width=\"32\"\r\n\t\t\t\theight=\"32\" align=\"middle\">Reporte Estadistico</A></TD>\r\n\t\t\t\t<TD></TD>\r\n\t\t</TR>\r\n\t\r\n\t\r\n\t</TBODY>\r\n</TABLE>\r\n\r\n\r\n\r\n</center>\r\n</BODY>\r\n");

              // end
              // ##DEBUG## "/jsp/hotelreserve/admin/main.jsp" 85,0-"/jsp/hotelreserve/admin/main.jsp" 85,12  LineMapIndex:3
              } while (_jspx_th_html_html_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
            }
            if (_jspx_th_html_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
              return;
          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
        // end
        // HTML // begin [file="/jsp/hotelreserve/admin/main.jsp";from=(84,12);to=(85,0)]
          out.write("\r\n");

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
    "/jsp/hotelreserve/admin/main.jsp", 
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
    },
    {
    "1", 
    "8", 
    "17", 
    "85", 
    },
    };
  }
