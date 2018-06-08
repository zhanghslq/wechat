package com.yb.entity;

/**
 * 为了发送模板消息，给微信接口发请求包装的数据类
 */
public class AccessData {
    private String touser;
    private String template_id;
    private String page;
    private String form_id;
    private Data data;
    private String color;
    private String emphasis_keyword;

    @Override
    public String toString() {
        return "AccessData{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", page='" + page + '\'' +
                ", form_id='" + form_id + '\'' +
                ", data=" + data +
                ", color='" + color + '\'' +
                ", emphasis_keyword='" + emphasis_keyword + '\'' +
                '}';
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEmphasis_keyword() {
        return emphasis_keyword;
    }

    public void setEmphasis_keyword(String emphasis_keyword) {
        this.emphasis_keyword = emphasis_keyword;
    }

    public AccessData(String touser, String template_id, String page, String form_id, Data data, String color, String emphasis_keyword) {

        this.touser = touser;
        this.template_id = template_id;
        this.page = page;
        this.form_id = form_id;
        this.data = data;
        this.color = color;
        this.emphasis_keyword = emphasis_keyword;
    }

    public AccessData() {

    }
}
