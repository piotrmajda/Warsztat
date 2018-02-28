<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

	<div class="table-responsive">
		<table class="table table-hover" style="width:98%; margin-left:1%;">
			<thead>
	    		<tr>
	      			<th scope="col">#</th>
	      			<th scope="col">Imię</th>
	      			<th scope="col">Nazwisko</th>
	      			<th scope="col">E-mail</th>
	      			<th scope="col">Numer telefonu</th>
				</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${ clients }" var="client">
	    			<tr>
	      				<th scope="row">${client.id}</th>
	      				<td>${client.name}</td>
	      				<td>${client.surname}</td>
	      				<td>${client.mail}</td>
	      				<td>${client.phone}</td>
				    </tr>
				</c:forEach>			    
			</tbody>
		</table>
	</div>
	

<jsp:include page="footer.jsp"/>