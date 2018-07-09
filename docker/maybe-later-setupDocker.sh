
pushd ../messaging
./gradlew setupDev
popd

pushd ../platform
./gradlew flywayMigrate
popd
