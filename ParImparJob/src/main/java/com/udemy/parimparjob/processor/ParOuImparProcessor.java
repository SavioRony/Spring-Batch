package com.udemy.parimparjob.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ParOuImparProcessor implements ItemProcessor<Integer, String> {

    @Override
    public String process(Integer item) throws Exception {
        return item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Ímpar", item);
    }
}
