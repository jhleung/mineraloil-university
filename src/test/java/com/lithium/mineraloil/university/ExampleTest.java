package com.lithium.mineraloil.university;

import com.lithium.mineraloi.university.ExampleController;
import com.lithium.mineraloi.university.browser.BaseUITest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExampleTest extends BaseUITest {

    @DisplayName("When something is inputted, then the this should pop up")
    @Test
    void exampleTest() {
        ExampleController example = new ExampleController();
        example.doSomething();
        Assertions.assertThat(example.getInputText()).isEqualTo("Hello World");
    }



}
