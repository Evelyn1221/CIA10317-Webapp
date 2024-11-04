<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Product Item</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>Product Item</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Product Item</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~���C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllProduct.jsp'>List</a> all Products.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="productItem.do" >
        <b>��J�q��s��:</b>
        <input type="text" name="productId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="empSvc" scope="page" class="com.productitem.model.ProductItemService" />
   
  <li>
     <FORM METHOD="post" ACTION="productItem.do" >
       <b>��ܭq��s��:</b>
       <select size="1" name="pdtOrderId">
         <c:forEach var="productItemVO" items="${empSvc.all}" > 
          <option value="${productItemVO.pdtOrderId}">${productItemVO.pdtOrderId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="productItem.do" >
       <b>��ܲ��~�s��:</b>
       <select size="1" name="pdtId">
         <c:forEach var="productItemVO" items="${empSvc.all}" > 
          <option value="${productItemVO.pdtId}">${productItemVO.pdtId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
</ul>


<!-- <h3>�q����Ӻ޲z</h3> -->

<!-- <ul> -->
<!--   <li><a href='addEmp.jsp'>Add</a> a new Emp.</li> -->
<!-- </ul> -->

</body>
</html>