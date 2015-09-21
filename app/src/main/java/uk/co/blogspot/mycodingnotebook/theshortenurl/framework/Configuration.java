package uk.co.blogspot.mycodingnotebook.theshortenurl.framework;

public interface Configuration {
    void set(String key, String value);
    String get(String key);
}
