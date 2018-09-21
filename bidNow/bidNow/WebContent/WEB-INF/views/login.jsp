<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<c:url value="/resources/css/main.css" var="cssURL" />
	<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
	
</head>
<body>

<div id="loginPageBlock">
<h2>Bidding Site project</h2>

<div id="login">
<h3>Login</h3>

<form action="/bidNow/login/LoginNow" method="POST">
Username: <input type="text" name ="username" /><br>
Password : <input type="password" name ="password"/><br>
<input type="submit" value ="login"/>
</form>
</div>

<br>

<a href="#" class="newCustomer">Register new Customer</a>
<div id="newUser">
</div>

</div>
</body>
</html>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript">

$(".newCustomer").click(function() {
		debugger;
		$("#newUser").empty();	
		
	  
				var divv=document.createElement('div');
					
				var h3 = document.createElement("h3")  
				var caption=document.createTextNode('New Customer');
				h3.appendChild(caption);	
				
				var br=document.createElement('br');
					
				var line=document.createElement('p');
				line.innerHTML="";	
				
				//name
				
				var captionName = document.createElement("LABEL");
			    var t = document.createTextNode("Name");
			    captionName.appendChild(t);
			    
				var inputName = document.createElement("INPUT");
				inputName.setAttribute("type", "text");
				inputName.setAttribute("name","namee");
				
				//address
				var captionaddr = document.createElement("LABEL");
			    var t1 = document.createTextNode("Address");
			    captionaddr.appendChild(t1);
				
				var inputAddr = document.createElement("INPUT");
				inputAddr.setAttribute("type", "text");
				inputAddr.setAttribute("name","address");
				
				//username
				var captionusername = document.createElement("LABEL");
			    var t2 = document.createTextNode("username");
			    captionusername.appendChild(t2);
			    
					
				var inputusn = document.createElement("INPUT");
				inputusn.setAttribute("type", "text");
				inputusn.setAttribute("name","username1");
				
				
				//pwd
				var captionpwd = document.createElement("LABEL");
			    var t3 = document.createTextNode("password");
			    captionpwd.appendChild(t3);
				
					
				var inputpwd = document.createElement("INPUT");
				inputpwd.setAttribute("type", "password");
				inputpwd.setAttribute("name","password2");
				
					
				var btn = document.createElement("button");
				var t = document.createTextNode("Register customer");
					
				btn.appendChild(t);
				btn.setAttribute('type', 'button');
				btn.setAttribute('onclick', "create()");
			    
					
				    divv.appendChild(h3);
        		    divv.appendChild(captionName);
        		    divv.appendChild(inputName);
        		    divv.appendChild(line);
        		    divv.appendChild(br);
        		    divv.appendChild(captionaddr);
        		    divv.appendChild(inputAddr);
        		     divv.appendChild(br);
        		     divv.appendChild(line);
        		     divv.appendChild(captionusername);
        		    divv.appendChild(inputusn);
        		    divv.appendChild(br);	    
        		    divv.appendChild(captionpwd);
        		    divv.appendChild(inputpwd);
        		   
        		    divv.appendChild(br);
        		    
        		    divv.appendChild(btn);
        		   
		        	document.getElementById("newUser").appendChild(divv);
    
	});
	
	function create(){
		
		var namee = document.getElementsByName("namee").item(0).value;
		var address = document.getElementsByName("address").item(0).value;
		var username1 = document.getElementsByName("username1").item(0).value;
		var password2 = document.getElementsByName("password2").item(0).value;
		
	        $.ajax
	        ({
	            type: "POST",         
	            data: '&namee='+namee+'&address='+address+'&username1='+username1+'&password2='+password2,
	            url: "/bidNow/login/RegisterNew",
	            success:function(content)
	        {          
	                location.reload();

	                alert('User Created') 
	            }           
	        });
	}

</script>
