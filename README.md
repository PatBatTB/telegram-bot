## Overview
#### Bot for Telegram.
* v0.1.0-SNAPSHOT

## Building
### The project is based on:
* Java 17
* Spring Boot 3.1.0(M1)
* Gradle-Groovy 7.6.1

## Usage

Contact [BotFather](https://t.me/BotFather) to register your bot and obtain an access token.

Record the bot's username and token in variables in the `src/main/resources/application.properties` file.

    bot.username = your_bot_username
    bot.token = your_access_token

Build the project with Gradle.
```Bash
./gradlew clean build
```
Grab the finished Jar archive from `build/libs`

## Troubleshooting
...

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* Patrick Bateman - [PatBatTB](https://github.com/PatBatTB)


## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details
