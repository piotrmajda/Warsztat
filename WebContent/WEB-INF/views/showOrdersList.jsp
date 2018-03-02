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
	      			<th scope="col"></th>	      			
	      			<th scope="col"></th>
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
	      				<td>	      				
	      					<c:forEach items="${ vehicles }" var="vehicle">
	      						<c:choose>	  								      					
	  				  				<c:when test="${vehicle.id == order.vehicleId}">
	      							${vehicle.brand}, ${vehicle.model}, ${vehicle.regNum}
	    							</c:when>    
	    							<c:otherwise>
								    </c:otherwise>
								</c:choose>
							</c:forEach>
						</td>
	      				<td>${order.plannedStartDate}</td>
	      				<td>${order.problemDesc}</td>
	      				<td>${order.startDate}</td>
	      				<td>	      				
	      					<c:forEach items="${ employees }" var="employee">
	      						<c:choose>	  								      					
	  				  				<c:when test="${employee.id == order.vehicleId}">
	      							${employee.surname}, ${employee.name}
	    							</c:when>    
	    							<c:otherwise>
								    </c:otherwise>
								</c:choose>
							</c:forEach>
						</td>
	      				<td>${order.repairDesc}</td>
	      				<td>
	      					<c:choose>	  								      					
	  				  			<c:when test="${order.generalCost > 0}">
	      							${order.generalCost}
	    						</c:when>    
	    						<c:when test="${order.partsCost > 0 && order.employeeHours >0 && order.employeeHourlyRate >0}">
	    							"${order.employeeHourlyRate * order.employeeHours + order.partsCost}
	    						</c:when> 
	    						<c:otherwise>
							    </c:otherwise>
							</c:choose>
	      				</td>
	      				<td>
	      					<c:choose>	  								      					
	  				  			<c:when test="${order.partsCost > 0}">
	      							${order.partsCost}
	    						</c:when>    
	    						<c:otherwise>
							    </c:otherwise>
							</c:choose>
	      				</td>
	      				<td>
	      					<c:choose>	  								      					
	  				  			<c:when test="${order.employeeHours > 0}">
	      							${order.employeeHours}
	    						</c:when>    
	    						<c:otherwise>
							    </c:otherwise>
							</c:choose>
	      				</td>
	      				<td>
	      					<c:choose>	  								      					
	  				  			<c:when test="${order.employeeHourlyRate > 0}">
	      							${order.employeeHourlyRate}
	    						</c:when>    
	    						<c:when test="${order.employeeHourlyRate == 0}">
	    							<c:forEach items="${ employees }" var="employee">
		    							<c:choose>
		    								<c:when test="${employee.id == order.employeeId}">
		    									${employee.employee_hours} zł/h
		    								</c:when>
		    							</c:choose>
		    						</c:forEach>
	    						</c:when>    
	    						<c:otherwise>
							    </c:otherwise>
							</c:choose>
	      				</td>	      				
	      				<td>
	      					<form action="editOrder" method="post">
								<button type="submit" name="editId" value="${order.id}" class="btn btn-warning">Edytuj</button>
							</form>
						</td>	      				
	      				<td>
							<button type="button" class="btn btn-danger" style="cursor:pointer;" data-toggle="modal" data-target="#${order.id}d">Usuń</button>
							<div class="modal fade" id="${order.id}d" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLongTitle">Czy chcesz usunąć zamówienie nr ${order.id} z dnia ${order.orderDate}, złożone przez 	      				
				      					<c:forEach items="${ clients }" var="client">
				      						<c:choose>	  								      					
				  				  				<c:when test="${client.id == order.clientId}">
				      							${client.surname}, ${client.name}
				    							</c:when>    
				    							<c:otherwise>
											    </c:otherwise>
											</c:choose>
										</c:forEach>?</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
									<form action="deleteOrder" method="post">
										<button type="submit" name="delId" value="${order.id}" class="btn btn-danger">Usuń</button>
									</form>
							      </div>
							    </div>
							  </div>
							</div>
						</td></td>

				    </tr>
				</c:forEach>			    
			</tbody>
		</table>
	</div>
	

<jsp:include page="footer.jsp"/>