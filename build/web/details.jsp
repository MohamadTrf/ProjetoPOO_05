<%-- 
    Document   : details
    Created on : 10/05/2019, 10:16:04
    Author     : MohamadTarif
--%>

<%@page import="br.com.fatecpg.jdbc.Order"%>
<%@page import="br.com.fatecpg.jdbc.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Db - Detalhes</title>
    </head>
    <body>
        <h1>JavaDb!</h1>
        <h2>Compras do cliente</h2>
        <h3><a href="index.jsp">Voltar</a></h3>
        <%try{%>
            <%
            int id = Integer.parseInt(request.getParameter("id"));
            Customer c = Customer.getCustomer(id);
            %>
            <%if(c!=null){%>
                <h3>ID: <u> <%=id%> </u></h3>
                <h3>Name: <u> <%=c.getName()%> </u></h3>
                <hr/>
                <table border="1">
                <tr>
                    <th>Número</th>
                    <th>Data</th>
                    <th>Frete</th>
                </tr>
                <%for(Order o: Order.getList(id)){%>
                <tr>
                    <td><%=o.getNum()%></td>
                    <td><%=o.getSalesDate()%></td>
                    <td><%=o.getShippingCost()%></td>
                </tr>
                <%}%>
                 </table>
            <%}else{%>
                <h3>Cliente <%=id%>não encontrado!</h3>
            <%}%>

        <%}catch(Exception e){%>
            <h3 style ="color: red"><%=e.getMessage()%></h3>
        <%}%>

    </body>
</html>
