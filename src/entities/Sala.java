package entities;

public class Sala {

    private Integer id;
    private String nome;
    private Integer numeroPosti;
    private Integer idSede;

    public Sala(){}

    public Sala(Integer id, String nome, Integer numeroPosti, Integer idSede) {
        this.id = id;
        this.nome = nome;
        this.numeroPosti = numeroPosti;
        this.idSede = idSede;
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

    public Integer getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(Integer numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroPosti=" + numeroPosti +
                ", idSede=" + idSede +
                '}';
    }
}
