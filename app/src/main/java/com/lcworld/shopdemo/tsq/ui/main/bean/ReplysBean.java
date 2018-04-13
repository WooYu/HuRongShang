package com.lcworld.shopdemo.tsq.ui.main.bean;

import java.io.Serializable;

/**
 * 回复 评论
 */
public class ReplysBean implements Serializable {
    private String replyer_id = "-1"; //
    private String to_id = ""; //
    private String replyname;//回复姓名
    private String toname;//被回复姓名
    private String id;//评论id
    private String replyuser_id = "-1";//回复id
    private String touser_id = "";//被回复id
    private String content;//": "回复内容",
    private String time;//": "时间"

    public String getReplyer_id() {
        return replyer_id;
    }

    public void setReplyer_id(String replyer_id) {
        this.replyer_id = replyer_id;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public String getToname() {
        return toname;
    }

    public void setToname(String toname) {
        this.toname = toname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReplyuser_id() {
        return replyuser_id;
    }

    public void setReplyuser_id(String replyuser_id) {
        this.replyuser_id = replyuser_id;
    }

    public String getTouser_id() {
        return touser_id;
    }

    public void setTouser_id(String touser_id) {
        this.touser_id = touser_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
