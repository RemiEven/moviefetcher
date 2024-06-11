package com.zenika;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App {
    public static void main(String[] args) throws IOException {
        Movie movie = fetchMovie();

        System.out.println(movie.title());
        System.out.println(movie.releaseDate());
        System.out.println("---");
        System.out.println(movie.description());
    }

    public static Movie fetchMovie() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("https://ghibliapi.vercel.app/films/58611129-2dbc-4a81-a72f-77ddfc1b1b49")
            .build();

        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response.body().string(), Movie.class);
    }
}
