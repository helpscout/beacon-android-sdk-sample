# Beacon SDK Samples for Android

This repo contains 3 sample apps that implement the Beacon Android SDK. 

* [Sample Kotlin](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-kotlin) - demos Login and Logout with the Beacon UI.
* [Sample Customisation](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-customisation) - illustrates how you can override the String and Colors of the Beacon UI and shows how to use Beacons in Secure mode.
* [Sample Core](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-core) - shows how you might use the Beacon Core module to load suggested articles and view article details. 


## Latest version

* Beacon Core [ ![Download Beacon Core](https://api.bintray.com/packages/helpscout/beacon/beacon-core/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-core/_latestVersion)
* Beacon UI[ ![Download Beacon UI](https://api.bintray.com/packages/helpscout/beacon/beacon-ui/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-ui/_latestVersion)
* [Change Log](https://github.com/helpscout/beacon-android-sdk-sample/blob/master/CHANGELOG.md)

## Documentation

You can find the primary SDK documentation on the [Help Scout developers site](https://developer.helpscout.com/beacon-2/android/). 

## Requirements

* The minimum supported SDK is **21** (Android 5.0)
* Your app must be compiled with at least an API version **28** (Android 9.0).
* The Beacon SDK requires you to grant Internet permission as defined in the Core module.
* A Help Scout account to obtain your Beacon Id.

## Installation
The Beacon Android SDK is distributed as AAR and available from JCenter, so add the following lines to your app's `build.gradle` file.

```groovy
dependencies {
  implementation "com.helpscout:beacon-core:$beaconVersion"
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

## Advance setup/configuration

There are three main components split amongst two modules that construct the Beacon SDK. 

* beacon-core
    - Beacon Builder -  `Beacon.Builder()`  
    - Public Data Layer - `BeaconRepository`

* beacon-ui
    - The easiest way to integrate Beacon features into your app

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

To verify, take a peek in your LogCat.


## Implementing a custom User Interface

If all you are looking to do is to expose the knowledge database of articles, the Public API mode is your best bet.
We have provided you with a `Repository` (you can read more about this pattern [here](https://msdn.microsoft.com/en-us/library/ff649690.aspx)). You'll only need to include the `core` dependency.

The only requirement is to have created a `Beacon` with the `Beacon.Builder` as described above.

```java
BeaconRepository repository = Beacon.getRepositoryInstance()
```

This `Repository` allows you to fetch a few collections:

### Exposed methods

- Fetch all articles article by id: `List<BeaconArticle> articles = repository.getArticles()`
- Fetch an article by id: `BeaconArticle article = repository.getArticleById(articleId)`
- Search for an article: `List<BeaconArticle> articles = repository.searchArticles(query)`

### Threading

All the calls made to the `BeaconRepository` are synchronous. Meaning that you'll have to provide a threading
mechanism. Instead of being opinionated about it, we prefer to give you the option to use whatever mechanism works
best for you.

The sample-core project [shows how to build a custom](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-core) User Interface
