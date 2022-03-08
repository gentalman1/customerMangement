import { request } from "../../axios/Request";

export function loginFunction(loginData) {
    return request({
        url: "http://localhost:9091/auth/login",
        method: "post",
        body: loginData
    })
}