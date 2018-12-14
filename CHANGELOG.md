Change Log
==========

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
