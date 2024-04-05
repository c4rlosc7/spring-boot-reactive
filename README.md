# Spring Boot - Reactive

RxJava is a popular library for composing asynchronous and event-based programs using observable sequences. It's a Java implementation of the ReactiveX (Reactive Extensions) API, which originated in the .NET world and has since been ported to many programming languages.

Here are some key features of RxJava:

- Observable Sequences: RxJava introduces the concept of observable sequences, which emit items (events or data) over time. These sequences can represent anything that can be observed: UI events, asynchronous data streams, or even collections.

- Observer Pattern: RxJava follows the observer pattern, where observers subscribe to observables to receive notifications when new items are emitted, errors occur, or the sequence is completed.

- Functional Operators: RxJava provides a rich set of operators for transforming, filtering, combining, and manipulating observable sequences. These operators allow you to express complex asynchronous operations in a concise and declarative manner.

- Backpressure Handling: RxJava offers built-in support for handling backpressure, which occurs when the rate of producing items is faster than the rate of consuming them. This helps prevent resource exhaustion and enables efficient processing of large or fast data streams.

- Concurrency and Schedulers: RxJava allows you to control concurrency and specify execution contexts using schedulers. You can easily switch between different threads or thread pools to perform operations asynchronously or on specific threads.

- Error Handling: RxJava provides mechanisms for handling errors within observable sequences. You can catch and recover from errors, retry operations, or propagate errors to downstream observers.

[DATA-R2DBC](https://spring.io/projects/spring-data-r2dbc#overview)

## Single:

In RxJava, a Single represents a single value or an error, much like a Future or a Promise in other asynchronous programming 
frameworks. It emits only one item or an error notification, and then it either completes successfully or encounters an error.

## Flowable:

In RxJava, a Flowable represents a stream of potentially unbounded asynchronous events. It's similar to Observable, but it's 
designed to handle backpressure, which occurs when the rate at which events are emitted is faster than the rate at which they can be processed.

## Maybe: 

In RxJava, a Maybe represents an asynchronous computation that may or may not produce a result. It's similar to Single, 
but it can also complete without emitting any value, indicating the absence of a result. Maybe is useful when you expect 
an operation to either succeed and produce a value, produce no value at all, or fail with an error.