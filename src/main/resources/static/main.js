function validate () {
    var text = document.getElementById("username").value;
    var regx = /^([a-z\d\.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$/;
    var length  = document.getElementById("pwd").value.length;

    if (regx.test(text)) {
        if (length < 6) {
            alert("Invalid password");
            document.getElementById("pwd").style.borderColor="red";
            event.preventDefault();
        } else {
            document.getElementById("pwd").style.borderColor="green";
        }

    } else {
        document.getElementById("username").style.borderColor = "red";
        document.getElementById("username").style.borderRadius = "5px";
        alert("Invalid email address");
        event.preventDefault();
    }
}

function validateSignUp () {
    var text = document.getElementById("username").value;
    var regx = /^([a-z\d\.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$/;
    var length  = document.getElementById("pwd").value.length;
    var pwd = document.getElementById("pwd");
    var pwdMatch = document.getElementById("pwdMatch");

    if (regx.test(text)) {
        if (length < 6) {
            alert("Invalid password");
            document.getElementById("pwd").style.borderColor="red";
            event.preventDefault();
        }

        if (pwd.value != pwdMatch.value) {
            alert("Password does not match");
            event.preventDefault();
        }
    } else {
        document.getElementById("username").style.borderColor = "red";
        document.getElementById("username").style.borderRadius = "5px";
        alert("Invalid email address");
        event.preventDefault();
    }
}
