#!/usr/bin/env bash
./gradlew clean install
sudo mkdir -p /usr/local/nudi/
sudo cp build/libs/nudi-lang-1.0.jar /usr/local/nudi/
sudo touch /usr/local/bin/nudi
echo 'java -jar /usr/local/nudi/nudi-lang-1.0.jar "$@"' | sudo tee /usr/local/bin/nudi > /dev/null
sudo chmod +x /usr/local/bin/nudi