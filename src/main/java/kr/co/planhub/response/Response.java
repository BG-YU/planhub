package kr.co.planhub.response;

import lombok.Getter;

@Getter
public class Response {

    private final String code;
    private final String message;
    private Object data;

    private Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response of() {
        return new Response("","");
    }

    public Response addObject(Object data) {
        this.data = data;
        return this;
    }
}
