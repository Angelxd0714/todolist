import { Avatar } from "flowbite-react";
import {
    Navbar, Dropdown,
} from "flowbite-react";
import {  useSelector } from "react-redux";
import { BrowserRouter, Link, Navigate, Route, Routes } from "react-router-dom";
import { RootState } from "../features/store";


const PrivateRoute: any = ({ children }: any) => {
    const isAuth = useSelector((state: RootState) => state.auth.isAuthenticated)
    return isAuth ? children : <Navigate to='/' />
}
const isAuthenticated = localStorage.getItem("isAuthenticated")  === "true";

export const MeNavbar = () => {
    return (
        <Navbar fluid rounded className="">
            
                <div className={ isAuthenticated ? "flex  md:order-2" : "hidden"}>
                    <Dropdown
                        arrowIcon={false}
                        inline
                        label={
                            <Avatar alt="User settings" img="https://flowbite.com/docs/images/people/profile-picture-5.jpg" rounded />
                        }
                    >
                        <Dropdown.Header>
                            <span className="block text-sm">Bonnie Green</span>
                            <span className="block truncate text-sm font-medium">name@flowbite.com</span>
                        </Dropdown.Header>
                        <Dropdown.Item>Dashboard</Dropdown.Item>
                        <Dropdown.Item>Settings</Dropdown.Item>
                        <Dropdown.Item>Earnings</Dropdown.Item>
                        <Dropdown.Divider />
                        <Dropdown.Item>Sign out</Dropdown.Item>
                    </Dropdown>
                    <Navbar.Toggle />
                </div>
            
            <Navbar.Collapse>
                <BrowserRouter>
                    <Routes>
                        <Route element={
                            <PrivateRoute>
                                <Link to={"/usuarios"}>usuarios</Link>
                            </PrivateRoute>
                        }>
                        </Route>
                        <Route element={
                            <PrivateRoute>
                                <Link to={"/tarea"}>Tareas</Link>
                            </PrivateRoute>
                        }>
                        </Route>
                    </Routes>
                </BrowserRouter>

            </Navbar.Collapse>
        </Navbar>
    );
};