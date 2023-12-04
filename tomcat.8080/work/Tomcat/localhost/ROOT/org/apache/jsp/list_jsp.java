/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2023-03-28 21:15:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("    <html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/meta.jsp", out, false);
      out.write("\n");
      out.write("      <title>List Program</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"containerChild\">\n");
      out.write("          ");
 Integer currentkey=(Integer) request.getAttribute("SendKey"); 
      out.write("\n");
      out.write("            <h2>\n");
      out.write("              ");
      out.print(request.getAttribute("Name"));
      out.write("\n");
      out.write("            </h2>\n");
      out.write("            <ul>\n");
      out.write("              ");
 List<String> data = (List<String>) request.getAttribute("Data");
                  List<Integer> key = (List<Integer>) request.getAttribute("Key");
                  List<Integer> keyList = (List<Integer>) request.getAttribute("KeyList");
                          for (int i = 0; i < data.size(); i++) { String href="itemdata.html" ; 
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                              ");
 if (keyList.get(i) == -1) { 
      out.write("\n");
      out.write("                                <form method=\"POST\" action=\"/viewitem.html\">\n");
      out.write("                                  ");
      out.print(key.get(i));
      out.write(".\n");
      out.write("                                    <button name=\"ListItem\" class=\"BUTTON_ALL\" value=\"");
      out.print(key.get(i));
      out.write("\">\n");
      out.write("                                      ");
      out.print(data.get(i));
      out.write("\n");
      out.write("                                    </button>\n");
      out.write("                                    <input type=\"hidden\" name=\"CurrentKey\" value=\"");
      out.print(currentkey);
      out.write("\" />\n");
      out.write("                                </form>\n");
      out.write("                                ");
 } else { 
      out.write("\n");
      out.write("                                  <form method=\"POST\" action=\"/list.html\">\n");
      out.write("                                    ");
      out.print(key.get(i));
      out.write(".\n");
      out.write("                                      <button name=\"CurrentKey\" class=\"BUTTON_ALL\" value=\"");
      out.print(keyList.get(i));
      out.write("\">\n");
      out.write("                                        ");
      out.print(data.get(i));
      out.write("\n");
      out.write("                                      </button>\n");
      out.write("                                  </form>\n");
      out.write("                                  ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            </li>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"containerChild\">\n");
      out.write("          <h1>Change list name</h1>\n");
      out.write("          <form method=\"POST\" action=\"/edititem.html\">\n");
      out.write("            <input type=\"text\" name=\"ListName\" class=\"css-input\" placeholder=\"Enter new name\" />\n");
      out.write("            <input type=\"hidden\" name=\"CurrentKey\" value=\"");
      out.print(currentkey);
      out.write("\" />\n");
      out.write("            <input type=\"hidden\" name=\"EditType\" value=\"Name\" />\n");
      out.write("            <input type=\"submit\" class=\"BUTTON_ALL\" value=\"Enter\" />\n");
      out.write("          </form>\n");
      out.write("          <h1>Add item to list</h1>\n");
      out.write("          <form method=\"POST\" action=\"/edititem.html\">\n");
      out.write("            <input type=\"text\" name=\"Content\" class=\"css-input\" placeholder=\"Enter new item\" />\n");
      out.write("            <input type=\"hidden\" name=\"CurrentKey\" value=\"");
      out.print(currentkey);
      out.write("\" />\n");
      out.write("            <input type=\"hidden\" name=\"EditType\" value=\"Add\" />\n");
      out.write("            <input type=\"submit\" class=\"BUTTON_ALL\" value=\"Enter\" />\n");
      out.write("          </form>\n");
      out.write("          <h1>Add list to list</h1>\n");
      out.write("          <form method=\"POST\" action=\"/edititem.html\">\n");
      out.write("            <input type=\"text\" name=\"Content\" class=\"css-input\" placeholder=\"Enter new list\" />\n");
      out.write("            <input type=\"hidden\" name=\"CurrentKey\" value=\"");
      out.print(currentkey);
      out.write("\" />\n");
      out.write("            <input type=\"hidden\" name=\"EditType\" value=\"AddList\" />\n");
      out.write("            <input type=\"submit\" class=\"BUTTON_ALL\" value=\"Enter\" />\n");
      out.write("          </form>\n");
      out.write("          <h1>Delete item from list</h1>\n");
      out.write("          <form method=\"POST\" action=\"/edititem.html\">\n");
      out.write("            <input type=\"text\" name=\"Delete\" class=\"css-input\" placeholder=\"Enter a key\" />\n");
      out.write("            <input type=\"hidden\" name=\"CurrentKey\" value=\"");
      out.print(currentkey);
      out.write("\" />\n");
      out.write("            <input type=\"hidden\" name=\"EditType\" value=\"Delete\" />\n");
      out.write("            <input type=\"submit\" class=\"BUTTON_ALL\" value=\"Enter\" />\n");
      out.write("          </form>\n");
      out.write("          <h1>Edit item in list</h1>\n");
      out.write("          <form method=\"POST\" action=\"/edititem.html\">\n");
      out.write("            <input type=\"text\" name=\"EditKey\" class=\"css-input\" placeholder=\"Enter a key\" />\n");
      out.write("            <input type=\"text\" name=\"EditData\" class=\"css-input\" placeholder=\"Enter Label\" />\n");
      out.write("            <input type=\"hidden\" name=\"CurrentKey\" value=\"");
      out.print(currentkey);
      out.write("\" />\n");
      out.write("            <input type=\"hidden\" name=\"EditType\" value=\"Edit\" />\n");
      out.write("            <input type=\"submit\" class=\"BUTTON_ALL\" value=\"Enter\" />\n");
      out.write("          </form>\n");
      out.write("          <h1>Delete List</h1>\n");
      out.write("          <form method=\"POST\" action=\"/editList.html\">\n");
      out.write("            <button name=\"CurrentKey\" class=\"BUTTON_ALL\" value=\"");
      out.print(currentkey);
      out.write("\">Delete</button>\n");
      out.write("            <input type=\"hidden\" name=\"ListAction\" value=\"Delete\" />\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}