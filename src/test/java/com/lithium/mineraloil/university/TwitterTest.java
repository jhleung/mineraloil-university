package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.TwitterController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwitterTest extends BaseUITest {

    @DisplayName("When filter timeline is successful, then tweet should render")
    @Test
    void filterTimelineResultsFoundTest() {
        TwitterController example = new TwitterController();
        final String keyword = "a";
        example.filterHomeTimeline(keyword);
        Assertions.assertThat(example.getInputText()).isEqualTo(keyword);
        Assertions.assertThat(example.tweetIsDisplayed()).isTrue();
        Assertions.assertThat(example.errorIsDisplayed()).isFalse();
    }

    @DisplayName("When filter timeline is unsuccessful, then tweet should render")
    @Test
    void filterTimelineNoResultsTest() {
        TwitterController example = new TwitterController();
        final String keyword = "NO_RESULTS_RETURNED_KEYWORD";
        example.filterHomeTimeline(keyword);
        Assertions.assertThat(example.getInputText()).isEqualTo(keyword);
        Assertions.assertThat(example.tweetIsDisplayed()).isFalse();
        Assertions.assertThat(example.errorIsDisplayed()).isTrue();
    }
}
