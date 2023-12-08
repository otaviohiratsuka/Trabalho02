import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitura_arquivo{

 public static String lerArquivo(String caminhoArquivo) {
        StringBuilder conteudo = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
                if("##".equals(linha)){
                 break;
                }
                    if("#".equalsIgnoreCase(linha)){
                        
                    }
                else{
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conteudo.toString();
    }
}
