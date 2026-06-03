# warpfix-kotlin-e2e

Minimal Gradle + Kotlin project used to validate WarpFix end-to-end on a JVM
language. `Intervals.mergeIntervals` has a deliberate off-by-one bug (a strict
`<` where boundaries are inclusive, so it should be `<=`) which makes the
JUnit test `merges touching intervals into one` fail in CI.
