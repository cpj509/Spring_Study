/**
 * 글쓰기 양식 유효성 검사
	글 제목이 비어있으면 "제목을 입력 해 주세요."
	글 내용이 비어있으면 "내용을 입력 해 주세요."
 */
function checkBoard(){
	var form = document.writeForm;
	var title = form.title.value;
	var content = form.content.value;
	
	if(title == ""){
		alert("제목을 입력 해 주세요.");
		form.title.focus();
		return false;
	}
	if(content == ""){
		alert("내용을 입력 해 주세요.");
		form.content.focus();
		return false;
	}
	form.submit();
}