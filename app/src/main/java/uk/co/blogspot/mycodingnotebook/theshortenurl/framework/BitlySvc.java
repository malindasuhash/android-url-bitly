package uk.co.blogspot.mycodingnotebook.theshortenurl.framework;

import retrofit.http.GET;

public interface BitlySvc {
    @GET("/")
    String shorten();
}
