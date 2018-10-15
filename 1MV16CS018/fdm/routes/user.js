
//---------------------------------------------signup page call------------------------------------------------------
exports.signup = function(req, res){
   message = '';
   console.log("in signup");
   if(req.method == "POST"){
      var post  = req.body;
      var email= post.email;
      var pass= post.password;
      var fname= post.fact_name;
      var name= post.name;
      var mob= post.mob_no;

      var sql = "INSERT INTO `factory_table`(`fact_name`,`name`,`mob_no`,`email`, `password`) VALUES ('" + fname + "','" + name + "','" + mob + "','" + email + "','" + pass + "')";
console.log(sql);
      var query = db.query(sql, function(err, result) {
        if(err)
        console.log(err);

         message = "Succesfull! Your account has been created.Please login";
	//console.log(result);
         res.render('index.ejs',{message: message});
      });

   } else {
      res.render('signup');
   }
};

//-----------------------------------------------login page call------------------------------------------------------
exports.login = function(req, res){
   var message = '';
   console.log("in signin");
   var sess = req.session;

   if(req.method == "POST"){
      var post  = req.body;
      var email= post.email;
      var pass= post.password;

      var sql="SELECT id, fact_name, name, email FROM `factory_table` WHERE `email`='"+email+"' and password = '"+pass+"'";
      db.query(sql, function(err, results){
        if(err) throw err;
      //  console.log(results)
         if(results.length){
            req.session.userId = results[0].id;
            req.session.user = results[0];
          //  console.log(results[0].id);
            res.redirect('/home/dashboard');
         }
         else{
            message = 'Wrong Credentials.';
            res.render('index.ejs',{message: message});
         }

      });
   } else {
      res.render('index.ejs',{message: message});
   }

};
//-----------------------------------------------dashboard page functionality----------------------------------------------

exports.dashboard = function(req, res, next){

   var user =  req.session.user,
   userId = req.session.userId;
  // console.log('fact_user='+userId);
   if(userId == null){
      res.redirect("/login");
      return;
   }

   var sql="SELECT * FROM `factory_table` WHERE `id`='"+userId+"'";

   db.query(sql, function(err, results){
      res.render('dashboard.ejs', {user:user});
   });
};
//------------------------------------logout functionality----------------------------------------------
exports.logout=function(req,res){
   req.session.destroy(function(err) {
      res.redirect("/login");
   })
};
exports.delete_customer=function(req,res){
  var userId = req.session.userId;
  var customer_id = req.query.id;
//  console.log("product="+product_id);
  var sql="DELETE FROM `customers` WHERE `customer_id` ='"+ customer_id+"'";
console.log(sql);
  db.query(sql, function(err, result){
    console.log(result);
    console.log(result[0]);
// exports.product();
  });
  var sql="SELECT * FROM `customers` WHERE `id`='"+userId+"'";
  db.query(sql, function(err, result){
 //   console.log(result);
 //   console.log(result[0]);
 //   console.log("length="+result.length);
    //if(result.length)
    //console.log(result[0].product_id);
    res.render('customers.ejs', {result:result});

  });

 if(userId == null){
  res.redirect("/login");
  return;
 }


};

exports.delete_product=function(req,res){
  var userId = req.session.userId;
  var product_id = req.query.id;
  console.log("product="+product_id);
  var sql="DELETE FROM `products` WHERE `product_id` ='"+ product_id+"'";
console.log(sql);
  db.query(sql, function(err, result){
    console.log(result);
    console.log(result[0]);
// exports.product();
  });
  var sql="SELECT * FROM `products` WHERE `id`='"+userId+"'";
  db.query(sql, function(err, result){
   // console.log(result);
   // console.log(result[0]);
    //console.log("length="+result.length);
    //if(result.length)
    //console.log(result[0].product_id);
    res.render('product.ejs', {result:result});

  });

 if(userId == null){
  res.redirect("/login");
  return;
 }


};
exports.product=function(req,res){
var userId = req.session.userId;
if(req.method == "POST")
{
    var post  = req.body;
  var product_name = post.product_name;
  var cost = post.cost;
  console.log("posted");
  var sql = "INSERT INTO `products`(`id`,`product_name`,`cost`) VALUES ('" + userId + "','" + product_name + "','" + cost + "')";
  console.log(sql);
  var query = db.query(sql, function(err, result) {
  //  if(err)
    //console.log(err);
});
//     message = "Succesfull! Your account has been created.Please login";
//  console.log(result);
  //  res.render('dashboard.ejs');
    //exports.product();
}


     var sql="SELECT * FROM `products` WHERE `id`='"+userId+"'";
     db.query(sql, function(err, result){
      // console.log(result);
      // console.log(result[0]);
       //console.log("length="+result.length);
       //if(result.length)
       //console.log(result[0].product_id);
       res.render('product.ejs', {result:result});

     });
  if(userId == null){
     res.redirect("/login");
     return;
  }

  };

//----------------------------customers-------------------------------------------------------------
  exports.customers=function(req,res){
  var userId = req.session.userId;
  if(req.method == "POST")
  {
      var post  = req.body;
    var customer_name = post.customer_name;
    var product_quantity = post.product_quantity;
    var month  = post.month;
    var transportation_cost = post.transportation_cost;
    var bill_amount = post.bill_amount;


    console.log("posted");
    var sql = "INSERT INTO `customers`(`id`,`customer_name`,`product_quantity`,`month`,`transportation_cost`,`bill_amount`) VALUES ('" + userId + "','" + customer_name + "','" + product_quantity + "','" + month  + "','"+transportation_cost + "','" + bill_amount+"')";
    console.log(sql);
    var query = db.query(sql, function(err, result) {
    //  if(err)
      //console.log(err);
  });
  //     message = "Succesfull! Your account has been created.Please login";
  //  console.log(result);
    //  res.render('dashboard.ejs');
      //exports.product();
  }


       var sql="SELECT * FROM `customers` WHERE `id`='"+userId+"'";
       db.query(sql, function(err, result){
      //   console.log(result);
      //   console.log(result[0]);
      //   console.log("length="+result.length);
         //if(result.length)
         //console.log(result[0].product_id);
         res.render('customers.ejs', {result:result});

       });
    if(userId == null){
       res.redirect("/login");
       return;
    }

    };

//--------------------------------render user details after login--------------------------------
exports.profile = function(req, res){

   var userId = req.session.userId;
   if(userId == null){
      res.redirect("/login");
      return;
   }

   var sql="SELECT * FROM `factory_table` WHERE `id`='"+userId+"'";
   db.query(sql, function(err, result){
      res.render('profile.ejs',{data:result});
   });
};
//---------------------------------edit factory_table details after login----------------------------------
exports.editprofile=function(req,res){
   var userId = req.session.userId;
   if(userId == null){
      res.redirect("/login");
      return;
   }

   var sql="SELECT * FROM `factory_table` WHERE `id`='"+userId+"'";
   db.query(sql, function(err, results){
      res.render('edit_profile.ejs',{data:results});
   });
};
