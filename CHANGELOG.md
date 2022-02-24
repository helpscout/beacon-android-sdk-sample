Change Log
==========


Version 4.0.1 *2022-02-24*
----------------------------
* We now check for available agents before creating a new chat. If no agents are available, we redirect to the contact form.

Version 4.0.0 *2022-01-17*
----------------------------

Bug fixes: 
* The email contact form is now correctly reset after calling `Beacon.contactFormReset()` [#163](https://github.com/helpscout/beacon-android-sdk-sample/issues/163)
* We've improved the transition animation when exiting a contact-only Beacon [#129](https://github.com/helpscout/beacon-android-sdk-sample/issues/129)
* We've further polished the Article screen to resolve the clipping issue with the bottom of the article being cut off after a rating is left  [#115](https://github.com/helpscout/beacon-android-sdk-sample/issues/115)

:warning: Breaking changes :warning:

* We've updated some of the language and platform requirements when using the Beacon Android SDK. This addressed [#173](https://github.com/helpscout/beacon-android-sdk-sample/issues/173)
    * Target Android SDK 31 (Android 12)
    * Java 11 
    * Kotlin 1.5
 
* The `showGetInTouch` option has been retired from the available [Contact Form Options](https://developer.helpscout.com/beacon-2/android/#contact-form-options) now that Focus Mode will allow developers to accomplish the same behavior.


Version 3.0.2 *(2021-05-18)*
----------------------------
- We've fixed a crash that occurs when opening a Beacon when host app is compiled using Kotlin 1.5 [#170](https://github.com/helpscout/beacon-android-sdk-sample/issues/170)

Version 3.0.1 *(2021-04-06)*
----------------------------
**Internal changes - No user impact**
- We have completely removed any reference to `jcenter()` by moving to a beta version of Koin – the library we use for dependency injection – that's published in Maven Central [#159](https://github.com/helpscout/beacon-android-sdk-sample/issues/159)

Version 3.0.0 *(2021-03-30)*
----------------------------
The SDK is now published to Maven Central instead of JCenter/Bintray.
No functional changes have been introduced.

:warning: **Breaking changes** :warning:

The library has been renamed from `beacon-ui` to `beacon`. Please, update your `build.gradle` file to match this change:
```
repositories {
    mavenCentral()
    …
}

dependencies {
    implementation "com.helpscout:beacon:3.0.0"
}
```

Version 2.3.3 *(2021-02-25)* 
----------------------------
**Fixes**
- Push notifications now subscribe correctly when sending a new message or replying. This fixes a regression issue introduced in 2.1.0. If you are using push notifications we strongly recommend upgrading to 2.3.3.

Version 2.3.2 *(2021-01-19)* 
----------------------------
**New**
- You can now open your Beacon directly to the Ask screen [#108](https://github.com/helpscout/beacon-android-sdk-sample/issues/108)
- Proguard optimize rules are now supported [#125](https://github.com/helpscout/beacon-android-sdk-sample/issues/125) 
- We are now using Kotlin 1.4. 

**Fixes**
- Chats will only allow keyboard-based GIFS/sticker attachments when a chat is in progress if the "Allow Attachments" setting is enabled. 
- The previous conversations button is now displayed when using secure mode and custom navigation. [#151](https://github.com/helpscout/beacon-android-sdk-sample/issues/151) 
- Improved the visibility of the send button on the Contact form. [#140](https://github.com/helpscout/beacon-android-sdk-sample/issues/140)
- Contact form drafts are now only saved when the user has changed the data; so, programmatic calls to prefill the form data when no user input has occurred will fill in the form data as expected. [#114](https://github.com/helpscout/beacon-android-sdk-sample/issues/114)

Version 2.3.1 *(2020-12-21)* 
----------------------------
**Fixes**
- Vimeo videos can now be embedded and played back within Articles[#147](https://github.com/helpscout/beacon-android-sdk-sample/issues/147)

Version 2.3.0 *(2020-11-25)* 
----------------------------
**New!**
- Want to know how customers experienced chatting with you? Beacon for Android now includes chat ratings! You’ll be able to get immediate feedback from your customers on how their conversation went with your team. [Learn more](https://docs.helpscout.com/article/1396-chat-satisfaction-ratings).

**Fixes**
- The close button no longer appears to terminate the host app. [#131](https://github.com/helpscout/beacon-android-sdk-sample/issues/131)
- Smoother transition when opening straight to an Article detail. [#113](https://github.com/helpscout/beacon-android-sdk-sample/issues/113)
- Removed opt-out of Firebase Analytics as it was disabling these events for the host project if not explicitly enabled. [#146](https://github.com/helpscout/beacon-android-sdk-sample/issues/146)
- Session attributes are now visible in Help Scout after creating a chat.
- The `SuggestedArticle` class was not accessible and prevented `Beacon.setOverrideSuggestedArticlesOrLinks()` from working. You can provide article suggestions by providing either Article IDs or custom links again.
- We stopped ProGuard from obfuscating some method parameters.
- Other bug fixes and performance improvements

Version 2.2.2 *(2020-09-24)* 
----------------------------
* We fixed a crash when starting `BeaconActivity` caused by a third-party library that we use internally – [Koin](https://github.com/InsertKoinIO/koin) – when using Kotlin version 1.4.x. We decided to use a beta version of  Koin to prevent the application from crashing. Please, let us know if you run into any issues. [#124](https://github.com/helpscout/beacon-android-sdk-sample/issues/124)
* Users will no longer experience a crash when starting `BeaconActivity` when the `targetSdk` is `30` due to some checks a third-party dependency – [OkHttp](https://square.github.io/okhttp/) – did during start up. [#132](https://github.com/helpscout/beacon-android-sdk-sample/issues/132)
* We fixed a crash when opening the `ArticleActivity` when the host application set a fixed orientation, and the user's device was running **Android 8.0**. [#133](https://github.com/helpscout/beacon-android-sdk-sample/issues/133)
* Users who have an active chat and open the `ChatActivity`  will no longer experience a crash when updating to a newer SDK version. This crash only impacted users if the SDK version in use is 2.1.2 or below. [#134](https://github.com/helpscout/beacon-android-sdk-sample/issues/134)
* Improved the user experience when starting a new conversation and replying to it. [#135](https://github.com/helpscout/beacon-android-sdk-sample/issues/135)
* Beacon color settings are now correctly set when a user with an active chat updates the SDK.

Version 2.2.1 *(2020-09-09)* 
----------------------------
* We now support opening hyperlinks to Articles contained in previous conversations in Beacon rather than a separate browser.
* We fixed a bug that prevented the push token from being registered for realtime chat when calling `Beacon.identify()` .
* Minor UI polish.

Version 2.2.0 *(2020-08-27)* 
----------------------------

* We now support anchor links within docs articles. [#101](https://github.com/helpscout/beacon-android-sdk-sample/issues/101) [#116](https://github.com/helpscout/beacon-android-sdk-sample/issues/116)  
* You can disable access to previous messages with a local override.

Breaking changes 

* We have merged the `beacon-core` module into the `beacon-ui` module. Please remove the `beacon-core` module from your `build.gradle` file as it may cause compatibility issues.

Bug Fixes:

* Beacon will now skip opening the ask chooser when chat is disabled on your Beacon. [#95](https://github.com/helpscout/beacon-android-sdk-sample/issues/95) 
* Fixed article links within the Beacon activity note, so they now open the article. [#110](https://github.com/helpscout/beacon-android-sdk-sample/issues/110)
* Users are now returned to the previously active ask screen when using Android's back button [#100](https://github.com/helpscout/beacon-android-sdk-sample/issues/100). 
* Added visual polish to the chat header, push notifications, and the "home to chat" transition.
* Fixed several memory leaks


Version 2.1.2 *(2020-07-30)* 
----------------------------

* We now support anonymous chats. To enable, uncheck email required on the Beacon builder contact options.
* It's now possible for users to rate Docs articles. 
* Updated the UI when displaying an invalid email message in chat.
* Added animations when the Beacon is loaded, transitioning to chat or contact form, and when you rate an article.
* We've given the message, conversations, and reply screens a fresh new look.
* Conversations with over 20 threads are now collapsed by default, allowing users to focus on the most recent messages. 

Bug Fixes:

* Fixed a crash with `PreFilledForm` when the host app uses Moshi Kotlin. Resolves [#91](https://github.com/helpscout/beacon-android-sdk-sample/issues/91) 
* We've updated to the latest version of PhotoView and removed the external dependency. There's no longer a need to add JitPack to your repositories. Resolves [#87](https://github.com/helpscout/beacon-android-sdk-sample/issues/87)
* Resolved an issue with state restoration on the Message form when the Developer setting "don't keep activities" is enabled. Resolves [#83](https://github.com/helpscout/beacon-android-sdk-sample/issues/83)
* Fixed a issue where links were not actionable via Previous Messages [#93](https://github.com/helpscout/beacon-android-sdk-sample/issues/93)
* Fixed the upgrade issue found in version 2.1.1



Version 2.1.1 *(2020-06-01)* - _Removed_
----------------------------

* We discovered a regression issue when upgrading from Beacon SDK below version 2.0.2 directly to 2.1.1. Therefore removed 2.1.1 and aim to resolve this issue in the next release. Please use 2.1.0 in the mean time, thank you for your patience.  


Version 2.1.0 *(2020-04-21)*
----------------------------

* New visually redesigned landing page with Answers and Ask tabs.
* Now supports Focus mode - see [Settings Customization](https://developer.helpscout.com/beacon-2/android/#settings-customization)


Version 2.0.3 *(2020-03-11)*
----------------------------

* Fixed a crash when manually initializing the Beacon [#79](https://github.com/helpscout/beacon-android-sdk-sample/issues/79) 
* Other bug fixes and performance improvements


Version 2.0.2 *(2020-01-14)*
----------------------------

* Added support for special attributes on the Help Scout customer profile: avatar, company, and job title. See the new method, `Beacon.identify(email, name, company, jobTitle, avatar)`.
* Tapping on images within a Chat now enlarges them.

Breaking changes:
Due to an update in the [OKHttp dependency](https://cashapp.github.io/2019-02-05/okhttp-3-13-requires-android-5), your app needs to define both sourceCompatibility and targetCompatibility to Java 1.8. Your app's build.gradle file should appear as follows:
```
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}
```

Bug Fixes:

* Better client-side handling of the attachment limit (20) for real-time chats
* Fixed an issue with the Up/Back button when using a Contact-only Beacon [#75](https://github.com/helpscout/beacon-android-sdk-sample/issues/75)


Version 2.0.1 *(2019-12-16)*
----------------------------

Bug Fixes:

* This release includes a fix to prevent a crash when using _non-image_ attachments in Chat.
* We've reduced visibility of an internal API, `Beacon.datastore()`. This is to prevent accidental usage which may result in the SDK getting into an unknown state.


Version 2.0.0 *(2019-12-10)*
----------------------------

Breaking changes:

* Added email to Pre-filled form. 
* See [2.0.0-beta](https://github.com/helpscout/beacon-android-sdk-sample/blob/5e1f6aae61d086838f1abc6cb0b4831d1fa53654/CHANGELOG.md#version-200-beta-2019-11-21) for more breaking changes. 

Behavior change: 

* Pre-filled content for the contact form is cleared after a successful send.  

Bug Fixes:  
 
* Removed Beacon SDK use of Koin's global scope to fix issues for host apps using Koin.   
* Reduced visibility of Beacon SDK's Kotlin extensions. [#70](https://github.com/helpscout/beacon-android-sdk-sample/issues/70)
* Removed com.commonsware.cwac.document repo dependency. [#73](https://github.com/helpscout/beacon-android-sdk-sample/issues/73)
* Fixed issue where users could initiate a chat via Beacon.navigate() method when no agents are available.                             
                       

Special thanks to @sipersso for raising these issues.


Version 2.0.0-beta *(2019-11-21)*
----------------------------

* Live chat - Now customers can start a chat from your app on their Android device, accessing great support no matter where they are. 

Breaking changes: 

* Migrate to AndroidX - The Beacon SDK dependencies have been migrated to use Google's AndroidX libraries. This removes the need to use Jetifier and should speed up your build process. To update your app to use AndroidX follow the instructions in [Migrating to AndroidX](https://developer.android.com/jetpack/androidx/migrate).     

Bug Fixes:
* Remove `@GlideModule` class as it causes a clash if the host app also uses Glide
* Fixed issue where email used wasn't updated when changed on contact form [#67](https://github.com/helpscout/beacon-android-sdk-sample/issues/67)
 

Version 1.0.9 *(2019-11-07)*
----------------------------
* Session Attributes: You are now able to include session-specific information on new messages. [Check out our docs for more details](https://developer.helpscout.com/beacon-2/android/#session-attributes).

Bug Fixes: 

* Removed Stetho dependency [#64](https://github.com/helpscout/beacon-android-sdk-sample/issues/64)
* Remapped some mobile-only translation strings to use Beacon Builder strings
* Beacon SDK 3rd party dependencies are now private (moved `api` to `implementation`) to avoid conflicts in host apps [#66](https://github.com/helpscout/beacon-android-sdk-sample/issues/66)  


Version 1.0.7 *(2019-10-01)* & 1.0.8 *(2019-10-10)*
----------------------------
* Behind the scenes updates for up and coming real-time chat beta


Version 1.0.6 *(2019-09-19)*
----------------------------

* Added a navigate option to allow you to open the Beacon directly to Previous Messages or Chat (beta coming soon)
* It is now possible to hide custom fields that you've pre-filled using the `Beacon.showPrefilledCustomFields(false)` 

Bug Fixes:

* Edited obfuscation config due to incompatibility with Firebase perf monitoring [#62](https://github.com/helpscout/beacon-android-sdk-sample/issues/62) 
* Fixed bug added in 1.0.5. Crash with message parameter chat should be non-null [#60](https://github.com/helpscout/beacon-android-sdk-sample/issues/60) 

Version 1.0.5 *(2019-08-07)*
----------------------------

Bug Fixes:

* Fix crash when using an app name in Chinese [#57](https://github.com/helpscout/beacon-android-sdk-sample/issues/57)
* Fix an issue with Koin library crashing Roboelectric tests [#59](https://github.com/helpscout/beacon-android-sdk-sample/issues/59)

**Note**: We removed support for right-to-left layouts, if you support it in your app please use `tools:replace="android:supportsRtl"` in your Manifest. For more information check the samples apps.

Version 1.0.4 *(2019-07-31)*
----------------------------

Bug Fix:

* Fix to issue loading suggested article external links


Version 1.0.3 *(2019-07-08)*
----------------------------

API change:
* Removed static modifier from `BeaconPushNotificationsProcessor.process()` method. `BeaconPushNotificationsProcessor.process(..)` becomes `new BeaconPushNotificationsProcessor().process()`.  

Bug Fixes:

* Improved typing performance on the Reply screen
* Updated CSS for Articles

Version 1.0.2 *(2019-06-01) Internal only release*
----------------------------

* Refactor to use Koin 2.0


Version 1.0.1 *(2019-04-11)*
----------------------------

Bug Fixes:

* Added meta data flag to ensure Firebase Analytics (that we do not use but is automatically included by Firebase Cloud Messaging) doesn't collect the Android Advertising ID
* The order of open articles is retained when rotating screen
* Agents avatars on previous conversations now display the correct agents
* Coloured the Agent avatar circle to match the Beacon color if no photo available
* When showing dates from previous years ensure the year is shown
* Fixed a cache bug when having multiple Beacons on the same application


Version 1.0 *(2019-03-11)*
----------------------------


* Android Beacon always prompts for the customer's name and email unless provided by the developer using `Beacon.login("some@email.com", "Name")`
* Developers can specify custom suggested articles and URLs via the new `setOverrideSuggestedArticlesOrLinks()` method.

Bug Fixes:

* The Send Message toolbar could be pulled down after a successful message was sent
* An animation bug when the Send Message toolbar was swiped-up too quickly
* The back arrow now is now correctly visible when viewing the Previous Conversations screen after a message was successfully sent 
* Navigation bugs during article search and viewing previous conversations

Version 0.3.1 *(2019-02-27)*
----------------------------

* We now support device rotation 🎉

Bug Fixes:

* Crash when Article preview was blank
* [#36](https://github.com/helpscout/beacon-android-sdk-sample/issues/36) Crash when loading conversation if any of the conversation threads was missing a creator. 
* Contact us FAB was incorrectly shown on the search error screen
* Hyperlinks in conversation body are now converted to clickable links
* Tweak to text color formula to match web/iOS
* Crash on some devices running Android version <5.0 (unsupported)


Version 0.3.0 *(2019-02-04)*
----------------------------

* Prefill attachments 

Bug Fixes:

* You can now correctly override the `messageEnabled` and `docsEnabled` flags on your Beacon
* [#33](https://github.com/helpscout/beacon-android-sdk-sample/issues/33) Fixed crash when launching BeaconActivity with Context rather than Activity
* [#36](https://github.com/helpscout/beacon-android-sdk-sample/issues/36) Fixed crash when `lastThread` is null on `ConversationsAdapter`
* [#39](https://github.com/helpscout/beacon-android-sdk-sample/issues/39) Fixed button coloring in low contrast conditions
* [#39](https://github.com/helpscout/beacon-android-sdk-sample/issues/39) Fixed white message icons on white backgrounds
* [#39](https://github.com/helpscout/beacon-android-sdk-sample/issues/39) Fixed back/navigate up button to have the correct Android design (use arrow_back, not keyboard_backspace)

Version 0.2.9 *(2019-01-18)*
----------------------------

* Suggested articles can now be overridden by the SDK
* Beacon Open and Close Event listeners - ideal for analytics to track when Beacon is used
* Contact form draft is now persisted so users can exit the Beacon and their draft message is restored when they resume their message. There's also a `contactFormReset()` so if you want it to reset and remove the draft.
* Image attachments now show a preview of the image instead of an icon.
* Push notifications are grouped by conversation, instead of getting new ones.

Bug fixes:

* Related articles now correctly escaping HTML
* Change to the way activities are launched to prevent multi copies of Home/Suggestions screen being loaded
* Attachment button disabled once the limit of 3 reached.
* The We're on it tick/circle now matches your Beacon color
* The message text area expands to the bottom of the view on the contact screen to give more space for message text
* New attachment icons to match the file extension type

Version 0.2.8 *(2018-12-13)*
----------------------------

* Beacon Builder Config overrides
* UI string overrides based on Strings set in Beacon Builder
* Compatibility with host projects using support lib 28 and AndroidX

Bug fixes:

* Push notifications token registration API (re-order of the API calls)
* Fixed color of hyperlinks in previous message details
* Corrected issue where file extensions were missing from files picked from Android media folders
* Clear DeviceId/Install Id on Logout
* Back arrow was not tinted according to text contrast colour
* Support null/missing previous message subject


Version 0.2.7 *(2018-11-21)*
----------------------------

* New options to Open Beacon UI straight to the contact form, search results or specific article
* Beacon UI color is now taken from the server defined Beacon color (local override coming in next version)
* Email input is now inline with other contact form fields rather than separate UI to match JS SDK

Bug Fixes

* Fixed crash when downloading an attachment without a file extension.  
* Removed `DisableableAppBarLayoutBehavior` which was causing issues when using different Android support library dependencies

Version 0.2.6 *(2018-10-31)*
----------------------------
Bug Fixes

* Fixed user attributes not shown on the first message a brand new user sends
* Fixed crash when scrolling through conversations
* Fixed crash when trying to attach some invalid extensions to a conversation or draft

Version 0.2.5 *(2018-10-19)*
----------------------------

* Initial Push notifications support via FCM.  Note server side UI not available at this time.  
* Support for pre filled contact form (name, subject, message) `Beacon.addPreFilledForm(..)`
* Local override to disable the contact form `Beacon.setOverrideMessagingEnabled(false)`
* Error screen for invalid beacon config
* Increased limit of user attributes permitted from 10 to 30
* Added Client-side validation for blacklisted attachment types


Bug Fixes

* Fixed issue where the Toolbar wasn't auto updating it's text color when `@color/hs_beacon_colorPrimary` was overridden in host app.
* Corrected issue with User Attributes upload, which were only being uploaded to API when using secure mode. Fixed to also support basic mode.
* Send a message FAB not working - https://github.com/helpscout/beacon-android-sdk-sample/issues/17
* Internal repository invalid beacon fix -  https://github.com/helpscout/beacon-android-sdk-sample/issues/16
* Error handling when registering Push token
* Clearing of user attributes on Logout

Version 0.2.4 *(2018-07-2)*
----------------------------

* Removed Moshi's Kotlin Type adapter to fix support for ProGuard in host app
* Previous messages list and message threads now load additional pages via infinite scrolling lists
* Message replies are now permitted with blank message if an attachment is present


Version 0.2.3 *(2018-06-26)* - _Deprecated_
----------------------------

Deprecated due to issue with 3rd party dependancy (Moshi's Kotlin Type adapter) preventing host app from using PorGuard.


* Draft support for message replies
* Support for HTTP caching of API responses
* Several minor UI fixes when in landscape mode
* Limit name & subject fields length on the Send a message form to match Web
* Hide avatar instead of displaying initials if image not present to match Web
* Fix Article CSS loading bug on Android 5
* Optimised search result handling to prevent unnecessary API call to get more results when none exist

Version 0.2.2 *(2018-06-19)*
----------------------------

* Fix screen flick after opening an article with related articles
* Added loading spinner before article loads
* Limited attachments to a total of 3, matching web-embed
* Fixed a bug that allowed a message to be sent before an attachments was fully uploaded  

Version 0.2.1 *(2018-06-12)*
----------------------------

* Fix regression error when loading conversations with chat transcripts
* Show avatar placeholder image on enter email screen  


Version 0.2.0 *Public BETA release*  *(2018-06-11)*
----------------------------

* Enable/Disable Send button depending on Form validation state
* Replace Listviews with Recycler views
* Load all the pages of search, conversations and conversation threads
* Truncate preview text on conversations list
* Use plurals for dates
* allow full name to be set via login method
* fix hyperlinks on conversations  
