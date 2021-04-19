<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	if('${resMsg}' != ''){
		alert('${resMsg }');
	}
</script>
<jsp:include page="/resources/header/header.jsp"/>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Forms</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic Form Elements
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="edit" method="post">
                                    <input type="text" name="bno" value="${vo.bno }" readonly="readonly" hidden=""/>
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" value="${vo.title }" name="title">
                                        </div>
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" name="content">${vo.content }</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" value="${vo.writer }" name="writer">
                                        </div>
                                        
                                        
                                        <button type="submit" class="btn btn-default">수정</button>
                                    </form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
<jsp:include page="/resources/header/bottom.jsp"/>