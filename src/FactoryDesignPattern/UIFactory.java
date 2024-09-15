package FactoryDesignPattern;

import FactoryDesignPattern.button.Button;
import FactoryDesignPattern.dropdown.Dropdown;
import FactoryDesignPattern.menu.Menu;

public interface UIFactory {     //abstract factory - collection of factory methods

    Button createButton();
    Menu createMenu();
    Dropdown createDropdown();

}
