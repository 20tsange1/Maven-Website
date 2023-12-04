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

@WebServlet("/list.html")
public class ViewItemListServlet extends HttpServlet
{

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {

    Model model = ModelFactory.getModel();
  
    Integer currentKey = Integer.parseInt(request.getParameter("CurrentKey"));
  
    // Getting all list information and setting it to JSP attributes.
    String name = model.lists.findNode(currentKey).getData().getName();
    List<Integer> key = model.getListKey(currentKey);
    List<String> data = model.getListData(currentKey);
    List<Integer> keyList = model.getListKeyList(currentKey);

    request.setAttribute("Data", data);
    request.setAttribute("Key", key);
    request.setAttribute("KeyList", keyList);
    request.setAttribute("Name", name);
    request.setAttribute("SendKey", currentKey);

    // Redirecting to the list JSP.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/list.jsp");
    dispatch.forward(request, response);
  }
}
