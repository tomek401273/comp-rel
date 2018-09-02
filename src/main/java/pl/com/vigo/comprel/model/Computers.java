package pl.com.vigo.comprel.model;

import javax.persistence.*;

@Entity
@Table(name = "computers")
public class Computers {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String compName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoryId")
    private ComputersCat computersCat;

    public Computers() {
    }

    public Computers(String compName, ComputersCat computersCat) {
        this.compName = compName;
        this.computersCat = computersCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public ComputersCat getComputersCat() {
        return computersCat;
    }

    public void setComputersCat(ComputersCat computersCat) {
        this.computersCat = computersCat;
    }

    @Override
    public String toString() {
        return "Computers{" +
                "id=" + id +
                ", compName='" + compName + '\'' +
                ", computersCat=" + computersCat +
                '}';
    }
}
