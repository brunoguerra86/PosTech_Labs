import java.util.ArrayList;
import java.util.List;

// Interface que define o Observador
interface Observer {
    void update(String message);
}

// Classe que representa o Sujeito (ou Observável)
class Blog {
    private List<Observer> observers = new ArrayList<>();
    private String latestArticle;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void publishArticle(String article) {
        latestArticle = article;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestArticle);
        }
    }
}

// Implementação concreta do Observador
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received an update: " + message);
    }
}

// Exemplo de uso
public class ObserverExample {
    public static void main(String[] args) {
        Blog blog = new Blog();

        Observer subscriber1 = new Subscriber("Alice");
        Observer subscriber2 = new Subscriber("Bob");

        blog.addObserver(subscriber1);
        blog.addObserver(subscriber2);

        blog.publishArticle("New article: Design Patterns");
    }
}