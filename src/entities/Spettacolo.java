package entities;

import java.sql.Time;
import java.time.LocalDateTime;

public class Spettacolo {

    private Integer id;
    private LocalDateTime orario;
    private String genere;
    private Double prezzo;
    private Integer durata;
    private Integer idSede;

    public Spettacolo(){}


    public Spettacolo(Integer id, LocalDateTime orario, String genere, Double prezzo, Integer durata, Integer idSede) {
        this.id = id;
        this.orario = orario;
        this.genere = genere;
        this.prezzo = prezzo;
        this.durata = durata;
        this.idSede = idSede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOrario() {
        return orario;
    }

    public void setOrario(LocalDateTime orario) {
        this.orario = orario;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Integer getIdSede() {
        return idSede;
    }

    public void setIdSede(Integer idSede) {
        this.idSede = idSede;
    }

    @Override
    public String toString() {
        return "Spettacolo{" +
                "id=" + id +
                ", orario=" + orario +
                ", genere='" + genere + '\'' +
                ", prezzo=" + prezzo +
                ", durata=" + durata +
                ", idSede=" + idSede +
                '}';
    }
}
