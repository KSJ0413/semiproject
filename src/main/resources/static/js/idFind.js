$(function(){
	$("#idFind_button").click(function(){


	 var mname = document.querySelector("#mname").value;
	 var email = document.querySelector("#email").value;
 
     

	  var data= {
		"mname" : mname,
		"email" : email
	  }
	  console.log(data);
  	$.ajax({
		 
	    type : "post", 
	    url : "/member/idFind?mname=" + mname + "&email=" + email,
	    // data : JSON.stringify(data),
	    data: data,
	    // dataType:"json",
	    contentType: "application/json",
	    success:function(idView){ 
		   console.log('성공입니다.');
		   console.log(idView);
		   if (idView == "fail") {
				alert("아이디와 비밀번호를 다시 확인해주세요\n 문의하실 내용이 있으실 경우\n문의전화:010-1581-482\n🤣🤣마지막 번호는 추리하세요.🤣🤣 " );
			} else {
				 
				console.log(idView);
				alert("회원님의 아이디는:"+idView+"입니다. \n로그인페이지로 이동합니다.");
					location.href= 'http://localhost:8000/member/login';


			}
	    },
	    error:function(){
	        alert("error");
	    }
	}); 
        

				//Ajax버젼도 작동 완료!
/*	fetch(
				'/member/idFindf?mname=' + mname + '&email=' + email
				, {
			        method: 'get',
			        headers: {
						'content-Type' : 'application-json'
					}
				})
		        .then(response => {
					console.log(response);
					// console.log(response);
					// return response.json();
					return response.text();
				}).then(response => {
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

