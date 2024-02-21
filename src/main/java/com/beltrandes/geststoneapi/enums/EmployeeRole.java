package com.beltrandes.geststoneapi.enums;

public enum EmployeeRole {
    GERENTE(true, "Gerencia a equipe de produção"),
    PRODUTOR(false, "Realiza a produção dos produtos"),
    MONTADOR(false, "Monta os produtos finais");

    private final boolean manages;
    private final String description;

    EmployeeRole(boolean manages, String description) {
        this.manages = manages;
        this.description = description;
    }

    public boolean manages() {
        return manages;
    }

    public String getDescription() {
        return description;
    }
}
