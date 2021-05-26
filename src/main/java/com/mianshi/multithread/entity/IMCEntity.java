package com.mianshi.multithread.entity;

import java.util.Date;

public class IMCEntity {
    private int id;
    private String ip;
    private Date accessTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("IMCEntity{");
        sb.append("id=").append(id);
        sb.append(", ip='").append(ip).append('\'');
        sb.append(", accessTime=").append(accessTime);
        sb.append('}');
        return sb.toString();
    }
}
