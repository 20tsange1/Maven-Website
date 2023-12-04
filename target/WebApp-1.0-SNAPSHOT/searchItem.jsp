<%@ page import="java.util.List" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>

    <head>
      <jsp:include page="/meta.jsp" />
      <title>List program</title>
    </head>

    <body>

      <jsp:include page="/header.jsp" />

      <div class="main">
        <div class="containerChild">
        <h2>Lists</h2>
        <ul>
          <% List<String> listName = (List<String>) request.getAttribute("ListName");
              List<Integer> listKey = (List<Integer>) request.getAttribute("ListKey");
                  if (listKey.size() > 0) {
                  for (int i = 0; i < listKey.size(); i++) { %>
                    <li>
                      <form method="POST" action="/list.html">
                        <button name="CurrentKey" class="BUTTON_ALL" value="<%=listKey.get(i)%>">
                          <%=listName.get(i)%>
                        </button>
                      </form>

                    </li>
                    <% } }%>
        </ul>
        <h2>Items in List</h2>
        <ul>
          <% List<String> itemData = (List<String>) request.getAttribute("ItemData");
              List<Integer> itemListKey = (List<Integer>) request.getAttribute("ItemListKey");
                  List<Integer> itemKey = (List<Integer>) request.getAttribute("ItemKey");

                      if (itemListKey.size() > 0) {
                      for (int i = 0; i < itemListKey.size(); i++) { %>
                        <li>
                          <form method="POST" action="/viewitem.html">
                            <button name="CurrentKey" class="BUTTON_ALL" value="<%=itemListKey.get(i)%>">
                              <%=itemData.get(i)%>
                            </button>
                            <input name="ListItem" type="hidden" value="<%=itemKey.get(i)%>" />
                          </form>
                        </li>
                        <% } }%>
        </ul>
      </div>
    <div class="containerChild">
        <form method="POST" action="/searchitem.html">
          <input type="text" name="SearchString" class="css-input" placeholder="Enter search query here" />
          <input type="submit" class="BUTTON_ALL" value="Search" />
        </form>
      </div>
      </div>
      <jsp:include page="/footer.jsp" />
    </body>

    </html>