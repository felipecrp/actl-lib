package actl.lib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// @Entity
@EqualsAndHashCode
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @EqualsAndHashCode.Exclude
    private Long id;

    @Getter @Setter
    private Resource origin;

    @Getter @Setter
    private Role role;

    public Access() {}

    public Access(Resource origin, Role role) {
        this.origin = origin;
        this.role = role;
    }
} 
