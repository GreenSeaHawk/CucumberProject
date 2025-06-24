#!/bin/bash

echo "🧹 Cleaning old Allure results..."
rm -rf allure-results/*

echo "🚀 Running tests..."
sbt "testOnly runner.TestRunner"

echo "📊 Serving Allure report..."
allure serve allure-results