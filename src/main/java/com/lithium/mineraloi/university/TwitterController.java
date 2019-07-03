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

    public void clickHomeTimelineTab() {
        view.getHomeTimelineTab().click();
    }

    public void clickUserTimelineTab() {
        view.getUserTimelineTab().click();
    }

    public String getInputText() {
        return view.getFilterTextElement().getAttribute("value");
    }

    public Boolean homeTimelineTweetIsDisplayed() {
        return view.getHomeTimelineTweetStyleOneElement().isDisplayed();
    }

    public Boolean userTimelineTweetIsDisplayed() { return view.getUserTimelineTweetStyleOneElement().isDisplayed(); }

    public Boolean errorIsDisplayed() {
        return view.getErrorElement().isDisplayed();
    }
}
