import com.team7.Controllers.InsuranceController;
import com.team7.Controllers.VehicleController;
import com.team7.Models.Insurance;
import com.team7.Models.Vehicle;
import com.team7.Services.FindUninsured;
import com.team7.Services.VehicleSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleSearchTest {

    @Test
    void findAllUninsuredVehicleID() throws ParseException {
        VehicleController veContr =new VehicleController(vehListCreate());
        InsuranceController insContr = new InsuranceController(insuListCreate());
        List<Vehicle> uninsuredArrayList = new ArrayList();
        VehicleSearch vehSearch =new VehicleSearch();
        uninsuredArrayList= vehSearch.FindAllUninsuredVehicleID();

        for (Vehicle veh :uninsuredArrayList) {
            FindUninsured findUninsured = new FindUninsured();
            Assertions.assertFalse(findUninsured.isUninsuredNow(veh.getVehInsurance()));
        }




    }

    @Test
    void findAllUninsuredVehicleOnDateID() throws ParseException {
        VehicleController veContr =new VehicleController(vehListCreate());
        InsuranceController insContr = new InsuranceController(insuListCreate());
        List<Vehicle> uninsuredArrayList = new ArrayList();
        VehicleSearch vehSearch =new VehicleSearch();
        uninsuredArrayList= vehSearch.FindAllUninsuredVehicleOnDateID(4);

        for (Vehicle veh :uninsuredArrayList) {
            FindUninsured findUninsured = new FindUninsured();
            Assertions.assertFalse(findUninsured.isOneUninsuredInDate(veh.getVehInsurance(),4));
        }
    }


    ArrayList<Insurance> insuListCreate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String insurID;
        Date insurFrom;
        Date insurTo;
        Insurance ins = new Insurance();
        ins.setInsuranceID("1d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2018-10-27 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2018-11-27 00:00:00"));

        Insurance ins1 = new Insurance();
        ins1.setInsuranceID("2d34h56s78kn9u9823473");
        ins1.setInsuranceFrom(sdf.parse("2018-10-30 00:00:00"));
        ins1.setInsuranceTo(sdf.parse("2018-11-30 00:00:00"));

        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("3d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2018-10-01 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2018-12-01 00:00:00"));

        Insurance ins3 = new Insurance();
        ins3.setInsuranceID("4d34h56s78kn9u9823473");
        ins3.setInsuranceFrom(sdf.parse("2018-10-02 00:00:00"));
        ins3.setInsuranceTo(sdf.parse("2018-12-02 00:00:00"));

        ArrayList<Insurance> insList = new ArrayList<>();
        insList.add(ins);
        insList.add(ins2);
        insList.add(ins3);
        return insList;
    }



    ArrayList<Vehicle> vehListCreate(){
        Vehicle veh1 = new Vehicle();
        veh1.setVehID("1433d34h56s78kefd7e83939u9823473");
        veh1.setVehLicensePlate("ABC-123");
        veh1.setOwnerID("122nh2dh34sjbcne27dbs");
        veh1.setInsurID("1d34h56s78kn9u9823473");

        Vehicle veh2 = new Vehicle();
        veh2.setVehID("2433d34h56s78kefd7e83939u9823473");
        veh2.setVehLicensePlate("ABC-223");
        veh2.setOwnerID("222nh2dh34sjbcne27dbs");
        veh2.setInsurID("2d34h56s78kn9u9823473");

        Vehicle veh3 = new Vehicle();
        veh3.setVehID("3433d34h56s78kefd7e83939u9823473");
        veh3.setVehLicensePlate("ABC-323");
        veh3.setOwnerID("322nh2dh34sjbcne27dbs");
        veh3.setInsurID("3d34h56s78kn9u9823473");

        Vehicle veh4 = new Vehicle();
        veh4.setVehID("4433d34h56s78kefd7e83939u9823473");
        veh4.setVehLicensePlate("ABC-423");
        veh4.setOwnerID("422nh2dh34sjbcne27dbs");
        veh4.setInsurID("4d34h56s78kn9u9823473");

        ArrayList<Vehicle> vehList = new ArrayList<>();
        vehList.add(veh1);
        vehList.add(veh2);
        vehList.add(veh3);
        vehList.add(veh4);
        return vehList;
    }


}