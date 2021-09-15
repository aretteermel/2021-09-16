let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let address = document.getElementById("address");

let sendNewCustomer = document.getElementById("sendNewCustomer");
sendNewCustomer.onclick = function () {
    let customer = {
        firstName: firstName.value,
        lastName: lastName.value,
        address: address.value
    }
    fetch("/bankaccountcontroller/addcustomer",
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(customer)
        }
    ).then(result => result.text())
        .then(function () {
            alert("New customer is added")
        })
};