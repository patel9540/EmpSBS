package com.sbs.service;

public class EmployeeResponse {

    private EmployeeResponseData data;
    

    /**
     * 
     * (U) Constructor.
     * <p>
     * @param entity
     * @param s
     * @param m
     */
    public EmployeeResponse(Object entity, ResponseStatusType s, String m) {
                
        this.data = new EmployeeResponseData(entity, s, m);
    }

    /**
     * @return the data
     */
    public EmployeeResponseData getData() {
        return data;
    }

}
