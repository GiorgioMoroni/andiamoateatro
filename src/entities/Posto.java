package entities;

public class Posto {

    private Integer id;
    private Integer fila;
    private Integer numero;
    private Integer idSala;

    public Posto(){}

    public Posto(Integer id, Integer fila, Integer numero, Integer idSala) {
        this.id = id;
        this.fila = fila;
        this.numero = numero;
        this.idSala = idSala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFila() {
        return fila;
    }

    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    @Override
    public String toString() {
        return "Posto{" +
                "id=" + id +
                ", fila='" + fila + '\'' +
                ", numero=" + numero +
                ", idSala=" + idSala +
                '}';
    }
}
