let modelControl = document.getElementById('modal');
console.log(modelControl)
function closeModal(){
    modelControl.classList.add("hidden")
}
function openModal(){
    modelControl.classList.remove("hidden")
}
function editFormOpen(id){
    console.log(id)
    let formEdit = document.getElementById(`modal-${id}`)
    formEdit.classList.remove('hidden');
}
function cancelFormEdit(id){
    let formEdit = document.getElementById(`modal-${id}`)
    formEdit.classList.add('hidden');
}
function assignForm(id){
    console.log(id)
    let display = document.getElementById(`display-${id}`)
    let assign = document.getElementById(`assign-${id}`)
    if (display.classList.contains("hidden")){
        display.classList.remove('hidden');
        assign.classList.add('hidden');
    }else{
        display.classList.add('hidden');
        assign.classList.remove('hidden');
    }
}
