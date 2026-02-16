<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Register - LearnSphere</title></head>
<body>
  <h2>Register</h2>
  <form method="post" action="/learnsphere/auth/register">
    Name: <input type="text" name="name" required/><br/>
    Email: <input type="email" name="email" required/><br/>
    Password: <input type="password" name="password" required/><br/>
    Role: <select name="role"><option>STUDENT</option><option>INSTRUCTOR</option></select><br/>
    <button type="submit">Register</button>
  </form>
</body></html>
