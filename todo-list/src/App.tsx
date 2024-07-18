

import './App.css'
import { MeNavbar } from './global/Navbar'
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import { Tareas } from './pages/Tareas';
import { Usuarios } from './pages/Usuarios';
import { Login } from './pages/Login';
import { useSelector } from 'react-redux';
import { RootState } from './features/store';
const PrivateRoute: any = ({ children }: any) => {
  const isAuth = useSelector((state: RootState) => state.auth.isAuthenticated)
  return isAuth ? children : <Navigate to='/' />
}
function App() {


  return (
    <>
      <div className="grid grid-cols-4 min-w-screen-xl min-h-screen">
        <div className='col-span-4 w-full h-full'>
          <MeNavbar />
        </div>
         
        <div className='col-span-4 flex items-center justify-center min-h-screen flex-col my-auto text-blue-700'>
         <h1 className='text-center font-mono font-semibold text-4xl'>Login</h1>
          <BrowserRouter>
            <Routes>
              
              <Route path='/' Component={Login}></Route>
              <Route path="/tarea" Component={Tareas} element={
                <PrivateRoute>
                  <Tareas />
                </PrivateRoute>
              }></Route>
              <Route path="/Usuarios" Component={Usuarios} element={
                <PrivateRoute>
                  <Usuarios />
                </PrivateRoute>
              }></Route>
            </Routes>
          </BrowserRouter>
        </div>
      </div>
    </>
  )
}

export default App
