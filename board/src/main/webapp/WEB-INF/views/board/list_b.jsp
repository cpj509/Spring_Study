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
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <button type="button" class="btn btn-default" onclick="location.href='register'">등록</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>bno</th>
										<th>title</th>
										<th>writer</th>
										<th>regdate</th>
										<th>updatedate</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="list" items="${list }">
                                    <tr class="odd gradeX">
                                    	<td><c:out value="${list.getBno() }"></c:out></td>
										<td><a href="get?bno=${list.getBno() }"><c:out value="${list.getTitle() }"></c:out></a></td>
										<td><c:out value="${list.getWriter() }"></c:out></td>
										<td><c:out value="${list.getRegdate() }"></c:out></td>
										<td><c:out value="${list.getUpdatedate() }"></c:out></td>
                                    </tr>
								</c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
							
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
        </div>
        <!-- /#page-wrapper -->
<jsp:include page="/resources/header/bottom.jsp"/>