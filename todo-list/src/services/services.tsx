
import axios from 'axios'
import { LoginAuth } from '../models/LoginInterface'


const conexion = async (data: LoginAuth) => {
    console.log(data)
    try {
        const response = await axios.post("http://localhost:8080/login", data, {
            headers: {
                'Content-Type': 'application/json'
            },
            withCredentials: true
        })
        console.log(response)
        return response.data
    } catch (error) {
        return await Promise.reject(error)
    }
}
export default conexion;