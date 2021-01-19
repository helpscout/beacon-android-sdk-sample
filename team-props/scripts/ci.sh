#!/bin/bash

# Executed by CI

set -e

trap 'catch $? $LINENO' EXIT

catch() {
  if [ "$1" != "0" ]; then
    echo "Error $1 occurred on $2"
  fi
}

comment() {
  echo "###########################################################################################"
  echo " $1"
  echo "###########################################################################################"
}

################################################
#                  EXECUTION                   #
################################################
comment "Building Beacon sample apps"
./gradlew assembleRelease lintRelease
comment "Finished building Beacon sample apps"
