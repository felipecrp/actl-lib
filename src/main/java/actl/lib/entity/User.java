package actl.lib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Represent a user
 */
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @EqualsAndHashCode.Exclude
    private Long id;

    public User() {}

    public User(Repository repository, String name) {
        super(repository, name);
    }
}
