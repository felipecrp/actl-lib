package actl.lib.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public abstract class Resource {
    @Getter @Setter
    private String name;

    @Getter @Setter
    @EqualsAndHashCode.Exclude
    private Set<Access> accesses;

    @Getter @Setter
    private Repository repository;

    public Resource() {
        this.accesses = new HashSet<>();
    }

    public Resource(Repository repository, String name) {
        this.accesses = new HashSet<>();
        this.name = name;
    }
}
