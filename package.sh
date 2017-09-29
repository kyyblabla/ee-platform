#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true
cd ee-platform-bootstrap
mvn package spring-boot:repackage -Dmaven.test.skip=true