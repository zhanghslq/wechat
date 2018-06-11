package com.yb.entity;

public class RequestTempData {
    private Integer offset;
    private Integer count;

    @Override
    public String toString() {
        return "RequestTempData{" +
                "offset=" + offset +
                ", count=" + count +
                '}';
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public RequestTempData() {

    }

    public RequestTempData(Integer offset, Integer count) {

        this.offset = offset;
        this.count = count;
    }
}
