package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _index extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _index( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/index.jsp";

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

          // HTML // begin [file="/index.jsp";from=(0,0);to=(2,0)]
            out.write("\r\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");

          // end
          // HTML // begin [file="/index.jsp";from=(2,58);to=(3,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/index.jsp";from=(3,58);to=(4,0)]
            out.write("\r\n");

          // end
          // HTML // begin [file="/index.jsp";from=(4,60);to=(5,0)]
            out.write("\r\n");

          // end
          // ##DEBUG## ##TAGLIB## "/index.jsp" 6,0-"/index.jsp" 6,11  LineMapIndex:1
            _jspx_th_html_html_0.setPageContext(pageContext);
            _jspx_th_html_html_0.setParent(null);
            _jspxTagObjects.push(_jspx_th_html_html_0);
              int _jspx_eval_html_html_0 = _jspx_th_html_html_0.doStartTag();
              if (_jspx_eval_html_html_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                // end
                // HTML // begin [file="/index.jsp";from=(5,11);to=(11,1)]
                  out.write("\r\n<HEAD>\r\n<TITLE></TITLE>\r\n</HEAD>\r\n\r\n<BODY>\r\n\t");

                // end
                // ##DEBUG## ##TAGLIB## "/index.jsp" 12,1-"/index.jsp" 12,33  LineMapIndex:2
                  /* ------  logic:forward ------ */
                  org.apache.struts.taglib.logic.ForwardTag _jspx_th_logic_forward_0 = new org.apache.struts.taglib.logic.ForwardTag();
                  _jspx_th_logic_forward_0.setPageContext(pageContext);
                  _jspx_th_logic_forward_0.setParent(_jspx_th_html_html_0);
                  _jspx_th_logic_forward_0.setName("lodgings");
                  _jspxTagObjects.push(_jspx_th_logic_forward_0);
                    int _jspx_eval_logic_forward_0 = _jspx_th_logic_forward_0.doStartTag();
                  // end
                  // ##DEBUG## "/index.jsp" 12,1-"/index.jsp" 12,33  LineMapIndex:3
                    if (_jspx_th_logic_forward_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                      return;
                  ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                // end
                // HTML // begin [file="/index.jsp";from=(11,33);to=(13,0)]
                  out.write("\r\n</BODY>\r\n");

                // end
                // ##DEBUG## "/index.jsp" 14,0-"/index.jsp" 14,12  LineMapIndex:4
                } while (_jspx_th_html_html_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
              }
              if (_jspx_th_html_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
          // end
          // HTML // begin [file="/index.jsp";from=(13,12);to=(14,0)]
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
      "/index.jsp", 
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
      "6", 
      "12", 
      "12", 
      "14", 
      },
      };
    }
