package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _cocoAdminLayout extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _cocoAdminLayout( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";

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
      /* ------  tiles:insert ------ */
      org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_0 = new org.apache.struts.taglib.tiles.InsertTag();

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

          // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";from=(0,0);to=(2,0)]
            out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

          // end
          // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";from=(2,58);to=(3,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";from=(3,58);to=(4,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";from=(4,60);to=(43,7)]
            out.write("\r\n\r\n<html>\r\n<HEAD>\r\n<TITLE>Reservas en linea - Parque Marítimo el Coco</TITLE>\r\n\r\n<META http-equiv=Content-Style-Type content=text/css>\r\n<META http-equiv=Content-Type content=\"text/html; charset=utf-8\">\r\n<STYLE type=text/css media=all>@import url( /ElCocoWeb/misc/drupal.css );\r\n</STYLE>\r\n\r\n<SCRIPT \r\nsrc=\"/ElCocoWeb/modules/playaelcoco_menus/playaelcoco_menus.js\" \r\ntype=text/javascript></SCRIPT>\r\n\r\n<STYLE type=text/css media=all>@import url( /ElCocoWeb/modules/playaelcoco_menus/playaelcoco_menus.css );\r\n</STYLE>\r\n\r\n<STYLE type=text/css media=all>@import url( /ElCocoWeb/themes/playaelcoco2/style.css );\r\n</STYLE>\r\n\r\n</HEAD>\r\n\r\n<BODY>\r\n\r\n<TABLE cellSpacing=0 cellPadding=0 width=\"100%\" border=0>\r\n  <TBODY>\r\n  <TR>\r\n  \t<TD class=header>&nbsp;</TD>\r\n    <TD class=header_center></TD>\r\n    <TD class=header>&nbsp;</TD>\r\n   </TR>\r\n   </TBODY>\r\n</TABLE>\r\n\r\n<TABLE width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"maintable\">\r\n\t<TBODY>\r\n\t\t<TR>\r\n\t\t    <TD class=main_vertical_border>&nbsp;</TD>\r\n\t\t\t<TD>");

          // end
          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 44,7-"/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 44,62  LineMapIndex:1
            _jspx_th_tiles_insert_0.setPageContext(pageContext);
            _jspx_th_tiles_insert_0.setParent(null);
            _jspx_th_tiles_insert_0.setAttribute("header.layout");
            _jspx_th_tiles_insert_0.setIgnore(true);
            _jspxTagObjects.push(_jspx_th_tiles_insert_0);
              int _jspx_eval_tiles_insert_0 = _jspx_th_tiles_insert_0.doStartTag();
            // end
            // ##DEBUG## "/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 44,7-"/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 44,62  LineMapIndex:2
              if (_jspx_th_tiles_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
          // end
          // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";from=(43,62);to=(51,24)]
            out.write("</TD>\r\n\t\t    <TD class=main_vertical_border>&nbsp;</TD>\r\n    \t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD class=main_horizontal_border colSpan=\"3\"></TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t    <TD class=main_vertical_border>&nbsp;</TD>\r\n\t\t    <TD class=content>");

          // end
          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 52,24-"/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 52,78  LineMapIndex:3
            /* ------  tiles:insert ------ */
            org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_1 = new org.apache.struts.taglib.tiles.InsertTag();
            _jspx_th_tiles_insert_1.setPageContext(pageContext);
            _jspx_th_tiles_insert_1.setParent(null);
            _jspx_th_tiles_insert_1.setAttribute("body-content");
            _jspx_th_tiles_insert_1.setIgnore(true);
            _jspxTagObjects.push(_jspx_th_tiles_insert_1);
              int _jspx_eval_tiles_insert_1 = _jspx_th_tiles_insert_1.doStartTag();
            // end
            // ##DEBUG## "/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 52,24-"/jsp/hotelreserve/layouts/cocoAdminLayout.jsp" 52,78  LineMapIndex:4
              if (_jspx_th_tiles_insert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
          // end
          // HTML // begin [file="/jsp/hotelreserve/layouts/cocoAdminLayout.jsp";from=(51,78);to=(69,0)]
            out.write("</TD>\r\n\t\t\t<TD class=main_vertical_border>&nbsp;</TD>\t\t\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD class=footer colSpan=\"3\"><STRONG>Tel:</STRONG> (00505) 8920124, <STRONG>Fax:</STRONG>\r\n\t\t\t(001) 801-812-8456 <STRONG><A\r\n\t\t\t\thref=\"mailto:parquemaritimo@playaelcoco.com.ni\">parquemaritimo@playaelcoco.com.ni</A><BR>\r\n\t\t\t</STRONG></TD>\r\n\t\t</TR>\r\n\t</TBODY>\r\n</TABLE>\r\n\r\n\r\n\r\n\r\n\r\n</BODY>\r\n</html>\r\n");

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
      "/jsp/hotelreserve/layouts/cocoAdminLayout.jsp", 
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
      "44", 
      "44", 
      "52", 
      "52", 
      },
      };
    }
