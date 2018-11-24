package com.team7.Models;

import java.util.Date;


/**
 * @author NikolaosPapazian
 * @version 1.0
 * Insurance
 * mast have ID,DateFrom,DateTo
 */
public class Insurance implements Comparable {
    private String insurID;
    private Date insurFrom;
    private Date insurTo;

    public String getInsuranceID() {
        return insurID;
    }

    public void setInsuranceID(String insurID) {
        this.insurID = insurID;
    }

    public Date getInsuranceFrom() {
        return insurFrom;
    }

    public void setInsuranceFrom(Date insurFrom) {
        this.insurFrom = insurFrom;
    }

    public Date getInsuranceTo() {
        return insurTo;
    }

    public void setInsuranceTo(Date insurTo) {
        this.insurTo = insurTo;
    }

    @Override
    public int compareTo(Object o) {
        //TODO: make the compare System
        return 0;
    }
}
