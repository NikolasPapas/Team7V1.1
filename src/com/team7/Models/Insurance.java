package com.team7.Models;

import java.util.Date;
import java.util.UUID;

/**
 * @author NikolaosPapazian
 * @version 1.0
 * Insurance
 * mast have ID,DateFrom,DateTo
 */
public class Insurance {
    private UUID insurID;
    private Date insurFrom;
    private Date insurTo;

    public UUID getInsurID() {
        return insurID;
    }

    public void setInsurID(UUID insurID) {
        this.insurID = insurID;
    }

    public Date getInsurFrom() {
        return insurFrom;
    }

    public void setInsurFrom(Date insurFrom) {
        this.insurFrom = insurFrom;
    }

    public Date getInsurTo() {
        return insurTo;
    }

    public void setInsurTo(Date insurTo) {
        this.insurTo = insurTo;
    }
}
