
import { Table } from "flowbite-react"
import { Users } from "../models/Users"
import { useDispatch, useSelector } from "react-redux"
import { RootState } from "../features/store"
import { useEffect } from "react"
import { dataUserGet } from "../services/services"

export const TableUsuarios = () => {
  const dispatch = useDispatch()
  const isAuthenticated = useSelector((state: RootState) => state.auth.isAuthenticated)
  const users = useSelector((state: RootState) => state.auth.users)
  const loading = useSelector((state: RootState) => state.auth.loading)
  const error = useSelector((state: RootState) => state.auth.error)
  useEffect(() => {
    dispatch(dataUserGet())
  }, [dispatch, isAuthenticated])
  return (<>
    <div className="overflow-x-auto">
      <Table>
        <Table.Head>
          <Table.HeadCell>Id</Table.HeadCell>
          <Table.HeadCell>Username</Table.HeadCell>
          <Table.HeadCell>Password</Table.HeadCell>
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
          { loading && users.map((user: Users) => (
            <Table.Row className="bg-white dark:border-gray-700 dark:bg-gray-800">
              <Table.Cell className="whitespace-nowrap font-medium text-gray-900 dark:text-white">
                {user.id}
              </Table.Cell>
              <Table.Cell>{user.username}</Table.Cell>
              <Table.Cell>{user.password}</Table.Cell>
              <Table.Cell>{user.role}</Table.Cell>
              <Table.Cell>{user.enabled}</Table.Cell>
              <Table.Cell>{user.accountNonExpired}</Table.Cell>
              <Table.Cell>{user.accountNonLocked}</Table.Cell>
              <Table.Cell>{user.credentialsNonExpired}</Table.Cell>
              <Table.Cell>
                <a href="#" className="font-medium text-cyan-600 hover:underline dark:text-cyan-500">
                  Edit
                </a>
              </Table.Cell>
            </Table.Row>
          ))
            
          }
        </Table.Body>
      </Table>
    </div>
  </>)
}