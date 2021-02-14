package com.psamatt.fluentbuilders.givenwhenthenreturn;

import static com.psamatt.fluentbuilders.givenwhenthenreturn.GivenBuilder.ReturnType.returnType;
import static com.psamatt.fluentbuilders.givenwhenthenreturn.GivenBuilder.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GivenBuilderTest {

    @ParameterizedTest
    @CsvSource({"1,1", "50,1", "500,100", "1500,1000", "5000,2000"})
    void shouldReturnBoundaryWithSameReturnType(int number, int expected) {
        Integer actual =
                given(number)
                        .when(i -> i > 2000)
                        .then(i -> 2000)
                        .when(i -> i > 1000)
                        .then(i -> 1000)
                        .when(i -> i > 100)
                        .then(i -> 100)
                        .orElse(1);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "50,1", "500,100", "1500,1000", "5000,2000"})
    void shouldReturnBoundaryWithExplicitReturnTypeMethod(int number, int expected) {
        Integer actual =
                given(number, returnType(Integer.class))
                        .when(i -> i > 2000)
                        .then(i -> 2000)
                        .when(i -> i > 1000)
                        .then(i -> 1000)
                        .when(i -> i > 100)
                        .then(i -> 100)
                        .orElse(1);

        assertThat(actual).isEqualTo(expected);
    }
}
