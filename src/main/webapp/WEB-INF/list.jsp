
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>페이징test</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
</head>

<body>
   
<section>
    <span>총게시물 ${totCnt} / 페이지 (${pagination.currentPageNo} / ${totalPageCnt})</span>
</div></div>
<div class="card-body">
<div class="table-responsive">
<table class="table table-bordered" width="100%" cellspacing="0" style="text-align:center;">
  <thead>
      <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>등록일</th>
      </tr>
  </thead>
  <c:forEach var="list" items="${boardList}">
  	<tr>
  		<td><c:out value="${list.qnaNum}" /></td>
  		<td>
  		<a href="/board/read?qnaNum=${list.qnaNum}&${pageVO.qustr}" >
  		<c:out value="${list.qnaMemId}" />
  		</a>
  		</td>
  		<td><c:out value="${list.qnaMemId}" /></td>
  		<td><c:out value="${list.qnaDate}" /></td>
  	</tr>
  </c:forEach>
  </tbody>
</table>

<!-- Paging[s] -->

<div class="col-sm-12 col-md-7" style="text-align:right">
<div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
  <ul class="pagination">
  
  <c:if test="${pageVO.prev}">
  <li class="paginate_button page-item previous" id="dataTable_previous">
 		 <a href="javascript:void(0);" onclick="fn_go_page(${pageVO.startDate - 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
  </li>
  </c:if>
  
  <c:forEach var="num" begin="${pageVO.startDate}" end="${pageVO.endDate}">
  <li class="paginate_button page-item">
 		 <a href="javascript:void(0);" onclick="fn_go_page(${num}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">${num}</a>
  </li>
  </c:forEach>
  
  <c:if test="${pageVO.next}">
  <li class="paginate_button page-item next" id="dataTable_next">
 		 <a href="javascript:void(0);" onclick="fn_go_page(${pageVO.endDate + 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Next</a>
  </li>
  </c:if>
  </ul>
</div>
</div>
<!-- Paging[e] -->

<form method="get"  id="listForm" action="/board/list/page">
	<input type="hidden" id="pageIndex" name="pageIndex" val="" /> 
</form>
<script>
function fn_go_page(pageNo) {
	$("#pageIndex").val(pageNo);
	$("#listForm").submit();
	return false;
}
</script>

</section>

   
</body>
</html> 