# Beacon SDK for Android

* Beacon Core [ ![Download Beacon Core](https://api.bintray.com/packages/helpscout/beacon/beacon-core/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-core/_latestVersion)
* Beacon UI[ ![Download Beacon UI](https://api.bintray.com/packages/helpscout/beacon/beacon-ui/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-ui/_latestVersion)


## Requirements

The minimum supported SDK is **21** (Android 5.0), and your app must be compiled with at least API version **27** (Android 8.1).

## Features

* [Change Log](https://github.com/helpscout/beacon-android-sdk-sample/blob/master/CHANGELOG.md)

### Coming Soon

* Pre-fill contact form data
* Push notification support
* Live chat

## Installation
The Beacon Android SDK is distributed as AAR and available from JCenter, so simply add the following lines to your app’s `build.gradle` file.

```groovy
dependencies {
  implementation "com.helpscout:beacon-core:$beaconVersion"
  implementation "com.helpscout:beacon-ui:$beaconVersion"
}
```

Once you sync the Gradle project you'll be ready to initialize Beacon. 


### Alternate install 
Alternatively you can download the .aar files from our repository on [bintray.com](https://bintray.com/helpscout/beacon)

* Beacon Core [ ![Beacon Core download](https://api.bintray.com/packages/helpscout/beacon/beacon-core/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-core/_latestVersion)
* Beacon UI [ ![Beacon UI download](https://api.bintray.com/packages/helpscout/beacon/beacon-ui/images/download.svg) ](https://bintray.com/helpscout/beacon/beacon-ui/_latestVersion)


## Initialize Beacon

After following the steps above, your app is set up for integrating with the Beacon SDK. Before you can continue any further, you'll need
 to get hold of the ID of the Beacon that you'd like to integrate with.

You can find your Beacon ID by [logging into Help Scout](https://secure.helpscout.net/settings/beacons) and navigating to the Beacon you'd like to use. Inside the `Installation` section you'll see an Android tab which highlights the Beacon ID and a code snippet.

Once you've located the Beacon ID, you are ready to initialise the library. If you will only display one Beacon, the `Application.onCreate()` method of your [Application class](https://developer.android.com/reference/android/app/Application.html)
class is a great place to initialize the SDK. If you won't know the Beacon ID at Application start, or will be running multiple Beacons, you'll need to make sure of adding
 the following call to the `Beacon.Builder()` before you launch `BeaconActivity`.  

```java
Beacon beacon = new Beacon.Builder()
  .withBeaconId("76d18b11-41f4-4d34-9a8c-08679d4759e3")       
  .build();
```

Beacon ID field is mandatory. Failing to provide it will throw an `SDKInitException`
when an interaction with the `Beacon` object is done.

## Launching the Beacon User Interface 

Once you’ve initialized Beacon, you’re ready to interact with it. Whenever you want
to invoke Beacon, use the code below to display the Beacon user interface. 

```java
BeaconActivity.open(context);
```

We've put together a [sample demo project](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-kotlin) that showcases how you integrate with Beacon SDK and launch the Beacon User Interface.

## Authenticating users

To allow your users to create new Conversations and link them to their previous Conversations in Help Scout you'll need to authenticate them with either Basic or Secure mode.
`Beacon.login(..)` should be called immediately after successful login to your services.  

### Basic Mode

Basic mode authentication requires an user's email address as the user identifier.
```java
  Beacon.login("user@domain.com");
```

Alternatively, you can also identify the user's name.
```java
  Beacon.login("user@domain.com", "John Doe");
```


### Secure Mode

Secure mode authentication requires a signature. The signature must be computed on a *per user* basis using the secret key. The Secret Key is provided on the Manage Beacon page > Messaging > Advance Options.
For security reasons, you'll need to pass in the signature every time you want to open the Beacon UI.

Note: the Secret key should *not* be stored in the app, instead your server should provide the computed signature value.  

```java
  BeaconActivity.openInSecureMode(context, "8235545a15c6f41b64e3c47e5c94d3...");
```

### User Attributes

Beacon supports the addition of up to 10 attributes. These are arbitrary key-value pairs to allow you 
to add extra identifying information to a user.

You may add an attribute like so:
  
```java
  Beacon.addAttributeWithKey("a key", "a value");
```

You may also remove specific attributes. This function will return true if it was successfully 
removed or false if the key wasn't found.
  
```java
  Beacon.removeAttribute("a key");
```

It's also possible to remove all the attributes:

```java
  Beacon.clearAttributes();
```


# Advance setup/configuration

There are three main components that construct the Beacon SDK that are split over two modules.

* beacon-core
    - Beacon Builder -  `Beacon.Builder()`  
    - Public Data Layer - `BeaconRepository`

* beacon-ui
    - Easiest way to integrate Beacon features into your app
   
## Developer options

It's possible to launch the Beacon SDK in developer mode. By doing so, you'll be able to read 
the HTTP requests and other actions that happen with the SDK realm. 

In order to activate this mode, you have to tell the Beacon Builder like so: 

```java
Beacon beacon = Beacon.Builder()
  .withBeaconId("cf2102b5-0f3c-4214-972e-2a1d33c7fadb")       
  .withLogsEnabled(true)       
  .build();
```

Once this is done, head over to LogCat.

## Beacon UI Mode

The easiest and recommended way to interact with Beacon is to use it's UI Mode with the `ui` artifact. The SDK takes care of everything, and
this mode has all the features that Beacon provides:

| Browse through Suggestions | Read an article from the Knowledge Base |
| ------ | ----- |
![suggestions](http://c.hlp.sc/1g2i292U470M/download/suggestions.png)|![article](http://c.hlp.sc/280630171d0U/download/article.png)|

| Start and reply to Help Scout conversations | Visit Conversation history |
| ------ | ----- |
![reply](http://c.hlp.sc/3s1K0W1m2135/download/send_message.png)|![prev](http://c.hlp.sc/2R0t0r0f1m2e/download/previous.png)|

### Customization

The Beacon SDK allows for some customization of it's color and text. We've made public a number of color and text
resources that will make it easy for you to add the look and feel of your own brand. Overriding any of these
values, you'll get the desired result.

Head over to the [sample project that shows color customization](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-customisation) to get you started.

#### Colors

```xml
<color name="hs_beacon_colorPrimary">@color/primary</color>
<color name="hs_beacon_colorPrimaryDark">@color/primary_dark</color>
<color name="hs_beacon_colorAccent">@color/accent</color>
```

These three colors work the same way as their counterparts in `AppCompat`. By overriding
the desired values you'll be able to customize the color values in the SDK.

#### Strings

Same goes for strings, there are a number of texts that can be overriden:

```xml
<string name="hs_beacon_toolbar_title">My new title</string>
<string name="hs_beacon_suggestions_header_title">My new header</string>
<string name="hs_beacon_search_hint">My new search hint</string>
```

## Implementing your own User Interface

If all you are looking to do is to expose the knowledge database of articles, the Public API mode is your best bet.
We have provided you with a `Repository` (you can read more about this pattern [here](https://msdn.microsoft.com/en-us/library/ff649690.aspx). You'll only need to include the `core` dependency.

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

There's also a demo project that [shows how to build your own](https://github.com/helpscout/beacon-android-sdk-sample/tree/master/sample-core) User Interface

## Permissions

The Beacon SDK only needs Internet permission which is defined in the Core module.
