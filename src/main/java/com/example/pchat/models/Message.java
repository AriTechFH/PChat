package com.example.pchat.models;

public class Message {
    public int Id;
    public User From;
    public User To;
    public String Content;

    public Message(User from, User to, String content) {
        this.From = from;
        this.To = to;
        this.Content = content;
    }
}
