package testSuite;

import appHelpers.NewStudentHelper;
import appHelpers.UserLogIn;
import org.testng.annotations.Test;
import testSuite.BaseTest;

public class NewStudentTest extends BaseTest
{
	
    @Test
    public void createStudentOH()
    {
    	UserLogIn.logIn(Driver, "OH");

        NewStudentHelper.createANewStudent(Driver, "NewStudentData.xlsx");
    }
    
    @Test
    public void createStudentPA()
    {
    	UserLogIn.logIn(Driver, "PA");

        NewStudentHelper.createANewStudent(Driver, "NewStudentData.xlsx");
    }
}