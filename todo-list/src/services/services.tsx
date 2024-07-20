
import axios from 'axios'
import { LoginAuth } from '../models/LoginInterface'
import { Users } from '../models/Users';
import { createAsyncThunk } from '@reduxjs/toolkit';

axios.defaults.withCredentials = true;

const conexion = async (data: LoginAuth) => {
    try {
        const response = await axios.post("http://localhost:8080/login", data, {
            headers: {
                'Content-Type': 'application/json'
            },

        })
        return response.data
    } catch (error) {
        return await Promise.reject(error)
    }
}

export const dataUserGet:any = createAsyncThunk<Users[]>('auth/dataUserGet', async () => {
    const response = await axios.get<Users[]>('http://localhost:8080/users/all',{
        headers:{
        'Content-Type':'application/json'
    }});
    return response.data;
  });

export default conexion;