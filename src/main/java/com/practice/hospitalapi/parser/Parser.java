package com.practice.hospitalapi.parser;

public interface Parser<T> {
    public T parse(String str);
}
