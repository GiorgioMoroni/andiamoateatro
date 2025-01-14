package entities;

import java.time.LocalDateTime;

public class Prenotazione {
    private Integer id;
    private LocalDateTime dataPrenotazione;
    private Double prezzoTotale;
    private Integer idUtente;
    private Integer idSpettacolo;
    private Integer idPosto;

    public Prenotazione(){}

    public Prenotazione(Integer id, LocalDateTime dataPrenotazione, Double prezzoTotale, Integer idUtente, Integer idSpettacolo, Integer idPosto) {
        this.id = id;
        this.dataPrenotazione = dataPrenotazione;
        this.prezzoTotale = prezzoTotale;
        this.idUtente = idUtente;
        this.idSpettacolo = idSpettacolo;
        this.idPosto = idPosto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDateTime dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public Double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(Double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }

    public Integer getIdSpettacolo() {
        return idSpettacolo;
    }

    public void setIdSpettacolo(Integer idSpettacolo) {
        this.idSpettacolo = idSpettacolo;
    }

    public Integer getIdPosto() {
        return idPosto;
    }

    public void setIdPosto(Integer idPosto) {
        this.idPosto = idPosto;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataPrenotazione=" + dataPrenotazione +
                ", prezzoTotale=" + prezzoTotale +
                ", idUtente=" + idUtente +
                ", idSpettacolo=" + idSpettacolo +
                '}';
    }
}
