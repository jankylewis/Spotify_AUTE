package se.commonHandler.baseService;

import org.apache.logging.log4j.Logger;
import se.utility.LoggingUtil;
import se.utility.apiUtil.FakeApiDataUtil;

public class BaseApiService {

    //region Introducing variables

    public FakeApiDataUtil apiFaker;
    public Logger LOGGER = LoggingUtil.TL_LOGGER.get();

    //endregion

    //region Initializing instances

    {
        apiFaker = new FakeApiDataUtil();
    }

    //endregion

}
