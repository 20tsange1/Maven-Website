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

@WebServlet("/searchitem.html")
public class SearchItemServlet extends HttpServlet
{

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {

    Model model = ModelFactory.getModel();

    // Setting JSP variables
    // Searches for search string regardless of case.
    List<String> listName = model.searchForName(request.getParameter("SearchString").toLowerCase());
    List<Integer> listKey = model.searchForKey(request.getParameter("SearchString").toLowerCase());

    List<String> itemData = model.searchForItemData(request.getParameter("SearchString").toLowerCase());
    List<Integer> itemListKey = model.searchForListKey(request.getParameter("SearchString").toLowerCase());
    List<Integer> itemKey = model.searchForItemKey(request.getParameter("SearchString").toLowerCase());

    request.setAttribute("ListName", listName);
    request.setAttribute("ListKey", listKey);
    request.setAttribute("ItemData", itemData);
    request.setAttribute("ItemListKey", itemListKey);
    request.setAttribute("ItemKey", itemKey);

    // Redirecting to page where searched items appear.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/searchItem.jsp");
    dispatch.forward(request, response);
  }
}
