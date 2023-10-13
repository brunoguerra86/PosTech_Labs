// Classe base para manipuladores
abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int amount);
}

// Implementações concretas dos manipuladores
class ManagerHandler extends Handler {
    public void handleRequest(int amount) {
        if (amount <= 1000) {
            System.out.println("Manager can approve $" + amount);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        } else {
            System.out.println("No one can approve $" + amount);
        }
    }
}

class DirectorHandler extends Handler {
    public void handleRequest(int amount) {
        if (amount <= 5000) {
            System.out.println("Director can approve $" + amount);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        } else {
            System.out.println("No one can approve $" + amount);
        }
    }
}

class CFOHandler extends Handler {
    public void handleRequest(int amount) {
        if (amount <= 10000) {
            System.out.println("CFO can approve $" + amount);
        } else {
            System.out.println("No one can approve $" + amount);
        }
    }
}

// Exemplo de uso
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Handler manager = new ManagerHandler();
        Handler director = new DirectorHandler();
        Handler cfo = new CFOHandler();

        manager.setNextHandler(director);
        director.setNextHandler(cfo);

        manager.handleRequest(1500);
        manager.handleRequest(7000);
        manager.handleRequest(12000);
    }
}