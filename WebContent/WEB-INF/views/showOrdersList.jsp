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
	  				  				<c:when test="${employee.id == order.employeeId}">
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
							<button type="button" class="btn btn-warning" style="cursor:pointer;" data-toggle="modal" data-target="#${order.id}e">Edytuj</button>
							<div class="modal fade" id="${order.id}e" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLongTitle">Modyfikacja zamówienia nr ${order.id} z dnia ${order.orderDate}, złożonego przez 	      				
				      					<c:forEach items="${ clients }" var="client">
				      						<c:choose>	  								      					
				  				  				<c:when test="${client.id == order.clientId}">
				      							${client.surname}, ${client.name}
				    							</c:when>    
				    							<c:otherwise>
											    </c:otherwise>
											</c:choose>
										</c:forEach></h5>
							      </div>
							      <div class="modal-body">
							      	<form action="editOrder" method="post">
										<div style="display:none;" class="form-group row">
											<label for="inputId" class="col-sm-2 col-form-label">Id</label>
											<div class="col-sm-10">
												<input type="text" name="id" class="form-control" id="inputId" value="${order.id}">
											</div>
										</div>																				
										<div class="form-group row">
										    <label for="editDate" class="col-sm-2 col-form-label">Data przyjęcia zamówienia</label>
										    <div class="col-sm-10">
										      <input type="date" name="orderDate" class="form-control" id="editDate" value="${order.orderDate}">
										    </div>
										</div>
										<div class="form-group row">
										    <label for="selectStatus" class="col-sm-2 col-form-label">Wybierz status zamówienia</label>
										    <div class="col-sm-10">
										      <select name="status" class="custom-select my-1 mr-sm-2" id="selectStatus">	 
											      <c:choose>
													<c:when test="${empty order.status}">
														<option selected>Wybierz status...</option>
													</c:when>
													<c:when test="${order.status == 'Przyjęty'}">
													<option selected value="Przyjęty">Przyjęty</option>
													</c:when>
													<c:when test="${order.status == 'Zatwierdzone koszty naprawy'}">
													<option selected value="Zatwierdzone koszty naprawy">Zatwierdzone koszty naprawy</option>
													</c:when>
													<c:when test="${order.status == 'W naprawie'}">
													<option selected value="W naprawie">W naprawie</option>
													</c:when>
													<c:when test="${order.status == 'Gotowy do odbioru'}">
													<option selected value="Gotowy do odbioru">Gotowy do odbioru</option>
													</c:when>
													<c:when test="${order.status == 'Rezygnacja'}">
													<option selected value="Rezygnacja">Rezygnacja</option>
													</c:when>											      
											      </c:choose>     
									    			<option>Wybierz status...</option>
													<option value="Przyjęty">Przyjęty</option>
													<option value="Zatwierdzone koszty naprawy">Zatwierdzone koszty naprawy</option>
													<option value="W naprawie">W naprawie</option>
													<option value="Gotowy do odbioru">Gotowy do odbioru</option>
													<option value="Rezygnacja">Rezygnacja</option>
									    	  </select>
										    </div>
										</div>
										<div class="form-group row">
											<label for="selectClientId" class="col-sm-2 col-form-label">Klient</label>
											<div class="col-sm-10">
												<select name="clientId" class="custom-select my-1 mr-sm-2" id="selectClientId">	 
	      											<c:forEach items="${ clients }" var="client">
	      												<c:choose>	  								      					
	  				  										<c:when test="${client.id == order.clientId}">	      							
																<option selected value="${client.id}">${client.surname}, ${client.name}</option>
	    													</c:when>    
	    													<c:otherwise>
								  							</c:otherwise>
														</c:choose>
													</c:forEach>													
	    											<option >Wybierz Klienta...</option>
													<c:forEach items="${ clients }" var="client">
														<option value="${client.id}">${client.surname}, ${client.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="form-group row">
											<label for="selectVehicleId" class="col-sm-2 col-form-label">Pojazd</label>
											<div class="col-sm-10">
												<select name="vehicleId" class="custom-select my-1 mr-sm-2" id="selectVehicleId">	
																<c:forEach items="${ vehicles }" var="vehicle">
						      												<c:choose>	  								      					
						  				  										<c:when test="${vehicle.id == order.vehicleId}">	      							
																					<option selected value="${vehicle.id}">${vehicle.brand}, ${vehicle.model}, ${vehicle.regNum}</option>
						    													</c:when>    
						    													<c:otherwise>
													  							</c:otherwise>
																			</c:choose>
																		</c:forEach>													
						    											<option >Wybierz pojazd...</option>
																		<c:forEach items="${ vehicles }" var="vehicle">
																			<option value="${vehicle.id}">${vehicle.brand}, ${vehicle.model}, ${vehicle.regNum}</option>
																		</c:forEach>				
												</select>
											</div>
										</div>
										
										<div class="form-group row">
										    <label for="inputPlannedStartDate" class="col-sm-2 col-form-label">Planowana data rozpoczęcia naprawy</label>
										    <div class="col-sm-10">
										      <input type="date" name="plannedStartDate" class="form-control" id="inputPlannedStartDate" value="${order.plannedStartDate}">
										    </div>
										</div>
										<div class="form-group row">
											<label for="editProblemDesc" class="col-sm-2 col-form-label">Opis problemu</label>
											<div class="col-sm-10">
												<input type="text" name="problemDesc" class="form-control" id="editProblemDesc" value="${order.problemDesc}">
											</div>
										</div>
										
										<div class="form-group row">
										    <label for="inputStartDate" class="col-sm-2 col-form-label">Data rozpoczęcia naprawy</label>
										    <div class="col-sm-10">
										      <input type="date" name="startDate" class="form-control" id="inputStartDate" value="${order.startDate}">
										    </div>
										</div>
										<div class="form-group row">
											<label for="selectEmployeeId" class="col-sm-2 col-form-label">Pracownik</label>
											<div class="col-sm-10">
												<select name="employeeId" class="custom-select my-1 mr-sm-2" id="selectEmployeeId">	 
	      											<c:forEach items="${ employees }" var="employee">
	      												<c:choose>	  								      					
	  				  										<c:when test="${employee.id == order.employeeId}">	      							
																<option selected value="${employee.id}">${employee.surname}, ${employee.name}</option>
	    													</c:when>    
	    													<c:otherwise>
								  							</c:otherwise>
														</c:choose>
													</c:forEach>													
	    											<option >Wybierz pracownika...</option>
													<c:forEach items="${ employees }" var="employee">
														<option value="${employee.id}">${employee.surname}, ${employee.name}</option>
													</c:forEach>
												</select>
											</div>
										</div> 
										
										
										
										
										<div class="form-group row">
											<label for="inputRepairDesc" class="col-sm-2 col-form-label">Opis naprawy</label>
											<div class="col-sm-10">
												<input type="text" name="repairDesc" class="form-control" id="inputRepairDesc" value="${order.repairDesc}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputGeneralCost" class="col-sm-2 col-form-label">Koszt naprawy</label>
											<div class="col-sm-10">
												<input type="text" name="generalCost" class="form-control" id="inputGeneralCost" value="${order.partsCost + order.employeeHours * order.employeeHourlyRate}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputPartsCost" class="col-sm-2 col-form-label">Koszt części</label>
											<div class="col-sm-10">
												<input type="text" name="partsCost" class="form-control" id="inputPartsCost" value="${order.partsCost}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputEmployeeHours" class="col-sm-2 col-form-label">Ilość roboczogodzin</label>
											<div class="col-sm-10">
												<input type="text" name="employeeHours" class="form-control" id="inputEmployeeHours" value="${order.employeeHours}">
											</div>
										</div>
										
										
										<div class="form-group row">
											<label for="inputEmployeeHourlyRate" class="col-sm-2 col-form-label">Stawka</label>
											<div class="col-sm-10">
												<c:forEach items="${ employees }" var="employee">
			      									<c:choose>	  								      					
			  				  							<c:when test="${employee.id == order.employeeId}">	      							
															<input type="text" name="employeeHourlyRate" class="form-control" id="inputEmployeeHourlyRate" value="${employee.employee_hours}">
			    										</c:when> 
													</c:choose>
												</c:forEach>		
											</div>
										</div>
										
										
										
										
										
										
							      
							      
							      
							      
							      
										<div class="form-group row">
											<div class="col-sm-10">
												<button type="submit" class="btn btn-warning">Zapisz</button>
											</div>
										</div>
							      
									</form>
									
							      
							      </div>
							  </div>
							</div>
						</div>
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