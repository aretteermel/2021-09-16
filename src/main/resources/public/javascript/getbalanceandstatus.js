let accountNr = document.getElementById("accountNr");
let balanceAndStatusButton = document.getElementById("getBalanceAndStatus");
balanceAndStatusButton.onclick = function () {
    fetch("/bankaccountcontroller/getbalanceandstatus?accountnr=" + accountNr.value)
        .then(result => result.json())
        .then(function (data) {
            console.log(data);
            let infoBalance = document.getElementById("fetchBalance");
            infoBalance.innerText = data.accountBalance;
            let infoStatus = document.getElementById("fetchStatus");
            infoStatus.innerText = data.accountStatus;
        })
}