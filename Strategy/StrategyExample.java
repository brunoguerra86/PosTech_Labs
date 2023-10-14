// Suponha que você tenha um personagem chamado Knight:
public class Knight {
    private AttackStrategy attackStrategy;

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void performAttack() {
        attackStrategy.attack();
    }
}

// E diferentes estratégias de ataque:
public interface AttackStrategy {
    void attack();
}

public class SwordAttack implements AttackStrategy {
    public void attack() {
        System.out.println("Sword attack!");
    }
}

public class BowAttack implements AttackStrategy {
    public void attack() {
        System.out.println("Bow attack!");
    }
}

// Ao criar um Knight, você pode definir sua estratégia de ataque conforme necessário:
Knight knight = new Knight();
knight.setAttackStrategy(new SwordAttack()); // ou knight.setAttackStrategy(new BowAttack());
knight.performAttack(); // Chama o ataque selecionado.