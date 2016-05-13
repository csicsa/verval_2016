package main.java;

public class LogAnalyzer {
    private WebService webService;

    public boolean isValidLogFileName(String s) {

        if (webService != null && s.length() < 3) {
            webService.logError(s + " too short");
            webService.logError(s + " too short");
        }

        return getFileExtensionManager().isValid(s);

    }

    public void setWebService(WebService webService) {
        this.webService = webService;
    }

    public FileExtensionManager getFileExtensionManager() {
        return FileExtensionManagerFactory.getInstance().getFileExtensionManager();
    }
}
