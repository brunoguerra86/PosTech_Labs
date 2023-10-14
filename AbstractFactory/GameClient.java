// Interfaces para os produtos de um jogo
interface Graphics {
    void render();
}

interface Sound {
    void play();
}

interface Controls {
    void handleInput();
}

// Fábrica abstrata para criar os produtos
interface GameFactory {
    Graphics createGraphics();
    Sound createSound();
    Controls createControls();
}

// Implementações concretas dos produtos para PC
class PCGraphics implements Graphics {
    public void render() {
        System.out.println("Rendering graphics for PC.");
    }
}

class PCSound implements Sound {
    public void play() {
        System.out.println("Playing sound for PC.");
    }
}

class PCControls implements Controls {
    public void handleInput() {
        System.out.println("Handling input for PC.");
    }
}

// Implementações concretas dos produtos para console
class ConsoleGraphics implements Graphics {
    public void render() {
        System.out.println("Rendering graphics for console.");
    }
}

class ConsoleSound implements Sound {
    public void play() {
        System.out.println("Playing sound for console.");
    }
}

class ConsoleControls implements Controls {
    public void handleInput() {
        System.out.println("Handling input for console.");
    }
}

// Implementações concretas da fábrica para PC
class PCGameFactory implements GameFactory {
    public Graphics createGraphics() {
        return new PCGraphics();
    }

    public Sound createSound() {
        return new PCSound();
    }

    public Controls createControls() {
        return new PCControls();
    }
}

// Implementações concretas da fábrica para console
class ConsoleGameFactory implements GameFactory {
    public Graphics createGraphics() {
        return new ConsoleGraphics();
    }

    public Sound createSound() {
        return new ConsoleSound();
    }

    public Controls createControls() {
        return new ConsoleControls();
    }
}

// Cliente que utiliza as fábricas e produtos
public class GameClient {
    public static void main(String[] args) {
        GameFactory pcFactory = new PCGameFactory();
        Graphics pcGraphics = pcFactory.createGraphics();
        Sound pcSound = pcFactory.createSound();
        Controls pcControls = pcFactory.createControls();

        pcGraphics.render();
        pcSound.play();
        pcControls.handleInput();

        GameFactory consoleFactory = new ConsoleGameFactory();
        Graphics consoleGraphics = consoleFactory.createGraphics();
        Sound consoleSound = consoleFactory.createSound();
        Controls consoleControls = consoleFactory.createControls();

        consoleGraphics.render();
        consoleSound.play();
        consoleControls.handleInput();
    }
}