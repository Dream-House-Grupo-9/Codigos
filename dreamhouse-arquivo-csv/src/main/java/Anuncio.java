import java.util.Date;

public class Anuncio {

    private Integer id;
    private String dtPublicacao;
    private String descricao;
    private String inicioDisponibilidade;
    private String fimDisponibilidade;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String notaAnuncio;

    public Anuncio(Integer id, String dtPublicacao, String descricao, String inicioDisponibilidade,
                   String fimDisponibilidade, String cidade, String bairro, String logradouro,
                   String numero, String notaAnuncio)
    {
        this.id = id;
        this.dtPublicacao = dtPublicacao;
        this.descricao = descricao;
        this.inicioDisponibilidade = inicioDisponibilidade;
        this.fimDisponibilidade = fimDisponibilidade;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.notaAnuncio = notaAnuncio;
    }

    @Override
    public String toString() {

        return String.format("%06d %-12s %-20s %7s %12s %15s %22s %25s %11s %13s\n",
                id, dtPublicacao, descricao, inicioDisponibilidade, fimDisponibilidade,
                cidade, bairro, logradouro, numero, notaAnuncio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(String dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public void setInicioDisponibilidade(String inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public String getFimDisponibilidade() {
        return fimDisponibilidade;
    }

    public void setFimDisponibilidade(String fimDisponibilidade) {
        this.fimDisponibilidade = fimDisponibilidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNotaAnuncio() {
        return notaAnuncio;
    }

    public void setNotaAnuncio(String notaAnuncio) {
        this.notaAnuncio = notaAnuncio;
    }
}
