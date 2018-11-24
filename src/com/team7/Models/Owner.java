package com.team7.Models;

import java.util.UUID;


/**
 * @author NikolaosPapazian
 * @version 1.0
 * Owner
 * mast have ID,Name
 */
public class Owner {
    private UUID ownerID;
    private String ownerName;


    public UUID getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(UUID ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
