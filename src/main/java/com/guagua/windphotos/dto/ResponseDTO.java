package com.guagua.windphotos.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {

    private boolean success;

    private T data;

    private String message;

    public static <T> ResponseDTO<T> buildSuccess(T data) {
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(true);
        responseDTO.setData(data);
        return responseDTO;
    }

    public static ResponseDTO<?> buildFailure(String message) {
        ResponseDTO<?> responseDTO = new ResponseDTO<>();
        responseDTO.setSuccess(false);
        responseDTO.setMessage(message);
        return responseDTO;
    }
}
