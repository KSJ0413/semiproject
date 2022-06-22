<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/passwdFind.js" type="text/javascript"></script>
  <title>아이디 찾기</title>
  <meta charset="utf-8">
</head>
<body>
<div class="container">

<h1 class="col-sm-offset-2 col-sm-10">비밀번호 찾기</h1>
  <form class="form-horizontal" 
        action="/member/passwdFind"
        method="post">
     <input type="hidden" name="rurl" value="${param.rurl}">    
    <input type="hidden" name="bbsno" value="${param.bbsno}">    
    <input type="hidden" name="nowPage" value="${param.nowPage}">    
    <input type="hidden" name="nPage" value="${param.nPage}">    
    <input type="hidden" name="col" value="${param.col}">    
    <input type="hidden" name="word" value="${param.word}"> 
        
    <div class="form-group">
      <label class="control-label col-sm-2" >아이디</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="id" 
        placeholder="Enter id" name="id" required="required" 
        value='${c_id_val}'>
      </div>
    </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="mname">이름</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="mname" 
        placeholder="Enter mname" name="mname" required="required" >
      </div>
    </div>
   
    
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-8">
       
      
        
        <button type="button" class="btn btn-default" onclick="location.href='/'">홈으로</button>
        <button type="button" class="btn btn-default" onclick="location.href='/member/login'">로그인</button>
        <button type="button" class="btn btn-default" id="passwdFind_button">비밀번호 찾기</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>