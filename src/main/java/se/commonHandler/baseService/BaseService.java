package se.commonHandler.baseService;

import se.utility.FakeDataUtil;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.GlobalVariableUtil.UserCredential;

public class BaseService {

    //region Introducing variables

    public FakeDataUtil faker;
    public Environment gve;
    public UserCredential gvuc;

    //endregion

    //region Initializing instances

    {
        gve = new Environment();
        gvuc = new UserCredential();
        faker = new FakeDataUtil();
    }

    //endregion
}
