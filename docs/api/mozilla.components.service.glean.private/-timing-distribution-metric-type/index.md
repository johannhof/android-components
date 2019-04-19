[android-components](../../index.md) / [mozilla.components.service.glean.private](../index.md) / [TimingDistributionMetricType](./index.md)

# TimingDistributionMetricType

`data class TimingDistributionMetricType : `[`CommonMetricData`](../-common-metric-data/index.md) [(source)](https://github.com/mozilla-mobile/android-components/blob/master/components/service/glean/src/main/java/mozilla/components/service/glean/private/TimingDistributionMetricType.kt#L23)

This implements the developer facing API for recording timing distribution metrics.

Instances of this class type are automatically generated by the parsers at build time,
allowing developers to record values that were previously registered in the metrics.yaml file.

The string list API exposes the [accumulate](#) method, which interacts with the storage engine to
accumulate to the correct bucket.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TimingDistributionMetricType(disabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, category: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lifetime: `[`Lifetime`](../-lifetime/index.md)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sendInPings: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, timeUnit: `[`TimeUnit`](../-time-unit/index.md)`)`<br>This implements the developer facing API for recording timing distribution metrics. |

### Properties

| Name | Summary |
|---|---|
| [category](category.md) | `val category: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [defaultStorageDestinations](default-storage-destinations.md) | `val defaultStorageDestinations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>Defines the names of the storages the metric defaults to when "default" is used as the destination storage. Note that every metric type will need to override this. |
| [disabled](disabled.md) | `val disabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [lifetime](lifetime.md) | `val lifetime: `[`Lifetime`](../-lifetime/index.md) |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [sendInPings](send-in-pings.md) | `val sendInPings: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [timeUnit](time-unit.md) | `val timeUnit: `[`TimeUnit`](../-time-unit/index.md) |

### Inherited Properties

| Name | Summary |
|---|---|
| [identifier](../-common-metric-data/identifier.md) | `open val identifier: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [cancel](cancel.md) | `fun cancel(timerId: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Abort a previous [start](start.md) call. No error is recorded if no [start](start.md) was called. |
| [start](start.md) | `fun start(timerId: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Start tracking time for the provided metric and associated object. This records an error if it’s already tracking time (i.e. start was already called with no corresponding [stopAndAccumulate](stop-and-accumulate.md)): in that case the original start time will be preserved. |
| [stopAndAccumulate](stop-and-accumulate.md) | `fun stopAndAccumulate(timerId: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Stop tracking time for the provided metric and associated object. Add a count to the corresponding bucket in the timing distribution. This will record an error if no [start](start.md) was called. |
| [testGetValue](test-get-value.md) | `fun testGetValue(pingName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = getStorageNames().first()): `[`TimingDistributionData`](../../mozilla.components.service.glean.storages/-timing-distribution-data/index.md)<br>Returns the stored value for testing purposes only. This function will attempt to await the last task (if any) writing to the the metric's storage engine before returning a value. |
| [testHasValue](test-has-value.md) | `fun testHasValue(pingName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = getStorageNames().first()): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Tests whether a value is stored for the metric for testing purposes only. This function will attempt to await the last task (if any) writing to the the metric's storage engine before returning a value. |

### Inherited Functions

| Name | Summary |
|---|---|
| [getStorageNames](../-common-metric-data/get-storage-names.md) | `open fun getStorageNames(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>Get the list of storage names the metric will record to. This automatically expands [DEFAULT_STORAGE_NAME](#) to the list of default storages for the metric. |
| [shouldRecord](../-common-metric-data/should-record.md) | `open fun shouldRecord(logger: `[`Logger`](../../mozilla.components.support.base.log.logger/-logger/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |