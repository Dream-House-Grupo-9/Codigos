import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCsv {

    public static void gravaArquivoCsv(ListaObj<Cachorro> lista, String nomeArq){
        FileWriter arq = null; // obj que representa o arquivo a ser gravado
        Formatter saida = null; // obg que usamos para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // bloco try Catch para abrir o arquivo
        try{
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // bloco try Catch para gravar o arquivo

        try{
            for(int i = 0 ; i < lista.getTamanho(); i++){
                Cachorro dog = lista.getElemento(i);
                // grava um registro com as informações do objeto dono
                saida.format("%d;%s;%s;%.2f\n", dog.getId(), dog.getNome(), dog.getPorte(), dog.getPeso());


            }
        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();

            try{
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }

        }
    }

    public static void leExibeArquivoCsv(String nomeArq){
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArq += ".csv";

        try{
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\n");
        }
        catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%4s %-15s %-9s %4s\n","ID","NOME","PORTE","PESO");

            while (entrada.hasNext()){
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                System.out.printf("%4d %-15s %-9s %04.2f\n", id,nome,porte,peso);
            }
        }
        catch (NoSuchElementException erro){
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro){
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();

            try{
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }

        }

    }

    public static void main(String[] args) {

        ListaObj<Cachorro> listaDog = new ListaObj<>(7);

        listaDog.adiciona(new Cachorro(1, "Agata", "Grande", 50.0));
        listaDog.adiciona(new Cachorro(2, "Lara", "Medio", 12.0));
        listaDog.adiciona(new Cachorro(3, "Princesa", "Medio", 20.0));
        listaDog.adiciona(new Cachorro(4, "Binao", "Medio", 12.0));
        listaDog.adiciona(new Cachorro(5, "Junin", "Pequeno", 8.0));

        listaDog.exibe();
        gravaArquivoCsv(listaDog, "dogs");
    }
}
