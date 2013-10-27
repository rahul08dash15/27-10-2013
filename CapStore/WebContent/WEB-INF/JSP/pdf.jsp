<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.itextpdf.text.Document"%>
    <%@ page import="com.itextpdf.text.Image"%>
    <%@ page import="com.itextpdf.text.Paragraph" %>
    <%@ page import="com.itextpdf.text.pdf.PdfWriter" %>
    <%@ page import="com.itextpdf.text.PageSize" %>
    <%@ page import="com.itextpdf.text.DocumentException" %>
    <%@ page import="com.itextpdf.text.Phrase" %>
    <%@ page import="com.itextpdf.text.pdf.PdfPCell" %>
    <%@ page import="com.itextpdf.text.pdf.PdfPTable" %>
    <%@ page import="com.itextpdf.text.Font" %>
    <%@ page import="com.itextpdf.text.FontFactory" %>
    <%@ page import="com.itextpdf.text.pdf.CMYKColor" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
</head>
<body>
<%
   response.setContentType("application/pdf");
   response.setHeader("Content-Disposition", "attachment; filename=\"Invoice.pdf\"");
   Document document= new Document(PageSize.A4, 50, 50, 50, 50);
	try{
		PdfWriter writer=PdfWriter.getInstance(document,response.getOutputStream());
		document.open();
		document.add(new Paragraph("CAPSTORE",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(150, 500, 500, 100))));
		document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));
		%>
        <c:forEach items="${list}" var="id" end="0">
	     <c:set var="transactionId" value="${trans_id}"/>
	 <%

	String transId=Long.toString((Long)pageContext.getAttribute("trans_id"));
	
		document.add(new Paragraph("Transaction Id:   "+transId));
		
		%>
		</c:forEach>
		<c:forEach items="${list}" var="id" end="0">
		 <c:set var="orderId" value="${id.orderId }"/>
<%

	String orderId=Long.toString((Long)pageContext.getAttribute("orderId"));
	
		document.add(new Paragraph("Order Id:   "+orderId));
		
		%>
</c:forEach>


<c:forEach items="${list}" var="id" end="0">
<c:set var="userfirstName" value="${id.userFirstname}"/>
<c:set var="userLastname" value="${id.userLastname}"/>
<%

	String userfirstName=(String)pageContext.getAttribute("userfirstName");
    String userLastname=(String)pageContext.getAttribute("userLastname");
	
		document.add(new Paragraph("Customer:  "+userfirstName+"  "+userLastname));
		document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------"));
		
		%>

</c:forEach>



<%
        //String transactionDate= (String)pageContext.getAttribute("transactionDate");
		//document.add(new Paragraph("transactionDate"+transactionDate));
		document.add(new Paragraph("ORDER DETAILS"));
		//document.add(new Paragraph("Product Name\t Product Quantity \t Product Cost"));
		PdfPTable t = new PdfPTable(3);

		      t.setSpacingBefore(25);
		      
		      t.setSpacingAfter(25);
		      
		      PdfPCell c1 = new PdfPCell(new Phrase("Product Name"));  
		      
		      t.addCell(c1);
		      
		      PdfPCell c2 = new PdfPCell(new Phrase("Quantity"));
		      
		      t.addCell(c2);
		      
		      PdfPCell c3 = new PdfPCell(new Phrase("Product Cost"));
		      t.addCell(c3);
		 
		%>


<c:forEach items="${list}" var="id">
    <c:set var="productName" value="${id.productName}"/>
    <c:set var="productQuantity" value="${id.productQuantity}"/>
    <c:set var="productCost" value="${id.productCost}"/>
   <%
   String productName=(String)pageContext.getAttribute("productName");
   String productQuantity=Long.toString((Long)pageContext.getAttribute("productQuantity"));
   String productCost=Double.toString((Double)pageContext.getAttribute("productCost"));
   t.addCell(productName);
   t.addCell(productQuantity);
   t.addCell(productCost);
   //document.add(t);
  // document.add(new Paragraph(productName+productQuantity +productCost));
		
		%>
   </c:forEach>
   <%document.add(t); %>
    <c:set var="TotalAmount" value="${sum}"/>
    <%
     String TotalAmount=Double.toString((Double)pageContext.getAttribute("TotalAmount"));
    document.add(new Paragraph("Total Amount"+TotalAmount));
  
		document.close(); 
		response.getOutputStream().close();
	}catch(DocumentException e){
		e.printStackTrace();
	}
  
%>

</body>
</html>