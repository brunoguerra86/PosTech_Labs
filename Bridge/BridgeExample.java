// Implementação da forma (abstração)
interface Shape {
    void draw();
}

// Implementações concretas de formas
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Implementação da cor (implementação)
interface Color {
    void applyColor();
}

// Implementações concretas de cores
class Red implements Color {
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class Blue implements Color {
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

// Abstração refinada que usa o padrão Bridge
abstract class ShapeWithColor implements Shape {
    protected Color color;

    public ShapeWithColor(Color color) {
        this.color = color;
    }

    abstract void drawWithColor();
}

// Implementação refinada da forma com uma cor específica
class ColoredCircle extends ShapeWithColor {
    public ColoredCircle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Drawing a colored circle");
    }

    public void drawWithColor() {
        draw();
        color.applyColor();
    }
}

// Implementação refinada da forma com uma cor específica
class ColoredSquare extends ShapeWithColor {
    public ColoredSquare(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Drawing a colored square");
    }

    public void drawWithColor() {
        draw();
        color.applyColor();
    }
}

// Exemplo de uso
public class BridgeExample {
    public static void main(String[] args) {
        ShapeWithColor redCircle = new ColoredCircle(new Red());
        ShapeWithColor blueSquare = new ColoredSquare(new Blue());

        redCircle.drawWithColor();
        blueSquare.drawWithColor();
    }
}