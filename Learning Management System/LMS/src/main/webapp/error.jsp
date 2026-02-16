<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Error</title></head><body>
  <h2>An error occurred</h2>
  <p><%= exception == null ? "Unknown error" : exception.getMessage() %></p>
</body></html>
