package com.rammus.daozang.domain;

public class Event {
    private String eventid;

    private String rowid;

    private String eventname;

    private String eventcontent;

    private String eventtype;

    private String eventlocation;

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventcontent() {
        return eventcontent;
    }

    public void setEventcontent(String eventcontent) {
        this.eventcontent = eventcontent;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }

    public String getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(String eventlocation) {
        this.eventlocation = eventlocation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventid=").append(eventid);
        sb.append(", rowid=").append(rowid);
        sb.append(", eventname=").append(eventname);
        sb.append(", eventcontent=").append(eventcontent);
        sb.append(", eventtype=").append(eventtype);
        sb.append(", eventlocation=").append(eventlocation);
        sb.append("]");
        return sb.toString();
    }
}