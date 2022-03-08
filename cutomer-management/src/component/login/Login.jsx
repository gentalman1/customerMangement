import { Visibility, VisibilityOff } from "@mui/icons-material";
import { Button } from "@mui/material";
import { Box } from "@mui/system";
import React, { useState } from "react";
import { loginFunction } from "../../api/loginAPI/LoginAPI";
import CustomeTextField from "./CustomeTextField";
const base64 = require('base-64');

export default function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isShow, setIsShow] = useState(true)
  const [isEmailError, setIsEmailError] = useState(false)
  const [errorEmailMessage, setErrorEmailMessage] = useState("")
  const [isPasswordError, setIsPasswordError] = useState(false)
  const [errorPasswordMessage, setErrorPasswordMessage] = useState("")



  let hideIcon = <Visibility onClick={isPasswordShow} role="button" />;

  let showIcon = <VisibilityOff onClick={isPasswordShow} role="button" />

  function handleOnChnageDetails(event) {
    event.target.name === "userName" && setEmail(event.target.value)
    event.target.name === "password" && setPassword(event.target.value)
  }

  const loginForm = [
    {
      label: "UserName / Email",
      id: "outlined-size-small",
      size: "small",
      name: "userName",
      value: email,
      handleOnChnage: handleOnChnageDetails,
      isError: isEmailError,
      errorMessage: errorEmailMessage
    },
    {
      value: password,
      name: "password",
      label: "Password",
      id: "outlined-size-small",
      size: "small",
      type: isShow ? "password" : "tect",
      inputProps: isShow ? hideIcon : showIcon,
      handleOnChnage: handleOnChnageDetails,
      isError: isPasswordError,
      errorMessage: errorPasswordMessage
    }
  ]


  function isPasswordShow() {
    setIsShow(!isShow);
  }

  function validateEmail(email) {
    //eslint-disable-next-line
    const regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return regex.test(email);
  }



  function validatePassword(password) {
    //eslint-disable-next-line
    var regex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    return regex.test(password);
  }

  function resetErrorState() {
    setIsEmailError(false);
    setErrorEmailMessage("");
    setIsPasswordError(false);
    setErrorPasswordMessage("");
  }

  function submit(event) {
    event.preventDefault();
    resetErrorState();
    if (email === '' || !validateEmail(email)) {
      console.log("email empty!!")
      setIsEmailError(true);
      setErrorEmailMessage("Please enter valid email!")
    } else if (password === '' || !validatePassword(password)) {
      console.log("password empty!!")
      setIsPasswordError(true);
      setErrorPasswordMessage("Please enter valid password!")
    } else {

      let loginData = {
        "userName": base64.encode(email),
        "password": base64.encode(password)
      }
      loginFunction(loginData).then(res => {
        if (res.data) {
          console.log(res.data, "::::::::")
        }
      }).catch(error => console.log("errror", error));
    }

  }



  return (
    <div className="login-page">
      <Box
        component="form"
        sx={{
          '& .MuiTextField-root': { m: 1, width: '25ch' },
        }}
        noValidate
        autoComplete="off"
        className="login-form"
        onSubmit={submit}
      >
        <div className="h3 text-center">Login</div>
        {
          loginForm.map((data, index) => {
            return <div key={index}>
              <CustomeTextField
                label={data?.label}
                id={data?.id}
                size={data?.size}
                type={data?.type}
                inputProps={data?.inputProps}
                name={data.name}
                value={data.value}
                handleOnChnage={data.handleOnChnage}
                isError={data.isError}
                errorMessage={data.errorMessage}
              />
            </div >
          })
        }
        <div>
          <Button type="submit" variant="contained" className="m-2">
            Login
          </Button>
        </div>
        <div>
          <a href="" className="m-2">Sign Up</a>
          <a href="" className="float-right">Forgot Password?</a>
        </div>
      </Box>
    </div>
  );
}