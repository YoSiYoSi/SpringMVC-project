<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MainPage</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="${path}/resources/mystyle.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${path}/resources/afterstyle.css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<script>
    //load함수를 이용하여 core스크립트의 로딩이 완료된 후, 우편번호 서비스를 실행합니다.
$('document').ready(function(){
	$('#find').click(function(){
		daum.postcode.load(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	                // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	                $('.address1').val(data.address);
	                $('.address2').val(data.zonecode);
	            }
	        }).open();
	    });
	});



	
	
}) ;
    
window.idcheck = function() {
	
	var id = $('#id').val();
	if(id =='')
		document.getElementById("checkmsg").innerHTML = "<font color='red'>아이디를 입력하세요.";

		else{
		    $.ajax({
		        url: "${path}/checkid",
		        type: "post",
		        data: {"value": $('#id').val()},
		        success: function(result){
		           if(result=='true'){
		        	   document.getElementById("checkmsg").innerHTML = "아이디를 사용할 수 있습니다";
		           }
		           else if(result=='false'){
		        	   document.getElementById("checkmsg").innerHTML = "<font color='red'>이미 존재하는 아이디입니다.";
		        	   
		           }
		        },
		        error : function(e){
		           alert(e.status);
		        }
		     }) 
			
		}
	
	}
	
window.pwdcheck = function(){
	
	if($('#pw').val()!= $('#pwchk').val()) 
		document.getElementById("pwdchecking").innerHTML = "<font color='red'>비밀번호가 일치하지 않습니다.";
		else
			document.getElementById("pwdchecking").innerHTML = "<font color='green'>일치합니다.";
		
}

</script> 
<style>


.form-control joinbox{

padding:15px;
font-color: red;
}


</style>
</head>

<body>
	<div class="container" >
		<div class="row header" >
			<div class="col" >
			<%@ include file="header.jsp" %>
			 <%@ include file="category.jsp" %>
			</div>
		</div>
		<hr>
		<div class="row ">
			<div class="col">
				<h1 class="jointitle">Palza 회원가입</h1>
			</div>
		</div>
		
		<form name="joined" action="joined" method="POST">
			<div class="row" >
				<div class="col" style="width:50%;padding:50px;">
				<h3>필수정보</h3>
					<input type="text" class="form-control joinbox" id="id" placeholder="아이디" maxlength="20" style="width:30%;display:inline;">
					<input type="button" class="form-control joinbox" name="idcheckbt" onclick="idcheck();" style="width:150px;display:inline;background-color: #99FF99;" value="아이디 확인">
					<span id="checkmsg" style="margin-left:10px"></span><br>
					
					<input type="password" class="form-control joinbox" id="pw" placeholder="비밀번호" style="width:30%; font-family:initial;font-size:21px;display:inline; margin-bottom: 10px;" >
					<input type="password" class="form-control joinbox" id="pwchk" placeholder="비밀번호확인" onchange="pwdcheck()"style="width:30%;display:inline;font-family:initial;font-size:21px; margin-bottom: 10px;" >
					<span id="pwdchecking" style="margin-left:10px"></span><br>
					
					<input type="text" class="form-control joinbox" name="name" placeholder="이름" style="width:30%">
					<input type="email" class="form-control joinbox" name="email" placeholder="이메일"style="width:30%; display:inline" >
					<select name="emailselect" style="width:200px; height:40px"> 
						  <option value="" selected="selected">직접입력</option>
						  <option value="naver.com">네이버</option>
						  <option value="daum.net">다음</option>
						  <option value="gmail.com">G메일</option>
						</select>
					<input type="text" class="form-control joinbox address2" name="address1" placeholder="번지 주소" style="width:80%;display:inline;">
					<input type="button" id="find" class="form-control joinbox" name="address" style="width:100px;display:inline;background-color: #99FF99;" value="주소찾기">
					<input type="text" class="form-control joinbox address1" name="address2" placeholder="도로명 주소" >
					<input type="text" class="form-control joinbox address" name="address3" placeholder="상세 주소" >
					<input type="tel" class="form-control joinbox" name="tel" placeholder="전화번호" >
					<input type="submit" class="form-control login-try" value="회원가입 완료">
				</div>
			</div>
			
			
		</form>
		<%@ include file="footer.jsp" %>
		
	</div>

</body>
</html>