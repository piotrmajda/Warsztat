<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

	<form action="" method="post">
	<fieldset style="padding:1em">
	  <div class="form-group row">
	    <label for="inputPlannedStartDate" class="col-sm-2 col-form-label">Planowana data rozpoczęcia naprawy</label>
	    <div class="col-sm-10">
	      <input type="date" name="plannedStartDate" class="form-control" id="inputPlannedStartDate" value="">
	    </div>
	  </div>
	  
	  
<%--
	  <div class="form-group row">
	    <label for="inputSurname" class="col-sm-2 col-form-label">Wybierz pracownika do tej naprawy</label>
	    <div class="col-sm-10">
	      <select name="employeeId" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">	      
    			<option selected>Wybierz pracownika...</option>
	      	<c:forEach items="${ employees }" var="employee">
				<option value="${employee.id}">${employee.surname}, ${employee.name}, ${employee.employee_hours}zł/h</option>
    	 	</c:forEach>
    	  </select>
	    </div>
	  </div>
--%>
	  
	  <div class="form-group row">
	    <label for="inputProblemDesc" class="col-sm-2 col-form-label">Podaj opis problemu</label>
	    <div class="col-sm-10">
	      <input type="text" name="problemDesc" class="form-control" id="inputProblemDesc" placeholder="Opis problemu">
	    </div>
	  </div>
	  
<%--	  
	  <div class="form-group row">
	    <label for="inputSurname" class="col-sm-2 col-form-label">Wybierz pojazd, którego dotyczy naprawa</label>
	    <div class="col-sm-10">
	      <select name="employeeId" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">	      
    			<option selected>Wybierz pojazd...</option>
	      	<c:forEach items="${ vehicles }" var="vehicle">
				<option value="${vehicle.id}">${vehicle.regNum}</option>
    	 	</c:forEach>
    	  </select>
	    </div>
	  </div>
--%>	    
	  <div class="form-group row">
	    <label for="inputSurname" class="col-sm-2 col-form-label">Wybierz Klienta, który zgłasza naprawę</label>
	    <div class="col-sm-10">
	      <select name="employeeId" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">	      
    			<option selected>Wybierz Klienta...</option>
	      	<c:forEach items="${ clients }" var="client">
				<option value="${client.id}">${client.surname}, %{client.name}</option>
    	 	</c:forEach>
    	  </select>
	    </div>
	  </div>	    
	  
	  <div class="form-group row">
	    <label for="inputSurname" class="col-sm-2 col-form-label">Wybierz status zamówienia</label>
	    <div class="col-sm-10">
	      <select name="employeeId" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">	      
    			<option selected>Wybierz status...</option>
				<option value="Przyjęty">Przyjęty</option>
				<option value="Zatwierdzone koszty naprawy">Zatwierdzone koszty naprawy</option>
				<option value="W naprawie">W naprawie</option>
				<option value="Gotowy do odbioru">Gotowy do odbioru</option>
				<option value="Rezygnacja">Rezygnacja</option>
    	  </select>
	    </div>
	  </div>
	  
	  
	  <div class="form-group row">
	    <div class="col-sm-10">
	      <button type="submit" class="btn btn-primary">Dodaj zamówienie</button>
	    </div>
	  </div>
	</fieldset>
	</form>


<jsp:include page="footer.jsp"/>