package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "WerknemerDetail")
public class WerknemerDetail {

    @Id
    @GeneratedValue
    @Column
    private Long DetailId;

    @Column
    private String Adres;

    @Column
    private String TelefoonNummer;

    @Column
    private String Email;

    @OneToOne
    @JoinColumn(name = "Werknemer_ID")
    private Werknemer werknemerId;


    public WerknemerDetail()
    {

    }

    public WerknemerDetail(Long detailId, String adres, String telefoonNummer, String email) {
        DetailId = detailId;
        Adres = adres;
        TelefoonNummer = telefoonNummer;
        Email = email;
    }




    public Long getDetailId() {
        return DetailId;
    }

    public void setDetailId(Long detailId) {
        DetailId = detailId;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getTelefoonNummer() {
        return TelefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        TelefoonNummer = telefoonNummer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Werknemer getWerknemerId() {
        return werknemerId;
    }

    public void setWerknemerId(Werknemer werknemerId) {
        this.werknemerId = werknemerId;
    }
}
