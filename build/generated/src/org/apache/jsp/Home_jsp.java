package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \n");
      out.write("\t\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("\t\t<title> My first JSP   </title>\n");
      out.write("                <style>\n");
      out.write("* {box-sizing: border-box;}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("  margin: 0;\n");
      out.write("  font-family: Arial, Helvetica, sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav {\n");
      out.write("  overflow: hidden;\n");
      out.write("  background-color: #e9e9e9;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav a {\n");
      out.write("  float: left;\n");
      out.write("  display: block;\n");
      out.write("  color: black;\n");
      out.write("  text-align: center;\n");
      out.write("  padding: 14px 16px;\n");
      out.write("  text-decoration: none;\n");
      out.write("  font-size: 17px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav a:hover {\n");
      out.write("  background-color: #ddd;\n");
      out.write("  color: black;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav a.active {\n");
      out.write("  background-color: #2196F3;\n");
      out.write("  color: white;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".topnav input[type=text] {\n");
      out.write("  float: right;\n");
      out.write("  padding: 6px;\n");
      out.write("  margin-top: 8px;\n");
      out.write("  margin-right: 16px;\n");
      out.write("  border: none;\n");
      out.write("  font-size: 17px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("@media screen and (max-width: 600px) {\n");
      out.write("  .topnav a, .topnav input[type=text] {\n");
      out.write("    float: none;\n");
      out.write("    display: block;\n");
      out.write("    text-align: left;\n");
      out.write("    width: 100%;\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 14px;\n");
      out.write("  }\n");
      out.write("  .topnav input[type=text] {\n");
      out.write("    border: 1px solid #ccc;  \n");
      out.write("  }\n");
      out.write("}\n");
      out.write("input[type=text] {\n");
      out.write("    width: 130px;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("    border: 2px solid #ccc;\n");
      out.write("    border-radius: 4px;\n");
      out.write("    font-size: 16px;\n");
      out.write("    background-color: white;\n");
      out.write("    background-image: url('searchicon.png');\n");
      out.write("    background-position: 10px 10px; \n");
      out.write("    background-repeat: no-repeat;\n");
      out.write("    padding: 12px 20px 12px 40px;\n");
      out.write("    -webkit-transition: width 0.4s ease-in-out;\n");
      out.write("    transition: width 0.4s ease-in-out;\n");
      out.write("}\n");
      out.write("input[type=text]:focus {\n");
      out.write("    width: 60%;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\t</head>\t\n");
      out.write("\t<body>\t\t\n");
      out.write("\t\t<form action=\"HelloServlet\">\t\t\t\n");
      out.write("\t\t\t Please enter search string <br>\n");
      out.write("\t\t\t<input type=\"text\" name=\"color\"size=\"20px\">\n");
      out.write("\t\t\t<input type=\"submit\" value=\"submit\">\t\t\t\t\t\t\n");
      out.write("\t\t</form>\t\t\n");
      out.write("\t</body>\t\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
