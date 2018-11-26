import com.team7.Controllers.VehicleController;
import com.team7.Models.Insurance;
import com.team7.Models.Owner;
import com.team7.Models.Vehicle;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleControllerTest {

    @Test
    void getVehicleList() {

        VehicleController vehControl = new VehicleController(vehListCreate());

        List<Vehicle> vehListTest = new ArrayList<>();

        vehListTest = vehControl.getVehicleList();
        assertTrue(vehListTest.get(0).getVehID().equals("1433d34h56s78kefd7e83939u9823473"));
        assertFalse(vehListTest.get(0).getVehID().equals("4433d34h56s78kefd7e83939u9823473"));


    }

    @Test
    void getVehicleID() {
        VehicleController vehControl = new VehicleController(vehListCreate());

        assertTrue(vehControl.getVehicleID("1433d34h56s78kefd7e83939u9823473").getVehID().equals("1433d34h56s78kefd7e83939u9823473"));
        assertFalse(vehControl.getVehicleID("1433d34h56s78kefd7e83939u9823473").getVehID().equals("4433d34h56s78kefd7e83939u9823473"));
    }

    @Test
    void getVehiclePlate() {
        VehicleController vehControl = new VehicleController(vehListCreate());

        assertTrue(vehControl.getVehiclePlate("ABC-123").getVehLicensePlate().equals("ABC-123"));
        assertFalse(vehControl.getVehiclePlate("ABC-323").getVehID().equals("ABC-123"));

    }

    @Test
    void setVehicleList() {
        VehicleController vehControl = new VehicleController(vehListCreate());

        assertTrue(vehControl.getVehicleID("1433d34h56s78kefd7e83939u9823473").getVehID().equals("1433d34h56s78kefd7e83939u9823473"));
        assertFalse(vehControl.getVehicleID("1433d34h56s78kefd7e83939u9823473").getVehID().equals("4433d34h56s78kefd7e83939u9823473"));


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