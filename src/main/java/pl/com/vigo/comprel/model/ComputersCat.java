package pl.com.vigo.comprel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "computersCat")
public class ComputersCat {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(
            targetEntity = Computers.class,
            mappedBy = "computersCat",
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    List<Computers> computersList = new ArrayList<>();

    public List<Computers> getComputersList() {
        return computersList;
    }

    public void setComputersList(List<Computers> computersList) {
        this.computersList = computersList;
    }

    public ComputersCat() {
    }

    public ComputersCat(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComputersCat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
