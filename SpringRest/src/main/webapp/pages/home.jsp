



<!DOCTYPE html>

<html>
   <head>  
   	 <title> Home </title>
   </head>
   <body>
	<h1 align="center"> Spring Boot REST API CRUD </h1>
	<p align="center"> SAVE ALIEN INFORMATION </p>
	<form action = "addAlien" align="center">
		<input type="text" name="aid" placeholder="Enter Alien ID"> <br>
		<input type="text" name="aname" placeholder="Enter Alien name"> <br>
		<input type="text" name="email" placeholder="Enter Alien email"> <br>
		<input type="submit"> <br>
	</form>
	
	<p align="center"> GET ALIEN INFORMATION </p>
	<form action = "getAlien" align="center">
		<input type="text" name="aid" placeholder="Enter Alien ID"> <br>
		<input type="submit"> <br>
	</form>
	
	<p align="center"> DELETE ALIEN INFORMATION </p>
	<form action = "deleteAlien" align="center">
		<input type="text" name="aid" placeholder="Enter Alien ID"> <br>
		<input type="submit"> <br>
	</form>
	
	<p align="center"> UPDATE ALIEN INFORMATION </p>
	<form action = "editAlien" align="center">
		<input type="text" name="aid" placeholder="Enter Alien ID"> <br>
		<input type="submit"> <br>
	</form>
	
   </body>
   
   
   
    

 </html>




