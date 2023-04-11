.DEFAULT_GOAL := build-run

clean:
	sudo gradle clean

build:
	sudo gradle clean build

install:
	sudo gradle clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	sudo ./gradlew run

test:
	sudo gradle test

report:
	sudo gradle jacocoTestReport

lint:
	sudo gradle checkstyleMain checkstyleTest

update-deps:
	sudo gradle useLatestVersions

build-run: build run

.PHONY: build
