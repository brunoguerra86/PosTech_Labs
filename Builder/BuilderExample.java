// Classe do produto
class Sandwich {
    private String bread;
    private String meat;
    private String cheese;
    private String veggies;
    private String condiments;

    // Métodos para definir as partes do sanduíche
    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setVeggies(String veggies) {
        this.veggies = veggies;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    // Métodos para mostrar o sanduíche
    public void display() {
        System.out.println("Sandwich with " + bread + ", " + meat + ", " + cheese + ", " + veggies + ", " + condiments);
    }
}

// Classe Builder
class SandwichBuilder {
    private Sandwich sandwich = new Sandwich();

    public SandwichBuilder withBread(String bread) {
        sandwich.setBread(bread);
        return this;
    }

    public SandwichBuilder withMeat(String meat) {
        sandwich.setMeat(meat);
        return this;
    }

    public SandwichBuilder withCheese(String cheese) {
        sandwich.setCheese(cheese);
        return this;
    }

    public SandwichBuilder withVeggies(String veggies) {
        sandwich.setVeggies(veggies);
        return this;
    }

    public SandwichBuilder withCondiments(String condiments) {
        sandwich.setCondiments(condiments);
        return this;
    }

    public Sandwich build() {
        return sandwich;
    }
}

// Exemplo de uso
public class BuilderExample {
    public static void main(String[] args) {
        Sandwich sandwich = new SandwichBuilder()
                .withBread("Wheat")
                .withMeat("Turkey")
                .withCheese("Swiss")
                .withVeggies("Lettuce, Tomato")
                .withCondiments("Mayo, Mustard")
                .build();

        sandwich.display();
    }
}