

import './App.css'
import { MeNavbar } from './global/Navbar'
import { BrowserRouter, Route, Link, Routes } from 'react-router-dom';
import { Tareas } from './pages/Tareas';
import { Usuarios } from './pages/Usuarios';
import { Login } from './pages/Login';

function App() {


  return (
    <>
    <div className="grid grid-cols-4 min-w-screen-xl min-h-screen">
      <div className='col-span-4 w-full h-full'>
        <MeNavbar />
      </div>
      <div className='col-span-4 flex items-center justify-center min-h-screen'>
        <BrowserRouter>
          <Routes>
            <Route path='/' Component={Login}></Route>
            <Route path="/tarea" Component={Tareas}></Route>
            <Route path="/Usuarios" Component={Usuarios}></Route>
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  </>
  )
}

export default App
