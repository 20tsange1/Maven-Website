package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.necessities.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/edititem.html")
public class EditItemServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    Model model = ModelFactory.getModel();

    Integer currentKey = Integer.parseInt(request.getParameter("CurrentKey"));

    // Choosing between different types of edits
    switch (request.getParameter("EditType")) {
      case ("Name"):
      model.changeName(currentKey, request.getParameter("ListName"));
      break;
      case ("Add"):
      model.lists.findNode(currentKey).getData().addNode(model.lists.findNode(currentKey).getData().getKeyCount(), request.getParameter("Content"));
      break;
      // The list which is created is also displayed makeList.jsp as it is created in the main list. However, this serves as a reference.
      case ("AddList"):
      model.lists.addNode(model.lists.getKeyCount(), new LinkedList<String>(request.getParameter("Content")));
      model.lists.findNode(currentKey).getData().addNode(model.lists.findNode(currentKey).getData().getKeyCount(), request.getParameter("Content"), model.lists.getKeyCount()-1);
      break;
      case ("Delete"):
      model.lists.findNode(currentKey).getData().deleteNode(Integer.parseInt(request.getParameter("Delete")));
      break;
      case("Edit"):
      model.lists.findNode(currentKey).getData().changeNode(Integer.parseInt(request.getParameter("EditKey")),request.getParameter("EditData"));
      if (model.lists.findNode(currentKey).getData().findNode(Integer.parseInt(request.getParameter("EditKey"))).getKeyList() != -1) {
        model.lists.findNode(model.lists.findNode(currentKey).getData().findNode(Integer.parseInt(request.getParameter("EditKey"))).getKeyList()).getData().changeName(request.getParameter("EditData"));
      }
      break;
    }

    // Setting JSP variables.
    String name = model.lists.findNode(currentKey).getData().getName();
    List<Integer> key = model.getListKey(currentKey);
    List<String> data = model.getListData(currentKey);
    List<Integer> keyList = model.getListKeyList(currentKey);
    
    request.setAttribute("Data", data);
    request.setAttribute("Key", key);
    request.setAttribute("KeyList", keyList);
    request.setAttribute("Name", name);
    request.setAttribute("SendKey", currentKey);


    // Exporting Lists everytime a command is run
    model.exportLists();

    // Redirecting back to list JSP page. So it seems as though the edit was made instantly.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/list.jsp");
    dispatch.forward(request, response);
  }
}
