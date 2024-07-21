
import { Button, Table } from "flowbite-react"
import { Users } from "../models/Users"
import { useDispatch, useSelector } from "react-redux"
import { RootState } from "../features/store"
import { useEffect, useState } from "react"
import { dataUserGet } from "../services/services"
import { SnniperLoad } from "./Snipper"
import { useNavigate } from "react-router-dom"
import { ModalUser } from "./modal"

export const TableUsuarios = () => {
  const dispatch = useDispatch()
  const navigate = useNavigate()
  const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated)
  const users:Array<Users> = useSelector((state: RootState) => state.auth.users)
  console.log(users)
  const loading = useSelector((state: RootState) => state.auth.loading)
  const error = useSelector((state: RootState) => state.auth.error)
  const [openModal,setOpenModal] = useState(false)
  useEffect(() => {
    if(isAuthenticated){
    dispatch(dataUserGet())
    }else{
      navigate("/")
    }
  }, [dispatch, isAuthenticated])
  return (<>
  {loading && <SnniperLoad/>}
  {error && <div>{error}</div>}
    <div className="overflow-x-auto">
      <Table>
        <Table.Head>
          <Table.HeadCell>Id</Table.HeadCell>
          <Table.HeadCell>Username</Table.HeadCell>
          <Table.HeadCell>Role</Table.HeadCell>
          <Table.HeadCell>Enabled</Table.HeadCell>
          <Table.HeadCell>accountNonExpired</Table.HeadCell>
          <Table.HeadCell>accountNonLocked</Table.HeadCell>
          <Table.HeadCell>credentialsNonExpired</Table.HeadCell>
          <Table.HeadCell>
            <span className="sr-only">Edit</span>
          </Table.HeadCell>
        </Table.Head>
        <Table.Body className="divide-y">
        {isAuthenticated &&users.map((user: Users) => {
        console.log("User roles:", user.rol); // Log de depuración

        return (
          <Table.Row key={user.id} className="bg-white dark:border-gray-700 dark:bg-gray-800">
            <Table.Cell className="whitespace-nowrap font-medium text-gray-900 dark:text-white">
              {user.id}
            </Table.Cell>
            <Table.Cell>{user.username}</Table.Cell>
            <Table.Cell>
            {user.rol && user.rol.length > 0
                  ? user.rol.map((role, index) => (
                      <span key={index}>
                        {role?.rolName}
                      </span>
                    ))
                  : 'No roles'}
            </Table.Cell>
            <Table.Cell>{user.enabled?.toString()}</Table.Cell>
            <Table.Cell>{user.accountNonExpired?.toString()}</Table.Cell>
            <Table.Cell>{user.accountNonLocked?.toString()}</Table.Cell>
            <Table.Cell>{user.credentialsNonExpired?.toString()}</Table.Cell>
            <Table.Cell>
              <Button className="bg-blue-700 text-white text-center" onClick={()=>setOpenModal(true)}>Editar</Button>
              <ModalUser id={user.id} openModal={openModal} setOpenModal={setOpenModal} />
            </Table.Cell>
          </Table.Row>
        );
      })}
        </Table.Body>
      </Table>
    </div>
  </>)
}