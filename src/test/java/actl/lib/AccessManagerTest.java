package actl.lib;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import actl.lib.entity.Access;
import actl.lib.entity.Repository;
import actl.lib.entity.Role;
import actl.lib.entity.User;

public class AccessManagerTest {
    
    @BeforeEach
    public void setup() {
        Repository repositoryA = new Repository("repository_a");
        Repository repositoryB = new Repository("repository_b");
        User user = new User(repositoryA, "user");
        user.getAccesses().add(new Access(user, new Role(repositoryA, "role")));
        user.getAccesses().add(new Access(user, new Role(repositoryB, "role")));
    }

    @Test
    public void it_grants_access() {
        Repository repository = new Repository("repository");
        User user = new User(repository, "user");
        Role role = new Role(repository, "role");

        AccessManager accessManager = new AccessManager();
        accessManager.grant(user, role);

        Access access = new Access(user, role);
        assert user.getAccesses().contains(access);
    }

    @Test
    public void it_revokes_access() {
        Repository repository = new Repository("repository");
        User user = new User(repository, "user");
        Role role = new Role(repository, "role");
        Access access = new Access(user, role);
        user.getAccesses().add(access);

        AccessManager accessManager = new AccessManager();
        accessManager.revoke(user, role);

        assert !user.getAccesses().contains(access);
    }
}
