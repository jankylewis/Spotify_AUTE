package se.requestProcessor;

import se.utility.apiUtil.RestUtil;

public class BaseProcessor {

    protected static RestUtil _requestProcessor;

    protected BaseProcessor() {}
    protected BaseProcessor(RestUtil requestProcessor) {
        _requestProcessor = requestProcessor;
    }
}
