$(function(){ 
 
    $('#checkForm').on('click', function(){
        uploadFile();
    });
 
});
function uploadFile(){
    
    var form = $('#updateFileEX')[0];
    var formData = new FormData(form);
 
    $.ajax({
        url : '/member/updateFile',
        type : 'POST',
        data : formData,
        contentType : false,
        processData : false  ,
	    success:function(){ 
		   console.log('성공입니다.');    
		   location.href= 'http://localhost:8000/member/mypage';  
},error:function(){
	        alert("파일이 정상등록에 실패하였습니다.");
	        }
    })

}
