package se.utility;

import org.jetbrains.annotations.NotNull;

public class PLUtil {           //PL means Java Programming Language
    public static class ThreadHandler {

        public String getCurrentTestMethodName(@NotNull Class<?> currentClass) {
//            String testMethodName = currentClass.getEnclosingMethod().getName();
            String testMethodName = currentClass.getEnclosingMethod().getName();
//            new Object(){}.getClass()
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
}