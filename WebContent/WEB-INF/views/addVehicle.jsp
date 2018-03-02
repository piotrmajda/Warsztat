<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

	<form action="" method="post">
	<fieldset style="padding:1em">	  
	  <div class="form-group row">
	    <label for="inputBrand" class="col-sm-2 col-form-label">Podaj producenta pojazdu</label>
	    <div class="col-sm-10">
	      <input type="text" name="brand" class="form-control" id="inputBrand" placeholder="Podaj producenta pojazdu">
	    </div>
	  </div>	  
	  <div class="form-group row">
	    <label for="inputModel" class="col-sm-2 col-form-label">Podaj model pojazdu</label>
	    <div class="col-sm-10">
	      <input type="text" name="model" class="form-control" id="inputModel" placeholder="Podaj model pojazdu">
	    </div>
	  </div>	  
	  <div class="form-group row">
	    <label for="inputProdYear" class="col-sm-2 col-form-label">Podaj rok produkcji pojazdu</label>
	    <div class="col-sm-10">
	      <input type="text" name="prodYear" class="form-control" id="inputProdYear" placeholder="Podaj rok produkcji pojazdu">
	    </div>
	  </div>	  
	  <div class="form-group row">
	    <label for="inputRegNum" class="col-sm-2 col-form-label">Podaj numer rejestracyjny pojazdu</label>
	    <div class="col-sm-10">
	      <input type="text" name="regNum" class="form-control" id="inputRegNum" placeholder="Podaj numer rejestracyjny pojazdu">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="inputNextService" class="col-sm-2 col-form-label">Data kolejnego przeglądu technicznego</label>
	    <div class="col-sm-10">
	      <input type="date" name="nextService" class="form-control" id="inputNextService" value="">
	    </div>
	  </div>	    
	  <div class="form-group row">
	    <label for="selectClientId" class="col-sm-2 col-form-label">Wybierz Klienta, do którego należy pojazd</label>
	    <div class="col-sm-10">
	      <select name="clientId" class="custom-select my-1 mr-sm-2" id="selectClientId">	      
    			<option selected>Wybierz Klienta...</option>
	      	<c:forEach items="${ clients }" var="client">
				<option value="${client.id}">${client.surname}, ${client.name}</option>
    	 	</c:forEach>
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
	  