
const BASE_URL = 'http://localhost:8080/api/v1'
const LOGIN_URL = BASE_URL + '/login'

let loginBtn = document.querySelector('.login-btn')

loginBtn.addEventListener("click", login) 

async function login() {
    let loginEmail = document.querySelector("input[type='email']").value
    let loginPass = document.querySelector("input[type='password']").value

    const options = {
        method: 'POST',
        url: LOGIN_URL,
        headers: {
            'Content-Type': 'application/json',
          },
        data: {
            email: loginEmail,
            password: loginPass
        }
    }

    await axios.request(options)
    .then(res => {
        window.location.href="file:///D:/black-hoodie/project/virus/sign-up-login-page/front-end/src/home-page/index.html";
    })
    .catch(e => {
        if(e.response) {
            let error = e.response.data
            if(error.errorCode === 'ERR2') {
                window.alert(error.errorMessage)
                document.querySelector("input[type='email']").value = ''
                document.querySelector("input[type='password']").value = ''
            }
        }
    })
}

