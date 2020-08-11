# Koin Project #

## Installation ##

Just clone this repository, and import the project in Android Studio and sync with Gradle.

## Building ##

Application implements Flavors and FlavorDimensions.


In order to build **staging debug** version invoke

```
./gradlew assembleStagingDebug
```

In order to build **production debug** version invoke

```
./gradlew assembleProductionDebug
```
## Architecture ##
The project is created in MVVM architecture, which allows separating the user interface logic from the business logic.

MVVM has mainly the following layers:
- Model
    Model represents the data and/or information.
- ViewModel
    ViewModel interacts with model and also prepares observable(s) that can be observed by a View.
- View
    View is to subscribe to a ViewModel to get data in order to update UI elements accordingly.

MVVM components and interaction between them:

## Dependencies ##
Dependencies used in the application:

1. [Koin](https://github.com/InsertKoinIO/koin/) - service locator framework
2. [Gson](https://github.com/google/gson) - convert a JSON string to an equivalent Kotlin object
3. [Retrofit2](http://square.github.io/retrofit/) - HTTP client
4. [Mockito](http://mockito.org) - mocking framework for unit tests
