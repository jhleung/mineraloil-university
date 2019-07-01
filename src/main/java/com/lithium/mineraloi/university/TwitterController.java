package com.lithium.mineraloi.university;

public class TwitterController {
    private TwitterView view;

    public TwitterController() {
        view = new TwitterView();
    }

    public void filterHomeTimeline() {
        view.getFilterTextElement().type("test");
        view.getFilterHomeTimelineButton().click();
    }

    public String getInputText() {
        return view.getFilterTextElement().getAttribute("value");
    }

    public Boolean tweetExists() {
        return view.getTweetStyleOneElement() != null;
    }

    public Boolean errorExists() {
        return view.getErrorElement() != null;
    }
}
