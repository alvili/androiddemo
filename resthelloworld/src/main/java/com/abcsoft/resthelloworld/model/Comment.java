package com.abcsoft.resthelloworld.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int id;			//Código del comentario
    private int postId;		//Código de la publicación comentada
    private String name;	//Nombre del comentador
    private String email;	//Email del comentador

    @SerializedName("body")
    private String text;	// El comentario

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
