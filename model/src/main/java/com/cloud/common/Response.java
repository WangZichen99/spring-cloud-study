package com.cloud.common;

import lombok.Data;

@Data
public class Response {
    private Integer status;
    private String message;
    private Object data;

    public static Response ok(Object data) {
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }

    public static Response error(String message) {
        Response response = new Response();
        response.setStatus(500);
        response.setMessage(message);
        return response;
    }

    public static Response error(Integer status, String message) {
        Response response = new Response();
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }

}
