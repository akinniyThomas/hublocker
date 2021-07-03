package com.assessment.hublocker;

import java.util.List;

public class AnObjectResult<T> {
    private List<T> resultObjects;
    private Boolean succeeded;
    private List<String> errorMessages;

    public AnObjectResult() {
    }

    public AnObjectResult(List<T> resultObjects, Boolean succeeded, List<String> errorMessages) {
        this.resultObjects = resultObjects;
        this.succeeded = succeeded;
        this.errorMessages = errorMessages;
    }

    public AnObjectResult(Boolean succeeded, List<String> errorMessages) {
        this.succeeded = succeeded;
        this.errorMessages = errorMessages;
        this.resultObjects=null;
    }

    public List<T> getResultObjects() {
        return this.resultObjects;
    }

    public void setResultObjects(List<T> resultObjects) {
        this.resultObjects = resultObjects;
    }

    public Boolean isSucceeded() {
        return this.succeeded;
    }

    public Boolean getSucceeded() {
        return this.succeeded;
    }

    public void setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
    }

    public List<String> getErrorMessages() {
        return this.errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "{" +
            " resultObjects='" + getResultObjects() + "'" +
            ", succeeded='" + isSucceeded() + "'" +
            ", errorMessages='" + getErrorMessages() + "'" +
            "}";
    }

    public AnObjectResult<T> returnObjectResult(Boolean succeeded, List<String> errorMessages) {
        return new AnObjectResult<T>(succeeded,errorMessages);
    }

    public AnObjectResult<T> returnObjectResult(Boolean succedded, String errorMessage){
        return new AnObjectResult<T> (succedded, List.of(errorMessage));
    }

    public AnObjectResult<T> returnObjectResult(T obj, Boolean succeeded, List<String> errorMessages){
        return new AnObjectResult<T> (List.of(obj),succeeded,errorMessages);
    }

    public AnObjectResult<T> returnObjectResult(List<T> obj, Boolean succeeded, List<String> errorMessages){
        return new AnObjectResult<T> (obj,succeeded,errorMessages);
    }

    public AnObjectResult<T> returnObjectResult(T obj, Boolean succeeded, String errorMessages){
        return new AnObjectResult<T> (List.of(obj),succeeded,List.of(errorMessages));
    }

    public AnObjectResult<T> returnObjectResult(List<T> obj, Boolean succeeded, String errorMessages){
        return new AnObjectResult<T> (obj,succeeded,List.of(errorMessages));
    }
}
