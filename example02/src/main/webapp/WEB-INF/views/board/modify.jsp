<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Modify Page</div>
      
      <form role="form" action="/board/modify" method="post">
      
      <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"></c:out>' />
      <input type="hidden" name="amount" value='<c:out value="${cri.amount }"></c:out>' />
	  <input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"></c:out>' />
	  <input type="hidden" name="type" value='<c:out value="${cri.type }"></c:out>' />	
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>Bno</label> <input class="form-control" name='bno'
            value='<c:out value="${board.bno }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Title</label> <input class="form-control" name='title'
            value='<c:out value="${board.title }"/>' >
        </div>

        <div class="form-group">
          <label>Text area</label>
          <textarea class="form-control" rows="3" name='content'><c:out value="${board.content}" /></textarea>
        </div>

        <div class="form-group">
          <label>Writer</label> <input class="form-control" name='writer'
            value='<c:out value="${board.writer }"/>' readonly="readonly">
        </div>
		<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
		<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  		<button type="submit" data-oper='list' class="btn btn-info">List</button>
      </div>
      <!--  end panel-body -->
      </form>
    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->
<script type="text/javascript">
$(function(){
	var formObj = $("form");
	
	$('button').on("click", function (e) {
		e.preventDefault();	//form태그는 기본적으로 submit으로 처리하기 때문에 기본 동작을 막음. 마지막에 조건을 거친 후 직접 submit 처리.
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'remove'){	//삭제.
			formObj.attr("action", "/board/remove");
		}else if(operation === 'list'){	//list로 이동.
			formObj.attr("action", "/board/list").attr("method", "get");
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone();
			var typeTag = $("input[name='type']").clone();
			var keywordTag = $("input[name='keyword']").clone();
		
			formObj.empty();	//위에 필요한 부분인 pageNum과 amount를 복사해 두고 form 태그의 내용을 지움.
			formObj.append(pageNumTag);
			formObj.append(amountTag);
			formObj.append(typeTag);
			formObj.append(keywordTag);
		}
		formObj.submit();
	});
});

</script>

<%@include file="../includes/footer.jsp"%>
