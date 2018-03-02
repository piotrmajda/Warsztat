<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

								<form action="addEmployee" method="post">
									<fieldset style="padding:1em">			
										<div class="form-group row">
											<label for="inputName" class="col-sm-2 col-form-label">Imię</label>
											<div class="col-sm-10">
												<input type="text" name="name" class="form-control" id="inputName" placeholder="Imię">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputSurname" class="col-sm-2 col-form-label">Nazwisko</label>
											<div class="col-sm-10">
												<input type="text" name="surname" class="form-control" id="inputSurname" placeholder="Nazwisko">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputAddress" class="col-sm-2 col-form-label">Adres</label>
											<div class="col-sm-10">
												<input type="text" name="address" class="form-control" id="inputAddress" placeholder="Adres">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputPhone" class="col-sm-2 col-form-label">Numer telefonu</label>
											<div class="col-sm-10">
												<input type="text" name="phone" class="form-control" id="inputPhone" placeholder="Numer telefonu">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputNote" class="col-sm-2 col-form-label">Notatka</label>
											<div class="col-sm-10">
												<input type="text" name="note" class="form-control" id="inputNote" placeholder="Notatka">
											</div>
										</div>
										<div class="form-group row">
											<label for="inputEmployee_hours" class="col-sm-2 col-form-label">Stawka za godzinę pracy</label>
											<div class="col-sm-10">
												<input type="text" name="employee_hours" class="form-control" id="inputEmployee_hours" placeholder="Stawka za godzinę pracy">
											</div>
										</div>
										
										<div class="form-group row">
											<div class="col-sm-10">
												<button type="submit" class="btn btn-warning">Dodaj pracownika</button>
											</div>
										</div>
									</fieldset>
								</form>

<jsp:include page="footer.jsp"/>
