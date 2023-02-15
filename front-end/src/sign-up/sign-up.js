
const BASE_URL = 'http://localhost:8080/api/v1'
const SIGN_UP_URL = BASE_URL + '/signup'

let signUpBtn = document.getElementById("sign-up-btn")

signUpBtn.addEventListener("click", signUpEvent)

async function signUpEvent() {
    console.log("submit")
    

    // Sign up api

    const options = {
        method: 'POST',
        url: SIGN_UP_URL,
        headers: {
            'Content-Type': 'application/json',
          },
        data: {
            name: document.getElementById("input-fname").value + " " + document.getElementById("input-lname").value,
            gender: document.querySelector(".input-gender:checked").value==="male"?1:0,
            phoneNumber: document.getElementById("input-phone").value,
            email: document.getElementById("input-email").value,
            password: document.getElementById("input-password").value
        }
    }

    axios.request(options)
    .then(res => {
            window.location.href = "file:///D:/black-hoodie/project/virus/sign-up-login-page/front-end/src/home-page/index.html"
    })
    .catch(err => {
        if(err.response) {
            let error = err.response.data
            if(error.errorCode === 'ERR1') {
                window.alert("Email already existed")
                console.log(error.errorMessage)
            }
        }
    })
}