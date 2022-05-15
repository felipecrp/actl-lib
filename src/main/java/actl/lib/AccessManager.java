package actl.lib;

import java.util.Set;

import actl.lib.entity.Access;
import actl.lib.entity.Resource;
import actl.lib.entity.Role;

public class AccessManager {
    public void grant(Resource origin, Role role) {
        Access access = new Access();
        access.setOrigin(origin);
        access.setRole(role);

        Set<Access> accesses = origin.getAccesses();
        if (!accesses.contains(access)) {
            accesses.add(access);
        }
    }

    public void revoke(Resource origin, Role role) {
        Access access = new Access();
        access.setOrigin(origin);
        access.setRole(role);

        Set<Access> accesses = origin.getAccesses();
        if (accesses.contains(access)) {
            accesses.remove(access);
        }
    }
}
