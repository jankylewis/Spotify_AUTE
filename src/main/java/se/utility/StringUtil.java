package se.utility;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public final class StringUtil {

    private static String stringAfterBeingHandled;

    public static String appendStrings(@NotNull List<String> strings) {

        //Assigning an empty value by default
        stringAfterBeingHandled = "";

        //Generating an immutable list from inputted list
        List<String> immutableStrings = Collections.unmodifiableList((strings));

        immutableStrings.forEach(str -> stringAfterBeingHandled+=str);

        return stringAfterBeingHandled;
    }
}
