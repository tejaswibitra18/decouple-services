#!/bin/bash

url="YOUR_URL_HERE"

while true; do
   response=$(curl -s -o /dev/null -w "%{http_code} %{time_total}" --connect-timeout 5 $url)
   IFS=' ' read -r http_code time_total <<< "$response"
   if [[ $http_code -ge 200 ]] && [[ $http_code -lt 400 ]]; then
       echo "URL is reachable, Response time: $time_total"
   else
       echo "URL is not reachable, response code: $http_code"
       exit 1
   fi
   sleep 0.5
done