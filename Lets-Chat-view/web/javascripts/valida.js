ValidaNome = function (nome) {

    if ((nome.value != null) //&&
            //   !(nome.value.matches("([^<|>|\\n]){1,40}"))) {
            ) {
        return true;
    }
    return false;
};

function ValidaLogin() {
    alert("BORA");
    var nome = document.getElementById("nome");
    if (ValidaNome(nome)) { 
        caminhourl = "/Lets-Chat-view/NovoServlet?bora=logar";
        document.forms[0].action = caminhourl;
        window.document.forms[0].submit();
    }
}

function EnviarMsg(msg) {
    
    caminhourl = "/Lets-Chat-view/Sala_Chat?bora=logar";
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
               username += ("<li><a>"+u[i].childNodes[0].nodeValue+"</a></li>");
            }
        }
        users.innerHTML = username;
    };
    
    http.open("GET", "/Sala_Chat?acao=userList&type=async", true);
    http.send();
    
},5000);

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
               username += ("<li><a>"+u[i].childNodes[0].nodeValue+"</a></li>");
            }
        }
        users.innerHTML = username;
    };
    
    http.open("GET", "/Sala_Chat?acao=userList&type=async", true);
    http.send();
    
},5000);

var refreshGrupos = setInterval(function(){
    
    var http = new XMLHttpRequest();    
    var groups = document.getElementById("groups");
    
    http.onreadystatechange = function() {
        var u;
        var username = "";
        var xmlDoc,parser;
        
        if (http.readyState == 4 && http.status == 200) {
            
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(http.responseText, "text/xml");            
            u = xmlDoc.getElementsByTagName("name");            
            
            for (i = 0; i < u.length; i++) {
               username += ("<li><a>"+u[i].childNodes[0].nodeValue+"</a></li>");
            }
        }
        groups.innerHTML = username;
    };
    
    http.open("GET", "/Sala_Chat?acao=groupList&type=async", true);
    http.send();
    
},5000);


var update = setInterval(function(){
    
    var http = new XMLHttpRequest();    
    http.open("GET", "/Sala_Chat?acao=Update&type=async", true);
    http.send();
    
},5000);


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
