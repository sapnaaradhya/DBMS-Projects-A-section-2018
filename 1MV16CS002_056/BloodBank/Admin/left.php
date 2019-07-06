<?php if(!isset($_SESSION)) {session_start();}  ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ADMIN PANNEL</title>
<link href="StyleSheet.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<link href="css/flexslider.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/jquery.flexslider.js" type="text/javascript"></script>
 <script type="text/javascript">
     $(function () {
         SyntaxHighlighter.all();
     });
     $(window).load(function () {
         $('.flexslider').flexslider({
             animation: "slide",
             animationLoop: false,
             itemWidth: 210,
             itemMargin: 5,
             minItems: 2,
             maxItems: 4,
             start: function (slider) {
                 $('body').removeClass('loading');
             }
         });
     });
  </script>
</head>
<body>

 
   <div style="width:1000px; height:700px; box-shadow:-10px 10px 5px #CCC">
      
       <div style="width:800px;float:left; height:500px">
<table style="width:100%; height:600px">
<tr><td style="font-size:24px; color:#F00; font-weight:bold">Admin Links</td></tr>
<br />
<?php if($_SESSION["usertype"]=="Admin")
{?>
<tr><td class="lefttd"><a href="adduser.php">Add User</a></td></tr>
<tr><td class="lefttd"><a href="upuser.php">Update User</a></td></tr>
<tr><td class="lefttd"><a href="deluser.php">Delete User</a></td></tr>
<tr><td class="lefttd"><a href="addcamp.php">Add Camp</a></td></tr>
<tr><td class="lefttd"><a href="viewcamp.php">View Camps</a></td></tr>
<?php }?>

</table></div></div>

</body>
</html>