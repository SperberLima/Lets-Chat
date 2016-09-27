
<%@page import="letschat.domain.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="letschat.domain.Mensagem"%>

<jsp:useBean id="perfil" class="letschat.domain.Usuario"></jsp:useBean>
<jsp:useBean id="gals" class="java.util.ArrayList"></jsp:useBean>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sala Principal</title>


        <link  rel="stylesheet" href="css/salachat.css">
        <link  rel="stylesheet" href="css/criargrupo.css">

        <script type="text/javascript" language="JavaScript" src="javascripts/valida.js" >
        </script> 
    </head>

    <body>

        <div class="barra"> 
            <a href="Criar_Grupo.jsp"><div class="barra_item">Criar Grupo</div></a>
            <a href="Login_Chat.jsp"><div class="barra_item">Sair</div></a>
        </div>
        <div class = "meio" >
            <div class = "esquerda">
                <!-- Usuarios -->

                <div class = "usuarios">
                    <ul id="users">
                        <li class="item_lista" >

                            <input type="radio" onclick="alert('absbhkdabhs')" class = "check" name = "cv" id = "o1" value="Marina"  checked>		
                            <label for="o1">
                                <div class="opcao">Marina
                                </div>
                            </label>

                        </li>
                        <li class="item_lista">
                            <input type="radio" class = "check" name = "cv" id = "o2" value="Luana">		
                            <label for="o2">
                                <div class="opcao">Luana
                                </div>
                            </label>
                        </li>

                        <li class="item_lista">	
                            <input type="radio" class = "check" name = "cv" id = "o3" value="Fernanda">
                            <label for="o3">
                                <div class="opcao">Fernanda
                                </div>
                            </label>
                        </li>

                        <li class="item_lista">
                            <input type="radio" class = "check" name = "cv" id = "o4" value="Maria" >		
                            <label for="o4">
                                <div class="opcao">Maria
                                </div>
                            </label>
                        </li>

                        <li class="item_lista">
                            <input type="radio" class = "check" name = "cv" id = "o5" value="Julia">		
                            <label for="o5">
                                <div class="opcao">Julia
                                </div>
                            </label>
                        </li>

                        <li class="item_lista">
                            <input type="radio" class = "check" name = "cv" id = "o6" value="Ana Carolina">
                            <label for="o6">
                                <div class="opcao">Ana Carolina
                                </div>
                            </label>
                        </li>
                    </ul>	
                </div>
            </div>


            <div class = "direita">
                <!-- Mensagens -->
                <div class="Mensagem" id="msg">

                </div>
            </div>
        </div>

        <div class="enviar">
            <!-- Caixa de Texto, Enviar -->
            <textarea class="txt_enviar" id=""></textarea>
            <input type="submit" class="submit" value="Enviar" />
            <div class="backlabel">
                <!--<div class="bola">
                        <div class="bola2"></div>
                </div> -->
                <input type="checkbox" class="check" id="box" > 
                <label for="box"> P/ todos 
                    <div class="bola">
                        <div class="bola2">
                        </div>
                    </div> </label>
            </div>		
        </div>

    </form>
</body>
</html>