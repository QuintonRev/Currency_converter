var pnpModule = angular.module("pnpStoreApp",[]);

var order_ID;
pnpModule.controller("pnpStoreAppController",function($scope,$http){
	   
    $http.defaults.headers.post["Content-Type"] = "application/json";  
    
    $scope.OrderNO = [];
	//Get all StockOrder in database
	$http.get('/GetStockOrders').then(function(response){
	console.log(response.data);
	$scope.StockOrders = response.data; 	
	});
	
	//Get all Deliveries in database
	$http.get('/GetDeliveries').then(function(response){
	console.log(response.data);
	$scope.deliveries = response.data; 	
	});
    
    //Get all products in database
    var inventory;
    		$http.get('/GetProducts').then(function(response){
    		console.log(response.data);
    		$scope.products = response.data;   		
    		
    		});
    		
    		 //Get all inventory in database
    		$http.get('/GetInventories').then(function(response){
    		console.log(response.data);
    		$scope.inventories = response.data; 	
    		});
    		
    		//Get user by email
    		$http.get('/user').then(function successCallback(response) {
    		$scope.userEmail=response.data;	
    		console.log()
    		}, function errorCallback(response) {
    		//console.log(response.statusText);
    		});
    		
    		//Get user by email
    		$http.get('/viewUser').then(function successCallback(response) {
    		$scope.userDetails=response.data;
    		var name = $scope.userDetails[0].id;
    		//View cart products
    		console.log(name);
    		
    		
    		$http.get('/viewCart/' + name ).then(function successCallback(response) {
    		$scope.cart=response.data;
    		
    		var totalAmt = 0;
			
			 for (var x = 0; x < $scope.cart.length ; x++)
				 { 
				 	totalAmt = totalAmt + $scope.cart[x].cart_price;
			     };
				 $scope.totalAmount = totalAmt ;
		
    		});
    		});
    		
    		//Add to cart in database
    		 $scope.create = function (prod,quant)
	         {
	            var Add2Cart = {
	            "product_name": prod.product_name,
	        	"cart_quantity" : quant ,
	        	"cart_price": prod.product_price * quant,
	        	"product_id": prod.product_id,
	        	"user_id" : $scope.userDetails[0].id,
	        	"order_no" : null,
	        	"product_img" :  prod.product_img 
	         };
	            
	            console.log(Add2Cart);
	            
	       $http.post('/SaveCart',Add2Cart).then(function(response){
             console.log(response);
             if(response.data.getcart_id !== 0)
             {
                       console.log("Cart product...");
                       alert("Cart product Added...");
                       location.reload(true);
                       
             }else{
                       console.log("Cart product Not Added");
                       alert("Cart product Not Added...");
                       location.reload(true);
                  }
             });
                
            };
            
            
            //Delete cart item
            $scope.DeleteItem = function (name)
            {
                var ID = name.cart_id;
                console.log(ID);
                  $http.delete('http:/DeleteCart/' +ID).then(function(response){
                    console.log(response);
                    if(response.data !== 0)
                    {
                       
                        alert("Item has been Deleted");
                        location.reload(true);
                    }else{
                       
                        alert("Item Not Deleted..!!!");
                        location.reload(true);
                    }
                });
            };
            //validate payment
            $scope.validatePay = function (banks,type,cardNo)
            {   
     	       //get all payments
   	         var num = 0;
             
              
              $http.get('/GetOrders').then(function(response){             	
           		$scope.orders = response.data;            	
                console.log($scope.orders);
                var orderID = 0;
              
                for(var i=0; i<$scope.orders.length; i++)
                {
                   if($scope.orders[i].user_id == $scope.userDetails[0].id)
                   {
                      if ($scope.orders[i].order_id > orderID)
                      {
                          orderID =  $scope.orders[i].order_id;
                          console.log(orderID);
                      } 
                   };
                };   
                
      
              console.log(orderID);
            	var bank = $scope.banks;
            	$scope.banks = bank;
            	var cardNo = $scope.cardNo;
            	$scope.cardNo = cardNo;
            	var type = $scope.type;
            	$scope.type = type;
            	var amount_payable = $scope.totalAmount;
            	$scope.banks = amount_payable;
            	if(bank !== undefined && type !== undefined && cardNo > "999999999999999" && cardNo < "9999999999999999")
            		{
            			alert("Payment successfully proccessed");
            			var Add2Payment = {
            		            "bank_name": bank,
            		        	"bank_type" : type ,
            		        	"card_number": cardNo,
            		        	"amount_payable": amount_payable,
            		        	"user_id" : $scope.userDetails[0].id,
            		        	"order_id" : orderID,
            		         };
            		            
            		            console.log(Add2Payment);
            		            
            		       $http.post('/SavePayment',Add2Payment).then(function(response){
            	             console.log(response);
            	             if(response.data.getpayment_id !== 0)
            	             {
            	                    
            	                       alert("Payment Added...");
            	                       location.reload(true);
            	                       //$("#myModal").modal('show');
            	            			//$("#myModal2").modal('show');
            	                       
            	             }else{
            	                       
            	                       alert("Payment Not Added...");
            	                       location.reload(true);
            	                  }
            	             });
            	
            		}
            	else { alert("Payment unsuccessfully");
            	     //$("#myModal2").modal('hide');
            	        //location.reload(true);
            	}            	
            	
              });
            	
            };
            
            //Cancel redirect
            $scope.Cancel = function ()
            {
            	
            	location.reload(true);
            };
      
            //validate order details
            $scope.order = function ()
            {
            	alert("order successfully proccessed");
            
            }

            
          //Get all orders in database
    		$http.get('/GetOrders').then(function(response){
    		console.log(response.data);
    		$scope.orders = response.data; 	
    		});
    		
    		
    		//Insert orders in database
    		
    		 $scope.order = function (contactNo,address,location)
	         {
    			 var contactNo = $scope.contactNo;
             	$scope.contactNo = contactNo;
             	var address = $scope.address;
             	$scope.address = address;
             	var location = $scope.location;
             	$scope.location = location;
    			var userID = $scope.userDetails[0].id; 
	            var Add2Order = {
	            "userNo": contactNo,
	        	"user_address" : address ,
	        	"user_location": location,
	        	"user_id" : $scope.userDetails[0].id,
	         };
	            
	            console.log(Add2Order);
	            var user_id; var order_id;
	       $http.post('/InsertOrders',Add2Order).then(function(response){                        
             if(response.data.getorder_id !== 0){	            	 
            	
            	    $http.get('/GetOrders').then(function(response){
             		console.log(response.data);
             		$scope.orders = response.data;
             		console.log($scope.orders.length);
             		console.log(response.data[$scope.orders.length -1]);
             		order_id = response.data[$scope.orders.length -1].order_id;
             		user_id = response.data[$scope.orders.length -1].user_id; 
             		order_ID = response.data[$scope.orders.length -1].order_id;
             		console.log(order_ID);
             		$scope.OrderNO[0] = order_ID;
             		console.log($scope.OrderNO[0]);
             		});
            	    console.log(order_id); 
                 //get all carts
                $http.get('/GetCarts').then(function(response){             	
             		$scope.carts = response.data;            	
             		 $scope.carts = response.data;
                     console.log(response.data.length);
                       var cartLegth = $scope.carts.length;
                       
                       
                       	for(var i=0; i<cartLegth; i++)
                       		{		var CartUserID =$scope.carts[i].user_id;
                       				var CartID =$scope.carts[i].cart_id;
                       				var product_name =$scope.carts[i].product_name;
                       				var cart_price =$scope.carts[i].cart_price;
                       				var cart_quantity =$scope.carts[i].cart_quantity;
                       				var product_id =$scope.carts[i].product_id;
                       				var product_img =$scope.carts[i].product_img;
                       		if(CartUserID == user_id)
                       		
                       		{	
                       		 	var UpdateCart = {
                       	    		 "cart_id" : CartID,
                       	        	"order_no" : order_id,
                       	        	"user_id" : CartUserID,
                       	        	"cart_price" : cart_price,
                       	        	"cart_quantity" : cart_quantity,
                       	        	"product_name" : product_name,
                       	        	"product_id" : product_id,
                       	        	"product_img" : product_img,
                       	        	
                       	              };
                       		 	
                       		  $http.put('/UpdateCart/'+ CartID,UpdateCart).then(function(response)
                            		   {
                            	   			//Inserting to deliveries
                       			         //Getting delivery date and time
                       			var Mydate = new Date();       
                       		    var hh = Mydate.getHours();
                       		    var mn = Mydate.getMinutes();
                       		    var mm = Mydate.getMonth() +1;
                       		    var yy = Mydate.getFullYear();
                       		    var dd = Mydate.getDate();
                       		    if(dd < 10) { dd = '0'+dd;}
                       		    if(mm < 10) {mm = '0'+mm;}
                       		    if(mm < 1) {mm = '0'+1;}
                       		     var deliveryDate = dd + '/' + mm + '/' + yy;
                       		    if(mn<10) { mn = '0'+mn;}
                       		    var deliveryTime = hh + ':' + mn;
                       		    console.log(deliveryTime);
                       		    console.log(deliveryDate);
                       			         var status = "pending";
                       			        var Add2Delivery = {                          	    		
                          	        	"order_id" : order_id,
                          	        	"delivery_date" : deliveryDate,
                          	        	"delivery_time" : deliveryTime,
                          	        	"delivery_status" : status,
                          	        
                          	              };
                            	   $http.post('/SaveDelivery',Add2Delivery).then(function(response){
                            	   
                            		   if(response.data.getdelivery_id !== 0){
                                       alert("your delivery has been Added...");
                                       
                                       
                             }else{
                                       console.log("delivery Not Added");
                                       alert("your order has not been Added......");
                                       location.reload(true);
                                  }
                            		   
                            	   });                           	
                            	     
                            	     });
                       		}
                       	}
             		
             		});
               
            	   
                       alert("your order has been Added...");
                       $("#myModal").modal('hide');
           			$("#myModal2").modal('show');
                      
                       
             }else{
                       console.log("Order Not Added");
                       alert("your order has not been Added......");
                       location.reload(true);
                  }
             });
             

	       
            };
            
          //Get all orders in database
    		$http.get('/GetOrders').then(function(response){
    		console.log(response.data);
    		$scope.orders = response.data; 	
    		});
    		
    		//Get all Users in database
    		$http.get('/GetUsers').then(function(response){
    		console.log(response.data);
    		$scope.users = response.data; 	
    		});
    		
    	    //Delete product in database
            $scope.DeleteProduct = function (prod)
            {
                var ID = prod.product_id;
                console.log(ID);
                  $http.delete('/DeleteProduct/' +ID).then(function(response){
                    console.log(response);
                    if(response.data !== 0)
                    {
                       
                        alert("Product has been Deleted");
                        location.reload(true);
                    }else{
                       
                        alert("Product Not Deleted..!!!");
                        location.reload(true);
                    }
                });
            };
            
            //Add product to database           
            $scope.AddProduct = function (group,productName,productPrice,productQuantity)
	         {
            	var file = document.getElementById('img');
       		 	var name = "/images/products/" + file.files.item(0).name;
   			    var group = $scope.group;
            	$scope.group = group;
            	var productName = $scope.productName;
            	$scope.productName = productName;            	
            	var productPrice = $scope.productPrice;
            	$scope.productPrice = productPrice;
            	var productQuantity = $scope.productQuantity;
            	$scope.productQuantity = productQuantity;
            
   			 
	            var Add2Product = {
	            "product_name": productName,
	        	"product_group" : group ,
	        	"product_price": productPrice,
	        	"product_img" : name,
	         };
	            
	            
	            
	            console.log(name);
	            
	       $http.post('/SaveProduct',Add2Product).then(function(response){
            console.log(response);
            if(response.data.getproduct_id !== 0)
            {
                      console.log(response.config.data.getproduct_id);
                      alert("Product has been Added...");
                      var Add2Invetory = {
      	    	            "product_name": productName,      	    	        	
      	    	        	"product_quantity": productQuantity,
      	    	        	     	    	        	
      	    	         };
                      $http.post('/SaveInventory',Add2Invetory).then(function(response){
                          console.log(response);
                          if(response.data.getinvetory_id !== 0)
                          {  alert("Invetory has been Added...");    }
                          else{alert("Invetory has not been Added......");}
                      });
                      location.reload(true);
                      
            }else{
                      console.log("Product Not Added");
                      alert("Product has not been Added......");
                      location.reload(true);
                 }
            });
               
           };
           
           //Update product
           $scope.prod2Updates; var prod_id;
           $scope.UpdatProduct = function (prod)
           {
               var ID = prod.product_id;
               prod_id = ID;
               var product_name = prod.product_name;
               var product_price = prod.product_price;
               var product_img = prod.product_img;
               var product_group = prod.product_group;
                var prod2Update =[{"product_name":product_name,"product_img": product_img,"product_price": product_price, "product_group": product_group,"ID":ID}];
               
               console.log(product_name);
               console.log(prod2Update);     
               if(ID != null){               
               $scope.prod2Updates = prod2Update;
   			    $("#UpdateProducts").modal('show');  		
   		
               }
               else {location.reload(true);}          
           };
           //update product and add to database
           $scope.UpdateProd = function (group,productName,productPrice,prod2Update)
           {           
        	   var prodID = prod_id;
        	   var file = document.getElementById('img2');
  		 	   var name = "/images/products/" + file.files.item(0).name;
  		 	   var group = $scope.group;
         	   $scope.group = group;
         	  var productName = $scope.productName;
         	  $scope.productName = productName;            	
         	  var productPrice = $scope.productPrice;
         	  $scope.productPrice = productPrice;
         	 console.log(prodID);
         	 
         	   var prodData = {
       	            "product_name": productName,
       	        	"product_group" : group ,
       	        	"product_price": productPrice,
       	        	"product_img" : name,
       	        	"product_id" : prodID,
       	         };
         	
         	  $http.put('/UpdateProduct/'+ prodID,prodData).then(function(response){
                  console.log(response);
                  if(response.data.getproduct_id !== 0)
                  {
                            console.log(response);
                            alert("Product has been updated...");
                            location.reload(true);
                            
                  }else{
                            console.log("Product Not Added");
                            alert("Product has not been updated......");
                            location.reload(true);
                       }
                  });
           };
         	 //delete user
         	 $scope.deleteUser = function (user)
             {           
          	  var User_id = user.id
           	  var user_name = user.name;
          	 var last_Name = user.lastName;            	
           	  var active = user.active;
           	var email = user.email;
           	var password = user.password;
           	var roles = user.roles;
           	var roles2 = "0";
           	  
           	 
           	 
           	   var UserData = {
         	             "id": User_id,
         	            "email" : email,
         	        	"password": password,
         	        	"name" : user_name,
         	        	"lastName" : last_Name,
         	        	"active" : active,
         	        	"roles" : null,
         	        	
         	         };
           	console.log(UserData);
           	 $http.put('/UpdateUser/'+ User_id,UserData).then(function(response){
                    console.log(response);
                    if(response.data.getid !== 0)
                    {
                    	  $http.delete('//DeleteUser/' + User_id).then(function(response){
                              console.log(response);
                              if(response.data !== 0)
                              {
                                 
                                  alert("User has been Deleted");
                                  location.reload(true);
                              }else{
                                 
                                  alert("User Not Deleted..!!!");
                                  location.reload(true);
                              }
                          });
                              
                              
                    }else{
                              
                              alert("User Not Deleted..!!!");
                              location.reload(true);
                         }
                    });
             };
         	
             //Delete order
             $scope.DeleteOrder = function (order)
             {   
                 var ID = order.order_id;
                 console.log(ID);
                   $http.delete('//DeleteOrder/' +ID).then(function(response){
                     console.log(response);
                     if(response.data !== 0)
                     {
                        
                         alert("Order has been Deleted");
                         location.reload(true);
                     }else{
                        
                         alert("Order Not Deleted..!!!");
                         location.reload(true);
                     }
                 });
             };          
       
  	
       	//out of stock
       	var inventoryQuantity = 100;
       	var product_name;
       	var stocksLength;
       	$scope.prodLength = [];
   	 //Get all inventory in database
		$http.get('/GetInventories').then(function(response){
		console.log(response.data);
		
		$scope.stocks = [];
		var nam = 0;
	
		for(var i=0; i<response.data.length; i++)
		{	
			if( response.data[i].product_quantity < inventoryQuantity  )
			{product_name=response.data[i].product_name;
			console.log(product_name);
	    		console.log(product_name);
	    	for(var j=0; j< $scope.products.length; j++)
	    			{
	    		if(product_name == $scope.products[j].product_name)
	    			{$scope.stocks[nam] = $scope.products[j];
	    				console.log($scope.stocks[nam]);
	    				nam++;
	    				console.log($scope.Add2Stocks);
	    				}
	    			}
	    	stocksLength = $scope.stocks.length;
	    	console.log(stocksLength);
	    	
	    	$scope.prodLength[0] = stocksLength;
	    	console.log($scope.prodLength[0]);
	    	 
			}
		}
	});
		
		
    //Stock request to supply
		$scope.Add2Stocks = [];
	     $scope.addStock = function (stock,StockQuantity)
         {   
	    	 var status = "pending"; 
	         var Add2StockOrder = {
	 	            "stock_product_name": stock.product_name,
	 	        	"stock_product_group" : stock.product_group ,
	 	        	"stock_product_quantity": StockQuantity,
	 	        	"stock_product_img" : stock_product_img = stock.product_img,
	 	        	"stockOrder_status" : status,
	 	         };
	 	            
	 	       
	    	 console.log($scope.Add2StockOrder);
	         $http.post('/SaveStockOrder',Add2StockOrder).then(function(response){
	            	console.log(response);
	            	if(response.data.getstockOrder_id !== 0)
	            	{
                   console.log(response);
                   alert("Stock order has been Added...");
                   location.reload(true);
                   
	            	}else{
                   alert("Stock order not Added");
                   location.reload(true);
              }
         });
	    	 
         };	
         console.log($scope.Add2StockOrder);
         
       //update product and add to database
         var stockOrderID; var stock_product_name; var stock_product_quantity; var inventoryID;
         $scope.SupplyStock = function (pendingstockOrder)
         {           
      	   stockOrderID = pendingstockOrder.stockOrder_id;      	 
		   stock_product_name = pendingstockOrder.stock_product_name;       	 
       	   var stock_product_group = pendingstockOrder.stock_product_group;       	              	
       	   stock_product_quantity = pendingstockOrder.stock_product_quantity;
       	   var stock_product_img = pendingstockOrder.stock_product_img;
       	   var stockOrder_status = "Stock supplied";
       	   console.log(stockOrderID);
       	 
       	   var stockData = {
     	            "stock_product_name": stock_product_name,
     	        	"stock_product_group" : stock_product_group,
     	        	"stock_product_quantity": stock_product_quantity,
     	        	"stock_product_img" : stock_product_img,
     	        	"stockOrder_status" : stockOrder_status,
     	        	"stockOrder_id" : stockOrderID,
     	         };
       	
       	  $http.put('/UpdateStockOrder/'+ stockOrderID,stockData).then(function(response){
                console.log(response);
                if(response.data.getstockOrder_id !== 0)
                {
                          console.log(response);
                          alert("Stock order has been updated...");                         
                          
                          
                }else{
                          
                          alert("Stock order has not been updated......");
                          location.reload(true);
                     }
                });
       	 //update inventories
       	 console.log(stock_product_name);
          $http.get('/GetInventories').then(function(response){
      		console.log(response.data);      		
          for(var i=0; i<response.data.length; i++)
        	  {
        	  	if(stock_product_name == response.data[i].product_name)
        	  		{
        	  		inventoryID = response.data[i].inventory_id;
        	  		var quantity = response.data[i].product_quantity + stock_product_quantity;
        	  		 var updateInvntData = {
        	     	            "inventory_id": response.data[i].inventory_id,
        	     	        	"product_quantity" : response.data[i].product_quantity,
        	     	        	"product_name": response.data[i].product_name,
        	     	        	"product_quantity" : quantity,
        	     	         };
        	  		$http.put('/UpdateInventory/'+ inventoryID,updateInvntData).then(function(response){
                        console.log(response);
                        if(response.data.getinventory_id !== 0)
                        {
                                  console.log(response);
                                  alert("inventory has been updated...");
                                  location.reload(true);
                                  
                        }else{
                                  
                                  alert("inventory has not been updated......");
                                  location.reload(true);
                             }
                        });
        	  		
        	  		}
        	  
        	  } 
          });
       	  
         };
         
         //Get deliveries
         $scope.pendingDeliveries = [];
         $scope.delivLength = [];
         var nam1 =0;
         $http.get('/GetDeliveries').then(function(response){
        		console.log(response.data);
        		$scope.deliveries = response.data;
        		var status = "pending";
        		var status2 = "on its way";
        		for(var i=0; i<$scope.deliveries.length; i++)
        			{
        				if(status == $scope.deliveries[i].delivery_status || status2 == $scope.deliveries[i].delivery_status)
        					{
        					$scope.pendingDeliveries[nam1] = $scope.deliveries[i];
    	    				console.log($scope.pendingDeliveries[nam1]);
    	    				nam1++;
    	    				
        					}
        			}
        		deliveryLength =$scope.pendingDeliveries.length;
    	    	console.log(deliveryLength);
    	    	
    	    	$scope.delivLength[0] = deliveryLength;
    	    	console.log($scope.delivLength[0]);
        		});
         
     
         //Updating delivery status
         var deliveryID;
         $scope.UpdateDelivery = function (pendingDelivery,status)
         {   
             
               
                 if(status == null)
                 {
                    
                     alert("Please Select delivery status");
                     location.reload(true);
                 }else{
                    
                	 deliveryID = pendingDelivery.delivery_id;
                	 console.log(deliveryID);
                	 console.log(status);
                	 var updateData = {
              	            "order_id": pendingDelivery.order_id,
              	        	"delivery_date" : pendingDelivery.delivery_date,
              	        	"delivery_time": pendingDelivery.delivery_time,
              	        	"delivery_status" : status,
              	        	"delivery_id" : pendingDelivery.delivery_id,
              	         };
                	 console.log(updateData);
                	  $http.put('/UpdateDelivery/'+ deliveryID,updateData).then(function(response){
                         console.log(response);
                         if(response.data.getdeliveryID !== 0)
                         {
                                   console.log(response);
                                   alert("Delivery has been updated...");
                                   
                                   //Clearing cart
                                   var cartID; var orderID; var cartProductName; var cartQntity; var inventoryID; var inventoryQntity;
                                  	$http.get('/GetDeliveries').then(function(response){
                                  	console.log(response.data);
                                  	$scope.deliveries = response.data;
                                  	for(var j=0; j<response.data.length; j++)
                           		{	 var DeliveryState = "delivered";
                           				if(DeliveryState == $scope.deliveries[j].delivery_status){
                           					orderID = $scope.deliveries[j].order_id;
                           					
                           					$http.get('/GetCarts').then(function(response){
                           				       	console.log(response.data);
                           				       	$scope.carts = response.data;
                           				       	for(var i=0; i<$scope.carts.length; i++)
                           				       		{
                           				       			if(orderID == $scope.carts[i].order_no){
                           				       				cartID = $scope.carts[i].cart_id;
                           				       				cartQntity = $scope.carts[i].cart_quantity;
                           				       				cartProductName = $scope.carts[i].product_name;
                           				       				$http.get('/GetInventories').then(function(response){
                           				       					console.log(response.data);
                           								       	$scope.inventories = response.data;
                           								       	for(var x=0; x<$scope.inventories.length; x++)
                           								       		{
                           								       			if(cartProductName == $scope.inventories[x].product_name)
                           								       				{ inventoryID = $scope.inventories[x].inventory_id;
                           								       				inventoryQntity = $scope.inventories[x].product_quantity - cartQntity;
                           								       				var UpdateInventory = {
                           						                       	    		 "inventory_id" : $scope.inventories[x].inventory_id,
                           						                       	        	"product_quantity" : inventoryQntity,
                           						                       	        	"product_name" : $scope.inventories[x].product_name,
                           								       				};
                           								       				$http.put('/UpdateInventory/'+ inventoryID,UpdateInventory).then(function(response)
                           						                            		   {
                           						                                         if(response.data.getinventory_id !== 0){
                           						                                       alert("Inventory has been updated...");
                           						                                       
                           						                                       
                           						                                       
                           						                             }else{
                           						                                       console.log("Inventory Not updated");
                           						                                       alert("Inventory has not been updated......");
                           						                                       location.reload(true);
                           						                                  }});
                           								       				}}
                           				       					});
                           				       				
                           				       		      $http.delete('/DeleteCart/' +cartID).then(function(response){
                           				                      console.log(response);
                           				                      if(response.data !== 0)
                           				                      {
                           				                         
                           				                          alert("Cart has been Deleted");
                           				                          location.reload(true);
                           				                      }else{
                           				                         
                           				                          alert("Cart Not Deleted..!!!");
                           				                          location.reload(true);
                           				                      }
                           				                  });}}
                           					}); 
                           				}
                                  		
                           		}
                                  	
                                  	});
                                   
                                   
                         }else{
                                   
                                   alert("Delivery has not been updated......");
                                   location.reload(true);
                              }
                         });
                     
                 }
           
         };
  
         //Get pending stock orders
         $scope.pendingstockOrders = [];
         $scope.stockOrder = [];
         var nam2 =0;
         $http.get('/GetStockOrders').then(function(response){
        		console.log(response.data);
        		$scope.stockOrders = response.data;
        		console.log($scope.stockOrders);
        		var status = "pending";
        		for(var i=0; i<$scope.stockOrders.length; i++)
        			{
        				if(status == $scope.stockOrders[i].stockOrder_status)
        					{
        					$scope.pendingstockOrders[nam2] = $scope.stockOrders[i];
    	    				console.log($scope.pendingstockOrders[nam2]);
    	    				nam2++;
    	    				
        					}
        			}
        		orderLength =$scope.pendingstockOrders.length;
    	    	console.log(orderLength);
    	    	
    	    	$scope.stockOrder[0] = orderLength;
    	    	console.log($scope.pendingstockOrders);
        		});
       
      //delete Stock orders
         var StockID;
         $scope.DeleteStockOrder = function (StockOrder)
         {   
        	 StockID = StockOrder.stockOrder_id;
        	 
             $http.delete('/DeleteStockOrder/' +StockID).then(function(response){
                 console.log(response);
                 if(response.data !== 0)
                 {
                                      				                         
                  alert("Stock order has been Deleted");
                location.reload(true);
                  }else{
                  alert("Stock order Not Deleted..!!!");
                  location.reload(true);
                }
                });
     };
     
     //payments
     
     
});



