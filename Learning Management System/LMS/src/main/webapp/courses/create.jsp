<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Create Course - LearnSphere</title></head>
<body>
  <h2>Create Course</h2>
  <form method="post" action="/learnsphere/courses/create">
    Title: <input name="title"/><br/>
    Description: <textarea name="description"></textarea><br/>
    Price: <input name="price" type="number" step="0.01" value="0.00"/><br/>
    <button type="submit">Create</button>
  </form>
</body></html>
