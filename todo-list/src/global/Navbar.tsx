import { Avatar } from "flowbite-react";
import {
    Navbar, Dropdown,
} from "flowbite-react";
import React from "react";


export const MeNavbar = () => {
    return (
        <Navbar fluid rounded className="">
            <div className="flex  md:order-2">
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

                <Navbar.Link href="/Usuarios">Usuarios</Navbar.Link>
                <Navbar.Link href="/">Tareas</Navbar.Link>


            </Navbar.Collapse>
        </Navbar>
    );
};