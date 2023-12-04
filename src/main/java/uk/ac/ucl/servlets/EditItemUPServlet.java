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

@WebServlet("/editup.html")
public class EditItemUPServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Model model = ModelFactory.getModel();

    Integer currentKey = Integer.parseInt(request.getParameter("CurrentKey"));

    String editdata = "";

    // Checking if the request is empty
    if (request.getParameter("EditData") == null || request.getParameter("EditData").equals("")) {
      editdata = "null";
    }
    else {
      editdata = request.getParameter("EditData");
    }

    // Changing either the URL or the picture
    if (request.getParameter("ChangeItem") != null) {
      if (request.getParameter("ChangeItem").equals("Url")) {
          model.lists.findNode(currentKey).getData().changeUrl(Integer.parseInt(request.getParameter("ListItem")),
              editdata);
        }
      else if (request.getParameter("ChangeItem").equals("Picture")) {
          model.lists.findNode(currentKey).getData().changePicture(Integer.parseInt(request.getParameter("ListItem")),
              editdata);
        }
      }

    // Setting JSP variables.
    String value = model.lists.findNode(currentKey).getData()
        .findNode(Integer.parseInt(request.getParameter("ListItem"))).getData();
    String url = model.lists.findNode(currentKey).getData().findNode(Integer.parseInt(request.getParameter("ListItem")))
        .getUrl();
    String picture = model.lists.findNode(currentKey).getData()
        .findNode(Integer.parseInt(request.getParameter("ListItem"))).getPicture();
    String listName = model.lists.findNode(currentKey).getData().getName();

    request.setAttribute("Data", value);
    request.setAttribute("Url", url);
    request.setAttribute("Picture", picture);
    request.setAttribute("Key", request.getParameter("ListItem"));
    request.setAttribute("ListName", listName);
    request.setAttribute("SendKey", currentKey);

    // Exporting list everytime so every edit is saved.
    model.exportLists();

    // Redirecting back to itemdata JSP page. So it seems as though the edit was made instantly.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/itemdata.jsp");
    dispatch.forward(request, response);
  }}
