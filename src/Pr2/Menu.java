package Pr2;

import java.util.Stack;

public class Menu {
    private Stack<Command> commandStack = new Stack<>();

    public void addCommand(Command command) {
        commandStack.push(command); // Добавить команду в стек
    }

    public void executeCommand(Command command) {
        command.execute(); // Выполнить команду
        commandStack.push(command); // Добавить команду в историю
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            Command lastCommand = commandStack.pop(); // Получить последнюю выполненную команду
            lastCommand.undo(); // Отменить последнюю выполненную команду
        } else {
            System.out.println("No commands to undo."); // Если стек пуст, вывести сообщение об отсутствии команд для отмены
        }
    }

    public void executeMacroCommand(Command... commands) {
        for (Command command : commands) {
            command.execute(); // Выполнить все команды из макрокоманды
            commandStack.push(command); // Добавить каждую команду в историю
        }
    }
}