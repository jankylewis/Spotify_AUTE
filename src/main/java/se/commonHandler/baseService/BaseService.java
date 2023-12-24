package se.commonHandler.baseService;

import org.apache.logging.log4j.Logger;
import se.utility.DateTimeUtil;
import se.utility.FakeDataUtil;
import se.utility.LoggingUtil;

//This service is used for running UI test scripts
public class BaseService {

    //region Introducing variables

    public FakeDataUtil faker;
    public DateTimeUtil dateTimeUtil;
    public Logger LOGGER = LoggingUtil.TL_LOGGER.get();

    //endregion

    //region Initializing instances

    {
        faker = new FakeDataUtil();
        dateTimeUtil = new DateTimeUtil();
    }

    //endregion
}

