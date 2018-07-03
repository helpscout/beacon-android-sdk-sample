Change Log
==========

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
