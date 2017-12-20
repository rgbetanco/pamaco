package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _RptGenStatistics extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _RptGenStatistics( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/jsp/hotelreserve/admin/RptGenStatistics.jsp";

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
      /* ------  c:forEach ------ */
      org.apache.taglibs.standard.tag.el.core.ForEachTag _jspx_th_c_forEach_0 = new org.apache.taglibs.standard.tag.el.core.ForEachTag();

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

                    // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(0,59);to=(33,3)]
                      out.write("\r\n<SCRIPT language=\"javascript\" type=\"text/javascript\" src=\"/ElCocoWeb/js/datetimepicker.js\"></SCRIPT>\r\n\r\n<LINK rel=\"stylesheet\" href=\"/ElCocoWeb/css/adminStyle.css\" type=\"text/css\">\r\n\r\n<form action=\"showStatistics.do\" method=\"POST\" >\r\n<table width=\"700\" cellspacing=0 border=\"0\" cellpadding=\"0\" align=\"center\" summary=\"\">\r\n\t  <tr>\r\n\t  \t<td colspan=\"2\" align=\"center\">\r\n\t  \t\t<div class=\"subtitle\"><h1>Reporte Estadistico</h1></div>\t\r\n\t  \t\r\n\t  \t</td>\r\n\t  </tr>\r\n\r\n\t  <tr>\r\n\t  <td>Fecha Inicial</td>\r\n\t  \t<td>\r\n\t  \t\t<input type=\"Text\" id=\"dateIni\" name=\"dateIniN\" maxlength=\"25\" size=\"25\"><a href=\"javascript:NewCal('dateIni','ddmmyyyy',false,24)\"><img src=\"/ElCocoWeb/img/cal.gif\" width=\"16\" height=\"16\" border=\"0\" alt=\"Pick a date\"></a>\r\n\t  \t\t<span class=\"descriptions\"></span>\r\n\t  \t</td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t  \t<td>Fecha Final</td>\r\n\t  \t<td>\r\n\t  \t\t<input type=\"Text\" id=\"dateFin\" name=\"dateFinN\" maxlength=\"25\" size=\"25\"><a href=\"javascript:NewCal('dateFin','ddmmyyyy',false,24)\"><img src=\"/ElCocoWeb/img/cal.gif\" width=\"16\" height=\"16\" border=\"0\" alt=\"Pick a date\"></a>\r\n\t  \t\t<span class=\"descriptions\"></span>\r\n\t  \t</td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t  <td>Por Cliente</td>\r\n\t  \t<td>\r\n\t  \t\t<select name=\"cliente\">\r\n\t\t\t<option value = Todos>Todos</option>\r\n\t\t\t");

                    // end
                    // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 34,3-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 34,49  LineMapIndex:1
                      _jspx_th_c_forEach_0.setPageContext(pageContext);
                      _jspx_th_c_forEach_0.setParent(null);
                      _jspx_th_c_forEach_0.setItems("${clientes}");
                      _jspx_th_c_forEach_0.setVar("clients");
                      try {
                        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
                        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          do {
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(33,49);to=(34,21)]
                            out.write("\r\n\t\t\t\t<option value = \"");

                          // end
                          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,21-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,55  LineMapIndex:2
                            /* ------  c:out ------ */
                            org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_0 = new org.apache.taglibs.standard.tag.el.core.OutTag();
                            _jspx_th_c_out_0.setPageContext(pageContext);
                            _jspx_th_c_out_0.setParent(_jspx_th_c_forEach_0);
                            _jspx_th_c_out_0.setValue("${clients.email}");
                            _jspxTagObjects.push(_jspx_th_c_out_0);
                              int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
                            // end
                            // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,21-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,55  LineMapIndex:3
                              if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(34,55);to=(34,58)]
                            out.write("\" >");

                          // end
                          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,58-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,91  LineMapIndex:4
                            /* ------  c:out ------ */
                            org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_1 = new org.apache.taglibs.standard.tag.el.core.OutTag();
                            _jspx_th_c_out_1.setPageContext(pageContext);
                            _jspx_th_c_out_1.setParent(_jspx_th_c_forEach_0);
                            _jspx_th_c_out_1.setValue("${clients.name}");
                            _jspxTagObjects.push(_jspx_th_c_out_1);
                              int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
                            // end
                            // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,58-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,91  LineMapIndex:5
                              if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(34,91);to=(34,92)]
                            out.write(",");

                          // end
                          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,92-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,129  LineMapIndex:6
                            /* ------  c:out ------ */
                            org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_2 = new org.apache.taglibs.standard.tag.el.core.OutTag();
                            _jspx_th_c_out_2.setPageContext(pageContext);
                            _jspx_th_c_out_2.setParent(_jspx_th_c_forEach_0);
                            _jspx_th_c_out_2.setValue("${clients.lastName}");
                            _jspxTagObjects.push(_jspx_th_c_out_2);
                              int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
                            // end
                            // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,92-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 35,129  LineMapIndex:7
                              if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(34,129);to=(35,3)]
                            out.write("</option>\r\n\t\t\t");

                          // end
                          // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 36,3-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 36,15  LineMapIndex:8
                          } while (_jspx_th_c_forEach_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                        }
                        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                          return;
                      } catch (Throwable _jspx_exception) {
                        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
                      } finally {
                        _jspx_th_c_forEach_0.doFinally();
                        _jspx_th_c_forEach_0.release();
                      }
                    // end
                    // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(35,15);to=(43,3)]
                      out.write("\r\n\t\t </td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t  \t<td>Por habitacion</td>\r\n\t  \t<td>\r\n\t  \t\t<select name=\"rooms\">\r\n\t\t\t<option value = Todos>Todos</option>\r\n\t\t\t");

                    // end
                    // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 44,3-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 44,48  LineMapIndex:9
                      /* ------  c:forEach ------ */
                      org.apache.taglibs.standard.tag.el.core.ForEachTag _jspx_th_c_forEach_1 = new org.apache.taglibs.standard.tag.el.core.ForEachTag();
                      _jspx_th_c_forEach_1.setPageContext(pageContext);
                      _jspx_th_c_forEach_1.setParent(null);
                      _jspx_th_c_forEach_1.setItems("${habitacion}");
                      _jspx_th_c_forEach_1.setVar("room");
                      try {
                        int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
                        if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                          do {
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(43,48);to=(44,21)]
                            out.write("\r\n\t\t\t\t<option value = \"");

                          // end
                          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,21-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,53  LineMapIndex:10
                            /* ------  c:out ------ */
                            org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_3 = new org.apache.taglibs.standard.tag.el.core.OutTag();
                            _jspx_th_c_out_3.setPageContext(pageContext);
                            _jspx_th_c_out_3.setParent(_jspx_th_c_forEach_1);
                            _jspx_th_c_out_3.setValue("${room.roomid}");
                            _jspxTagObjects.push(_jspx_th_c_out_3);
                              int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
                            // end
                            // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,21-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,53  LineMapIndex:11
                              if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(44,53);to=(44,56)]
                            out.write("\" >");

                          // end
                          // ##DEBUG## ##TAGLIB## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,56-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,98  LineMapIndex:12
                            /* ------  c:out ------ */
                            org.apache.taglibs.standard.tag.el.core.OutTag _jspx_th_c_out_4 = new org.apache.taglibs.standard.tag.el.core.OutTag();
                            _jspx_th_c_out_4.setPageContext(pageContext);
                            _jspx_th_c_out_4.setParent(_jspx_th_c_forEach_1);
                            _jspx_th_c_out_4.setValue("${room.briefdescription}");
                            _jspxTagObjects.push(_jspx_th_c_out_4);
                              int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
                            // end
                            // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,56-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 45,98  LineMapIndex:13
                              if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                                return;
                            ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                          // end
                          // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(44,98);to=(45,3)]
                            out.write("</option>\r\n\t\t\t");

                          // end
                          // ##DEBUG## "/jsp/hotelreserve/admin/RptGenStatistics.jsp" 46,3-"/jsp/hotelreserve/admin/RptGenStatistics.jsp" 46,15  LineMapIndex:14
                          } while (_jspx_th_c_forEach_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                        }
                        if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                          return;
                      } catch (Throwable _jspx_exception) {
                        _jspx_th_c_forEach_1.doCatch(_jspx_exception);
                      } finally {
                        _jspx_th_c_forEach_1.doFinally();
                        _jspx_th_c_forEach_1.release();
                      }
                    // end
                    // HTML // begin [file="/jsp/hotelreserve/admin/RptGenStatistics.jsp";from=(45,15);to=(53,0)]
                      out.write("\r\n\t\t </td>\r\n\t  </tr>\r\n\t  <tr>\r\n\t  \t<td><input type=\"submit\" value = \"Generar\" /></td>\r\n\t  </tr>\r\n</table>\r\n</form>\r\n");

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
                "/jsp/hotelreserve/admin/RptGenStatistics.jsp", 
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
                "0", 
                "0", 
                "0", 
                "0", 
                "0", 
                "0", 
                "0", 
                "0", 
                "0", 
                "0", 
                },
                {
                "1", 
                "34", 
                "35", 
                "35", 
                "35", 
                "35", 
                "35", 
                "35", 
                "36", 
                "44", 
                "45", 
                "45", 
                "45", 
                "45", 
                "46", 
                },
                };
              }
