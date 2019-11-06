Change Log
==========

Version 1.0.9 *(2019-11-07)*
----------------------------
* Session Attributes: You are now able to include session-specific information on new messages. [Check out our docs for more information](https://developer.helpscout.com/beacon-2/android/#session-attributes).

Bug Fixes: 

* Removed Stetho dependency [#64](https://github.com/helpscout/beacon-android-sdk-sample/issues/64).
* Remapped some mobile-only translation strings to use Beacon Builder strings.
* Beacon SDK 3rd party dependencies are now private (moved `api` to `implementation`) to avoid conflicts in host apps [#66](https://github.com/helpscout/beacon-android-sdk-sample/issues/66).  


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
