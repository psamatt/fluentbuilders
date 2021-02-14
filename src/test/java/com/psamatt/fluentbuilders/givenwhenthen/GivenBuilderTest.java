package com.psamatt.fluentbuilders.givenwhenthen;

import static com.psamatt.fluentbuilders.givenwhenthen.GivenBuilder.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GivenBuilderTest {

    @ParameterizedTest
    @CsvSource({"1,1", "50,1", "500,100", "1500,1000", "5000,2000"})
    void shouldLogBoundary(int number, int expected) {
        ValueLog valueLog = new ValueLog();
        given(number)
                .when(i -> i > 2000)
                .then(i -> valueLog.log = 2000)
                .when(i -> i > 1000)
                .then(i -> valueLog.log = 1000)
                .when(i -> i > 100)
                .then(i -> valueLog.log = 100)
                .orElse(i -> valueLog.log = 1);

        assertThat(valueLog.log).isEqualTo(expected);
    }

    private class ValueLog {
        public int log;
    }
}
