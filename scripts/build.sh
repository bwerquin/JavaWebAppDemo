#!/usr/bin/env bash
#title           :build.sh
#description     :Builds and packages war file
#author		     :bwerquin
#==============================================================================
FINAL_WAR_NAME=${1?Final war name must be passed as first argument}

# Build backend web app
function build(){
    mvn clean install -DskipTests -Dfinal.war.name="$FINAL_WAR_NAME"
}

build