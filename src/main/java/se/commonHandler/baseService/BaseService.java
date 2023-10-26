package se.commonHandler.baseService;

import se.utility.FakeDataUtil;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.GlobalVariableUtil.BrowserConfiguration;
import se.utility.GlobalVariableUtil.UserCredential;
import se.utility.PLUtil;

public class BaseService {

    //region Introducing variables

    public FakeDataUtil faker;
    public PLUtil plUtil;
    public Environment gve;
    public BrowserConfiguration gvbc;
    public UserCredential gvuc;

    //endregion

    //region Initializing instances

    {
        gve = new Environment();
        gvbc = new BrowserConfiguration();
        gvuc = new UserCredential();
        faker = new FakeDataUtil();
    }

    //endregion
}
