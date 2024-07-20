import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { AuthState } from "../../models/LoginInterface";
import conexion, { dataUserGet } from "../../services/services";
import { AppDispatch } from "../store";
import { Users } from "../../models/Users";
const initialState: AuthState = {
    isAuthenticated: false,
    user: null,
    users: Array<Users>(),
    loading: false,
    error: null,

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
    extraReducers: (builder) => {
        builder.addCase(dataUserGet.pending, (state) => {
            state.loading = true;
            state.error = null;
        })
            .addCase(dataUserGet.fulfilled, (state, action:PayloadAction<Users[]>) => {
                state.loading = false;
                state.users = action.payload;
            })
            .addCase(dataUserGet.rejected, (state, action) => {
                state.loading = false;
                state.error = action.error.message;
            })

    }
});

export const { setAuth, logout } = authSlice.actions;
export const login = (username: string, password: string) => async (dispatch: AppDispatch) => {
    try {
        const res = await conexion({ username, password })
        localStorage.setItem("username",username)
        localStorage.setItem("password", password)
        dispatch(setAuth({ isAuthenticated: true, user: res }));
    } catch (error) {
        dispatch(setAuth({ isAuthenticated: false, user: error }));

    }
}
export default authSlice.reducer;