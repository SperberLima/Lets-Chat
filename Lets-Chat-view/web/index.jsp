
<html>

    <head>
        <meta charset="windows-1252">
        <title>Login</title>

        <link  rel="stylesheet" href="css\\login.css">

        <script type="text/javascript" language="JavaScript" src="javascripts/valida.js" >

        </script>

    </head>
    <%
        String msg = request.getParameter("msg");
    %>

    <body>
        <div class = "meio" >
            <div class="meio2" >
                <form name="frmLogar" >
                    <div class = "nome">
                        Nome:
                    </div>
                    <div>
                        <span id="txt" style="font-size:12px;"><%= (msg == null) ? "" : msg%></span>
                    </div> 
                    <div class = "txt">
                        <input size = "20" id="nome" class = "cmp_txt" />
                    </div>
                    <div class = "btn">
                        <input type="button" class = "submit" value="Enviar" onClick="ValidaLogin()" />
                    </div>		
                </form>
            </div>
        </div>
    </body>
</html>