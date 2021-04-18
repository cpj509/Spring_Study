/**
 *	폼 유효성 검사
	아이디 - 4 ~ 12자 가능
	비밀번호 - 8 ~ 20자 가능 (영문+숫자 조합)
	비밀번호와 비밀번호 확인이 같지 않으면 '비밀번호를 동일하게 입력 해 주세요.'
	이름을 입력하지 않으면 '이름을 입력 해 주세요'.
 */

function checkMember(){
	var form = document.regForm;
	var id = form.memberId.value;
	var pw1 = form.passwd.value;
	var pw2 = form.passwd_confirm.value;
	var name = form.name.value;
	
	var regExPw = /^[a-zA-Z0-9]{6,15}$/;	//중괄호는 글자 수 지정
	var chk_num = pw1.search(/[0-9]/g);
	var chk_eng = pw1.search(/[a-zA-Z]/g);
	
	if(id.length < 4 || id.length > 12){
		alert("아이디는 4 ~ 12자 까지 가능합니다.");
		form.memberId.select();
		return false;
	}
	
	if(!regExPw.test(pw1) || chk_num < 0 || chk_eng < 0){
		alert("비밀번호는 영문자와 숫자의 조합으로 6 ~ 15자 까지 가능합니다.");
		form.passwd.select();
		return false;
	}
	
	if(pw1 != pw2){
		alert("비밀번호를 동일하게 입력 해 주세요.");
		form.passwd_confirm.select();
		return false;
	}
	
	if(name == ""){
		alert("이름을 입력 해 주세요.");
		form.name.focus();
		return false;
	}
	
	var genderCheck = 0;
	
	for(var i = 0; i < form.gender.length; i++){
		if(form.gender[i].checked == true){
			genderCheck++;
			break;
		}
	}
	if(genderCheck == 0){
		alert("성별을 선택 해 주세요.");
		return false;
	}
	
	form.submit();	//onclick이 들어간 input tag가 submit에 return checkmember면 필요 없음.
}