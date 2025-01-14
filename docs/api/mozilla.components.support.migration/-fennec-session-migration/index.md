[android-components](../../index.md) / [mozilla.components.support.migration](../index.md) / [FennecSessionMigration](./index.md)

# FennecSessionMigration

`object FennecSessionMigration` [(source)](https://github.com/mozilla-mobile/android-components/blob/master/components/support/migration/src/main/java/mozilla/components/support/migration/FennecSessionMigration.kt#L20)

Helper for importing/migrating "open tabs" from Fennec.

### Functions

| Name | Summary |
|---|---|
| [migrate](migrate.md) | `fun migrate(profilePath: `[`File`](https://developer.android.com/reference/java/io/File.html)`): `[`Result`](../-result/index.md)`<`[`Snapshot`](../../mozilla.components.browser.session/-session-manager/-snapshot/index.md)`>`<br>Ties to migrate the "open tabs" from the given [profilePath](migrate.md#mozilla.components.support.migration.FennecSessionMigration$migrate(java.io.File)/profilePath) and on success returns a [SessionManager.Snapshot](../../mozilla.components.browser.session/-session-manager/-snapshot/index.md) (wrapped in [Result.Success](../-result/-success/index.md)). |

### Extension Functions

| Name | Summary |
|---|---|
| [loadResourceAsString](../../mozilla.components.support.test.file/kotlin.-any/load-resource-as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.loadResourceAsString(path: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Loads a file from the resources folder and returns its content as a string object. |
