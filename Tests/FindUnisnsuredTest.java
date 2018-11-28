import com.team7.Models.Insurance;
import com.team7.Services.FindUninsured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;



class FindUninsuredTest {

    @Test
    void findAllUninsuredVehicleID() {
    }

    @Test
    void isUninsuredNow() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        FindUninsured find =new FindUninsured();

        Insurance ins = new Insurance();
        ins.setInsuranceID("d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2017-08-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2017-08-05 00:00:00"));


        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2019-8-05 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2019-8-05 00:00:00"));


        Assertions.assertTrue(find.isUninsuredNow(ins2));
        Assertions.assertFalse(find.isUninsuredNow(ins));
    }




    @Test
    void isUninsuredInDate() {

    }

    @Test
    void isOneUninsuredInDate() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
        FindUninsured find =new FindUninsured();

        Insurance ins = new Insurance();
        ins.setInsuranceID("d34h56s78kn9u9823473");
        ins.setInsuranceFrom(sdf.parse("2018-10-05 00:00:00"));
        ins.setInsuranceTo(sdf.parse("2018-11-29 00:00:00"));


        Insurance ins2 = new Insurance();
        ins2.setInsuranceID("d34h56s78kn9u9823473");
        ins2.setInsuranceFrom(sdf.parse("2018-10-30 00:00:00"));
        ins2.setInsuranceTo(sdf.parse("2018-12-30 00:00:00"));


        Assertions.assertTrue(find.isOneUninsuredInDate(ins2,10));
        Assertions.assertFalse(find.isOneUninsuredInDate(ins,10));
    }
}