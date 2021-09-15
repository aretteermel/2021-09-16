let newAccount = document.getElementById("newAccount");
let customerId = document.getElementById("customerId");

let sendNewAccount = document.getElementById("sendNewAccount");
sendNewAccount.onclick = function () {
    fetch("/bankaccountcontroller/createaccount?accountnr=" + newAccount.value + "&customerid=" + customerId.value,
        {
            method: 'POST'
        }).then(result => result.text())
        .then(function (data) {
            alert("New account is added")
        })
};