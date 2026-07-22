<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <style>
    * {margin: 0; padding: 0; box-sizing: border-box;}
    ul{ list-style-type: none; }
    header, footer{
      border-top: 1px solid black;
      border-bottom: 1px solid black;
      height: 50px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    div.container{
      border: 1px solid black;
      width: 80%;
      height: 75vh;
      margin: 0 auto;
    }
    .container > section{
      /* border: 1px solid red; */
      height: 80%;
      display: flex;
      justify-content: flex-start;
      align-items: center;
      gap: 10px;
      padding: 10px;
    }
    .product1, .product2{
      /* border: 3px dotted blue; */
      width: 50%;
      height: 100%;
    }
    .product1{
      display: flex;
      flex-direction: column;
      flex-wrap: nowrap;
      justify-content: center;
      align-items: center;
      gap: 10px;
    }
    #coffeeImg{
      border: 1px dotted black;
      width: 80%;
    }
    .product1 > ul{
      /* border: 1px solid blue; */
      display: flex;
      flex-direction: row;
      flex-wrap: nowrap;
      justify-content: space-around;
      align-items: center;
      gap: 10px;
    }
    .product1 > ul img{
      border: 1px solid black;
      width: 50px;
    }
    .product2{
      display: flex;
      flex-direction: column;
      /* flex-wrap: nowrap; */
      justify-content: space-around;
      align-items: flex-start;
      gap: 10px;
      padding: 10px;
    }
    .product2 > ul > li{
      font-size: 14px;
    }
    .product2 > button{
      width: 90%;
      padding: 5px 0;
    }
    .product2 > p{
      font-size: 12px;
    }


  </style>

</head>
<body>
  <header>header</header>

  <div class="container">
    <h1>ìëì¤í¼ì ê²ë</h1>
    <section>
      <div class="product1">
        <img id="coffeeImg" src="./images/coffee-blue.jpg" alt="">
        <ul>
          <li><img id="img1" src="./images/coffee-blue.jpg" alt=""></li>
          <li><img id="img2" src="./images/coffee-gray.jpg" alt=""></li>
          <li><img id="img3" src="./images/coffee-pink.jpg" alt=""></li>
        </ul>
      </div>
      <div class="product2">
        <ul>
          <li>ìíëª : ìëì¤í¼ì ê²ë</li>
          <li>íë§¤ê° : 9,000ì</li>
          <li>ë°°ì¡ë¹ : 3,000ì</li>
          <li>(50,000ì ì´ì êµ¬ë§¤ì ë¬´ë£)</li>
          <li>ì ë¦½ê¸ : 180ì(2%)</li>
          <li>ë¡ì¤í : 2019.06.17</li>
        </ul>
        <button type="button">ì¥ë°êµ¬ëë´ê¸°</button>
        <p>ìì¸ ì¤ëª ë³´ê¸°</p>
      </div>
    </section>
  </div>

  <footer>footer</footer>
  
  <script>
    let coffeeImg = document.querySelector('#coffeeImg');
    let img1 = document.querySelector('#img1');
    let img2 = document.querySelector('#img2');
    let img3 = document.querySelector('#img3');

    img1.addEventListener("mouseover", ()=>{ coffeeImg.src = img1.src }, false);
    img2.addEventListener("mouseover", ()=>{ coffeeImg.src = img2.src }, false);
    img3.addEventListener("mouseover", ()=>{ coffeeImg.src = img3.src }, false);
    // img2.addEventListener("mouseout", ()=>{ coffeeImg.src = img1.src }, false);
    // img3.addEventListener("mouseout", ()=>{ coffeeImg.src = img1.src }, false);



  </script>

</body>
</html>