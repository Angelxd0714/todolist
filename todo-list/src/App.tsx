

import './App.css'
import { MeNavbar } from './global/Navbar'
import { BrowserRouter, Route, Routes, useNavigate } from 'react-router-dom';

import { Login } from './pages/Login';
import { Usuarios } from './pages/Usuarios';
import { Tareas } from './pages/Tareas';
import { AlertError } from './layout/Toast';
import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import { RootState } from './features/store';



function App() {
 
  const user = useSelector((state: RootState) => state.auth.user);
  console.log(user);
  useEffect(()=>{
      if(user==false){
   
      }
  },[user])
  return (
    <>
    <BrowserRouter>
      <div className="grid grid-cols-4 min-w-screen-xl min-h-screen">
        <div className='col-span-4 w-full h-full'>
          <MeNavbar />
        </div>
          {user && <AlertError message="Error al logearse"></AlertError>}
        <div className='col-span-4 flex items-center justify-center min-h-screen flex-col my-auto text-blue-700'>

          

            <Routes>

              <Route path='/' Component={Login} />
              <Route path="/usuarios"  Component={Usuarios}/>

              <Route path="/tarea" Component={Tareas}/>

            </Routes>

        
        </div>
      </div>
      </BrowserRouter>
    </>
  )
}

export default App
