package se.utility;

import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class StringUtil {

    private static String stringAfterBeingHandled = "";
    private static List<String> immutableStrings;

    public static String appendStrings(@NotNull List<String> strings) {

        //Generating an immutable list from inputted list
        immutableStrings = Collections.unmodifiableList((strings));

        immutableStrings.forEach(str -> stringAfterBeingHandled+=str);

        return stringAfterBeingHandled;
    }
}
