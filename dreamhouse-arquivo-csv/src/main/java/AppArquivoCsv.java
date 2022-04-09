import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCsv {

    public static void gravaArquivoCsv(ListaObj<Anuncio> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Anuncio anuncio = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", anuncio.getId(),anuncio.getDtPublicacao(),
                        anuncio.getDescricao(), anuncio.getInicioDisponibilidade(), anuncio.getFimDisponibilidade(),
                        anuncio.getCidade(), anuncio.getBairro(), anuncio.getLogradouro(),
                        anuncio.getNumero(), anuncio.getNotaAnuncio());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;

        Boolean deuRuim = false;
        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada= new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado!");
            System.exit(1);
        }

        try {

            System.out.printf("%-6s %-20s %10s %18s %18s %14s %18s %23s %10s %8s\n",
                    "ID", "DESCRIÇÃO", "PUBLICAÇÃO", "INICIO ALUGUEL", "FIM ALUGUEL",
                    "CIDADE", "BAIRRO", "LOGRADOURO", "NUMERO", "NOTA");

            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String dtPublicacao = entrada.next();
                String descricao = entrada.next();
                String dtInicio = entrada.next();
                String dtFim = entrada.next();
                String cidade = entrada.next();
                String bairro = entrada.next();
                String logradouro = entrada.next();
                String numero = entrada.next();
                String nota = entrada.next();

                System.out.printf("%06d %-20s %7s %18s %18s %14s %18s %23s %10s %8s\n",
                        id,descricao,dtPublicacao,dtInicio,dtFim,cidade, bairro, logradouro, numero, nota);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }

    }

    public static void main(String[] args) {
        ListaObj <Anuncio> anuncio = new ListaObj<>(5);

        Anuncio casa = new Anuncio(1, "03/04/2022", "Casa boa", "04/04/2022",
                "11/04/2022", "São Paulo", "Vila Mariana", "Rua Afonso Celso",
                "235", "*****");


        anuncio.adiciona(casa);

        gravaArquivoCsv(anuncio, "anuncio");
        leExibeArquivoCsv("anuncio");



    }
}
