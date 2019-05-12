<%-- 
    Document   : listManufacturer
    Created on : 11/05/2019, 17:06:56
    Author     : MohamadTarif
--%>

<%@page import="br.com.fatecpg.jdbc.Manufacturer"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Fabricantes</title>
    </head>
    <body>
        <h1>Lista de Fabricantes cadastrado!</h1>
        <h3><a href="index.jsp">Voltar</a></h3>
        <%try{%>
            <%ArrayList<Manufacturer> list = Manufacturer.getManufacturer();%>
            <table border="1">
               <tr>
                   <th>ID</th>
                   <th>Nome</th>
                   <th>Cidade</th>
                   <th>Estado</th>
                   <th>Email</th>
               </tr>
               <%for(Manufacturer m: list) {%>
                 <tr>
                     <td><%= m.getManufacturer_id() %></td>
                     <td><%= m.getName() %></td>
                     <td><%= m.getCity()%></td>
                     <td><%= m.getState()%></td>
                     <td><%= m.getEmail()%></td> 
                     <td><a href="details.jsp?id=<%= m.getManufacturer_id()%>"> Lista de Produtos do Fabricante</a></td>
                 </tr>
               <%}%>
           </table>
        <%}catch(Exception Ex){%>
            <h3 style ="color: red"><%=Ex.getMessage()%></h3>
        <%}%>
    </body>
</html>
