package main.java;

public class FileExtensionManagerFactory {

    private static FileExtensionManagerFactory INSTANCE;
    private FileExtensionManager fileExtensionManager;

    private FileExtensionManagerFactory() {

    }

    public static FileExtensionManagerFactory getInstance() {
        if(INSTANCE == null)
            INSTANCE= new FileExtensionManagerFactory();
        return INSTANCE;
    }

    public FileExtensionManager getFileExtensionManager() {
        return fileExtensionManager != null ? fileExtensionManager : new FakeFileExtensionManager();
    }

    public void setFileExtensionManager(FileExtensionManager fileExtensionManager) {
        this.fileExtensionManager = fileExtensionManager;
    }
}
