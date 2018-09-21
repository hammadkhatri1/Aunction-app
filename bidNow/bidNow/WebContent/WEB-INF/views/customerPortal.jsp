<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>

	<c:url value="/resources/css/main.css" var="cssURL" />
	<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<h2>Welcome ${USERNAME1} </h2>
<input type="button" onclick="createProd()" value="Submit an item to Sell">
<div id="newprodBoxx"></div>

<div id="newUser">
	<h3>List of Products for bidding</h3>

<a href="#" class="search">search item by name</a>
<div id="searchBox">
<form action="/bidNow/Customer/Search" method="POST">
Item Name<input type="text" name="searchName" >
</form>
</div>


	<div id="listBox">
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<th>Bid Id</th>
			<th>Product Name</th>
			<th>Customer Name</th>
			<th>Price</th>
			<th>Function</th>
		</tr>

		<c:forEach items="${bidList}" var="bid">

			<tr>
				<td >${bid.bidNo}</td>
				<td >${bid.prod_name}</td>
				<td >${bid.customer_name}</td>
				<td >${bid.price}</td>
				<td ><a href="#" id="${bid.bidNo}">Bid NOW!</a>/	
				<div id="bidOnItemNow"></div>			
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>

</html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript">
   


function createProd(){
	debugger;
	$("#newprodBoxx").empty();	
		
	var divv=document.createElement('div');
	divv.setAttribute("id","itemSubmitBox2");
	var h3 = document.createElement("h3")  
	var caption=document.createTextNode('New Customer');
	h3.appendChild(caption);	
	
	var br=document.createElement('br');
		
	var line=document.createElement('p');
	line.innerHTML="";	
	
	//name
	
	var captionName = document.createElement("LABEL");
    var t = document.createTextNode("Item name");
    captionName.appendChild(t);
    
	var inputName = document.createElement("INPUT");
	inputName.setAttribute("type", "text");
	inputName.setAttribute("name","namee");
	
	//address
	var captionSP = document.createElement("LABEL");
    var t1 = document.createTextNode("Starting Price");
    captionSP.appendChild(t1);
	
	var inputSP = document.createElement("INPUT");
	inputSP.setAttribute("type", "text");
	inputSP.setAttribute("name","startingPrice");
	
	//username
	var captionD = document.createElement("LABEL");
    var t2 = document.createTextNode("description");
    captionD.appendChild(t2);
		
	var inputD = document.createElement("INPUT");
	inputD.setAttribute("type", "text");
	inputD.setAttribute("name","description");
	
	var btn = document.createElement("button");
	var t = document.createTextNode("Submit Item");
		
	btn.appendChild(t);
	btn.setAttribute('type', 'button');
	btn.setAttribute('onclick', "create()");
    
		
	    divv.appendChild(h3);
	    divv.appendChild(captionName);
	    divv.appendChild(inputName);
	    divv.appendChild(br);
	    divv.appendChild(line);
	    divv.appendChild(br);
	    divv.appendChild(captionSP);
	    divv.appendChild(inputSP);
	    divv.appendChild(br);
	    divv.appendChild(line);
	    divv.appendChild(captionD);
	    divv.appendChild(inputD);
	    divv.appendChild(br);
	    divv.appendChild(btn);
	   
    	document.getElementById("newprodBoxx").appendChild(divv);
    
	}
	
function create(){
	
	var namee = document.getElementsByName("namee").item(0).value;
	var startingPrice = document.getElementsByName("startingPrice").item(0).value;
	var description = document.getElementsByName("description").item(0).value;
	
        $.ajax
        ({
            type: "POST",         
            data: '&namee='+namee+'&startingPrice='+startingPrice+'&description='+description,
            url: "/bidNow/Customer/SubmitItem",
            success:function(content)
        {          
            	window.location = "/bidNow/Customer/list";
            	 alert('Item added') 
               
            }           
        });
}
$(".update").click(function() {
	debugger;
	$("#bidOnItemNow").empty();	
	
	
	var id = +this.id; 

	  
			var divv=document.createElement('div');
				
			var h1 = document.createElement("h3")  
			var caption=document.createTextNode('Update Record');
			h1.appendChild(caption);	
			
			var br=document.createElement('br');
				
			var captionId=document.createElement('p');
			captionId.innerHTML="ID: ";
				
			var inputId = document.createElement("INPUT");
			inputId.setAttribute("type", "text");
			inputId.setAttribute("value", id);
			inputId.setAttribute("name","itemId");
    		    
			var captionName=document.createElement('p');
			captionName.innerHTML="Name: ";
				
			var inputName = document.createElement("INPUT");
			inputName.setAttribute("type", "text");
			inputName.setAttribute("name","itemNamee");
				
			var btn = document.createElement("button");
			var t = document.createTextNode("Updatee Record");
				
			btn.appendChild(t);

			btn.setAttribute('type', 'button');
			btn.setAttribute('onclick', "Update()");
		    
				
			    divv.appendChild(h1);
    		    divv.appendChild(captionId);
    		    divv.appendChild(inputId);
    		    divv.appendChild(br);
    		    divv.appendChild(captionName);
    		    divv.appendChild(inputName);
    		    divv.appendChild(br);
    		    divv.appendChild(br);
    		    
    		    divv.appendChild(btn);
    		   
	        	document.getElementById("updateRecord").appendChild(divv);

});

function Update(){
	var itemNamee = document.getElementsByName("itemNamee").item(0).value;
	var itemId = document.getElementsByName("itemId").item(0).value;
	
        $.ajax
        ({
            type: "POST",         
            data: '&itemId='+itemId+'&itemNamee='+itemNamee,
            url: "/bidNow/Customer/bidOnItem",
            success:function(content)
        {          
                location.reload();

            }           
        });
}

</script>

</script>