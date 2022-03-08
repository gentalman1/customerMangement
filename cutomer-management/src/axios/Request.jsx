import axios from "axios";



export function setupAxios(axios) {
    axios.interceptors.request.use(
        (config) => {
            return config;
        },
        (err) => Promise.reject(err)
    );

    axios.interceptors.response.use((response) => {
        console.log("response:::{}", response)
        return response;
    }, (error) => {
        console.log("error:::{}", error)
        return error;
    })
}
{/* <p>Already have an account? <a href="#">Sign in</a>.</p> */}
export const request = (options) => {

    const config = {
        headers: !options["contentType"] ? { "Content-Type": "application/json" } : { "Content-Type": options["contentType"] },
        url: options["url"],
        method: options["method"],
    };

    if (options["body"]) {
        config["data"] = options["body"];
    }
    if (options["params"]) {
        config["params"] = options["params"];
    }

    if (navigator.onLine) {
        return axios.request(config);
    }
}