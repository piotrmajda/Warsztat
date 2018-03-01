<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<c:forEach items="${ clients }" var="client">
<button type="button" class="btn btn-secondary" style="cursor:pointer;" data-toggle="modal" data-target="#${client.id}">${client.surname}, ${client.name}</button>

<div class="modal fade" id="${client.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Edytuj dane dla ${client.surname}, ${client.name}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
      	

				<form action="editClient" method="post">
				<div style="display:none;" class="form-group row">
				    <label for="inputId" class="col-sm-2 col-form-label">Id</label>
				    <div class="col-sm-10">
				      <input type="text" name="id" class="form-control" id="inputId" value="${client.id}">
				    </div>
				  </div>				
				  <div class="form-group row">
				    <label for="inputName" class="col-sm-2 col-form-label">Imię</label>
				    <div class="col-sm-10">
				      <input type="text" name="name" class="form-control" id="inputName" value="${client.name}">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="inputSurname" class="col-sm-2 col-form-label">Nazwisko</label>
				    <div class="col-sm-10">
				      <input type="text" name="surname" class="form-control" id="inputSurname" value="${client.surname}">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="inputMail" class="col-sm-2 col-form-label">Adres e-mail</label>
				    <div class="col-sm-10">
				      <input type="text" name="mail" class="form-control" id="inputMail" value="${client.mail}">
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="inputPhone" class="col-sm-2 col-form-label">Numer telefonu</label>
				    <div class="col-sm-10">
				      <input type="text" name="phone" class="form-control" id="inputPhone" value="${client.phone}">
				    </div>
				  </div>
				
				  <div class="form-group row">
				    <div class="col-sm-10">
				      <button type="submit" class="btn btn-primary">Zapisz</button>
				    </div>
				  </div>
				</form>
      	
   
      </div>
      
    </div>
  </div>
</div>
</c:forEach>

<jsp:include page="footer.jsp"/>