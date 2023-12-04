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

@WebServlet("/viewitem.html")
public class ViewItemServlet extends HttpServlet
{

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {

    Model model = ModelFactory.getModel();

    Integer currentKey = Integer.parseInt(request.getParameter("CurrentKey"));


    // Setting JSP attributes.
    String value = model.lists.findNode(currentKey).getData().findNode(Integer.parseInt(request.getParameter("ListItem"))).getData();
    String url = model.lists.findNode(currentKey).getData().findNode(Integer.parseInt(request.getParameter("ListItem"))).getUrl();
    String picture = model.lists.findNode(currentKey).getData().findNode(Integer.parseInt(request.getParameter("ListItem"))).getPicture();
    String listName = model.lists.findNode(currentKey).getData().getName();
    
    request.setAttribute("Data", value);
    request.setAttribute("Url", url);
    request.setAttribute("Picture", picture);
    request.setAttribute("Key", request.getParameter("ListItem"));
    request.setAttribute("ListName", listName);
    request.setAttribute("SendKey", currentKey);


    // Redirecting to itemdata JSP, displays item.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/itemdata.jsp");
    dispatch.forward(request, response);
  }
}
