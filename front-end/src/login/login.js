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
    try {
        console.log(options)
        const res = await axios.request(options)
        console.log(res)
    } catch(e) {
        console.log(e)
    }

}

