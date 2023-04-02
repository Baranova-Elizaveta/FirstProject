package by.itclass.model.enums;

import by.itclass.model.db.SQLRequest;

public enum NewsAction {

    DISLIKES_FOR_NEWS(SQLRequest.DELETE_LIKE_FOR_NEWS),
    LIKES_FOR_NEWS(SQLRequest.INSERT_LIKE_FOR_NEWS),
    VIEW,
    UPDATE_USER(SQLRequest.UPDATE_USER),
    DELETE(SQLRequest.DELETE_NEWS_BY_ID),
    ADD(SQLRequest.INSERT_NEWS),
    EDIT(SQLRequest.UPDATE_NEWS),
    GET_BY_ID(SQLRequest.SELECT_NEWS_BY_ID),
    GET_LIST_BY_ID_USER(SQLRequest.SELECT_NEWS_BY_ID_USER),
    SORTED(SQLRequest.SELECT_NEWS_SORTED_BY_DATE),
    TOP(SQLRequest.SELECT_NEWS_BY_TOP_LIKES);

    private String sql;

    NewsAction() {
    }

    NewsAction(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
