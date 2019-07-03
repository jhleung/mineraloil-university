package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.TwitterController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwitterTest extends BaseUITest {

    @DisplayName("When filter timeline is successful, then tweet should render")
    @Test
    void filterTimelineResultsFound() {
        TwitterController example = new TwitterController();
        final String keyword = "a";
        example.clickHomeTimelineTab();
        example.filterHomeTimeline(keyword);
        Assertions.assertThat(example.getInputText()).isEqualTo(keyword);
        Assertions.assertThat(example.homeTimelineTweetIsDisplayed()).isTrue();
        Assertions.assertThat(example.userTimelineTweetIsDisplayed()).isFalse();
        Assertions.assertThat(example.errorIsDisplayed()).isFalse();
    }

    @DisplayName("When filter timeline is unsuccessful, then tweet should render")
    @Test
    void filterTimelineNoResults() {
        TwitterController example = new TwitterController();
        final String keyword = "NO_RESULTS_RETURNED_KEYWORD";
        example.clickHomeTimelineTab();
        example.filterHomeTimeline(keyword);
        Assertions.assertThat(example.getInputText()).isEqualTo(keyword);
        Assertions.assertThat(example.homeTimelineTweetIsDisplayed()).isFalse();
        Assertions.assertThat(example.userTimelineTweetIsDisplayed()).isFalse();
        Assertions.assertThat(example.errorIsDisplayed()).isTrue();
    }


    @DisplayName("When user timeline tab is active, user timeline should exist")
    @Test
    void userTimelineExists() {
        TwitterController example = new TwitterController();
        example.clickUserTimelineTab();
        Assertions.assertThat(example.homeTimelineTweetIsDisplayed()).isFalse();
        Assertions.assertThat(example.userTimelineTweetIsDisplayed()).isTrue();
        Assertions.assertThat(example.errorIsDisplayed()).isFalse();
    }
}
