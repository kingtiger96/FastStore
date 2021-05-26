package com.mianshi.multithread.entity;

import java.util.Date;

public class ResultEntity {
    private int id;
    private String username;
    private String ip;
    private Date AccessTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getAccessTime() {
        return AccessTime;
    }

    public void setAccessTime(Date accessTime) {
        AccessTime = accessTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResultEntity{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", AccessTime=").append(AccessTime);
        sb.append('}');
        return sb.toString();
    }
}
