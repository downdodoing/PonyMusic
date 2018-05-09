package me.wcy.music.http;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

import okhttp3.Response;

/**
 * Json封装
 */
public abstract class JsonCallback<T> extends Callback<T> {
    private Class<T> clazz;
    private Gson gson;

    public JsonCallback(Class<T> clazz) {
        this.clazz = clazz;
        gson = new Gson();
    }

    @Override
    public T parseNetworkResponse(Response response, int id) {
        try {
            String jsonString = response.body().string();
            return gson.fromJson(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
