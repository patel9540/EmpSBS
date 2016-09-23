package com.sbs.service;


public class EmployeeResponseData {

    private Object data;
    
    private ResponseStatusType status;
    
    private String message;

    
    /** 
     * (U) Constructor.
     * <p>
     */
    public EmployeeResponseData(Object entity, ResponseStatusType s, String m) {
        
        data = entity;
        status = s;
        message = m;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @return the status
     */
    public ResponseStatusType getStatus() {
        return status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}

