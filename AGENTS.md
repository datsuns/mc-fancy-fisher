# Fancy Fisher Project Notes

## Overview
- Targeting both Fabric and NeoForge loaders for Minecraft 1.21.10.
- Mod identifier: `Fancy Fisher` with base package `my.datsuns.fancyfisher`.
- Goal is to share core logic across loaders while keeping loader-specific glue minimal.

## Module Layout
- `common/` — loader-agnostic gameplay code, data packs, shared resources, and optional unit tests.
- `fabric/` — applies Fabric Loom, depends on `:common`, holds Fabric entrypoints, mixin configs, and `fabric.mod.json`.
- `neoforge/` — applies NeoGradle, depends on `:common`, includes `@Mod` entrypoint, event bus wiring, and `META-INF/neoforge.mods.toml`.
- Root Gradle project manages version catalogs, shared repositories, and aggregates `:fabric` and `:neoforge` jar outputs.

## Build & Run
- Use Gradle wrapper (`./gradlew`) with `GRADLE_USER_HOME=../gradle_home` when running inside sandboxed environments.
- Primary tasks:
  - `./gradlew :fabric:build` — produces Fabric-ready jar under `fabric/build/libs`.
  - `./gradlew :neoforge:build` — produces NeoForge-ready jar under `neoforge/build/libs`.
  - `./gradlew :fabric:runClient` / `:neoforge:runClient` for in-game testing once configured.
- Keep Gradle caches and downloaded assets inside project-local directories to avoid polluting global state.

## Development Guidelines
- Place shared constants, registries, and gameplay systems in `common`, exposing loader hooks via small interfaces or helper classes.
- For diverging behavior, define abstractions in `common.platform` and implement loader-specific versions under each platform module.
- Maintain loader-specific metadata (mixin configs, access wideners, NeoForge configs) within their respective modules.
- Prefer data-driven definitions (recipes, loot tables, tags) in `common/src/main/resources/data`.

## Open Items
- Confirm Minecraft version alignment between Fabric Loom and NeoForge Gradle plugins before scaffolding.
- Define initial feature set (e.g., custom fishing rod, loot tables) to prioritize shared abstractions.
- Decide on language/localization strategy and testing approach for shared logic.
