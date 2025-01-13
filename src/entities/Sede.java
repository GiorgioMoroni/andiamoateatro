package entities;

public class Sede {

    private Integer id;
    private String nome;
    private String indirizzo;
    private String comune;
    private Boolean tipoLuogo;

    public Sede (){}

    public Sede(Integer id, String nome, String indirizzo, String comune, Boolean tipoLuogo) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.comune = comune;
        this.tipoLuogo = tipoLuogo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public Boolean getTipoLuogo() {
        return tipoLuogo;
    }

    public void setTipoLuogo(Boolean tipoLuogo) {
        this.tipoLuogo = tipoLuogo;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", comune='" + comune + '\'' +
                ", tipoLuogo=" + tipoLuogo +
                '}';
    }
}
