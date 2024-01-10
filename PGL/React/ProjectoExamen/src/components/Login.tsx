import React from 'react'
import UseSession from '../hooks/UseSession';

const Login = () => {
    const {login} = UseSession();

    return (
        <div>
            <form method="post" onSubmit={login}>
                <label htmlFor="nick">Nick: </label>
                <input type="text" name="nick" id="nick" required/>
                <br/>

                <label htmlFor="email">Correo: </label>
                <input type="text" name="email" id="email" required/>
                <br/>

                <label htmlFor="psswrd">Password: </label>
                <input type="text" name="psswrd" id="psswrd" required/>
                <br/>

                <input type="submit" value="enviar" />
            </form>
        </div>
    )
}

export default Login