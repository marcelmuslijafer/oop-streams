# Stream<T> methods

1. `filter(Predicate<T> predicate)`: Filters elements based on the specified predicate.
2. `map(Function<T, R> mapper)`: Transforms elements by applying the specified mapper function.
3. `flatMap(Function<T, Stream<R>> mapper)`: Flattens elements by applying the specified mapper function and then flattening the resulting streams into a single stream.
4. `distinct()`: Removes duplicate elements from the stream.
5. `sorted()`: Sorts the elements of the stream in natural order.
6. `limit(long maxSize)`: Truncates the stream to a maximum size specified by `maxSize`.
7. `skip(long n)`: Skips the first `n` elements of the stream.
8. `forEach(Consumer<T> action)`: Performs the specified action on each element of the stream.
9. `collect(Collector<T, A, R> collector)`: Accumulates the elements of the stream into a mutable result container using the specified collector.
10. `reduce(T identity, BinaryOperator<T> accumulator)`: Performs a reduction on the elements of the stream using the specified identity value and an associative accumulation function.
11. `allMatch(Predicate<T> predicate)`: Returns whether all elements of the stream match the provided predicate.
12. `anyMatch(Predicate<T> predicate)`: Returns whether any elements of the stream match the provided predicate.
13. `noneMatch(Predicate<T> predicate)`: Returns whether no elements of the stream match the provided predicate.
14. `findFirst()`: Returns the first element in the stream, or `Optional.empty()` if the stream is empty.
15. `findAny()`: Returns any element in the stream, or `Optional.empty()` if the stream is empty.
16. `count()`: Returns the count of elements in the stream as a `long` value.
17. `min(Comparator<T> comparator)`: Returns the minimum element of the stream according to the provided comparator.
18. `max(Comparator<T> comparator)`: Returns the maximum element of the stream according to the provided comparator.
19. `toArray()`: Collects the elements of the stream into an array.

# `IntStream` Methods Not Available in `Stream`

1. `average()`: Returns the average of the elements in the stream as an `OptionalDouble`.
2. `sum()`: Returns the sum of the elements in the stream as an `int`.
3. `min()`: Returns the minimum element in the stream as an `OptionalInt`.
4. `max()`: Returns the maximum element in the stream as an `OptionalInt`.
5. `anyMatch(IntPredicate predicate)`: Returns whether any elements in the stream match the given predicate.
6. `allMatch(IntPredicate predicate)`: Returns whether all elements in the stream match the given predicate.
7. `noneMatch(IntPredicate predicate)`: Returns whether no elements in the stream match the given predicate.
8. `forEach(IntConsumer action)`: Performs an action for each element in the stream.
