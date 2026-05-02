import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String logincorreto = "Admin";
        String senhacorreto = "12345";

        String login, senha;
        boolean acesso = false;

        for (int i = 1; i <=3; i++){
            System.out.println( "Tentativa " + i);

            System.out.println(" login ");
            login = sc.next();

            System.out.println(" senha ");
            senha = sc.next();

            if (login.equalsIgnoreCase(logincorreto)&& senha.equalsIgnoreCase(senhacorreto)){
                System.out.println(" Acesso liberado ");
                acesso = true;
                break;
            }else{
                System.out.println(" Login ou senha incorreta!\n ");
            }}
            if(!acesso){
                System.out.println(" Acesso bloqueado! Número maximo de tentativas atingido");
                return;
            }
            double saldo = 1000.0;
            int opcaoMenu;
            String ultimaOperacao ="";
            double valorOperacao =0;
        do {
            System.out.println("""
                1           Consultar Saldo
                2           Realizar depósito
                3           Realizar saque
                4           Emitir comprovante
                5           Sair
                
                Digita a opção dezejada""");
        opcaoMenu = sc.nextInt();
        switch (opcaoMenu) {
            case 1:
                System.out.printf(" Saldo atual: R$%.2f\n", saldo);
                break;
            case 2:
                System.out.println( " Valor do deposito");
                double deposito = sc.nextDouble();
                if (deposito >0){
                    saldo +=deposito;
                    ultimaOperacao = "Deposito";
                    valorOperacao = deposito;
                    System.out.println( " Deposito realiado ");
                }else {
                    System.out.println(" Valor invalido");
                }
                break;
            case 3:
                System.out.println(" Valor do Saque ?");
                double saque = sc.nextDouble();
                if (saque <= saldo && saque >0){
                    saldo -= saque;
                    ultimaOperacao = " Saque";
                    valorOperacao = saque;
                    System.out.println(" Saque Realizado.");
                }else {
                    System.out.println(" Saldo insuficiente, consulte o saldo.");
                }
                break;
            case 4:
                System.out.println("=======COMPROVANTE=======");
                if (ultimaOperacao.equals("")){
                    System.out.println(" Nenhuma operação realizada.");
                }else {
                    System.out.println("Operação:" + ultimaOperacao);
                    System.out.printf("Valor R$ %.2f\n", valorOperacao);
                    System.out.printf("Saldo Atual R$ %.2f\n", saldo);
                    System.out.println("===== Obrigado por utilizar nossos serviço.=====");
                }
                System.out.println("\nDeseja continuar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Sair");
                int opcao = sc.nextInt();
                if(opcao == 2){
                    opcaoMenu = 5;
                }
                break;
            case 5:
                System.out.println(" Saindo.");
                break;
            default:
                System.out.println(" Opção invalida");
        }
}while (opcaoMenu !=5);
        sc.close();
    }
}
