
package com.team7.Controllers;


import com.team7.DataSave.SingletonDataSave;
import com.team7.Models.Insurance;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author NikolaosPapazian
 * @version 1.0
 */
public class InsuranceController {
    private List<Insurance> insuranceList;
    private SingletonDataSave singletonClass;


    /**
     * Constructor
     * @version 1.0
     */
    public InsuranceController() {
        singletonClass = SingletonDataSave.getInstance();
    }

    /**
     * Constructor
     * @version 1.0
     * @param insuranceList
     */
    public InsuranceController(ArrayList<Insurance> insuranceList) {
        singletonClass = SingletonDataSave.getInstance();
        if(insuranceList !=null) {
            singletonClass.setSingletonInsurance(insuranceList);
            this.insuranceList = insuranceList;
        }else {
            ArrayList<Insurance> insuranceList2=new ArrayList<>();
            Insurance ins = new Insurance();
            ins.setInsuranceID("");
            ins.setInsuranceFrom(null);
            ins.setInsuranceTo(null);
            insuranceList2.add(ins);
            singletonClass.setSingletonInsurance(insuranceList2);
            this.insuranceList = insuranceList2;

        }
    }

    /**
     * @version 1.0
     * @return ArrayList<Insurance>
     */
    public List<Insurance> getInsuranceList() {
        return singletonClass.getSingletonInsurance();
    }

    /**
     * set New ArrayList of Insurance
     * @version 1.0
     * @param insuranceList
     */
    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        if(insuranceList !=null) {
            singletonClass.setSingletonInsurance(insuranceList);
            this.insuranceList = insuranceList;
        }else {
            ArrayList<Insurance> insuranceList2=new ArrayList<>();
            Insurance ins = new Insurance();
            ins.setInsuranceID("");
            ins.setInsuranceFrom(null);
            ins.setInsuranceTo(null);
            insuranceList2.add(ins);
            singletonClass.setSingletonInsurance(insuranceList2);
            this.insuranceList = insuranceList2;

        }
    }

    /**
     * @version 1.0
     * @param insID
     * @return Insurance | null
     */
    public Insurance getInsuranceID(String insID){
        for (Insurance ins:singletonClass.getSingletonInsurance()) {
            if(insID.equals(ins.getInsuranceID())){
                return ins;
            }
        }
        return null;
    }

    /**
     * @version 1.0
     * @param dateEnd
     * @return ArrayList<Insurance>
     */
    public List<Insurance> getInsuranceDateEnd(Date dateEnd){
        List<Insurance> insuranceEndList=new ArrayList<Insurance>();

        for (Insurance ins:singletonClass.getSingletonInsurance()) {
            if(ins.getInsuranceTo().before(dateEnd)){
                insuranceEndList.add(ins);
            }
        }
        return insuranceEndList;
    }

    /**
     * @version 1.0
     * @param startDate
     * @return ArrayList<Insurance>
     */
    public List<Insurance> getInsuranceDateStart(Date startDate){
        List<Insurance> insuranceEndList=new ArrayList<>();

        for (Insurance ins:singletonClass.getSingletonInsurance()) {
            if(ins.getInsuranceFrom().after(startDate)){
                insuranceEndList.add(ins);
            }
        }
        return insuranceEndList;
    }


}
