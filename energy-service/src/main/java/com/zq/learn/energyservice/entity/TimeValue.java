package com.zq.learn.energyservice.entity;

import java.util.Date;

public class TimeValue<T> {
    private Date date;
    private T value;

    public TimeValue() {
    }

    public TimeValue(Date date, T value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
