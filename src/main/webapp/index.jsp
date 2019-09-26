<html>

<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body style="background-color:${clr};">



<h2 style="color:${clr};">exercise1</h2>

      <p>Enter your Name ${clr}</p>

      <form action = "display" method="post">
         <table>
            <tr>
               <td>
                  <input type = "text" name="name"/>
                  <button action="display"  value="hhh">click</button>

               </td>
            </tr>
         </table>
      </form>

      <br><br>

   <h2>exercise2</h2>
            <form action = "displayUser" method="post">
               <table>
                  <tr>
                     <td>
                        <input type = "text" name="name"/>
                        <input type = "password" name="pass"/>

                        <button action="displayUser" >click</button>
                     </td>
                  </tr>
               </table>
            </form>

            <form action="home" method="post">

<h2>   enter background color       </h2>
<input type="text"  name="clrr">
             <button action="home" method="post" >changecolor</button>
            </form>



</body>
</html>
