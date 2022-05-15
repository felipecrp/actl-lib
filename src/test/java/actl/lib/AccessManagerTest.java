package actl.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import actl.lib.entity.Access;
import actl.lib.entity.Repository;
import actl.lib.entity.Role;
import actl.lib.entity.User;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AccessManagerTest {
    private Repository repositoryA;
    private Repository repositoryB;
    private User user;

    @BeforeEach
    public void setup() {
        this.repositoryA = new Repository("repository_a");
        this.repositoryB = new Repository("repository_b");
        this.user = new User(repositoryA, "user");
        this.user.getAccesses().add(
            new Access(this.user, new Role(repositoryA, "role_a")));
        this.user.getAccesses().add(
            new Access(this.user, new Role(repositoryB, "role_a")));
    }

    @Test
    public void it_grants_access() {
        Role role = new Role(this.repositoryA, "role_b");

        AccessManager accessManager = new AccessManager();
        accessManager.grant(this.user, role);

        Access access = new Access(this.user, role);
        assert user.getAccesses().contains(access);
    }

    @Test
    @DisplayName("It revokes access")
    public void it_revokes_access() {
        Role role = new Role(this.repositoryA, "role_a");

        AccessManager accessManager = new AccessManager();
        accessManager.revoke(this.user, role);

        Access access = new Access(user, role);
        assert !user.getAccesses().contains(access);
    }
}
