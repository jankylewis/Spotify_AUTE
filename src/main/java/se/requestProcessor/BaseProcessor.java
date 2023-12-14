package se.requestProcessor;

import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.baseService.BaseVerifier.IVerification;
import se.commonHandler.constantHouse.ApiConstant;
import se.utility.FakeDataUtil;
import se.utility.LoggingUtil;
import se.utility.apiUtil.RestUtil;

public class BaseProcessor implements IVerification {

    private int responseStatusCode = -1;
    private boolean responseHealth = false;

    protected ApiConstant apiConstant;
    protected Logger LOGGER = LoggingUtil.TL_LOGGER.get();
    protected FakeDataUtil faker;

    protected static RestUtil _requestProcessor;

    //region Generating an instance

    protected BaseProcessor() {}
    protected BaseProcessor(RestUtil requestProcessor) {
        _requestProcessor = requestProcessor;
    }

    //endregion

    //region Initializing const

    {
        apiConstant = new ApiConstant();
        faker = new FakeDataUtil();
    }

    //endregion

    protected Pair<Boolean, Integer> verifyResponseStatusCodeWentGreen(@NotNull Response response) {

        responseStatusCode = response.statusCode();
        responseHealth = responseStatusCode == apiConstant.GREEN_STATUS;

        return Pair.with(responseHealth, responseStatusCode);
    }

    //region IVerification

    @Override
    public void verificationWentPassed() {
        assert true;
    }

    @Override
    public void verificationWentFailed() {
        assert false;
    }

    //endregion
}
