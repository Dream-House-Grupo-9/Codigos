public class DetalhesAnuncio {

    private Integer id;
    private boolean ativoDiaria;
    private boolean ativoSemanal;
    private boolean ativoMensal;
    private Double valorDiaria;
    private Double valorSemanal;
    private Double valorMensal;
    private Integer qtdDormitorios;
    private Integer qtdToaletes;
    private boolean garagem;
    private boolean mobiliada;

    public DetalhesAnuncio(Integer id, boolean ativoDiaria, boolean ativoSemanal, boolean ativoMensal,
                           Double valorDiaria, Double valorSemanal, Double valorMensal, Integer qtdDormitorios,
                           Integer qtdToaletes, boolean garagem, boolean mobiliada)
    {
        this.id = id;
        this.ativoDiaria = ativoDiaria;
        this.ativoSemanal = ativoSemanal;
        this.ativoMensal = ativoMensal;
        this.valorDiaria = valorDiaria;
        this.valorSemanal = valorSemanal;
        this.valorMensal = valorMensal;
        this.qtdDormitorios = qtdDormitorios;
        this.qtdToaletes = qtdToaletes;
        this.garagem = garagem;
        this.mobiliada = mobiliada;
    }

    @Override
    public String toString() {
        return String.format("%06d %8b %10b %11b %9.2f %13.2f %19.2f %18d %18d %20b %13b\n",
                id, ativoDiaria, ativoSemanal, ativoMensal, valorDiaria, valorSemanal,
                valorMensal, qtdDormitorios, qtdToaletes, garagem, mobiliada);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAtivoDiaria() {
        return ativoDiaria;
    }

    public void setAtivoDiaria(boolean ativoDiaria) {
        this.ativoDiaria = ativoDiaria;
    }

    public boolean isAtivoSemanal() {
        return ativoSemanal;
    }

    public void setAtivoSemanal(boolean ativoSemanal) {
        this.ativoSemanal = ativoSemanal;
    }

    public boolean isAtivoMensal() {
        return ativoMensal;
    }

    public void setAtivoMensal(boolean ativoMensal) {
        this.ativoMensal = ativoMensal;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Double getValorSemanal() {
        return valorSemanal;
    }

    public void setValorSemanal(Double valorSemanal) {
        this.valorSemanal = valorSemanal;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Integer getQtdDormitorios() {
        return qtdDormitorios;
    }

    public void setQtdDormitorios(Integer qtdDormitorios) {
        this.qtdDormitorios = qtdDormitorios;
    }

    public Integer getQtdToaletes() {
        return qtdToaletes;
    }

    public void setQtdToaletes(Integer qtdToaletes) {
        this.qtdToaletes = qtdToaletes;
    }

    public boolean isGaragem() {
        return garagem;
    }

    public void setGaragem(boolean garagem) {
        this.garagem = garagem;
    }

    public boolean isMobiliada() {
        return mobiliada;
    }

    public void setMobiliada(boolean mobiliada) {
        this.mobiliada = mobiliada;
    }
}
