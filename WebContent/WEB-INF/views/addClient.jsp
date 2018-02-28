<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

	<form action="" method="post">
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
	    <label for="inputMail" class="col-sm-2 col-form-label">Adres e-mail</label>
	    <div class="col-sm-10">
	      <input type="text" name="mail" class="form-control" id="inputMail" placeholder="Adres e-mail">
	    </div>
	  </div>
	  <div class="form-group row">
	    <label for="inputPhone" class="col-sm-2 col-form-label">Numer telefonu</label>
	    <div class="col-sm-10">
	      <input type="text" name="phone" class="form-control" id="inputPhone" placeholder="Numer telefonu">
	    </div>
	  </div>
	
	  <div class="form-group row">
	    <div class="col-sm-10">
	      <button type="submit" class="btn btn-primary">Dodaj Klienta</button>
	    </div>
	  </div>
	</fieldset>
	</form>


<jsp:include page="footer.jsp"/>