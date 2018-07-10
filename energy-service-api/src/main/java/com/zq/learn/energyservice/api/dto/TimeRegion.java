package com.zq.learn.energyservice.api.dto;

import java.util.Date;

public class TimeRegion {
    private Date startTime;
    private Date endTime;

    public TimeRegion() {
    }

    public TimeRegion(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
