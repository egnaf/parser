package io.github.egnaf.parser;

public interface Parser {

    <T> T decode(Object from, String to);

    <T> T encode(String from, Class<T> to);
}
