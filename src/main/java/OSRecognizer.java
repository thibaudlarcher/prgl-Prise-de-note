public final class OSRecognizer {

    private static String OS = null;

    private static String getOsName()
    {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }
    public static boolean isWindows()
    {
        return getOsName().startsWith("Windows");
    }

    public static boolean isMac(){
        return getOsName().startsWith("mac") || getOsName().startsWith("Mac");
    }
}
