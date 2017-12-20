package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;

/* File Declaration Phase */

public class _signin extends com.ibm.ws.webcontainer.jsp.runtime.HttpJspBase {

  /* Class Declaration Phase */

  static {
    /* Static Initializer Phase */
  }

  public _signin( ) {
  }

  private static boolean _jspx_inited = false;

  private static String _jspx_debug_jspSourceLocation = "/jsp/authentication/signin.jsp";

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
      /* ------  html:form ------ */
      org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = new org.apache.struts.taglib.html.FormTag();

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

                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(0,0);to=(1,0)]
                    out.write("\r\n");

                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(1,58);to=(2,0)]
                    out.write("\r\n");

                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(2,58);to=(3,0)]
                    out.write("\r\n");

                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(3,60);to=(4,0)]
                    out.write("\r\n");

                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(4,60);to=(5,0)]
                    out.write("\r\n");

                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(5,60);to=(22,8)]
                    out.write("\r\n\r\n\r\n\r\n<HEAD>\r\n<LINK rel=\"stylesheet\" href=\"/ElCocoWeb/css/adminStyle.css\"\r\n\ttype=\"text/css\">\r\n</HEAD>\r\n<TABLE border=\"0\" align=\"center\" width=\"300\">\r\n\t<TBODY>\r\n\t\t<TR>\r\n\t\t\t<TD colspan=\"2\" align=\"center\"><SPAN class=\"checkoutTitle\">sign in <SPAN\r\n\t\t\t\tclass=\"checkoutSubTitle\">|</SPAN></SPAN><SPAN\r\n\t\t\t\tclass=\"checkoutSubTitle\"> control panel</SPAN></TD></TR>\r\n\t\t<TR>\r\n\t\t\t<TD colspan=\"2\">\r\n\r\n<center>");

                  // end
                  // ##DEBUG## "/jsp/authentication/signin.jsp" 23,8-"/jsp/authentication/signin.jsp" 23,88  LineMapIndex:1
                    {
                      String _jspx_qStr = "";
                      JspRuntimeLibrary.include(request, response, "/jsp/framework/errormessages.jsp" + _jspx_qStr, out, true);
                      if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                    }
                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(22,88);to=(30,1)]
                    out.write(" </center>\r\n\t\t\t</TD>\r\n\t\t</TR>\r\n\t</TBODY>\r\n</TABLE>\r\n\t\r\n\t\t\t\t\r\n<TABLE align=\"center\" border=\"0\" style=\"border-color: #cccccc; border-width: thin; border-style: solid;\" width=\"300\">\r\n\t");

                  // end
                  // ##DEBUG## ##TAGLIB## "/jsp/authentication/signin.jsp" 31,1-"/jsp/authentication/signin.jsp" 31,46  LineMapIndex:2
                    _jspx_th_html_form_0.setPageContext(pageContext);
                    _jspx_th_html_form_0.setParent(null);
                    _jspx_th_html_form_0.setAction("signin.do");
                    _jspx_th_html_form_0.setFocus("userId");
                    _jspxTagObjects.push(_jspx_th_html_form_0);
                      int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
                      if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        do {
                        // end
                        // HTML // begin [file="/jsp/authentication/signin.jsp";from=(30,46);to=(51,4)]
                          out.write("\r\n\t<TBODY>\r\n\t\t<TR>\r\n\t\t\t<td colspan=\"3\" >\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t</td>\r\n\t\t</TR>\t\r\n\t\t<TR>\r\n\t\t\t<TD colspan=\"3\" style=\"background-color: #efefef;\" align=\"center\">\r\n\r\n\t\t\t<B>Please enter the information below</B>\r\n\t\t\t</TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<td rowspan=5>\r\n\t\t\t\t<img src=\"/ElCocoWeb/img/login.gif\">\r\n\t\t\t</td>\r\n\t\t</TR>\r\n\r\n\t\t<TR>\r\n\t\t\t<TD align=\"right\">\r\n\t\t\t\t");

                        // end
                        // ##DEBUG## ##TAGLIB## "/jsp/authentication/signin.jsp" 52,4-"/jsp/authentication/signin.jsp" 52,45  LineMapIndex:3
                          /* ------  logic:messagesPresent ------ */
                          org.apache.struts.taglib.logic.MessagesPresentTag _jspx_th_logic_messagesPresent_0 = new org.apache.struts.taglib.logic.MessagesPresentTag();
                          _jspx_th_logic_messagesPresent_0.setPageContext(pageContext);
                          _jspx_th_logic_messagesPresent_0.setParent(_jspx_th_html_form_0);
                          _jspx_th_logic_messagesPresent_0.setProperty("userId");
                          _jspxTagObjects.push(_jspx_th_logic_messagesPresent_0);
                            int _jspx_eval_logic_messagesPresent_0 = _jspx_th_logic_messagesPresent_0.doStartTag();
                            if (_jspx_eval_logic_messagesPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              do {
                              // end
                              // HTML // begin [file="/jsp/authentication/signin.jsp";from=(51,45);to=(51,85)]
                                out.write("<span class=\"daterror\">User name:</span>");

                              // end
                              // ##DEBUG## "/jsp/authentication/signin.jsp" 52,85-"/jsp/authentication/signin.jsp" 52,109  LineMapIndex:4
                              } while (_jspx_th_logic_messagesPresent_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            }
                            if (_jspx_th_logic_messagesPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                        // end
                        // HTML // begin [file="/jsp/authentication/signin.jsp";from=(51,109);to=(52,7)]
                          out.write("\r\n\t\t\t\t<B>");

                        // end
                        // ##DEBUG## ##TAGLIB## "/jsp/authentication/signin.jsp" 53,7-"/jsp/authentication/signin.jsp" 53,51  LineMapIndex:5
                          /* ------  logic:messagesNotPresent ------ */
                          org.apache.struts.taglib.logic.MessagesNotPresentTag _jspx_th_logic_messagesNotPresent_0 = new org.apache.struts.taglib.logic.MessagesNotPresentTag();
                          _jspx_th_logic_messagesNotPresent_0.setPageContext(pageContext);
                          _jspx_th_logic_messagesNotPresent_0.setParent(_jspx_th_html_form_0);
                          _jspx_th_logic_messagesNotPresent_0.setProperty("userId");
                          _jspxTagObjects.push(_jspx_th_logic_messagesNotPresent_0);
                            int _jspx_eval_logic_messagesNotPresent_0 = _jspx_th_logic_messagesNotPresent_0.doStartTag();
                            if (_jspx_eval_logic_messagesNotPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              do {
                              // end
                              // HTML // begin [file="/jsp/authentication/signin.jsp";from=(52,51);to=(52,61)]
                                out.write("User name:");

                              // end
                              // ##DEBUG## "/jsp/authentication/signin.jsp" 53,61-"/jsp/authentication/signin.jsp" 53,88  LineMapIndex:6
                              } while (_jspx_th_logic_messagesNotPresent_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            }
                            if (_jspx_th_logic_messagesNotPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                        // end
                        // HTML // begin [file="/jsp/authentication/signin.jsp";from=(52,88);to=(55,4)]
                          out.write("</B>\t\t\t\t\r\n\t\t\t</TD>\r\n\t\t\t<TD>\t\t\t\t\r\n\t\t\t\t");

                        // end
                        // ##DEBUG## ##TAGLIB## "/jsp/authentication/signin.jsp" 56,4-"/jsp/authentication/signin.jsp" 56,45  LineMapIndex:7
                          /* ------  html:text ------ */
                          org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = new org.apache.struts.taglib.html.TextTag();
                          _jspx_th_html_text_0.setPageContext(pageContext);
                          _jspx_th_html_text_0.setParent(_jspx_th_html_form_0);
                          _jspx_th_html_text_0.setProperty("userId");
                          _jspx_th_html_text_0.setSize("35");
                          _jspxTagObjects.push(_jspx_th_html_text_0);
                            int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
                          // end
                          // ##DEBUG## "/jsp/authentication/signin.jsp" 56,4-"/jsp/authentication/signin.jsp" 56,45  LineMapIndex:8
                            if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                        // end
                        // HTML // begin [file="/jsp/authentication/signin.jsp";from=(55,45);to=(60,4)]
                          out.write("\t\t\t\t\r\n\t\t\t</TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD align=\"right\">\r\n\t\t\t\t");

                        // end
                        // ##DEBUG## ##TAGLIB## "/jsp/authentication/signin.jsp" 61,4-"/jsp/authentication/signin.jsp" 61,48  LineMapIndex:9
                          /* ------  logic:messagesPresent ------ */
                          org.apache.struts.taglib.logic.MessagesPresentTag _jspx_th_logic_messagesPresent_1 = new org.apache.struts.taglib.logic.MessagesPresentTag();
                          _jspx_th_logic_messagesPresent_1.setPageContext(pageContext);
                          _jspx_th_logic_messagesPresent_1.setParent(_jspx_th_html_form_0);
                          _jspx_th_logic_messagesPresent_1.setProperty("password");
                          _jspxTagObjects.push(_jspx_th_logic_messagesPresent_1);
                            int _jspx_eval_logic_messagesPresent_1 = _jspx_th_logic_messagesPresent_1.doStartTag();
                            if (_jspx_eval_logic_messagesPresent_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              do {
                              // end
                              // HTML // begin [file="/jsp/authentication/signin.jsp";from=(60,48);to=(60,87)]
                                out.write("<span class=\"daterror\">Password:</span>");

                              // end
                              // ##DEBUG## "/jsp/authentication/signin.jsp" 61,87-"/jsp/authentication/signin.jsp" 61,111  LineMapIndex:10
                              } while (_jspx_th_logic_messagesPresent_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            }
                            if (_jspx_th_logic_messagesPresent_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                        // end
                        // HTML // begin [file="/jsp/authentication/signin.jsp";from=(60,111);to=(61,7)]
                          out.write("\r\n\t\t\t\t<B>");

                        // end
                        // ##DEBUG## ##TAGLIB## "/jsp/authentication/signin.jsp" 62,7-"/jsp/authentication/signin.jsp" 62,53  LineMapIndex:11
                          /* ------  logic:messagesNotPresent ------ */
                          org.apache.struts.taglib.logic.MessagesNotPresentTag _jspx_th_logic_messagesNotPresent_1 = new org.apache.struts.taglib.logic.MessagesNotPresentTag();
                          _jspx_th_logic_messagesNotPresent_1.setPageContext(pageContext);
                          _jspx_th_logic_messagesNotPresent_1.setParent(_jspx_th_html_form_0);
                          _jspx_th_logic_messagesNotPresent_1.setProperty("password");
                          _jspxTagObjects.push(_jspx_th_logic_messagesNotPresent_1);
                            int _jspx_eval_logic_messagesNotPresent_1 = _jspx_th_logic_messagesNotPresent_1.doStartTag();
                            if (_jspx_eval_logic_messagesNotPresent_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                              do {
                              // end
                              // HTML // begin [file="/jsp/authentication/signin.jsp";from=(61,53);to=(61,62)]
                                out.write("Password:");

                              // end
                              // ##DEBUG## "/jsp/authentication/signin.jsp" 62,62-"/jsp/authentication/signin.jsp" 62,89  LineMapIndex:12
                              } while (_jspx_th_logic_messagesNotPresent_1.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                            }
                            if (_jspx_th_logic_messagesNotPresent_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                              return;
                          ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                        // end
                        // HTML // begin [file="/jsp/authentication/signin.jsp";from=(61,89);to=(85,0)]
                          out.write("</B>\r\n\t\t\t</TD>\r\n\t\t\t<TD><INPUT type=\"password\" name=\"password\" size=\"35\"></TD>\r\n\t\t</TR>\r\n\t\t\r\n\t\t<TR>\t\t\r\n\t\t\t<TD></TD>\r\n\t\t\t<TD>\r\n\t\t\t\t<INPUT type=\"image\" name=\"continue\" src=\"/ElCocoWeb/img/singin.jpg\" onclick=\"this.form.submit();\" >\r\n\t\t\t</TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD></TD>\r\n\t\t\t<TD>Forgot your password? <A href=\"/ElCocoWeb/admin/showforgotpwd.do\">Click here</A>.<BR>\r\n\t\t\t</TD>\r\n\t\t</TR>\r\n\t\t<TR>\r\n\t\t\t<TD></TD>\r\n\t\t\t<td></td>\r\n\t\t\t<TD><a href=\"http://realtynica.com/cgi-bin/openwebmail/openwebmail.pl\">Check your Email</TD>\r\n\t\t</TR>\r\n\t</TBODY>\r\n</TABLE>\r\n\t\t\t\r\n");

                        // end
                        // ##DEBUG## "/jsp/authentication/signin.jsp" 86,0-"/jsp/authentication/signin.jsp" 86,12  LineMapIndex:13
                        } while (_jspx_th_html_form_0.doAfterBody() == javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN);
                      }
                      if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                        return;
                    ((javax.servlet.jsp.tagext.Tag)_jspxTagObjects.pop()).release();
                  // end
                  // HTML // begin [file="/jsp/authentication/signin.jsp";from=(85,12);to=(94,0)]
                    out.write("\r\n\t\t\t\r\n\t\t<center><SPAN> Go to <a href=\"http://www.playaelcoco.com.ni\">playaelcoco.com.ni</a></SPAN></center>\r\n\t\t\t\t\r\n\t\t\t</TD></TR>\r\n\t</TBODY>\r\n</TABLE>\r\n\r\n\r\n");

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
              "/jsp/authentication/signin.jsp", 
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
              },
              {
              "1", 
              "23", 
              "31", 
              "52", 
              "52", 
              "53", 
              "53", 
              "56", 
              "56", 
              "61", 
              "61", 
              "62", 
              "62", 
              "86", 
              },
              };
            }
