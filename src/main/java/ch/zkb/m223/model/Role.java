package ch.zkb.m223.model;

public enum Role {
    Admin(Roles.ADMIN),
    Member(Roles.MEMBER);

    private final String label;

    public class Roles {
        public static final String ADMIN = "Admin";
        public static final String MEMBER = "Member";
    }

    private Role(String label) {
        this.label = label;
    }

    public String toString() {
        return this.label;
    }
}
