// Interface que representa o serviço de pagamento em dólares
interface DollarPaymentService {
    void processPayment(double amount);
}

// Implementação concreta do serviço de pagamento em dólares
class PayPalService implements DollarPaymentService {
    public void processPayment(double amount) {
        System.out.println("Processing dollar payment of $" + amount);
    }
}

// Interface que representa o serviço de pagamento em euros
interface EuroPaymentService {
    void processPaymentInEuros(double amount);
}

// Adaptador que permite que o serviço de pagamento em dólares funcione com euros
class EuroPaymentServiceAdapter implements EuroPaymentService {
    private DollarPaymentService dollarPaymentService;

    public EuroPaymentServiceAdapter(DollarPaymentService dollarPaymentService) {
        this.dollarPaymentService = dollarPaymentService;
    }

    public void processPaymentInEuros(double amount) {
        // Convertendo euros para dólares usando uma taxa de conversão fictícia
        double amountInDollars = amount * 1.2;
        dollarPaymentService.processPayment(amountInDollars);
    }
}

// Exemplo de uso
public class AdapterExample {
    public static void main(String[] args) {
        // Usando o serviço de pagamento em dólares diretamente
        DollarPaymentService dollarService = new PayPalService();
        dollarService.processPayment(100.0);

        // Adaptando o serviço de pagamento em dólares para lidar com euros
        EuroPaymentService euroService = new EuroPaymentServiceAdapter(dollarService);
        euroService.processPaymentInEuros(100.0);
    }
}