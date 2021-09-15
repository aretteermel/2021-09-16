let accountNrDeposit = document.getElementById("accountNrDeposit");
let amountDeposit = document.getElementById("amountDeposit");

let depositMoney = document.getElementById("depositMoney");
depositMoney.onclick = function () {
    fetch("/bankaccountcontroller/depositmoney?accountnr=" + accountNrDeposit.value + "&amount=" + amountDeposit.value,
        {
            method: 'PUT'
        }).then(result => result.text())
        .then(function (result) {
            alert(result)
        })
};