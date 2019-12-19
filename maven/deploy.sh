#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn clean deploy --settings maven/settings.xml -DskipTests=true -B -U -Prelease
fi