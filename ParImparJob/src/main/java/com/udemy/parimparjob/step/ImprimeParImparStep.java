package com.udemy.parimparjob.step;

import com.udemy.parimparjob.processor.ParOuImparProcessor;
import com.udemy.parimparjob.reader.ContaAteDezReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeParImparStep {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ContaAteDezReader reader;
    @Autowired
    private ItemProcessor<Integer, String> processor;
    @Autowired
    private ItemWriter<String> writer;

    @Bean
    public Step parImparStep() {
        return stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String>chunk(1)
                .reader(reader.read())
                .processor(processor)
                .writer(writer)
                .build();
    }}
