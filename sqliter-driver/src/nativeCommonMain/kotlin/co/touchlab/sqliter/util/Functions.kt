package co.touchlab.sqliter.util

import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.concurrent.ensureNeverFrozen
import kotlin.native.concurrent.freeze

@OptIn(FreezingIsDeprecated::class, ExperimentalNativeApi::class)
internal inline fun <T> T.maybeFreeze(): T = if (Platform.memoryModel == MemoryModel.STRICT) {
    this.freeze()
} else {
    this
}

@OptIn(FreezingIsDeprecated::class, ExperimentalNativeApi::class)
internal inline fun <T> T.ensureNeverFrozenIfStrictMM() {
    if (Platform.memoryModel == MemoryModel.STRICT)
        this?.ensureNeverFrozen()
}
