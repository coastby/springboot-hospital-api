package com.practice.hospitalapi.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext<T> {
    private Parser<T> parser;
    boolean isRemoveFirstLine = true;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        //첫 번째줄 버림 : default는 true로 되어있다.
        if (isRemoveFirstLine) {
            br.readLine();
        }
        while ((str = br.readLine()) != null) {
            //파싱된 결과값이 Null이 아닌 경우에만 리스트에 추가
            if(parser.parse(str) != null){
                result.add(parser.parse(str));
            }
        }
        return result;
    }
}
