<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="/css/style.css">
  <script type="text/javascript">
  function cart(){
	  if('${sessionScope.id}' ==''){
		  alert("먼저 로그인을 하세요");
		  location.href='/member/login';
		  return;
	  }
	  //카트테이블에 등록하고 카트 목록으로 이동(비동기)
  }
  function order(){
	  if('${sessionScope.id}' ==''){
		  alert("먼저 로그인을 하세요");
		  location.href='/member/login';
		  return;
	  }
	  //주문서 작성으로 이동 주문생성(비동기) 
  }
  </script>
</head>
<body>
 
<div class="container">
  <div class="row">
  <div class="col-sm-3">
  <h4><img src="/svg/box2-heart.svg"> 상품 정보</h4>
  <img class="img-rounded" src="/contents/storage/${dto.filename}" style="width:250px">
  <div class="caption">
    <p>상품명:${dto.pname}</p>
    <p>${dto.detail }</p>
  </div>
  </div>
  <div class="col-sm-6">
  <h4><img src="/svg/rulers.svg"> 사이즈 및 수량</h4>
  <ul class="list-group">
    <li class="list-group-item">사이즈 :
    <c:choose>
    <c:when test="${dto.cateno==1 }">
     <select class="form-select" aria-label="Default select example">
  <option selected>사이즈 선택</option>
  <option value="1">L</option>
  <option value="2">M</option>
  <option value="3">S</option>
</select>
    </c:when>
    
    <c:when test="${dto.cateno==2 }">
         <select class="form-select" aria-label="Default select example" disabled="disabled">
  <option selected>사이즈 선택</option>
  </select>
    </c:when>
    
    <c:when test="${dto.cateno==3 }">
         <select class="form-select" aria-label="Default select example">
  <option selected>사이즈 선택</option>
  <option value="220">220</option>
  <option value="230">230</option>
  <option value="240">240</option>
  <option value="250">250</option>
  <option value="260">260</option>
  <option value="270">270</option>
  <option value="280">280</option>
  <option value="290">290</option>
    </c:when>
</c:choose>
    <li class="list-group-item">가격 : ${dto.price }
    <li class="list-group-item">재고 : ${dto.stock }
    <li class="list-group-item">수량 : <input type="number" name="quantity" min=0 max=20 value="1" >     
    <li class="list-group-item">
        <a href="javascript:cart()">
        <img class="btn" src="/svg/cart4.svg">	</a>
        <a href="javascript:order()">
        <img class="btn" src="/svg/bag-heart-fill.svg">	</a>
         <a href="javascript:history.back()">
         <img class='btn' src="/svg/arrow-return-left.svg"/></a>
 
  </ul>
  </div>
  </div>
</div>
 
</body>
</html>