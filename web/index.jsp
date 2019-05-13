<%-- 
    Document   : index
    Created on : 07/05/2019, 23:16:18
    Author     : MohamadTarif

    parado no 15 min de video de aula do pupo
--%>

<%@page import="br.com.fatecpg.jdbc.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaDB - Clientes</title>
    </head>
    <body>
        <h1>JavaDb!</h1>
        <h2>Clientes</h2>
        <h2><a href="listManufacturer.jsp">Visualizar Fabricantes</a></h2>
        <%try{%>
           <%ArrayList<Customer> list = Customer.getList();%>
           <table border="1">
               <tr>
                   <th>ID</th>
                   <th>Nome</th>
                   <th>E-mail</th>
                   <th>Detalhes</th>
                   <th>Compras</th>
               </tr>
               <%for(Customer c: list) {%>
                 <tr>
                     <td><%= c.getId() %></td>
                     <td><%= c.getName()%></td>
                     <td><%= c.getEmail()%></td>
                     <td><a href="details.jsp?id=<%= c.getId()%>">Ver detalhes</a></td>
                     <td><a href="purchaseOrder.jsp?id=<%= c.getId()%>">Ver compras do cliente</a></td>
                 </tr>
               <%}%>
           </table>
        <%}catch(Exception e){%>
        <h3 style ="color: red"><%=e.getMessage()%></h3>
        <%}%>
    </body>
</html>
