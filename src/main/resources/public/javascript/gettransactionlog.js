let accountNr = document.getElementById("accountNr")
let newButton = document.getElementById("newButton")
let transactionLog = document.getElementById("transactionLog")

newButton.onclick = function () {
    fetch('/bankaccountcontroller/gettransactionlog?accountnr=' + accountNr.value)
        .then(result => result.json())
        .then(function (data) {
            transactionLog.innerHTML = ''
            for (let i = 0; i < data.length; i++) {
                let htmlRow = document.createElement("tr")
                transactionLog.appendChild(htmlRow)
                let logIdColumn = document.createElement("td")
                let accountIdColumn = document.createElement("td")
                let timestampColumn = document.createElement("td")
                let amountColumn = document.createElement("td")
                let actionColumn = document.createElement("td")
                let connectedAccountIdColumn = document.createElement("td")
                htmlRow.appendChild(logIdColumn)
                htmlRow.appendChild(accountIdColumn)
                htmlRow.appendChild(timestampColumn)
                htmlRow.appendChild(amountColumn)
                htmlRow.appendChild(actionColumn)
                htmlRow.appendChild(connectedAccountIdColumn)
                logIdColumn.innerText = data[i].logId
                accountIdColumn.innerText = data[i].accountId
                timestampColumn.innerText = data[i].timestamp
                amountColumn.innerText = data[i].amount
                actionColumn.innerText = data[i].action
                connectedAccountIdColumn.innerText = data[i].connectedAccountId

            }
        })
}