import entidades.*;
import entidades.Veiculo.Categoria;
import service.*;
import Exceções.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== RideShareApp - Demonstração Completa ===\n");

        try {
            // Passageiros sendo adicionados//
            UsuarioService<Passageiro> cadastroPassageiros = new UsuarioService<>();

            Passageiro passageiro1 = new Passageiro("Fabiana", "12345678900",
                    "fabiana@email.com", "11999999999", "1234", "Cartão");

            Passageiro passageiro2 = new Passageiro("Lucas", "98765432100",
                    "lucas@email.com", "11988888888", "4321", "PIX");

            cadastroPassageiros.adicionar(passageiro1);
            cadastroPassageiros.adicionar(passageiro2);

            System.out.println("Passageiros cadastrados: Fabiana e Lucas\n");

            // Motoristas sendo adicionados//
            UsuarioService<Motorista> cadastroMotoristas = new UsuarioService<>();

            Veiculo carro1 = new Veiculo("ABC1234", "Onix", "Prata", 2020, Categoria.COMUM);
            Veiculo carro2 = new Veiculo("XYZ5678", "Civic", "Preto", 2022, Categoria.LUXO);

            CNH cnh1 = new CNH(2005, 2035, "Carro", "547587480");
            CNH cnh2 = new CNH(2005, 2035, "Carro", "635643989");

            Motorista motorista1 = new Motorista("Carlos", "11122233344",
                    "carlos@email.com", "11977777777",
                    "senha", cnh1, carro1);

            Motorista motorista2 = new Motorista("Ana", "55566677788",
                    "ana@email.com", "11966666666",
                    "senha2", cnh2, carro2);

            cadastroMotoristas.adicionar(motorista1);
            cadastroMotoristas.adicionar(motorista2);

            System.out.println("Motoristas cadastrados: Carlos e Ana\n");

            // Chamando corridas//
            passageiro1.solicitarCorrida("Rua A, 123", "Avenida B, 456", cadastroMotoristas.mostrarUsuarios());
            passageiro2.solicitarCorrida("Rua C, 789", "Avenida D, 101", cadastroMotoristas.mostrarUsuarios());

            Corrida corrida1 = passageiro1.getCorridaAtual();
            Corrida corrida2 = passageiro2.getCorridaAtual();

            System.out.println("Corridas solicitadas\n");

            // Designando Motorista //
            corrida1.atribuirMotorista(motorista1);
            System.out.println("Motorista Carlos atribuído à corrida de Fabiana");

            corrida2.atribuirMotorista(motorista2);
            System.out.println("Motorista Ana atribuído à corrida de Lucas\n");

            corrida1.iniciarCorrida();
            corrida2.iniciarCorrida();

            System.out.println("Corridas iniciadas\n");

            // Formas de Pagamentos
            PagamentoService pagamento1 = new PagamentoCartao("1111222233334444", "1234");
            pagamento1.processarPagamento(corrida1.getPreco());
            System.out.println("Pagamento da corrida de Fabiana via Cartão concluído\n");

            PagamentoService pagamento2 = new PagamentoPix("lucaspix@email.com");
            pagamento2.processarPagamento(corrida2.getPreco());
            System.out.println("Pagamento da corrida de Lucas via PIX \n");

            // --- Finalização das corridas ---
            motorista1.finalizarCorrida();
            motorista2.finalizarCorrida();

            System.out.println("\nCorridas finalizadas\n");

            // --- Resumo ---
            System.out.println("Resumo das Corridas");
            System.out.println("Corrida 1: Passageiro: " + corrida1.getPassageiro().getNome()
                    + ", Motorista: " + corrida1.getMotorista().getNome()
                    + ", Preço: R$" + corrida1.getPreco());

            System.out.println("Corrida 2: Passageiro: " + corrida2.getPassageiro().getNome()
                    + ", Motorista: " + corrida2.getMotorista().getNome()
                    + ", Preço: R$" + corrida2.getPreco());

        } catch (EstadoInvalidoDaCorridaException |
                 PagamentoRecusadoException | NenhumMotoristaException | SaldoInsuficienteException e) {

            System.out.println("Erro: " + e.getMessage());
        }
    }
}
