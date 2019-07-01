package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.TwitterController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwitterTest extends BaseUITest {

    @DisplayName("When something is inputted, then the this should pop up")
    @Test
    void exampleTest() {
        TwitterController example = new TwitterController();
        example.filterHomeTimeline();
        Assertions.assertThat(example.getInputText()).isEqualTo("test");
        Assertions.assertThat(example.tweetExists() || example.errorExists()).isTrue();
    }
}
