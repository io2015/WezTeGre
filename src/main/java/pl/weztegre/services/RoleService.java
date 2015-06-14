package pl.weztegre.services;

import pl.weztegre.models.Role;

public interface RoleService {
        Role findRole(final String role);
        void createRole(final String role);
}
