package com.psamatt.fluentbuilders.givenwhenthen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class GivenBuilder<T> {

    public static <T> WhenBuilder<T> given(T t) {
        return new WhenBuilder<T>(t);
    }

    public static class WhenBuilder<T> {
        private final T t;
        private final Collection<ConditionPair<T>> conditionPairs;

        private WhenBuilder(T t) {
            this.t = t;
            this.conditionPairs = Collections.emptyList();
        }

        private WhenBuilder(T t, Collection<ConditionPair<T>> conditionPairs) {
            this.t = t;
            this.conditionPairs = conditionPairs;
        }

        public ThenBuilder<T> when(Predicate<T> p) {
            return new ThenBuilder<T>(t, conditionPairs, p);
        }

        public void orElse(Consumer<T> orElse) {
            ConditionPair<T> tConditionPair =
                    conditionPairs.stream()
                            .filter(c -> c.test(t))
                            .findFirst()
                            .orElse(new ConditionPair<T>((a) -> true, orElse));

            tConditionPair.accept(t);
        }
    }

    public static class ThenBuilder<T> {
        private final T t;
        private final Collection<ConditionPair<T>> conditionPairs;
        private final Predicate<T> p;

        private ThenBuilder(T t, Collection<ConditionPair<T>> conditionPairs, Predicate<T> p) {
            this.t = t;
            this.conditionPairs = conditionPairs;
            this.p = p;
        }

        public WhenBuilder<T> then(Consumer<T> c) {
            Collection<ConditionPair<T>> newList = new ArrayList<>(conditionPairs);
            newList.add(new ConditionPair<T>(p, c));
            return new WhenBuilder<T>(t, List.copyOf(newList));
        }
    }

    public record ConditionPair<T>(Predicate<T> p, Consumer<T> c) {

        public boolean test(T t) {
            return p.test(t);
        }

        public void accept(T t) {
            c.accept(t);
        }
    }
}
