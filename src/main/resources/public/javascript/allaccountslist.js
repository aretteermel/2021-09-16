let newButton = document.getElementById("newButton")
let allAccountsList = document.getElementById("allAccountsList")
newButton.onclick = function () {
    fetch('/bankaccountcontroller/allaccountslist')
        .then(result => result.json())
        .then(function (data) {
            for (let i = 0; i < data.length; i++) {
                let htmlRow = document.createElement("tr")
                allAccountsList.appendChild(htmlRow)
                let accountNumberColumn = document.createElement("td")
                let accountBalanceColumn = document.createElement("td")
                let customerFirstNameColumn = document.createElement("td")
                let customerLastNameColumn = document.createElement("td")
                let customerAddressColumn = document.createElement("td")
                htmlRow.appendChild(accountNumberColumn)
                htmlRow.appendChild(accountBalanceColumn)
                htmlRow.appendChild(customerFirstNameColumn)
                htmlRow.appendChild(customerLastNameColumn)
                htmlRow.appendChild(customerAddressColumn)
                accountNumberColumn.innerText = data[i].accountNumber
                accountBalanceColumn.innerText = data[i].accountBalance
                customerFirstNameColumn.innerText = data[i].customerFirstName
                customerLastNameColumn.innerText = data[i].customerLastName
                customerAddressColumn.innerText = data[i].customerAddress
            }
        })
}

// NÄIDE sql-test4
// let newButton = document.getElementById("newButton")
// let sampleTable = document.getElementById("sampleTable")
// newButton.onclick = function () {
//     fetch('sql-test4')
//         .then(result => result.json())
//         .then(function (data) {
//             for (let i = 0; i < data.length; i++) {
//                 let htmlRow = document.createElement("tr")
//                 sampleTable.appendChild(htmlRow)
//                 let idColumn = document.createElement("td")
//                 let nameColumn = document.createElement("td")
//                 let addressColumn = document.createElement("td")
//                 htmlRow.appendChild(idColumn)
//                 htmlRow.appendChild(nameColumn)
//                 htmlRow.appendChild(addressColumn)
//                 idColumn.innerText = data[i].id
//                 nameColumn.innerText = data[i].name
//                 addressColumn.innerText = data[i].address
//             }
//         })
// }