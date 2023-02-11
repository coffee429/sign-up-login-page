const baseUrl = 'localhost:8080'
const loginUrl = baseUrl + '/login'

let loginBtn = document.querySelector('.login-btn')

loginBtn.addEventListener("click", login) 

async function login() {
    let email = document.querySelector('input[type=email]').textContent
    let pass = document.querySelector('input[type=password]').textContent

    const options = {
        method: 'POST',
        url: loginUrl,
        headers: {Accept: 'application.json'},
        data: {
            email: email,
            password: pass
        }
    }
    try {
        const res = await axios.request(options)
    } catch(e) {
        console.log(e)
    }
    
}

