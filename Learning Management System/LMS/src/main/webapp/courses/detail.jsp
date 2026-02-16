<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.learnsphere.model.Course"%>
<html>
<head><title>Course Detail - LearnSphere</title></head>
<body>
  <% Course c = (Course) request.getAttribute("course"); 
     if (c != null) { %>
    <h2><%=c.getTitle()%></h2>
    <p>Instructor: <%=c.getInstructorName()%></p>
    <p><%=c.getDescription()%></p>
    <form method="post" action="/learnsphere/enroll">
      <input type="hidden" name="courseId" value="<%=c.getId()%>"/>
      <button type="submit">Enroll</button>
    </form>
  <% } else { %>
    <p>Course not found.</p>
  <% } %>
</body>
</html>
