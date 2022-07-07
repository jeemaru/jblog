<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="center-content">
		
		<!-- header -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- //header -->
	

		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id"></td>
		      			
		      			<td><button id="btnIdCheck" type="button">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2">사용할 수 있는 아이디 입니다.</td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value=""></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value=""></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
	      		
			</form>
			
		</div>
		
		<!-- //footer -->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		<!-- footer -->
		
	</div>

</body>

<script type="text/javascript">
/* $("#btnIdCheck").on("button", function(){
	
	var idcheck = $("#txtId").val();
	if(id == idcheck){
		alert("중복된 아이디입니다.")
		return false
	}
	
	
}); */


$("#joinForm").on("submit", function(){
	
	var id = $("#txtId").val();
	var password = $("#txtPassword").val();
	var UserName= $("#txtUserName").val();
	var idcheck = $().val("#btnIdCheck").val;
	
	if(id == "" || id == null){
		alert("아이디를 입력해주세요");
		return false;
	}
	
	if(password == "" || password == null){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	
	if(UserName == "" || UserName == null){
		alert("이름을 입력해주세요");
		return false;
	}
	
	if(idcheck == "" || idcheck == null){
		alert("이미 사용중인 아이디입니다.");
		return false;
	}
	
	//약관동의
 	var agree = $("#chkAgree").is(":checked");
		
	if(agree == false){
		alert("약관에 동의해주세요")
		return false;
	}
});

</script>



</html>