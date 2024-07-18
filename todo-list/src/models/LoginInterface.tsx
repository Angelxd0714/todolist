export interface LoginAuth{
  username: string;
  password: string;
}
export interface AuthState {
  isAuthenticated: boolean;
  user: any;
}
