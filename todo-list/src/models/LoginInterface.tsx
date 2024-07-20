import { Users } from "./Users";

export interface LoginAuth{
  username: string;
  password: string;
}
export interface AuthState {
  isAuthenticated: boolean;
  user: any;
  users:Array<Users>
  loading: boolean,
  error: null
}
