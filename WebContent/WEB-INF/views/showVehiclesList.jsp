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
	      			<th scope="col">Producent</th>
	      			<th scope="col">Model</th>
	      			<th scope="col">Rok produkcji</th>
	      			<th scope="col">Numer rejestracyjny</th>	      			
	      			<th scope="col">Data ważności badań technicznych</th>
	      			<th scope="col">Właściciel</th>
	      			<th scope="col"></th>	      			
	      			<th scope="col"></th>
				</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${ vehicles }" var="vehicle">
	    			<tr>
	      				<th scope="row">${vehicle.id}</th>
	      				<td>${vehicle.brand}</td>
	      				<td>${vehicle.model}</td>
	      				<td>
	      					<c:choose>	  								      					
	  				  			<c:when test="${vehicle.prodYear > 0}">
	      							${vehicle.prodYear}
	    						</c:when>    
	    						<c:otherwise>
							    </c:otherwise>
							</c:choose>
	      				</td>
	      				<td>${vehicle.regNum}</td>	  
	      				<td>${vehicle.nextService}</td>
	      				<td>	      				
	      					<c:forEach items="${ clients }" var="client">
	      						<c:choose>	  								      					
	  				  				<c:when test="${client.id == vehicle.clientId}">
	      							${client.surname}, ${client.name}
	    							</c:when>    
	    							<c:otherwise>
								    </c:otherwise>
								</c:choose>
							</c:forEach>
	      				</td>	      				
	      				<td>	      				
							<button type="button" class="btn btn-warning" style="cursor:pointer;" data-toggle="modal" data-target="#${vehicle.id}e">Edytuj</button>
							<div class="modal fade" id="${vehicle.id}e" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLongTitle">Modyfikacja danych pojazdu: ${vehicle.brand}, ${vehicle.model}, ${vehicle.regNum}</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							      	<form action="editVehicle" method="post">
							      	
										<div style="display:none;" class="form-group row">
											<label for="inputId" class="col-sm-2 col-form-label">Id</label>
											<div class="col-sm-10">
												<input type="text" name="id" class="form-control" id="inputId" value="${vehicle.id}">
											</div>
										</div>				
										<div class="form-group row">
											<label for="inputBrand" class="col-sm-2 col-form-label">Producent</label>
											<div class="col-sm-10">
												<input type="text" name="brand" class="form-control" id="inputBrand" value="${vehicle.brand}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputModel" class="col-sm-2 col-form-label">Model</label>
											<div class="col-sm-10">
												<input type="text" name="model" class="form-control" id="inputModel" value="${vehicle.model}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputProdYear" class="col-sm-2 col-form-label">Rok produkcji</label>
											<div class="col-sm-10">
												<input type="text" name="prodYear" class="form-control" id="inputProdYear" value="<c:choose><c:when test="${vehicle.prodYear > 0}">${vehicle.prodYear}</c:when><c:otherwise></c:otherwise></c:choose>">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputRegNum" class="col-sm-2 col-form-label">Numer rejestracyjny</label>
											<div class="col-sm-10">
												<input type="text" name="regNum" class="form-control" id="inputRegNum" value="${vehicle.regNum}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputNextService" class="col-sm-2 col-form-label">Data kolejnego przeglądu</label>
											<div class="col-sm-10">
												<input type="date" name="nextService" class="form-control" id="inputNextService" value="${vehicle.nextService}">
											</div>
										</div>	    
										<div class="form-group row">
											<label for="selectClientId" class="col-sm-2 col-form-label">Właściciel</label>
											<div class="col-sm-10">
												<select name="clientId" class="custom-select my-1 mr-sm-2" id="selectClientId">	 
	      											<c:forEach items="${ clients }" var="client">
	      												<c:choose>	  								      					
	  				  										<c:when test="${client.id == vehicle.clientId}">	      							
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
							<button type="button" class="btn btn-danger" style="cursor:pointer;" data-toggle="modal" data-target="#${vehicle.id}d">Usuń</button>
							<div class="modal fade" id="${vehicle.id}d" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLongTitle">Czy chcesz usunąć dane pojazdu ${vehicle.brand} ${vehicle.model}, ${vehicle.regNum}?</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
									<form action="deleteVehicle" method="post">
										<button type="submit" name="delId" value="${vehicle.id}" class="btn btn-danger">Usuń</button>
									</form>
							      </div>
							    </div>
							  </div>
							</div>
						</td>
				    </tr>
				</c:forEach>			    
			</tbody>
		</table>
	</div>
	

<jsp:include page="footer.jsp"/>