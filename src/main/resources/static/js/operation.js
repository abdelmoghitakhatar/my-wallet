function addOperation(operation){

        document.getElementById("operation").value = operation;
        console.log(`operation : ${operation}\ntype : ${typeof operation}`)
        document.getElementById("form").submit();


}

document.getElementById('montant').addEventListener("input", function (){

    let isValidInput = false
    let montant = document.getElementById('montant').value;

    isValidInput = !isNaN(parseFloat(montant)) && isFinite(montant) && montant>0;

    if (!isValidInput) {
        document.getElementById('in').disabled = true
        document.getElementById('out').disabled = true
    } else {
        document.getElementById('in').disabled = false
        document.getElementById('out').disabled = false
    }
})
