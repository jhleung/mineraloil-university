package com.lithium.mineraloi.university;

public class ExampleController {
    private ExampleView view;

    public ExampleController() {
        view = new ExampleView();
    }

    public void doSomething() {
        view.getTextElement().type("Hello World");
        view.getSomeElement().click();
    }

    public String getInputText() {
        return view.getTextElement().getText();
    }
}
