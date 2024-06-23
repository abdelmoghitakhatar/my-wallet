function addOperation(operation){
    let isValidInput = false;
    let montant;

        switch (operation) {
            case 'in':
                montant = window.prompt("Enter the number you want to add:");
                break;

            case 'out':
                montant = window.prompt("Enter the number you want to subtract:");
                break;

            default:
                alert("Invalid operation.");
                return;
        }

        isValidInput = !isNaN(parseFloat(montant)) && isFinite(montant) && montant>=0;

    if (!isValidInput) {
        alert("Please enter a valid number!");
    } else {
        document.getElementById("montant").value = +montant;
        document.getElementById("operation").value = operation;
        console.log(`operation : ${operation}\ntype : ${typeof operation}`)
        document.getElementById("form").submit();
    }

}
