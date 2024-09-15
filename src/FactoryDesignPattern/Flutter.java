package FactoryDesignPattern;

public class Flutter {   // actual method - from this only we separated the abstract factory methods

    SupportedPlatforms supportedPlatforms;

    public Flutter(SupportedPlatforms s) {
        this.supportedPlatforms = s;
    }

    public void setRefreshRate() {
        System.out.println("setting 90Hz...");
    }

    public void setVersion() {
        System.out.println("setting the version as 1.11.1");
    }

    public UIFactory getUIFactory() {
        return UIFactoryFactory.getUIFactory(supportedPlatforms);
    }

}
