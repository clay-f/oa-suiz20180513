$(function () {
    $("#login_form").on("submit", (event) => {
        event.preventDefault();
        axios.post("/users/doLogin", objectifyForm($(event.currentTarget).serializeArray()))
            .then(res => {
                if (res.data.code == 200) {
                    location.href = "/vouchers/index";
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    });
});

function objectifyForm(formArray) {
    var returnArray = {};
    for (var i = 0; i < formArray.length; i++) {
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return returnArray;
}