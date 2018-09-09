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
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>
        <link rel='stylesheet' type='text/css' href='styles/style.css' />
        <title>Hash Sha256</title>
    </head>
    <body>
        <div class="container">
            <div class="result">
                <h1>Gerador Hash SHA 256</h1>
                <form method="POST" action="hash">
                    <p>Digite o dado que você deseja criptografar</p>
                    <input name="dados" class="form-control" value="" type="text">
                    <button type="submit" class="btn btn-dark">Enviar</button>
                </form>
                <div>
                    <%int i = 0; 
                       byte[] t = sha256.getSha256("teste");
                       String s = sha256.bytesToBase64(t);
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
