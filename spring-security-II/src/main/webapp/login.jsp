

<!DOCTYPE html> 
<html> 
<head>
<title> Login Page </title>
</head>  
<body>  
    <h1> Login </h1>
    ${SPRING_SECURITY_LAST_EXCEPTION.message}
    <form action="login" method='POST'>
        <div class="container"> 
            <label>Username : </label> 
            <input type="text" placeholder="Enter Username" name="username" required> <br>
            <label>Password : </label> 
            <input type="password" placeholder="Enter Password" name="password" required> <br>
            <button type="submit">Login</button>  
        </div> 
    </form>   
</body>   
</html>

 
