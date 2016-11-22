# LedBorg Project

The [LedBorg](https://www.piborg.org/ledborg) is an ultra bright RGB LED add-on board for my Raspberry Pi. For this board I decided to write a small Java
library. For controlling the LedBorg from a remote machine I added a [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) interface.

Hence the project is split into three parts:

  1. borg-core: Contains the library itself
  2. borg-demo: Contains demo application
  3. borg-rest: Offers access to the library via REST


## Changes
* Version 1.5
  * Restructuring of project 
* Version 1.4
  * Added LedBorg interface.
  * Added LedBorg dummy implementation.
* Version 1.3
  * Added support for darken/ brighten the LedBorg.
* Version 1.2
  * Added support for blinking LedBorg.
  * Added logging support.
