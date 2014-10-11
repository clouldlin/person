<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자료실</title>
<%@ include file="../include/common.jsp"%><!-- 공통 js/css 및 contextPath  -->
</head>
<body>
<%@ include file="../include/header.jsp"%><!-- 로그인 바   -->
<div class="wrapper">
<%@ include file="../include/sidebar.jsp"%><!-- 사이드 메뉴  --> 
	<div class="col-lg-9" style="padding: 20px;">
		<h1 class="page-header">자료실</h1>
		<div class="panel">
			<div class="panel-heading">공개 자료실</div>
			<div class="panel-body">
				<table class="table table-bordered table-striped table-hover">
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="10%" />
						<col width="10%" />
						<col width="10%" />
					</colgroup>
					<thead>
						<tr>
							<th class="text-center">글번호</th>
							<th>제목</th>
							<th class="text-center">작성자</th>
							<th class="text-center">작성일</th>
							<th class="text-center">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="text-center">10</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">9</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">8</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">7</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">6</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">5</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">4</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">3</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">2</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
						<tr>
							<td class="text-center">1</td>
							<td><a href="#">제목입니다.</a></td>
							<td class="text-center">작성자</td>
							<td class="text-center">2013-12-18</td>
							<td class="text-center">1</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li><a href="#">Prev</a></li>
                    <li><a href="#">«</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><a href="#">10</a></li>
                    <li><a href="#">»</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </div>
        </div>
	</div>
</div>
</body>
</html>