package se.commonHandler.constantEnumeration;

import com.microsoft.playwright.Locator.ClearOptions;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Locator.ClickOptions;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ActionConstant {

    //region Locator > Options classes

    public static ClearOptions clOpts = new ClearOptions();
    public static FillOptions fillOpts = new FillOptions();
    public static ClickOptions clickOpts = new ClickOptions();

    //endregion

    //region Locator > Options classes > setting values

    //region ClearOptions

    public static Boolean getClearByForced(@NotNull ClearOptions clOpts) {
        return clOpts.force = false;
    }

    public static Boolean getNoWaitAfter(@NotNull ClearOptions clOpts) {
        return clOpts.noWaitAfter = false;
    }

    //endregion

    //region FillOptions

    public static Boolean getClearByForced(@NotNull FillOptions fillOpts) {
        return fillOpts.force = false;
    }

    public static Boolean getNoWaitAfter(@NotNull FillOptions fillOpts) {
        return fillOpts.noWaitAfter = false;
    }

    //endregion

    //region ClickOptions

    public static Boolean getClearByForced(@NotNull ClickOptions clickOpts) {
        return clickOpts.force = false;
    }

    public static Boolean getNoWaitAfter(@NotNull ClickOptions clickOpts) {
        return clickOpts.noWaitAfter = false;
    }

    public static int getClickCount(@NotNull ClickOptions clickOpts, int counter) {
        return clickOpts.clickCount = counter;
    }

    public static @NotNull HashMap<Double, Double> getPositions(@NotNull ClickOptions clickOpts, Double xPosition, Double yPosition) {

        //Setting x and y positions
        clickOpts.position.x = xPosition;
        clickOpts.position.y = yPosition;

        //Handling Hashmap
        HashMap<Double, Double> newHM = new HashMap<>();
        newHM.put(new Double(clickOpts.position.x), new Double(clickOpts.position.y));

        return newHM;
    }

    //endregion

    //endregion

}
