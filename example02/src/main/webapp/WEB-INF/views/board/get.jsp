<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Read</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${board.bno }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'
            readonly="readonly"><c:out value="${board.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer }"/>' readonly="readonly">
        </div>
        <!-- 버튼에 직접 버튼에 링크를 처리하는 방식. 다양한 상황에 대응하기 위해서 밑에 방식으로 수정함.
		<button data-oper='modify' class="btn btn-default"
			onclick="location.href='/board/modify?bno=<c:out value="${board.bno }"/>'">Modify</button>
		<button data-oper='list' class="btn btn-info"
			onclick="location.href='/board/list'">List</button>
		 -->
		<button data-oper='modify' class="btn btn-default">Modify</button>
		<button data-oper='list' class="btn btn-info">List</button>
		<form id="operForm" action="/board/modify" method="get">
			<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"></c:out>' />
		</form>
      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<script type="text/javascript">
$(document).ready(function() {
	var operForm = $("#operForm"); 
	$("button[data-oper='modify']").on("click", function(e){
        operForm.attr("action","/board/modify").submit();
      });
	$("button[data-oper='list']").on("click", function(e){
        operForm.find("#bno").remove();    
        operForm.attr("action","/board/list").submit();
  });  
});
</script>

<%@include file="../includes/footer.jsp"%>