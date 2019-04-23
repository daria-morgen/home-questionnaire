package home.telegrambot.utils;

import java.util.ArrayList;
import java.util.List;


public class Response {

    private final ResponseStatus status;

    private final List<ResponseError> errors = new ArrayList<ResponseError>();
    private Object result;

    public Response() {
        this.status = ResponseStatus.SUCCESS;
    }

    public Response(ResponseError error) {
        this.status = ResponseStatus.ERROR;
        errors.add(error);
    }

    public Response(Object result) {
        this.status = ResponseStatus.SUCCESS;
        this.result = result;
    }

}