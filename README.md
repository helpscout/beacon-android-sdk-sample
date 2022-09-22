# Beacon Android SDK Samples

This repository contains two sample apps that showcase how to integrate the Beacon Android SDK.

* [Sample Kotlin](./sample-kotlin) - A simple and concise demo that shows how to install, initialise, and two different ways to open your Help Scout Beacon.
* [Sample Customisation](./sample-customisation) - Java based sample illustrates some of the key features you can use to customise the Beacon SDK to add additional data about the user and how to override certain Beacon settings.

## Beacon SDK version [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.helpscout/beacon/badge.svg?gav=true)](https://maven-badges.herokuapp.com/maven-central/com.helpscout/beacon)

[Release notes and changelog](https://github.com/helpscout/beacon-android-sdk-sample/blob/master/CHANGELOG.md)

You can subscribe to receive release updates by following these steps:
1. At the top right-hand corner, click on "Watch"
2. Choose "Custom"
3. Check the "Releases" option

[<img src="./docs/subscribe-to-releases.png" width="320">](./docs/subscribe-to-releases.png)

## Requirements

* `minSdkVersion`: **21**
* `compileSdkVersion`:**31**
* Java 11 language feature support
* [Android X](https://developer.android.com/jetpack/androidx/) as of version SDK 2.0.0
* A Beacon Id created on [Help Scout](https://secure.helpscout.net/settings/beacons/)

### Supported platform and language versions

* Android 11.0 to 13.0 (as noted above the "minSdkVersion: 21 (Android 5.0)" for greater compatiblity however we only offer support for issues on Android 11.0 to 12.0)
* Kotlin 1.6
* Java 11
* Koin 3.2.0

## Installation
The Beacon Android SDK is distributed as AAR and available from Maven Central, so add the following lines to your app's `build.gradle` file.

**Groovy**
```groovy
repositories {
    mavenCentral()
    …
}

dependencies {
  implementation 'com.helpscout:beacon:<beaconVersion>'
}
```

**Kotlin DSL**
```groovy
repositories {
    mavenCentral()
    …
}

dependencies {
    implementation("com.helpscout:beacon:<beaconVersion>")
}
```

Once you sync the Gradle project, you'll be ready to initialize Beacon.


# Initialize Beacon

After following the steps above, your app is ready to integrate with the Beacon SDK. Before you can continue any further, you'll need to get a hold of the ID of the Beacon that you'd like to use.

You can find your Beacon ID by [logging into Help Scout](https://secure.helpscout.net/settings/beacons) and navigating to the Beacon you'd like to use. Inside the `Installation` section, you'll see an Android tab that highlights the Beacon ID and a code snippet.

Once you've located the Beacon ID, you are ready to initialize the library. If you only display one Beacon, the `Application.onCreate()` method of your [Application class](https://developer.android.com/reference/android/app/Application.html)
class is a great place to initialize the SDK. If you won't know the Beacon ID at Application start or run multiple Beacons, you'll need to make sure of adding the following call to the `Beacon.Builder()` before you launch `BeaconActivity`.  

```java
Beacon beacon = new Beacon.Builder()
  .withBeaconId("YOUR_BEACON_ID_HERE")       
  .build();
```

Beacon ID field is mandatory. Failing to provide it throws an `SDKInitException`
when interacting with the `Beacon` object.

## Opening Beacon

Once you've initialized Beacon, you're ready to interact with it. Whenever you want
to invoke Beacon, use the code below to display the Beacon user interface.

```java
BeaconActivity.open(context);
```

## Developer options

It's possible to launch the Beacon SDK in developer mode. By doing so, you'll be able to read
the HTTP requests and other actions that happen with the SDK realm.

To activate this mode, you have to tell the Beacon Builder like so:

```java
Beacon beacon = Beacon.Builder()
  .withBeaconId("YOUR_BEACON_ID_HERE")       
  .withLogsEnabled(true)       
  .build();
```

To verify, take a peek in your Logcat.


## Documentation

* [Beacon Mobile SDK documentation](https://developer.helpscout.com/beacon-2/mobile/)
* [Android SDK API](https://developer.helpscout.com/beacon-2/android/)
* [Android SDK API reference](https://developer.helpscout.com/beacon-2/android-api/beacon/index.html)


## Support

For issues or questions, contact Help Scout support at [help@helpscout.com](mailto:help@helpscout.com?subject=%5BAndroid%20Beacon%20SDK%5D%20Issue%20report&body=Technical%20details%0A%0A-%20Beacon%20version%3A%0A-%20Android%20OS%20version%3A%0A-%20Device%20make%2Fmodel%3A%0A-%20Impacted%20user%20count%3A%0A%0AActual%20outcome%0A%0A%20%20%20%20Beacon%20did%20or%20did%20not...%0A%0AExpected%20outcome%0A%0A%20%20%20%20Beacon%20should...%0A%0ASteps%20to%20reproduce%0A%0A%20%20%20%201.%20%E2%80%A6%0A%20%20%20%202.%20%E2%80%A6%0A%20%20%20%203.%20%E2%80%A6%0A%0AScreenshots%2FScreen%20Recording%0A%0A%20%20%20%20Please%20add%20any%20images%20or%20videos%20to%20support%20your%20report.%0A%0AAdditional%20Information%0A%0A%20%20%20%20Please%20attach%20any%20crash%20logs)
