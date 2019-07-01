package com.lithium.mineraloi.university;

public class TwitterController {
    private TwitterView view;

    public TwitterController() {
        view = new TwitterView();
    }

    public void filterHomeTimeline(String keyword) {
        view.getFilterTextElement().type(keyword);
        view.getFilterHomeTimelineButton().click();
    }

    public String getInputText() {
        return view.getFilterTextElement().getAttribute("value");
    }

    public Boolean tweetIsDisplayed() {
        return view.getTweetStyleOneElement().isDisplayed();
    }

    public Boolean errorIsDisplayed() {
        return view.getErrorElement().isDisplayed();
    }
}
