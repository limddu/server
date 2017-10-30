package controller;

import controller.action.Action;
import controller.action.LoginAction;

public class ActionFactory {
    private ActionFactory() {

    }

    private static ActionFactory instance = new ActionFactory();
    public static ActionFactory getInstance() {
        return instance;
    }

    public Action getAction(String command) {
        Action action = null;
        System.out.println("ActionFactory: "+command);
        if(command.equals("login")) {
            action = new LoginAction();
        }
        return action;
    }
}
