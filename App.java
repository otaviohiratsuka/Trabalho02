import java.util.Scanner;

public class App {
    public static void main(String[] args){
        int opc = 0;
        Scanner entrada = new Scanner(System.in);
        Aeroporto Aeroporto = new Aeroporto();

        int intervaloAutomaticoSegundos = 60;
        String conteudoDoArquivo = "Aviao.txt";

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
            }
            
            if (opc != 4) {  //a cada min, programa indica o que aconteceu.
                aeroporto.calcularTempoMedioEsperaAterrissagem();
                System.out.println("Número de Aterrissagens de Emergência: " + aeroporto.getAterrissagensEmergenciais());
                try {
                    Thread.sleep(intervaloAutomaticoSegundos * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Ocorreu um minuto.");

        } while (opc != 4);
            entrada.close();
        }
    }

    public static void entradaArquivo(Aeroporto aeroporto) {
        try {
            Scanner arquivoScanner = new Scanner(new File("Aviao.txt"));

            while (arquivoScanner.hasNextLine()) {
                String linha = arquivoScanner.nextLine();

                if (linha.startsWith("#") || linha.trim().isEmpty()) {
                    continue;
                }

                processarLinhaArquivo(linha, aeroporto);
            }

            arquivoScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'aviao.txt' não encontrado.");
        }
    }

    private static void processarLinhaArquivo(String linha, Aeroporto aeroporto) {
        String[] partes = linha.split(",");
        
        if (partes.length >= 5) {
            String id = partes[0].trim();
            int combustivel = Integer.parseInt(partes[1].trim());
            String companhia = partes[2].trim();
            int passageiro = Integer.parseInt(partes[3].trim());
            boolean preferencia = Boolean.parseBoolean(partes[4].trim());

            Aviao av = new Aviao(id, passageiro, combustivel, companhia, preferencia);

            if (preferencia) {
                aeroporto.adicionarAterrisagem(aviao);
            } else {
                aeroporto.adicionarDecolagem(aviao);
            }
        }
    }

}
