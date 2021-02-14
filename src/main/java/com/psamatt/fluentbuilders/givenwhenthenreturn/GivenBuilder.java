package com.psamatt.fluentbuilders.givenwhenthenreturn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class GivenBuilder {

    public static <T, R> WhenBuilder<T, R> given(T t, ReturnType<R> returnType) {
        return new WhenBuilder<>(t);
    }

    public static <T> WhenBuilder<T, T> given(T t) {
        return new WhenBuilder<>(t);
    }

    public static class ReturnType<R> {

        private ReturnType(Class<R> r) {
            // do nothing, just used for strong typing
        }

        public static <R> ReturnType<R> returnType(Class<R> r) {
            return new ReturnType<>(r);
        }
    }

    public static class WhenBuilder<T, R> {
        private final T t;
        private final Collection<ConditionPair<T, R>> conditionPairs;

        private WhenBuilder(T t) {
            this.t = t;
            this.conditionPairs = Collections.emptyList();
        }

        private WhenBuilder(T t, Collection<ConditionPair<T, R>> conditionPairs) {
            this.t = t;
            this.conditionPairs = conditionPairs;
        }

        public ThenBuilder<T, R> when(Predicate<T> p) {
            return new ThenBuilder<T, R>(t, conditionPairs, p);
        }

        public R orElse(R orElse) {
            return conditionPairs.stream()
                    .filter(c -> c.p.test(t))
                    .map(c -> c.c().apply(t))
                    .findFirst()
                    .orElse(orElse);
        }
    }

    public static class ThenBuilder<T, R> {
        private final T t;
        private final Collection<ConditionPair<T, R>> conditionPairs;
        private final Predicate<T> p;

        private ThenBuilder(T t, Collection<ConditionPair<T, R>> conditionPairs, Predicate<T> p) {
            this.t = t;
            this.conditionPairs = conditionPairs;
            this.p = p;
        }

        public WhenBuilder<T, R> then(Function<T, R> then) {
            Collection<ConditionPair<T, R>> newList = new ArrayList<>(conditionPairs);
            newList.add(new ConditionPair<T, R>(p, then));
            return new WhenBuilder<T, R>(t, List.copyOf(newList));
        }
    }

    public record ConditionPair<T, R>(Predicate<T> p, Function<T, R> c) {}
}
