package FactoryDesignPattern;

import FactoryDesignPattern.button.Button;
import FactoryDesignPattern.button.IoSButton;
import FactoryDesignPattern.dropdown.Dropdown;
import FactoryDesignPattern.dropdown.IoSDropdown;
import FactoryDesignPattern.menu.IoSMenu;
import FactoryDesignPattern.menu.Menu;

public class IoSUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new IoSButton();
    }

    @Override
    public Menu createMenu() {
        return new IoSMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new IoSDropdown();
    }

}
