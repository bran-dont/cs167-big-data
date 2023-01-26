package org.example;

static class IsEven implements Function<Integer, Boolean> {
    @Override
    public Boolean apply(Integer x) {
        return x % 2 == 0;
    }
}