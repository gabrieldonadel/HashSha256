<%-- 
    Document   : index
    Created on : 03/09/2018, 11:40:31
    Author     : Gabriel Donadel Dall'Agnol
--%>

<%@page import="br.com.gabrieldonadel.sha256"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hash Sha256</title>
    </head>
    <body>
        <h1>Gerador Hash SHA 256</h1>
        <form method="POST" action="hash">
            <p>Digite o dado que você deseja criptografar</p>
            <input name="dados" value="" type="text">
            <button type="submit">Enviar</button>
        </form>
        <div>
            <%int i = 0; 
               byte[] t = sha256.getSha256("teste");
               String s = sha256.bytesToBase64(t);
            %>
            <p>Este número é <%= s %>.</p>
        </div>
    </body>
</html>
