

<html>
<head>
<title> Edit </title> 
</head>

<body>

<p> ID: ${obj.id} Name: ${obj.name}  Email: ${obj.email}</p>

<p> Update User </p>
     <form action="storeUser">
     <input type= "text" name="id" value= ${obj.id} > <br>
     <input type= "text" name="name" value= ${obj.name} > <br>
     <input type="text" name="email" value= ${obj.email} > <br>
     <input type="submit"> <br>
     </form>
</body>
</html>