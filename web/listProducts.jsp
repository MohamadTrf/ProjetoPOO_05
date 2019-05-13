<%-- 
    Document   : listProducts
    Created on : 11/05/2019, 21:03:23
    Author     : MohamadTarif
--%>

<%@page import="br.com.fatecpg.jdbc.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabricante</title>
    </head>
    <body>
        <h1>Produtos do Fabricante</h1>
        <h3><a href="index.jsp">Voltar</a></h3>
        <%try{%>
            <%int id = Integer.parseInt(request.getParameter("id"));%>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                </tr>
                
                <%for(Product p: Product.getProduct(id)) {%>
                <%if(p!=null)%>
                    <tr>
                        <td><%= p.getProductId() %></td>                     
                        <td><%= p.getDescricao()%></td> 
                        <td><%= p.getPreco() %></td>
                    </tr>
               <%}%>
           </table>
        <%}catch(Exception e){%>
            <h3 style ="color: red"><%=e.getMessage()%></h3>
        <%}%>
    </body>
</html>
