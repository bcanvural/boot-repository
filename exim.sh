#!/usr/bin/env bash

http :8080/cms/ws/indexexport --download -a admin:admin -o export.zip
rm -rf storage/workspaces/default/index/*
tar -xzvf export.zip -C storage/workspaces/default/index/