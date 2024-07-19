import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { AuthState } from "../../models/LoginInterface";
import conexion from "../../services/services";
import { AppDispatch } from "../store";

const initialState: AuthState = {
    isAuthenticated: false,
    user: null,
};


const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        setAuth(state, action: PayloadAction<{ isAuthenticated: boolean, user: any }>) {
            state.isAuthenticated = action.payload.isAuthenticated;
            state.user = action.payload.user;
        },
        logout(state) {
            state.isAuthenticated = false;
            state.user = null;
        },
    },
});

export const { setAuth, logout } = authSlice.actions;
export const login = (username: string, password: string) => async (dispatch: AppDispatch) => {
    try {
        const res = await conexion({ username, password })
        console.log(res)
        dispatch(setAuth({ isAuthenticated: true, user: res }));
    } catch (error) {
        dispatch(setAuth({ isAuthenticated: false, user: error }));
     
    }
}
export default authSlice.reducer;