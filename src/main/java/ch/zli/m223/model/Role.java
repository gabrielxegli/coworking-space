package ch.zli.m223.model;

public enum Role {
    Admin("admin"),
    Member("member");

    public final String label;

    private Role(String label) {
        this.label = label;
    }
}
