package se.requestProcessor;

import se.utility.apiUtil.RestUtil;

public class BrowseCategoryProcessor extends BaseProcessor {

    //region Introducing constructors

    private BrowseCategoryProcessor() {
        super();
    }
    private BrowseCategoryProcessor(RestUtil restUtil) {
        super(restUtil);
    }

    //endregion

    //region Processing instance`

    private static final BrowseCategoryProcessor INSTANCE = getInstance();

    protected static BrowseCategoryProcessor getInstance() {
        _requestProcessor = RestUtil.getInstance();
        return BrowseCategoryProcessorHelper._INSTANCE;
    }

    private static final class BrowseCategoryProcessorHelper {
        private static final BrowseCategoryProcessor _INSTANCE =
                new BrowseCategoryProcessor();
    }

    //endregion

    private final String browseCategoriesUri = "https://api.spotify.com/v1/browse/categories";

    //region Making request to get list of browse categories

    //Blocking access to this method from others
    public synchronized BrowseCategoryProcessor getBrowseCategories() {

        _requestProcessor.sendAuthenticatedRequest(
                browseCategoriesUri,
                null,
                null,
                RestUtil.EMethod.GET
        );

        return INSTANCE;
    }

    //endregion
}
