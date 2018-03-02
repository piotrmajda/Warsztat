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
	      			<th scope="col">Adres</th>
	      			<th scope="col">Numer telefonu</th>	      			
	      			<th scope="col">Notatka</th>
	      			<th scope="col">Stawka za godzinę</th>
	      			<th scope="col"></th>	      			
	      			<th scope="col"></th>
				</tr>
	  		</thead>
	  		<tbody>
	  			<c:forEach items="${ employees }" var="employee">
	    			<tr>
	      				<th scope="row">${employee.id}</th>
	      				<td>${employee.name}</td>
	      				<td>${employee.surname}</td>
	      				<td>${employee.address}</td>
	      				<td>${employee.phone}</td>	  
	      				<td>${employee.note}</td>	  
	      				<td>${employee.employee_hours} zł/h</td>	      				
	      				<td>	      				
							<button type="button" class="btn btn-warning" style="cursor:pointer;" data-toggle="modal" data-target="#${employee.id}e">Edytuj</button>
							<div class="modal fade" id="${employee.id}e" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLongTitle">Modyfikacja danych Pracownika: ${employee.surname} ${employee.name} </h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
							      	<form action="editEmployee" method="post">
										<div style="display:none;" class="form-group row">
											<label for="inputId" class="col-sm-2 col-form-label">Id</label>
											<div class="col-sm-10">
												<input type="text" name="id" class="form-control" id="inputId" value="${employee.id}">
											</div>
										</div>				
										<div class="form-group row">
											<label for="inputName" class="col-sm-2 col-form-label">Imię</label>
											<div class="col-sm-10">
												<input type="text" name="name" class="form-control" id="inputName" value="${employee.name}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputSurname" class="col-sm-2 col-form-label">Nazwisko</label>
											<div class="col-sm-10">
												<input type="text" name="surname" class="form-control" id="inputSurname" value="${employee.surname}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputAddress" class="col-sm-2 col-form-label">Adres</label>
											<div class="col-sm-10">
												<input type="text" name="address" class="form-control" id="inputAddress" value="${employee.address}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputPhone" class="col-sm-2 col-form-label">Numer telefonu</label>
											<div class="col-sm-10">
												<input type="text" name="phone" class="form-control" id="inputPhone" value="${employee.phone}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputNote" class="col-sm-2 col-form-label">Notatka</label>
											<div class="col-sm-10">
												<input type="text" name="note" class="form-control" id="inputNote" value="${employee.note}">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputEmployee_hours" class="col-sm-2 col-form-label">Stawka za godzinę pracy</label>
											<div class="col-sm-10">
												<input type="text" name="employee_hours" class="form-control" id="inputEmployee_hours" value="${employee.employee_hours}">
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
							<button type="button" class="btn btn-danger" style="cursor:pointer;" data-toggle="modal" data-target="#${employee.id}d">Usuń</button>
							<div class="modal fade" id="${employee.id}d" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							  <div class="modal-dialog modal-dialog-centered" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <h5 class="modal-title" id="exampleModalLongTitle">Czy chcesz usunąć dane Pracownika ${employee.surname} ${employee.name} ?</h5>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body">
									<form action="deleteEmployee" method="post">
										<button type="submit" name="delId" value="${employee.id}" class="btn btn-danger">Usuń</button>
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