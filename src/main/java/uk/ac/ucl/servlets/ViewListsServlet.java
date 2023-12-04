package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/makeList.html")
public class ViewListsServlet extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {

    Model model = ModelFactory.getModel();


    // Setting JSP attributes.
    List<Integer> key = model.getKeys();
    List<String> names = model.getNames();

    request.setAttribute("ListKey", key);
    request.setAttribute("ListName", names);

    // Redirecting to JSP which displays all lists.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/makeList.jsp");
    dispatch.forward(request, response);
  }
}
