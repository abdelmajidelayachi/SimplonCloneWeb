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