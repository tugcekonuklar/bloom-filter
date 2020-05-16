package com.dkb.bloom.filter.controller;

public interface Controller {
    void execute();

    boolean mightContain(final String value);
}
