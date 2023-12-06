import 

public class App {
    public static void main(String[] args){
        int opc = 0;
        Scanner entrada = new Scanner(System.in);
        Aeroporto Aeroporto = new Aeroporto();

        String conteudoDoArquivo = lerArquivo(caminhoDoArquivo);

        do{
            System.out.println("Menu");
            System.out.println("Escolha uma opção: ");
            System.out.println("1- Atualize o sistema");
            System.out.println("2- Informe um desastre");
            System.out.println("3- sair");

            opc = entrada.nextInt();
            entrada.nextLine();

            switch(opc){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("saindo...");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA...");
                    break;
            } while(opc!=4);
            entrada.close();
        }
    }
}
