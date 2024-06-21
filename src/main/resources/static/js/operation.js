function addOperation(operation){
    let isValidInput = false;
    let montant;
    let i = 0;

    do {
        if (i>0) {
            alert("Please enter a valid number.");
        }

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
        i++;
    } while (!isValidInput);

    document.getElementById("montant").value = +montant;
    document.getElementById("operation").value = operation;

    document.getElementById("form").submit();
}