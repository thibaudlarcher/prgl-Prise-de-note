public class OSRecognizer {
    /**
     * Permet de charger l'Os sous lequel on tourne l'application
     */
    private static String OS = null;

    private static String getOsName()
    {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }

    /**
     * Check si c'est Windows
     * @return true si c'est Windows
     */
    public static boolean isWindows()
    {
        return getOsName().startsWith("Windows");
    }
    /**
     * Check si c'est Max OS
     * @return true si c'est Mac OS
     */
    public static boolean isMac(){
        return getOsName().startsWith("mac") || getOsName().startsWith("Mac");
    }
}
