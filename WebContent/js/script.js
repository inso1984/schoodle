const Login = {
	doLogin: () => {
		const data = {
			email:$("#loginEmail").val(),
			pw:$("#loginPw").val()
		}
		
		$.post( "/Schoodle/login.jsp",data, ( data )=> {
		  if(data.success === true){
			  location.reload();
		  }else{
			  $("#loginError").removeClass("hidden");
		  }
		});
		
	}
}