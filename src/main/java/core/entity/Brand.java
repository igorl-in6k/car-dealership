package core.entity;

import javax.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public Brand() {
        name = "no brand defined";
    }

    public Brand(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Brand && name.equals(((Brand) obj).name);
    }
}
