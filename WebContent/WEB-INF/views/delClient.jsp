<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<jsp:include page="menu.jsp"/>

<form action="" method="post" class="form-inline">

  <select name="delId" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
    <option selected>Wybierz Klienta, którego dane chcesz usunąć</option>
    <c:forEach items="${ clients }" var="client">
    <option value="${client.id}">${client.surname}, ${client.name}, ${client.mail}, ${client.phone}</option>
    </c:forEach>
  </select>


  <button type="submit" class="btn btn-primary my-1">Usuń dane</button>
</form>



<jsp:include page="footer.jsp"/>