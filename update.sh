#!/bin/sh

echo Updating intelliJ
echo removing old libs
rm -r .idea/libraries
rm -rf .idea_modules/shopTo_V_11.iml


echo Updating dependencies
./sbt.sh clean update gen-idea

echo "intelliJ"  needs help with the !?*.props files in sdk settings

