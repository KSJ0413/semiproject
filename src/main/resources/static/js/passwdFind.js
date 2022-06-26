$(function(){
	$("#passwdFind_button").click(function(){


	 var id = document.querySelector("#id").value;
	 var mname = document.querySelector("#mname").value;
 
     

	  var data= {
		"id" : id,
		"mname" : mname
	  }
	  console.log(data);
	
  	$.ajax({
		 
	    type : "post", 
	    url : "/member/passwdFind?id=" + id + "&mname=" + mname,
	    // data : JSON.stringify(data),
	    data: data,
	    // dataType:"json",
	    contentType: "application/json",
	    success:function(passwdView){ 
		   console.log('성공입니다.');
		   console.log(passwdView);
		   if (passwdView == "fail") {
				alert("아이디와 이름을 다시 확인해주세요\n 문의하실 내용이 있으실 경우\n문의전화:010-0000-0000" ) 
				} 
				else {
				 
				console.log(passwdView);
				alert("회원님의 비밀번호는:"+passwdView+"입니다.\n로그인 페이지로 이동합니다.");
					location.href= 'http://localhost:8000/member/login';


			}
	    },
	    error:function(){
	        alert(err);
	    }
	}); 
        

				//Ajax버젼도 작동 완료!
/*fetch(
				'/member/passwdFind'       //?id=' + id + '&mname=' + mname
				, {
			        method: 'post',
			        headers: {
						'content-Type' : 'application-json'
					}
				})
		        .then(response => {
					console.log(response);
					// console.log(response);
					 //return response.json();
					return response.text();
				})
				.then(response => {
					if (response == "fail") {
						alert("로그인 실패");
					} else {
						 
						console.log(response);
						alert("회원님의 아이디는 : response");
					}
					
					
				}).catch(err => {
					console.log(err);
					// alert("에러입니다");
				});*/
	});

});

