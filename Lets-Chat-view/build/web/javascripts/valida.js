ValidaNome = function (nome) {
    alert(nome.value);
    if ((nome.value != null) //&&
            //   !(nome.value.matches("([^<|>|\\n]){1,40}"))) {
            ) {
        alert("true");
        return true;
    }
    return false;
};

function ValidaLogin() {

    var nome = document.getElementById("nome");

    if (ValidaNome(nome)) {
        caminhourl = "/Lets-Chat-view/NovoServlet?acao=logar";
        document.forms[0].action = caminhourl;
        document.forms[0].acao = "logar";
        window.document.forms[0].submit();
    } else {
        document.getElementById("txt").value = "O nome nao pode conter < ou > \\n e deve ter no maximo 40 caracteres.";
    }
}