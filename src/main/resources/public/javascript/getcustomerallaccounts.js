let customerId = document.getElementById("customerId")
let newButton = document.getElementById("newButton")
let accountList = document.getElementById("accountList")

newButton.onclick = function () {
    fetch('/bankaccountcontroller/getcustomerallaccounts?id=' + customerId.value)
        .then(result => result.json())
        .then(function (data) {
            accountList.innerHTML = ''
            for (let i = 0; i < data.length; i++) {
                let htmlRow = document.createElement("tr")
                accountList.appendChild(htmlRow)
                let accountNumberColumn = document.createElement("td")
                let accountBalanceColumn = document.createElement("td")
                htmlRow.appendChild(accountNumberColumn)
                htmlRow.appendChild(accountBalanceColumn)
                accountNumberColumn.innerText = data[i].accountNumber
                accountBalanceColumn.innerText = data[i].accountBalance
            }
        })
}