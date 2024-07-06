import java.util.InputMismatchException;
import java.util.Scanner;

public class ContadorJava {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = terminal.nextInt();

        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = terminal.nextInt();

        try {
            validarParametros(parametroUm, parametroDois);
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Entrada inválida. Digite apenas números.");
        } finally {
            terminal.close();
        }
    }

    static void validarParametros(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroDois <= parametroUm) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }
    }

    static void contar(int parametroUm, int parametroDois) {
        for (int i = parametroUm; i <= parametroDois; i++) {
            System.out.println(i);
        }
    }
}

class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}