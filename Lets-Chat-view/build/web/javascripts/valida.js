

function ValidaLogin() {
    var nome = document.getElementById("nome");
    if(nome != null) {
        caminhourl = "/Lets-Chat-view/NovoServlet?bora=logar";
        document.forms[0].action = caminhourl;
        window.document.forms[0].submit();
    }
}

function EnviarMsg(msg) {
    
    caminhourl = "/Lets-Chat-view/Sala_Chat?bora=enviar";
    document.forms[0].action = caminhourl;
    window.document.forms[0].submit();
    
}

var refreshUsers = setInterval(function(){
    
    var http = new XMLHttpRequest();    
    var users = document.getElementById("users");
    
    http.onreadystatechange = function() {
        var u;
        var username = "";
        var xmlDoc,parser;
        
        if (http.readyState == 4 && http.status == 200) {
            
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(http.responseText, "text/xml");            
            u = xmlDoc.getElementsByTagName("name");            
            
            for (i = 0; i < u.length; i++) {
               username += "<li class=\"item_lista\">" +
                            "<input type=\"radio\" onclick=\"trocaMensagem();\" class = \"check\" name = \"cv\" id = \"o" + i + "\" value=\"" + u[i].childNodes[0].nodeValue + "\" checked>" +		
                            "<label for=\"o" + i + "\">" +
                                "<div class=\"opcao\">" + u[i].childNodes[0].nodeValue + 
                                "</div>" +
                            "</label>"+
                            "</li>";
            }
        }
        users.innerHTML = username;
    };
    
    http.open("GET", "/Sala_Chat?acao=userList&type=async", true);
    http.send();
    
},5000);

document.getElementById("o1").onclick = function() {
    var radios = document.getElementsByName("cv");

    var msg = document.getElementById("msg");
    alert("bhkzfjkszfdnlsajdfjksdfsd");
    for (var i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            msg.innerHTML = msgs;
        }
    }
};

var refreshGrupos = setInterval(function(){
    
    var http = new XMLHttpRequest();    
    var users = document.getElementById("");
    
    http.onreadystatechange = function() {
        var u;
        var username = "";
        var xmlDoc,parser;
        
        if (http.readyState == 4 && http.status == 200) {
            
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(http.responseText, "text/xml");            
            u = xmlDoc.getElementsByTagName("grupo");            
            
            for (i = 0; i < u.length; i++) {
               username += "<li class=\"item_lista\">" +
                            "<input type=\"radio\" onclick=\"trocaMensagem();\" class = \"check\" name = \"cv\" id = \"o" + i + "\" value=\"" + u[i].childNodes[0].nodeValue + "\" checked>" +		
                            "<label for=\"o" + i + "\">" +
                                "<div class=\"opcao\">" + u[i].childNodes[0].nodeValue + 
                                "</div>" +
                            "</label>"+
                            "</li>";
            }
        }
        users.innerHTML = users.innerHTML + username;
    };
    
    http.open("GET", "/Sala_Chat?acao=groupList&type=async", true);
    http.send();
    
},5000);

var update = setInterval(function(){
    
    var http = new XMLHttpRequest();    
    http.open("GET", "/Sala_Chat?acao=Update&type=async", true);
    http.send();
    
},5000);

var msgs;

var refreshMSG = setInterval(function(){
    
    var http = new XMLHttpRequest();    
    var msg = document.getElementById("msgs");
    
    http.onreadystatechange = function() {
        var o,t, d;
        var msgs = "";
        var xmlDoc,parser;
        
        if (http.readyState == 4 && http.status == 200) {
            
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(http.responseText, "text/xml");            
            o = xmlDoc.getElementsByTagName("org");
            t = xmlDoc.getElementsByTagName("txt");
            d = xmlDoc.getElementsByTagName("date");
            atual = 0;
            while(atual<d.length && parseInt(d[atual].childNodes[0].nodeValue) <= ult){
                atual++;
            }
            
            for (i = atual; i < o.length; i++) {
               msgs += ("<li class='msg'><h4 id='remetente'>"+o[i].childNodes[0].nodeValue+"</h4><span id='mensagem'>"+t[i].childNodes[0].nodeValue+"</span></li>");
            }
            if(d.length-1 >= 0){
                ult = parseInt(d[d.length-1].childNodes[0].nodeValue);
            }            
        }
        var objDiv = document.getElementById("wrapper");
        if(msgs !== ""){
            if(objDiv.scrollTop >= objDiv.scrollHeight -600){
                msg.innerHTML += msgs;
                objDiv.scrollTop = objDiv.scrollHeight;
            }else{
                msg.innerHTML += msgs;
            }
        }
    };
    
    http.open("GET", "/Sala_Chat?acao=getMessage&type=async", true);
    http.send();
    
},1000);

function criarGrupo(){
}

function ajaxCallGet(func, dest){
    var http = new XMLHttpRequest();
    http.onreadystatechange = func();
    http.open("GET", dest, true);
    http.send();
}

function ajaxCallPost(func, dest){
    var http = new XMLHttpRequest();
    http.onreadystatechange = func();
    http.open("POST", dest, true);
    http.send();
}
