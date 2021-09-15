let accountNrStatus = document.getElementById("accountNrStatus");
let accountStatus = document.getElementById("accountStatus");

let updateStatus = document.getElementById("updateStatus");
updateStatus.onclick = function () {
    fetch("/bankaccountcontroller/updatestatus?accountnr=" + accountNrStatus.value + "&status=" + accountStatus.value,
        {
            method: 'PUT'
        }).then(result => result.text())
        .then(function (result) {
            alert(result)
        })
};