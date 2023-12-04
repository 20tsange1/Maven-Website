<%@ page import="java.util.List" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>

    <head>
      <jsp:include page="/meta.jsp" />
      <title>List program</title>
    </head>

    <body>

      <jsp:include page="/header.jsp" />

      <div class="container">
        <div class="containerChild">
          <ul>
            <% List<String> names = (List<String>) request.getAttribute("ListName");
                List<Integer> keys = (List<Integer>) request.getAttribute("ListKey");
                    for (int i = 0; i < names.size(); i++) { String href="list.html" ; %>
                      <li>
                        <form method="POST" action="/list.html">
                          <%=keys.get(i)%>.
                            <button name="CurrentKey" class="BUTTON_ALL" value="<%=keys.get(i)%>">
                              <%=names.get(i)%>
                            </button>
                        </form>

                      </li>
                      <% } %>
          </ul>
        </div>
        <div class="containerChild">
          <h1>Add New List</h1>
          <form method="POST" action="/editList.html">
            <input type="text" name="NewListName" class="css-input" placeholder="Enter list name here" />
            <input type="hidden" name="ListAction" value="Add" />
            <input type="submit" class="BUTTON_ALL" value="Create" />
          </form>
          <h1>Search</h1>
          <form method="POST" action="/searchitem.html">
            <input type="text" name="SearchString" class="css-input" placeholder="Enter search query here" />
            <input type="submit" class="BUTTON_ALL" value="Search" />
          </form>
        </div>
      </div>
      <jsp:include page="/footer.jsp" />
    </body>

    </html>