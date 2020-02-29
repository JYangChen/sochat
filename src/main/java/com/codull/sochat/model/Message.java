package com.codull.sochat.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: sochat
 * @description:
 * @author: anthony1314
 * @create: 2020-02-25 14:26
 **/
@Data
public class Message implements Serializable {

    /**
     * 消息推送者
     */
    private User from;

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 消息内容
     */
    private String message;

    /**
     * 消息接收者：
     *      如果是私有（向指定窗口推送），to即为接受者User对象
     *      如果是公共消息（群组聊天），to设为null
     */
    private User to;

    public String getTime() {
        return time;
    }

    /**
     * 创建时间
     */
    private String time;

    public void setMessage(String message) {
        this.message = message == null ? "" : message.replaceAll("\r\n|\r|\n", "");
    }
    public Message(){

    }
    public Message(User from, String message, User to, String time){
        this.from = from;
        this.message = message;
        this.to = to;
        this.time = time;
    }
}