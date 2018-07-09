package testSuite;

import appHelpers.UserLogIn;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest
{	    
    @Test()
    public void logInPA()
    {
    	UserLogIn.logIn(Driver, "PA");
    }
    
   @Test()
   public void logInWI()
   {
    	UserLogIn.logIn(Driver, "WI");
    }
    
    @Test()
    public void logInIL()
    {
    	UserLogIn.logIn(Driver, "IL");
    }
    
    @Test()
    public void logInOH()
    {
    	UserLogIn.logIn(Driver, "OH");
    }
    
}