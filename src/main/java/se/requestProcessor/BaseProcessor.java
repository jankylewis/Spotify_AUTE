package se.requestProcessor;

import io.restassured.response.Response;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import se.commonHandler.baseService.BaseApiService;
import se.commonHandler.baseService.BaseVerification.IVerification;
import se.commonHandler.constantHouse.apiConstant.ApiConstant;
import se.commonHandler.constantHouse.apiConstant.ApiMessageConstant;
import se.utility.apiUtil.RestUtil;

public class BaseProcessor extends BaseApiService implements IVerification {

    private int responseStatusCode = -1;
    private boolean responseHealth = false;

    protected ApiConstant apiConstant;
    protected ApiMessageConstant apiMessageConstant;

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
        apiMessageConstant = new ApiMessageConstant();
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
