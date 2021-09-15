let accountNrWithdraw = document.getElementById("accountNrWithdraw");
let amountWithdraw = document.getElementById("amountWithdraw");

let withdrawMoney = document.getElementById("withdrawMoney");
withdrawMoney.onclick = function () {
    fetch("/bankaccountcontroller/withdrawmoney?accountnr=" + accountNrWithdraw.value + "&amount=" + amountWithdraw.value,
        {
            method: 'PUT'
        }).then(result => result.text())
        .then(function (result) {
            alert(result)
        })
};