# Beacon Android SDK Samples

This repo contains 2 sample apps that implement the Beacon Android SDK.

* [Sample Kotlin](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-kotlin) - demos how to install, initialise, and open your Help Scout Beacon.
.
* [Sample Customisation](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-customisation) - illustrates how you can override the String and Colors of the Beacon UI and shows how to use Beacons in Secure mode.

## Beacon SDK version [![Download Beacon UI](https://api.bintray.com/packages/helpscout/beacon/beacon-ui/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-ui/_latestVersion)

[Release notes and changelog](https://github.com/helpscout/beacon-android-sdk-sample/blob/master/CHANGELOG.md)

## Documentation

* [Beacon Mobile SDK documentation](https://developer.helpscout.com/beacon-2/mobile/)
* [Android SDK API](https://developer.helpscout.com/beacon-2/android/)
* [Android SDK API reference](https://developer.helpscout.com/beacon-2/android-api/beacon/index.html)

## Requirements

* The minimum supported Android version is 5.0 (SDK INT 21)
* Your app must be compiled with at least an API version **29** 
* A Beacon Id created on [Help Scout](https://secure.helpscout.net)

## Installation
The Beacon Android SDK is distributed as AAR and available from JCenter, so add the following lines to your app's `build.gradle` file.

```groovy
dependencies {
  implementation "com.helpscout:beacon-ui:$beaconVersion"
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
  .withBeaconId("76d18b11-41f4-4d34-9a8c-08679d4759e3")       
  .build();
```

Beacon ID field is mandatory. Failing to provide it throws an `SDKInitException`
when interacting with the `Beacon` object.

## Launching the Beacon User Interface

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
  .withBeaconId("cf2102b5-0f3c-4214-972e-2a1d33c7fadb")       
  .withLogsEnabled(true)       
  .build();
```

To verify, take a peek in your Logcat.
