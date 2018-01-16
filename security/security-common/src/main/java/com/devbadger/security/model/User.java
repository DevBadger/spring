package com.devbadger.security.model;

public class User {
    private String sessionId;
    private String storeId;
    private String repId;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getRepId() {
        return repId;
    }

    @Override
    public String toString() {
        return "FlexUser{" +
                "sessionId='" + sessionId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", repId='" + repId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (sessionId != null ? !sessionId.equals(user.sessionId) : user.sessionId != null) return false;
        if (storeId != null ? !storeId.equals(user.storeId) : user.storeId != null) return false;
        return repId != null ? repId.equals(user.repId) : user.repId == null;
    }

    @Override
    public int hashCode() {
        int result = sessionId != null ? sessionId.hashCode() : 0;
        result = 31 * result + (storeId != null ? storeId.hashCode() : 0);
        result = 31 * result + (repId != null ? repId.hashCode() : 0);
        return result;
    }
}