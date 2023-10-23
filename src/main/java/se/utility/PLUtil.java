package se.utility;

import com.microsoft.playwright.Page;
import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;
import java.awt.Toolkit;
import java.awt.Dimension;

public class PLUtil {           //PL means Java Programming Language

    //region Resizing viewport

    public static class ViewportUtil {

        private int width;
        private int height;

        public void setScreenSize(@NotNull Pair<Integer, Integer> tupleOfWidthAndHeight) {
            this.width = tupleOfWidthAndHeight.getValue0();
            this.height = tupleOfWidthAndHeight.getValue1();
        }

        public Pair<Integer, Integer> getScreenSize() {
            return Pair.with(width, height);
        }

        public Pair<Integer, Integer> getDeviceScreenSize() {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            return Pair.with((int)dimension.getWidth(), (int)dimension.getHeight());
        }

        public Page exaggerateViewport(@NotNull Page exaggeratedPage) {

            //Forcing to generate a default tuple of screen size
            Pair<Integer, Integer> tupleOfWidthAndHeight = getDeviceScreenSize();

            //Exaggerating the Page
            exaggeratedPage.setViewportSize(
                                            tupleOfWidthAndHeight.getValue0() - 30,
                                                tupleOfWidthAndHeight.getValue1() - 145     // - 145 for taskbar
                                            );

            return exaggeratedPage;
        }

        public Page resizeViewport(@NotNull Page resizedPage,
                                   @NotNull Pair<Integer, Integer> tupleOfWidthAndHeight) {

            //Resizing the Page
            resizedPage.setViewportSize(
                                        tupleOfWidthAndHeight.getValue0(),
                                        tupleOfWidthAndHeight.getValue1()
                                        );

            return resizedPage;
        }
    }

    //endregion

    //region Thread Handler

    public static class ThreadHandler {

        public String getCurrentTestMethodName(@NotNull Class<?> currentClass) {
            String testMethodName = currentClass.getEnclosingMethod().getName();
            return testMethodName;
        }

        private void setThreadName(@NotNull Thread setThread, String threadName) {
            setThread.setName(threadName);
        }

        public Thread getCurrentThread(Thread expThread, String threadNameToSet) {

            //Setting Thread name
            setThreadName(expThread, threadNameToSet);

            return expThread;
        }
    }

    //endregion

    //region Conversion Utilities

    public static class ConversionUtil {
        public static Object convert(Object value, Class<?> parsedType) {

            Boolean isConvertedSuccessfully = false;

            //Parsing into Integer
            if (parsedType == int.class) {

                value = Integer.parseInt(value.toString());
                isConvertedSuccessfully = true;
            }

            //Parsing into String
            if (parsedType == String.class) {

                value = value.toString();
                isConvertedSuccessfully = true;
            }

            //Parsing into Double
            if (parsedType == Double.class) {

                value = Double.parseDouble(value.toString());
                isConvertedSuccessfully = true;
            }

            if (isConvertedSuccessfully) {
                return value.getClass().toGenericString();
            } else {
                throw new IllegalArgumentException("Your desired value was invalid! ");
            }
        }
    }

    //endregion
}