import { Button, Checkbox, Label, TextInput } from "flowbite-react"
import { useState } from "react";
import { useDispatch } from "react-redux";
import { login } from "../features/auth/authSlice";
import { AppDispatch } from "../features/store";



export const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const dispatch = useDispatch<AppDispatch>();
  const handleSubmit = async (e:any) => {
    e.preventDefault();
    dispatch(login(username,password))
  }
  return (
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
      <div className="flex items-center gap-2">
        <Checkbox id="remember" />
        <Label htmlFor="remember">Remember me</Label>
      </div>
      <Button type="submit">Submit</Button>
    </form>
  )
}