<%@ page import="java.util.List" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>

    <head>
      <jsp:include page="/meta.jsp" />
      <title>List Program</title>
    </head>

    <body>
      <jsp:include page="/header.jsp" />
      <div class="container">
        <div class="containerChild">
          <% Integer currentkey=(Integer) request.getAttribute("SendKey"); %>
            <h2>
              <%=request.getAttribute("Name")%>
            </h2>
            <ul>
              <% List<String> data = (List<String>) request.getAttribute("Data");
                  List<Integer> key = (List<Integer>) request.getAttribute("Key");
                  List<Integer> keyList = (List<Integer>) request.getAttribute("KeyList");
                          for (int i = 0; i < data.size(); i++) { String href="itemdata.html" ; %>
                            <li>
                              <% if (keyList.get(i) == -1) { %>
                                <form method="POST" action="/viewitem.html">
                                  <%=key.get(i)%>.
                                    <button name="ListItem" class="BUTTON_ALL" value="<%=key.get(i)%>">
                                      <%=data.get(i)%>
                                    </button>
                                    <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
                                </form>
                                <% } else { %>
                                  <form method="POST" action="/list.html">
                                    <%=key.get(i)%>.
                                      <button name="CurrentKey" class="BUTTON_ALL" value="<%=keyList.get(i)%>">
                                        <%=data.get(i)%>
                                      </button>
                                  </form>
                                  <% } %>

                            </li>
                            <% } %>
            </ul>
        </div>
        <div class="containerChild">
          <h1>Change list name</h1>
          <form method="POST" action="/edititem.html">
            <input type="text" name="ListName" class="css-input" placeholder="Enter new name" />
            <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
            <input type="hidden" name="EditType" value="Name" />
            <input type="submit" class="BUTTON_ALL" value="Enter" />
          </form>
          <h1>Add item to list</h1>
          <form method="POST" action="/edititem.html">
            <input type="text" name="Content" class="css-input" placeholder="Enter new item" />
            <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
            <input type="hidden" name="EditType" value="Add" />
            <input type="submit" class="BUTTON_ALL" value="Enter" />
          </form>
          <h1>Add list to list</h1>
          <form method="POST" action="/edititem.html">
            <input type="text" name="Content" class="css-input" placeholder="Enter new list" />
            <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
            <input type="hidden" name="EditType" value="AddList" />
            <input type="submit" class="BUTTON_ALL" value="Enter" />
          </form>
          <h1>Delete item from list</h1>
          <form method="POST" action="/edititem.html">
            <input type="text" name="Delete" class="css-input" placeholder="Enter a key" />
            <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
            <input type="hidden" name="EditType" value="Delete" />
            <input type="submit" class="BUTTON_ALL" value="Enter" />
          </form>
          <h1>Edit item in list</h1>
          <form method="POST" action="/edititem.html">
            <input type="text" name="EditKey" class="css-input" placeholder="Enter a key" />
            <input type="text" name="EditData" class="css-input" placeholder="Enter Label" />
            <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
            <input type="hidden" name="EditType" value="Edit" />
            <input type="submit" class="BUTTON_ALL" value="Enter" />
          </form>
          <h1>Delete List</h1>
          <form method="POST" action="/editList.html">
            <button name="CurrentKey" class="BUTTON_ALL" value="<%=currentkey%>">Delete</button>
            <input type="hidden" name="ListAction" value="Delete" />
          </form>
        </div>
      </div>
      <jsp:include page="/footer.jsp" />
    </body>

    </html>