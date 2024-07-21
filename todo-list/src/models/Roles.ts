import { Permissions } from "./Permissions";

export interface Roles{
    id:number;
    rolName:string;
    description:string | null;
    permissions:Array<Permissions>[];
}