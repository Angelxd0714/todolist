export interface Users{
   id:number,
   username:string, 
   password:string,
   role:Array<string>[],
   enabled:boolean
   accountNonExpired:boolean,
   accountNonLocked:boolean,
   credentialsNonExpired:boolean   
}