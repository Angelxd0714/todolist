import { Button, Label, TextInput } from "flowbite-react"
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { login } from "../features/auth/authSlice";
import { AppDispatch, RootState } from "../features/store";
import {useNavigate } from "react-router-dom";




export const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const dispatch = useDispatch<AppDispatch>();
  const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated)
  const user = useSelector((state: RootState) => state.auth.user)
  const navigate = useNavigate();
  const handleSubmit = async (e:any) => {
    e.preventDefault();
    await dispatch(login(username,password))
  }
  useEffect(()=>{
      if(user=="ok"){
          navigate('/tarea');
    }else{
      navigate('/');
    }
  },[isAuthenticated,user])
  return (
    <>
    
    <h1 className='text-center font-mono font-semibold text-4xl'>Login</h1>
    <form className="flex max-w-md flex-col gap-4" onSubmit={handleSubmit}>
      <div>
        <div className="mb-2 block">
          <Label htmlFor="name1" value="Your name" />
        </div>
        <TextInput id="name1" value={username} onChange={(e) => setUsername(e.target.value)} type="text" placeholder="name..." required />
      </div>
      <div>
        <div className="mb-2 block">
          <Label htmlFor="password1" value="Your password" />
        </div>
        <TextInput id="password1" value={password} onChange={(e) => setPassword(e.target.value)} type="password" required />
      </div>
      <Button type="submit">Submit</Button>
    </form>
    
    </>
  )
}