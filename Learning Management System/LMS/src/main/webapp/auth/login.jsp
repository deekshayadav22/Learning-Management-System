<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Login - LearnSphere</title></head>
<body>
  <h2>Login</h2>
  <form method="post" action="/learnsphere/auth/login">
    Email: <input type="email" name="email" required/><br/>
    Password: <input type="password" name="password" required/><br/>
    <button type="submit">Login</button>
  </form>
</body></html>
