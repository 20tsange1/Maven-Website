<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <html lang="en">

  <head>
    <jsp:include page="/meta.jsp" />
    <title>List Program</title>
  </head>

  <body>
    <jsp:include page="/header.jsp" />

    <body>
      <div class="containerChild">
      <% String url=(String) request.getAttribute("Url"); String picture=(String) request.getAttribute("Picture");
        Integer currentkey=(Integer) request.getAttribute("SendKey"); %>
        <h2>List: <%=request.getAttribute("ListName") %>
        </h2>
        <p>Key: <%=request.getAttribute("Key") %>
        </p>
        <p>Label: <%=request.getAttribute("Data") %>
        </p>
        <% if (!url.equals("null")) { %>
          <p>
            Url:
          </p>
          <a href="<%=url%>">
            <%=url%>
          </a>

        <% } %>
        
        <% if (!picture.equals("null")) { %>
          <p>
            Picture:
          </p>
          <img src="<%=picture%>">
        <% } %>

      </div>

      <div class="containerChild">
        <h1>Edit item in list</h1>
        <form method="POST" action="/editup.html">
          <input type="radio" name="ChangeItem" value="Url">
          Url
          <input type="radio" name="ChangeItem" value="Picture">
          Picture
          <input type="text" name="EditData" class="css-input" placeholder="Enter link"/>
          <input type="hidden" name="CurrentKey" value="<%=currentkey%>" />
          <input type="hidden" name="ListItem" value="<%=request.getAttribute("Key") %>" />
          <input type="submit" class="BUTTON_ALL" value="Enter" />
        </form>
      </div>
    </body>
    <jsp:include page="/footer.jsp" />

  </html>