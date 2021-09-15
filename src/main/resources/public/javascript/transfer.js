let fromAccountNr = document.getElementById("fromAccountNr");
let toAccountNr = document.getElementById("toAccountNr");
let amountTransfer = document.getElementById("amountTransfer");

let transferMoney = document.getElementById("transferMoney");
transferMoney.onclick = function () {
    fetch("/bankaccountcontroller/transfermoney?fromaccount=" + fromAccountNr.value + "&toaccount=" + toAccountNr.value + "&amount=" + amountTransfer.value,
        {
            method: 'PUT'
        }).then(result => result.text())
        .then(function (result) {
            alert(result)
        })
};