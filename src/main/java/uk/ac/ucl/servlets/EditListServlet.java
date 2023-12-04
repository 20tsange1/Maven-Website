package uk.ac.ucl.servlets;

import uk.ac.ucl.necessities.LinkedList;
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

@WebServlet("/editList.html")
public class EditListServlet extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    Model model = ModelFactory.getModel();

    // Adding or Deleting list
    if (request.getParameter("ListAction") != null) {
      switch (request.getParameter("ListAction")) {

        case ("Add"):
          model.lists.addNode(model.lists.getKeyCount(), new LinkedList<String>(request.getParameter("NewListName")));
          break;

        case ("Delete"):
          model.lists.deleteNode(Integer.parseInt(request.getParameter("CurrentKey")));
          break;

      }
    }

    // Setting JSP variables.
    List<Integer> key = model.getKeys();
    List<String> names = model.getNames();

    request.setAttribute("ListKey", key);
    request.setAttribute("ListName", names);

    // Exporting the list everytime so that edits are saved.
    model.exportLists();

    // Redirecting back to makeList JSP page. So it seems as though the edit was made instantly.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/makeList.jsp");
    dispatch.forward(request, response);
  }
}
