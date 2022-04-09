import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoDetalhesCsv {

        public static void gravaArquivoCsv(ListaObj<DetalhesAnuncio> lista, String nomeArq) {
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
                    DetalhesAnuncio detalhesAnuncio = lista.getElemento(i);
                    saida.format("%d;%b;%b;%b;%.2f;%.2f;%.2f;%d;%d;%b;%b\n",
                            detalhesAnuncio.getId(),
                            detalhesAnuncio.isAtivoDiaria(), detalhesAnuncio.isAtivoSemanal(),
                            detalhesAnuncio.isAtivoMensal(), detalhesAnuncio.getValorDiaria(),
                            detalhesAnuncio.getValorSemanal(), detalhesAnuncio.getValorMensal(),
                            detalhesAnuncio.getQtdDormitorios(), detalhesAnuncio.getQtdToaletes(),
                            detalhesAnuncio.isGaragem(), detalhesAnuncio.isMobiliada());
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

                System.out.printf("%-6s %10s %10s %10s %14s %16s %18s %20s %15s %15s %15s\n",
                        "ID", "DIARIA", "SEMANAL", "MENSAL", "VALOR DIARIA",
                        "VALOR SEMANAL", "VALOR MENSAL", "DORMITORIOS", "TOALETES", "GARAGEM", "MOBILIADA");

                while (entrada.hasNext()) {
                    Integer id = entrada.nextInt();
                    boolean diaria = entrada.nextBoolean();
                    boolean semanal = entrada.nextBoolean();
                    boolean mensal = entrada.nextBoolean();
                    Double valorDiaria = entrada.nextDouble();
                    Double valorSemanal = entrada.nextDouble();
                    Double valorMensal = entrada.nextDouble();
                    Integer dormitorios = entrada.nextInt();
                    Integer toaletes = entrada.nextInt();
                    boolean garagem = entrada.nextBoolean();
                    boolean mobiliada = entrada.nextBoolean();

                    System.out.printf("%06d %10b %10b %10b %14.2f %16.2f %18.2f %20d %15d %15b %15b\n",
                            id,diaria,semanal,mensal,valorDiaria,valorSemanal, valorMensal,
                            dormitorios, toaletes, garagem, mobiliada);
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
        ListaObj <DetalhesAnuncio> detalhesAnuncio = new ListaObj<>(5);

        DetalhesAnuncio detalhes = new DetalhesAnuncio(
                1, true, false, false,
                250.0, 0.0, 0.0, 2,
                2, false, false
        );

        detalhesAnuncio.adiciona(detalhes);

            gravaArquivoCsv(detalhesAnuncio, "detalhes-anuncio");
            leExibeArquivoCsv("detalhes-anuncio");


        }

    }
