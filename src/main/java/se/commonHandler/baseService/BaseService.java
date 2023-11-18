package se.commonHandler.baseService;

import org.apache.logging.log4j.Logger;
import se.utility.FakeDataUtil;
import se.utility.GlobalVariableUtil.Environment;
import se.utility.GlobalVariableUtil.UserCredential;
import se.utility.LoggingUtil;

public class BaseService {

    //region Introducing variables

    public FakeDataUtil faker;
    public Environment gve;
    public UserCredential gvuc;
    public Logger LOGGER = LoggingUtil.LOGGER;

    //endregion

    //region Initializing instances

    {
        gve = new Environment();
        gvuc = new UserCredential();
        faker = new FakeDataUtil();
    }

    //endregion
}
