package main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions;

import main.java.com.savytskyy.Lesson4.Phonebook.menu.menuactions.MenuAction;

public class QuitMenuAction implements MenuAction {
    @Override
    public void doAction() {
        System.out.println("Good Bye!");
        System.out.println("Thank you for using our service!");
    }

    @Override
    public String getName() {
        return "Quit menu";
    }

    @Override
    public boolean closeAfter() {
        return true;
    }
}
