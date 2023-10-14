// Subsistema 1
class CPU {
    void freeze() {
        System.out.println("CPU freezing...");
    }

    void execute() {
        System.out.println("CPU executing...");
    }
}

// Subsistema 2
class Memory {
    void load() {
        System.out.println("Memory loading...");
    }
}

// Subsistema 3
class HardDrive {
    void read() {
        System.out.println("Hard Drive reading...");
    }
}

// Fachada que simplifica a interação com os subsistemas
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        cpu.freeze();
        memory.load();
        hardDrive.read();
        cpu.execute();
        System.out.println("Computer started.");
    }
}

// Exemplo de uso
public class FacadeExample {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}