package actl.lib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Table(name = "REPO")
public class Repository {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String name;

    public Repository() {}

    public Repository(String name) {
        this.name = name;
    }
}
