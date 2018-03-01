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
	      			<th scope="col">Data zlecenia</th>
	      			<th scope="col">Status</th>
	      			<th scope="col">Klient</th>
	      			<th scope="col">Pojazd</th>
	      			<th scope="col">Planowana data rozpoczęcia naprawy</th>
	      			<th scope="col">Opis problemu</th>
	      			<th scope="col">Data rozpoczęcia naprawy</th>
	      			<th scope="col">Pracownik przeprowadzający naprawę</th>
	      			<th scope="col">Opis naprawy</th>
	      			<th scope="col">Całkowity koszt naprawy</th>
	      			<th scope="col">Koszt części</th>
	      			<th scope="col">Ilość roboczogodzin</th>
	      			<th scope="col">Stawka za godzinę</th>
				</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${ orders }" var="order">
	    			<tr>
	      				<th scope="row">${order.id}</th>
	      				<td>${order.orderDate}</td>
	      				<td>${order.status}</td>
	      				<td>	      				
	      					<c:forEach items="${ clients }" var="client">
	      						<c:choose>	  								      					
	  				  				<c:when test="${client.id == order.clientId}">
	      							${client.surname}, ${client.name}
	    							</c:when>    
	    							<c:otherwise>
								    </c:otherwise>
								</c:choose>
							</c:forEach>
	      				</td>
	      				<td>${order.vehicleId}</td>
	      				<td>${order.plannedStartDate}</td>
	      				<td>${order.problemDesc}</td>
	      				<td>${order.startDate}</td>
	      				<td>${order.employeeId}</td>
	      				<td>${order.repairDesc}</td>
	      				<td>${order.generalCost}</td>
	      				<td>${order.partsCost}</td>
	      				<td>${order.employeeHours}</td>
	      				<td>${order.employeeHourlyRate}</td>
				    </tr>
				</c:forEach>			    
			</tbody>
		</table>
	</div>
	

<jsp:include page="footer.jsp"/>