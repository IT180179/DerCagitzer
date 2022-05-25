#!/usr/bin/bash
rm -rfv /var/www/html/*
#!scp *.tgz server:
pushd /var/www/html
tar -xvzf public.tgz
pwd
popd
