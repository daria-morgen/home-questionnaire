package home.questionnaire.utils;


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

    public ResponseStatus getStatus() {
        return status;
    }

    public List<ResponseError> getErrors() {
        return errors;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}