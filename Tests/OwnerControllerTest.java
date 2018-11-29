import com.team7.Controllers.OwnerController;
import com.team7.Models.Owner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OwnerControllerTest {

    @Test
    void getOwnerList() {

        OwnerController ownerContr = new OwnerController(onerListCreate());
        assertTrue(ownerContr.getOwner("422nh2dh34sjbcne27dbs").getOwnerName().equals("nikolas"));
        assertTrue(ownerContr.getOwner("222nh2dh34sjbcne27dbs").getOwnerName().equals("kostas"));
        assertFalse(ownerContr.getOwner("422nh2dh34sjbcne27dbs").getOwnerName().equals("kostas"));
        assertFalse(ownerContr.getOwner("222nh2dh34sjbcne27dbs").getOwnerName().equals("kostas2"));

    }

    @Test
    void getOwner() {
        OwnerController ownerContr = new OwnerController(onerListCreate());
        assertTrue(ownerContr.getOwner("222nh2dh34sjbcne27dbs").getOwnerName().equals("kostas"));
        assertFalse(ownerContr.getOwner("422nh2dh34sjbcne27dbs").getOwnerName().equals("kostas"));

    }

    @Test
    void setOwnerList() {

        OwnerController ownerContr = new OwnerController(onerListCreate());

        Owner oner5 = new Owner();
        oner5.setOwnerID("522nh2dh34sjbcne27dbs");
        oner5.setOwnerName("Vaggelis2");
        Owner oner6 = new Owner();
        oner6.setOwnerID("622nh2dh34sjbcne27dbs");
        oner6.setOwnerName("kostas2");
        Owner oner7 = new Owner();
        oner7.setOwnerID("722nh2dh34sjbcne27dbs");
        oner7.setOwnerName("manos2");
        Owner oner8 = new Owner();
        oner8.setOwnerID("822nh2dh34sjbcne27dbs");
        oner8.setOwnerName("nikolas2");
        ArrayList<Owner> ownqeList2 = new ArrayList<>();
        ownqeList2.add(oner5);
        ownqeList2.add(oner6);
        ownqeList2.add(oner7);
        ownqeList2.add(oner8);
        ownerContr.setOwnerList(ownqeList2);

        assertTrue(ownerContr.getOwner("622nh2dh34sjbcne27dbs").getOwnerName().equals("kostas2"));
        assertFalse(ownerContr.getOwner("722nh2dh34sjbcne27dbs").getOwnerName().equals("kostas2"));
    }

    @Test
    void setOwner() {


        OwnerController ownerContr = new OwnerController(onerListCreate());


        Owner oner5 = new Owner();
        oner5.setOwnerID("522nh2dh34sjbcne27dbs");
        oner5.setOwnerName("nikolas2");

        ownerContr.setOwner(oner5);


        assertTrue(ownerContr.getOwner("522nh2dh34sjbcne27dbs").getOwnerName().equals("nikolas2"));
        assertFalse(ownerContr.getOwner("122nh2dh34sjbcne27dbs").getOwnerName().equals("kostas"));
    }


    ArrayList<Owner> onerListCreate(){
        Owner oner = new Owner();
        oner.setOwnerID("122nh2dh34sjbcne27dbs");
        oner.setOwnerName("Vaggelis");
        Owner oner2 = new Owner();
        oner2.setOwnerID("222nh2dh34sjbcne27dbs");
        oner2.setOwnerName("kostas");
        Owner oner3 = new Owner();
        oner3.setOwnerID("322nh2dh34sjbcne27dbs");
        oner3.setOwnerName("manos");
        Owner oner4 = new Owner();
        oner4.setOwnerID("422nh2dh34sjbcne27dbs");
        oner4.setOwnerName("nikolas");
        ArrayList<Owner> ownqeList = new ArrayList<>();
        ownqeList.add(oner);
        ownqeList.add(oner2);
        ownqeList.add(oner3);
        ownqeList.add(oner4);
        return ownqeList;
    }
}