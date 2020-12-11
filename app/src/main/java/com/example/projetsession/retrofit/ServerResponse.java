package com.example.projetsession.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ServerResponse implements Serializable
    {

        @SerializedName("response")
        @Expose
        private String response;
        private final static long serialVersionUID = 5577819968974496117L;

        public String getResponse() {
        return response;
    }

        public void setResponse(String response) {
        this.response = response;
    }
}