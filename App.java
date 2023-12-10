import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;


public class App {
public static boolean interacao = false;

    public static void processarLinhaArquivo(String id, String companhia, String numero_passageiro, String prioridade, String combustivel, Aeroporto aeroporto) {
        int numero_pass, combusti;
        boolean prio;

        try {
            numero_pass = Integer.parseInt(numero_passageiro);
        } catch (NumberFormatException ex) {
            System.out.println("O passageiro foi informado incorretamento do ID: "+id);
            System.out.println("Aviao não salvo.");
            return;
        }

        try {
            combusti = Integer.parseInt(combustivel);
        } catch (NumberFormatException ex) {
            System.out.println("O combustivel foi informado incorretamento do ID: "+id);
            System.out.println("Aviao não salvo.");
            return;
        }

        if(prioridade.toLowerCase().equals("sim")){
            prio = true;
        }
        else if(prioridade.toLowerCase().equals("nao")){
            prio = false;
        }
        else{
            System.out.println("A prioridade foi informado incorretamento do ID: "+id);
            System.out.println("Aviao não salvo.");
            return;
        }
         Aviao aviao =new Aviao(id+"-"+combustivel,numero_pass,combusti,companhia,prio);

        if( (Integer.parseInt(id)) %2 == 0){
           aeroporto.adicionarDecolagem(aviao);
        }
        else{
            aeroporto.adicionarAterrisagem(aviao);
        }


    }

    public static void entradaArquivo(Aeroporto aeroporto) {
        try (Scanner arquivoScanner = new Scanner(new File("Aviao.txt"))) {
            int controlador = 0;
            String id = "", companhia = "", numero_passageiro = "", prioridade = "", combustivel = "";
    
            while (arquivoScanner.hasNextLine()) {
                String linha = arquivoScanner.nextLine();
    
                if (linha.startsWith("##") || linha.trim().isEmpty()) {
                    processarLinhaArquivo(id, companhia, numero_passageiro, prioridade, combustivel, aeroporto);
                    break;
                
                } else if (linha.startsWith("#")) {
                    processarLinhaArquivo(id, companhia, numero_passageiro, prioridade, combustivel, aeroporto);

                    controlador = 0;
                } else {
                    switch (controlador) {
                        case 0:
                            id = linha;
                            break;
                        case 1:
                            companhia = linha;
                            break;
                        case 2:
                            numero_passageiro = linha;
                            break;
                        case 3:
                            prioridade = linha;
                            break;
                        case 4:
                            combustivel = linha;
                            break;
                        default:
                            break;
                    }
    
                    controlador++;
                }
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter("Aviao.txt", false))) {
                writer.print("");
            }
    
        } catch (IOException ex) {
            System.out.println("Arquivo 'aviao.txt' não encontrado.");
        }
    }
    
    public static void menu_sem_desastre(Aeroporto aeroporto){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        System.out.println("+======Menu=====+");
        System.out.println("1- Atualizar o Sistema");
        System.out.println("2- Ocorrencia de Desastre");
        System.out.println("3- Sair");
        System.out.println("-------------");

        while(true){
            try{
                System.out.println("Escolha uma opção: ");
                opcao = entrada.nextInt();
                break;
            }catch(InputMismatchException ex){
                entrada.nextLine();
            }
        }

        System.out.println("-------------");
        switch (opcao) {
            case 1:
            {
                entradaArquivo(aeroporto);

                aeroporto.rodarTempoTotal();
                
                aeroporto.atualizarAeroportoNormal();
        
                break;
            }
            case 2:
            {
                interacao = true;
                break;
            }
            case 3:
            {
                System.exit(0);
                break;
            }
            default:
                System.out.println("OPCAO INVALIDA...");
                break;

        }

}

    public static void menu_com_desastre(Aeroporto aeroporto){
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        System.out.println("+======Menu=====+");
        System.out.println("1- Atualizar o Sistema");
        System.out.println("2- Sair do Desastre");
        System.out.println("3- Sair");
        System.out.println("-------------");

        while(true){
            try{
                System.out.println("Escolha uma opção: ");
                opcao = entrada.nextInt();
                break;
            }catch(InputMismatchException ex){
                entrada.nextLine();
            }
        }

        System.out.println("-------------");
        switch (opcao) {
            case 1:
            {
                entradaArquivo(aeroporto);
                aeroporto.rodarTempoTotal();
                aeroporto.atualizarAeroportoEspecial();
                break;
            }
            case 2:
            {
                interacao = false;
                break;
            }
            case 3:
            {
                System.exit(0);
                break;
            }
            default:
                System.out.println("OPCAO INVALIDA...");
                break;
        }

}


    public static void main(String[] args){
        Aeroporto aeroporto = new Aeroporto();

        entradaArquivo(aeroporto);
        
        while(true){
            if(interacao == true){
                menu_com_desastre(aeroporto);
            }
            else{
                menu_sem_desastre(aeroporto);
            }
        }

    }
}




