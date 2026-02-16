<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.learnsphere.model.Course"%>
<html>
<head><title>Courses - LearnSphere</title></head>
<body>
  <h2>All Courses</h2>
  <% List<Course> courses = (List<Course>) request.getAttribute("courses"); 
     if (courses != null) {
       for (Course c : courses) { %>
         <div><a href="/learnsphere/courses/view?id=<%=c.getId()%>"><%=c.getTitle()%></a> - <%=c.getInstructorName()%></div>
  <% } } else { %>
    <p>No courses.</p>
  <% } %>
</body>
</html>
