//



    const requestURL = 'http://localhost:8080/clients'



    function sendUser() {

        fetch(requestURL, {
            method: 'POST',
            body: JSON.stringify({
                username: $("#user_name").val(),
                password: $("#user_password").val(),
                age: $("#user_age").val(),
                idRole: $("#user_role").val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=utf-8'
            }
        });
    }

    function updateUsers() {

        fetch(`${requestURL}/${id}`, {
            method: 'PUT',
            body: JSON.stringify({
                username: $("#oldusername").val(),
                password: $("#password1").val(),
                age: $("#newage").val(),
                idRole: $("#idRole").val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=utf-8'
            }
        })
    }

(document).ready(function () {

    $("#updateUser").on("click", updateUsers());


});


