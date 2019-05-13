<%-- 
    Document   : purchaseOrder
    Created on : 12/05/2019, 22:49:44
    Author     : MohamadTarif
--%>

<%@page import="br.com.fatecpg.jdbc.PurchaseOrder"%>
<%@page import="br.com.fatecpg.jdbc.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras do cliente</title>
    </head>
    <body>
     <%try{%>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            Customer c = Customer.getCustomer(id);
        %>
        <h1>Compras do cliente <%=c.getName()%></h1>
        <%if (c!=null) {%>
              <table border="1">
            <tr>
                <th>Ordem</th>
                
                <th>Codigo do Produto</th>
                
                <th>Quantidade do produto</th>
                
            </tr>
            <% for(PurchaseOrder purchase: PurchaseOrder.getPuchaseOrders(id)){%>
            <tr>
                <td><%=purchase.getOrderNumber()%></td>
                <td><%=purchase.getProductId()%></td>
                <td><%=purchase.getQuantity()%></td>
            </tr>
            <%}%>
        <%}else{%>
        <h3>Pedidos do Cliente <%=id%> inexistentes! </h3>
        
        <% } %>
        </table>
        
        <%}catch(Exception e){%>
        <h3 style="color: red"> <%= e.getMessage() %> </h3>
        
<%}%>
    </body>
</html>
