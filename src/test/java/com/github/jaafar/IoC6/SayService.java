package com.github.jaafar.IoC6;

/**
 * ${DESCRIPTION}
 *
 * @author jaafaree
 * @create 2018/2/9 23:04
 */
public class SayService {
    private String word;
    private OutputService outputService;

    public void say() {
        outputService.output(word);
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
