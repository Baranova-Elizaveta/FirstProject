package by.itclass.model.enums;

import by.itclass.model.db.SQLRequest;

public enum ImageAction {
    SAVE(SQLRequest.INSERT_USER_IMAGE),
    UPDATE(SQLRequest.UPDATE_USER_IMAGE);

    private String sql;

    ImageAction(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
