import { TextField } from "@mui/material";
import React from "react";

export default function CustomeTextField(props) {
    
    const { isError = false, errorMessage = "", name = "", value = "", handleOnChnage, label = "", id = "outlined-size-small", size = "small", type = "text", inputProps } = props
    
    return <TextField
        label={label}
        id={id}
        size={size}
        type={type}
        InputProps={{
            endAdornment: inputProps
        }}
        name={name}
        value={value}
        onChange={handleOnChnage}
        error={isError}
        helperText={isError ? errorMessage : ''}
    />;
}