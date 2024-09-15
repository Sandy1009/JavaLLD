package FactoryDesignPattern;

import FactoryDesignPattern.button.AndroidButton;
import FactoryDesignPattern.button.Button;
import FactoryDesignPattern.dropdown.AndroidDropdown;
import FactoryDesignPattern.dropdown.Dropdown;
import FactoryDesignPattern.menu.AndroidMenu;
import FactoryDesignPattern.menu.Menu;

public class AndroidUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }

}
