import React from 'react'
import UseSession from '../hooks/UseSession'

const Register = () => {
    const {register} = UseSession();

    return (
        <div>
            <form method="post" onSubmit={register}>
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

export default Register