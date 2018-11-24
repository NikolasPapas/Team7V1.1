package com.team7.Controllers;



import com.team7.DataSave.SingletonDataSave;
import com.team7.Models.Owner;

import java.util.ArrayList;
import java.util.List;


/**
 * @author NikolaosPapazian
 * @version 1.0
 */
public class OwnerController {

    private List<Owner> ownerList;
    private SingletonDataSave singletonClass;

    /**
     * Constructor
     * @version 1.0
     * @param owner
     */
    public OwnerController(ArrayList<Owner> owner) {
        singletonClass = SingletonDataSave.getInstance();
        singletonClass.setSingletonOwner(owner);
        this.ownerList = owner;
    }

    /**
     * @version 1.0
     * @return ArrayList<Owner>
     */
    public List<Owner> getOwnerList() {
        return ownerList;
    }

    /**
     * @version 1.0
     * @param ownerID
     * @return Owner | null
     */
    public Owner getOwner(String ownerID){
        for (Owner owner:ownerList) {
            if(ownerID.equals(owner.getOwnerID())){
                return owner;
            }
        }
        return null;
    }

    /**
     * set ArrayList of Owners
     * @version 1.0
     * @param ownerList
     */
    public void setOwnerList(ArrayList<Owner> ownerList) {
        singletonClass.setSingletonOwner(ownerList);
        this.ownerList = ownerList;
    }

    /**
     * add new value to ownerList
     * @version 1.0
     * @param owner
     */
    public void setOwner(Owner owner) {
        singletonClass.setSingletonOneOwner(owner);
        this.ownerList.add(owner);
    }
}
