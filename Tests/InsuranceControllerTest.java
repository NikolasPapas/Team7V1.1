import com.team7.Controllers.InsuranceController;
import com.team7.Models.Insurance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceControllerTest {

    @Test
    void getInsuranceList() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String insurID;
        Date insurFrom;
        Date insurTo;
        Insurance ins = new Insurance();
        ins.setInsuranceID("1d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2017-08-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2017-08-05 00:00:00"));

        Insurance ins1 = new Insurance();
        ins1.setInsuranceID("2d34h56s78kn9u9823473");
        ins1.setInsuranceFrom(sdf.parse("2017-08-06 00:00:00"));
        ins1.setInsuranceTo(sdf.parse("2017-08-06 00:00:00"));

        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("3d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2017-08-07 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2017-08-07 00:00:00"));

        Insurance ins3 = new Insurance();
        ins3.setInsuranceID("4d34h56s78kn9u9823473");
        ins3.setInsuranceFrom(sdf.parse("2017-08-08 00:00:00"));
        ins3.setInsuranceTo(sdf.parse("2017-08-08 00:00:00"));

        ArrayList<Insurance> insList = new ArrayList<>();
        insList.add(ins);
        insList.add(ins2);
        insList.add(ins3);
        InsuranceController insControl = new InsuranceController(insList);


        List<Insurance> insList2 = new ArrayList<>();
        insList2=insControl.getInsuranceList();
        assertTrue(insList2.get(0).getInsuranceTo().equals(sdf.parse("2017-08-05 00:00:00")));
        assertFalse(insList2.get(0).getInsuranceTo().equals(sdf.parse("2017-08-08 00:00:00")));


    }

    @Test
    void setInsuranceList() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String insurID;
        Date insurFrom;
        Date insurTo;
        Insurance ins = new Insurance();
        ins.setInsuranceID("1d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2017-08-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2017-08-05 00:00:00"));

        Insurance ins1 = new Insurance();
        ins1.setInsuranceID("2d34h56s78kn9u9823473");
        ins1.setInsuranceFrom(sdf.parse("2017-08-06 00:00:00"));
        ins1.setInsuranceTo(sdf.parse("2017-08-06 00:00:00"));

        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("3d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2017-08-07 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2017-08-07 00:00:00"));

        Insurance ins3 = new Insurance();
        ins3.setInsuranceID("4d34h56s78kn9u9823473");
        ins3.setInsuranceFrom(sdf.parse("2017-08-08 00:00:00"));
        ins3.setInsuranceTo(sdf.parse("2017-08-08 00:00:00"));

        ArrayList<Insurance> insList = new ArrayList<>();
        insList.add(ins);
        insList.add(ins2);
        insList.add(ins3);
        InsuranceController insControl = new InsuranceController(insList);

        assertTrue(insControl.getInsuranceID("1d34h56s78kn9u9823473").getInsuranceTo().equals(sdf.parse("2017-08-05 00:00:00")));
        assertFalse(insControl.getInsuranceID("1d34h56s78kn9u9823473").getInsuranceTo().equals(sdf.parse("2017-08-08 00:00:00")));



    }

    @Test
    void getInsuranceID() throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String insurID;
        Date insurFrom;
        Date insurTo;
        Insurance ins = new Insurance();
        ins.setInsuranceID("1d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2017-08-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2017-08-05 00:00:00"));

        Insurance ins1 = new Insurance();
        ins1.setInsuranceID("2d34h56s78kn9u9823473");
        ins1.setInsuranceFrom(sdf.parse("2017-08-06 00:00:00"));
        ins1.setInsuranceTo(sdf.parse("2017-08-06 00:00:00"));

        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("3d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2017-08-07 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2017-08-07 00:00:00"));

        Insurance ins3 = new Insurance();
        ins3.setInsuranceID("4d34h56s78kn9u9823473");
        ins3.setInsuranceFrom(sdf.parse("2017-08-08 00:00:00"));
        ins3.setInsuranceTo(sdf.parse("2017-08-08 00:00:00"));

        ArrayList<Insurance> insList = new ArrayList<>();
        insList.add(ins);
        insList.add(ins2);
        insList.add(ins3);
        InsuranceController insControl = new InsuranceController(insList);


        assertTrue(insControl.getInsuranceID("4d34h56s78kn9u9823473").getInsuranceID().equals("4d34h56s78kn9u9823473"));
        assertFalse(insControl.getInsuranceID("4d34h56s78kn9u9823473").getInsuranceID().equals("1d34h56s78kn9u9823473"));

    }

    @Test
    void getInsuranceDateEnd() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String insurID;
        Date insurFrom;
        Date insurTo;
        Insurance ins = new Insurance();
        ins.setInsuranceID("1d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2017-08-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2017-08-05 00:00:00"));

        Insurance ins1 = new Insurance();
        ins1.setInsuranceID("2d34h56s78kn9u9823473");
        ins1.setInsuranceFrom(sdf.parse("2017-08-06 00:00:00"));
        ins1.setInsuranceTo(sdf.parse("2017-08-06 00:00:00"));

        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("3d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2017-08-07 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2017-08-07 00:00:00"));

        Insurance ins3 = new Insurance();
        ins3.setInsuranceID("4d34h56s78kn9u9823473");
        ins3.setInsuranceFrom(sdf.parse("2017-08-08 00:00:00"));
        ins3.setInsuranceTo(sdf.parse("2017-08-08 00:00:00"));

        ArrayList<Insurance> insList = new ArrayList<>();
        insList.add(ins);
        insList.add(ins2);
        insList.add(ins3);
        InsuranceController insControl = new InsuranceController(insList);


        assertTrue(insControl.getInsuranceID("1d34h56s78kn9u9823473").getInsuranceTo().equals(sdf.parse("2017-08-05 00:00:00")));
        assertFalse(insControl.getInsuranceID("1d34h56s78kn9u9823473").getInsuranceTo().equals(sdf.parse("2017-08-08 00:00:00")));



    }

    @Test
    void getInsuranceDateStart() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        String insurID;
        Date insurFrom;
        Date insurTo;
        Insurance ins = new Insurance();
        ins.setInsuranceID("1d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2017-08-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2017-08-05 00:00:00"));

        Insurance ins1 = new Insurance();
        ins1.setInsuranceID("2d34h56s78kn9u9823473");
        ins1.setInsuranceFrom(sdf.parse("2017-08-06 00:00:00"));
        ins1.setInsuranceTo(sdf.parse("2017-08-06 00:00:00"));

        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("3d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2017-08-07 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2017-08-07 00:00:00"));

        Insurance ins3 = new Insurance();
        ins3.setInsuranceID("4d34h56s78kn9u9823473");
        ins3.setInsuranceFrom(sdf.parse("2017-08-08 00:00:00"));
        ins3.setInsuranceTo(sdf.parse("2017-08-08 00:00:00"));

        ArrayList<Insurance> insList = new ArrayList<>();
        insList.add(ins);
        insList.add(ins2);
        insList.add(ins3);
        InsuranceController insControl = new InsuranceController(insList);



        assertTrue(insControl.getInsuranceID("4d34h56s78kn9u9823473").getInsuranceFrom().equals(sdf.parse("2017-08-08 00:00:00")));
        assertFalse(insControl.getInsuranceID("4d34h56s78kn9u9823473").getInsuranceFrom().equals(sdf.parse("2017-08-07 00:00:00")));


    }
}