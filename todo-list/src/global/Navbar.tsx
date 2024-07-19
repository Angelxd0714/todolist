import { Avatar } from "flowbite-react";
import {
    Navbar, Dropdown,
} from "flowbite-react";
import { useSelector } from "react-redux";

import {  Link } from "react-router-dom";
import { RootState } from "../features/store";
import { useEffect } from "react";

export const MeNavbar = () => {
    const isAuthenticated = useSelector((state:RootState)=>state.auth.isAuthenticated);
    useEffect(()=>{
    if(isAuthenticated){
        console.log(isAuthenticated)
    }
    },[isAuthenticated])
    return (
        <Navbar fluid className="w-auto min-w-max bg-[#4C1D95] text-yellow-100 h-14 text-center shadow-xl">

            <div className={isAuthenticated ? "flex  md:order-2" : "hidden"}>
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
                    <Dropdown.Item>Sign out</Dropdown.Item>
                </Dropdown>
                <Navbar.Toggle />
            </div>

            <Navbar.Collapse>
            
                <Link to="/usuarios" className={isAuthenticated ? "py-2":"hidden"}>usuarios</Link>
                <Link to="/tarea" className={isAuthenticated ? "py-2":"hidden"}>Tareas</Link>
            
            </Navbar.Collapse>
        </Navbar>
    );
};