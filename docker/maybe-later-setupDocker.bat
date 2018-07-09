cd ..\messaging
gradlew setupDev

cd ..\platform
gradlew flywayMigrate
