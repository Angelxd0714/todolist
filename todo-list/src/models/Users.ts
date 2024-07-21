import { Roles } from "./Roles"

export interface Users{
   id:number,
   username:string, 
   password:string,
   rol:Roles[],
   enabled:boolean
   accountNonExpired:boolean,
   accountNonLocked:boolean,
   credentialsNonExpired:boolean   
}