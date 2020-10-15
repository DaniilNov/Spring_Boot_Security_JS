const requestURL = 'http://localhost:8080/clients';
const addUserName = document.getElementById('username-value');
const addUserPassword = document.getElementById('password-value');
const addUserAge = document.getElementById('age-value');
const addUserIdRole = document.getElementById('idAddRole');

const oldUserName = document.getElementById('usernameEdit');
const oldUserPassword = document.getElementById('passwordEdit');
const oldUserAge = document.getElementById('ageEdit');
const oldUserIdRole = document.getElementById('oldIdRole');

const btnSubmit = document.querySelector('.btn-add');
const btnUpdate = document.querySelector('.btn-update');
const btnDelete = document.querySelector('.btn-delete');

const usersCollection = document.getElementById('dataInf');


//Вывести всех пользователей

fetch(requestURL).then(res => res.json()).then(renderUsers);


function renderUsers(users) {
    usersCollection.innerHTML = '';
    let roleName='';
    users.forEach((user)=> {
        user.authorities.forEach((elem)=>{
            roleName = elem.name;
        })
        usersCollection.innerHTML += `

     <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.age}</td>
        <td>${roleName}</td>
        <td><a href="#" class="btn btn-info" id="editButton" data-id="${user.id}">Edit</a></td>
        <td><a href="#" class="btn btn-danger" id="deleteButton" data-id="${user.id}">Delete</a></td>
    </tr>
        `
        })

}


//При нажатии кнопки в таблице

usersCollection.addEventListener('click', (e) => {
    e.preventDefault();

    let delButtIsPress = e.target.id == 'deleteButton';
    let editButtIsPress = e.target.id == 'editButton';

    //При нажатии кнопки редактирования
    if (editButtIsPress) {
        $('#editModal').modal();
        let id = e.target.dataset.id;
        $.get(`${requestURL}/${id}`, function (user) {
            $('.editForm #idEdit').val(user.id);
            $('.editForm #usernameEdit').val(user.username);
            $('.editForm #passwordEdit').val(user.password);
            $('.editForm #ageEdit').val(user.age);

        })
    }
    //При нажатии кнопки удаления
    if (delButtIsPress) {
        $('#deleteModal').modal();
        let id = e.target.dataset.id;
        $.get(`${requestURL}/${id}`, function (user) {
            let roleNameDel='';
            user.authorities.forEach((elem)=>{
                roleNameDel = elem.name;
            })

            $('.deleteForm #idDelete').val(user.id);
            $('.deleteForm #usernameDelete').val(user.username);
            $('.deleteForm #passwordDelete').val(user.password);
            $('.deleteForm #ageDelete').val(user.age);
            $('.deleteForm #roleDelete').val(roleNameDel);
        });
    }
})


//POST
btnSubmit.addEventListener('click', (e) => {
    e.preventDefault();
    fetch(requestURL, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify({
            username: addUserName.value,
            password: addUserPassword.value,
            age: addUserAge.value,
            idRole: addUserIdRole.value
        })
    })


        .then(response => {
            console.log('Response:', response)
            return response.text();
        })

        .then(()=>location.reload())
})

//PUT
$(document).ready(function () {
    btnUpdate.addEventListener('click', (e) => {
        e.preventDefault();
        let elId = document.getElementById('idEdit');
        let id = elId.value;

        fetch(`${requestURL}/${id}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify({
                username: oldUserName.value,
                password: oldUserPassword.value,
                age: oldUserAge.value,
                idRole: oldUserIdRole.value
            })

        })

            .then(response => {
                console.log('Response:', response)
                return response.text();
            })
            .then(getUsers)
        $('#editModal').modal('toggle')
    })

});

//Delete
$(document).ready(function () {
    btnDelete.addEventListener('click', (e) => {
        e.preventDefault();
        let elId = document.getElementById('idDelete');
        let id = elId.value;
        fetch(`${requestURL}/${id}`, {
            method: 'DELETE',
        })


            .then(res => res.text())
            .then(() => location.reload())
        $('#deleteModal').modal('toggle')
    })


});

function getUsers() {
    fetch(requestURL).then(res => res.json()).then(renderUsers);
}

