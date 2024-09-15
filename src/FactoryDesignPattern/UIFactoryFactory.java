package FactoryDesignPattern;

public class UIFactoryFactory {

    public static UIFactory getUIFactory(SupportedPlatforms supportedPlatforms) {    //separated out so that when new platform is added, we need not test all the classes where getUIFactory() method is used
        return switch (supportedPlatforms) {
            case ANDRIOD -> new AndroidUIFactory();
            case IoS -> new IoSUIFactory();
        };
    }

}
