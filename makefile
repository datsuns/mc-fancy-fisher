default:

b: build

bf: build_fabric

bn: build_neoforge

rf: run_fabric

rn: run_neoforge

build: build_setup build_fabric build_neoforge

build_setup:
	mkdir -p ../gradle_home

build_fabric:
	GRADLE_USER_HOME=../_sandbox/gradle_home ./gradlew :fabric:build

build_neoforge:
	GRADLE_USER_HOME=../_sandbox/gradle_home ./gradlew :neoforge:build

run_fabric:
	GRADLE_USER_HOME=../_sandbox/gradle_home ./gradlew :fabric:runClient

run_neoforge:
	GRADLE_USER_HOME=../_sandbox/gradle_home ./gradlew :neoforge:runClient

.PHONY: default b bf bn rf rn
.PHONY: build build_setup build_fabric build_neoforge run_fabric run_neoforge

