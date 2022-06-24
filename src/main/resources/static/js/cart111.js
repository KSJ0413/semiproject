/* $(".addCart_btn").click(function(){
   

 	
   var piece = $(".piece").val();
   var size = $("#size option:selected").val();
      console.log(contentsno)
      console.log(piece)
      console.log(size)
   var data = {
     contentsno : contentsno,
     size:size,
     piece : piece
     };
   if(size=="사이즈 선택"){
	alert("사이즈 선택 해주세요");
	}
else if(piece <=0 ){
	alert("수량을 1개 이상 선택해주세요.")
}else if(stock<piece){
	alert("재고보다 많이 시킬순 없습니다.")
}else{
   
   $.ajax({
    url : "/contents/addCart",
    type : "post",
    data : data,
    success : function(result){
     alert("카트 담기 성공");
     $(".numBox").val("1");
    },
    error : function(){
     alert("카트 담기 실패");
    }
   });
  }});*/
  
  function addCart(param){
	return fetch ('cart/create'),{
		method:'post',
		body: JSON.stringify(parm)
	}
	
}
	
	
