package actl.lib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EqualsAndHashCode
public abstract class Resource {
    @Getter @Setter
    private String name;

    @Getter @Setter
    @EqualsAndHashCode.Exclude
    @Transient
    private Set<Access> accesses;

    @Getter @Setter
    @ManyToOne
    private Repository repository;

    public Resource() {
        this.accesses = new HashSet<>();
    }

    public Resource(Repository repository, String name) {
        this.repository = repository;
        this.name = name;
        this.accesses = new HashSet<>();
    }
}
