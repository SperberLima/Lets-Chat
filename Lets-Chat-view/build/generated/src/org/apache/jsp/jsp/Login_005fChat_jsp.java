package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import letschat.servlet.Logar;

public final class Login_005fChat_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"windows-1252\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        <style>\r\n");
      out.write("            @import url(\"..\\\\css\\\\login.css\");\r\n");
      out.write("        </style>\r\n");
      out.write("        <!--<script type=\"text/javascript\" language=\"JavaScript\" src=\"../javascripts/valida.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("        -->\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    ");

        String msg = request.getParameter("msg") ;
        String nome = request.getParameter("nome");
        if(nome == null) {
        }
        else if ( (nome.matches("([^<|>|\\n]){1,40}")) ) {
            request.setAttribute("nome", nome );
            Logar.execute(request);
        } 
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class = \"meio\" >\r\n");
      out.write("            <form name=\"frmLogar\" method=\"POST\">\r\n");
      out.write("                <div class = \"nome\">\r\n");
      out.write("                    Nome:\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <span id=\"txt\" style=\"font-size:12px;\">");
      out.print( (msg==null) ? "" : msg );
      out.write("</span>\r\n");
      out.write("                </div> \r\n");
      out.write("                <div class = \"txt\">\r\n");
      out.write("                    <input size = \"20\" id=\"nome\" class = \"cmp_txt\" />\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class = \"btn\">\r\n");
      out.write("                    <input type=\"submit\" class = \"submit\" value=\"Enviar\"  />\r\n");
      out.write("                </div>\t\t\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
