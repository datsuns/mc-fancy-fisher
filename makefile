default:

b: build

bf: build_fabric

bn: build_neoforge

rf: run_fabric

rn: run_neoforge

wb: win_build_fabric win_build_neoforge

wbf: win_build_fabric

wbn: win_build_neoforge

wrf: win_run_fabric

wrn: win_run_neoforge

build: build_setup build_fabric build_neoforge

build_setup:
	mkdir -p ../gradle_home

build_fabric:
	GRADLE_USER_HOME=../gradle_home ./gradlew :fabric:build

build_neoforge:
	GRADLE_USER_HOME=../gradle_home ./gradlew :neoforge:build

run_fabric:
	cp ./fabric/build/libs/fancy-fisher-fabric-1.0.0-mc1.21.10.jar ./fabric/run/mods/
	GRADLE_USER_HOME=../gradle_home ./gradlew :fabric:runClient

run_neoforge:
	cp ./neoforge/build/libs/fancy-fisher-neoforge-1.0.0-mc1.21.10.jar ./neoforge/run/mods/
	GRADLE_USER_HOME=../gradle_home ./gradlew :neoforge:runClient

win_build_fabric:
	set GRADLE_USER_HOME=..\gradle_home
	gradlew.bat :fabric:build

win_build_neoforge:
	set GRADLE_USER_HOME=..\gradle_home
	gradlew.bat :neoforge:build

win_run_fabric:
	set GRADLE_USER_HOME=..\gradle_home
	-copy /Y fabric\build\libs\fancy-fisher-fabric-1.0.0-mc1.21.10.jar fabric\run\mods
	gradlew.bat :fabric:runClient

win_run_neoforge:
	set GRADLE_USER_HOME=..\gradle_home
	-copy /Y neoforge\build\libs\fancy-fisher-neoforge-1.0.0-mc1.21.10.jar neoforge\run\mods
	gradlew.bat :neoforge:runClient

.PHONY: default b bf bn rf rn
.PHONY: build build_setup build_fabric build_neoforge run_fabric run_neoforge
.PHONY: wb wbf wbn wrf wrn
.PHONY: win_build_fabric win_build_neoforge win_run_fabric win_run_neoforge
