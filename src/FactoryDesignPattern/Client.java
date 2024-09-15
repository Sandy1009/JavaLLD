package FactoryDesignPattern;

import FactoryDesignPattern.button.Button;
import FactoryDesignPattern.dropdown.Dropdown;
import FactoryDesignPattern.menu.Menu;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter(SupportedPlatforms.ANDRIOD);

        UIFactory uiFactory = flutter.getUIFactory();    //returns AndriodUIFactory object

        Button button = uiFactory.createButton();  //returns AndriodButton object
        Menu menu = uiFactory.createMenu();   //returns AndriodMenu object
        Dropdown dropdown = uiFactory.createDropdown();   //returns AndriodDropdown object

    }

}
