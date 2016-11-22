# Demo Application

The library contains a demo application. This application continuously switches
between six different colors until it terminates. Each colour changes is logged to
the console like this

    INFO  [main] LedBorgDemo  - Setting color java.awt.Color[r=0,g=0,b=255]
    INFO  [main] LedBorgDemo  - Setting color java.awt.Color[r=0,g=255,b=255]
    INFO  [main] LedBorgDemo  - Setting color java.awt.Color[r=255,g=0,b=255]
    INFO  [main] LedBorgDemo  - Setting color java.awt.Color[r=255,g=200,b=0]
    INFO  [main] LedBorgDemo  - Setting color java.awt.Color[r=255,g=255,b=0]
    INFO  [main] LedBorgDemo  - Setting color java.awt.Color[r=255,g=0,b=0]

For proper execution super user privileges may be required. If those ones are missing
you will see an output similar to

    wiringPiSetup: Unable to open /dev/mem: Permission denied
    Exception in thread "main" java.lang.RuntimeException: Unable to open GPIO direction interface for pin [0]: Permission denied
        at com.pi4j.wiringpi.GpioUtil.export(Native Method)
        at com.pi4j.io.gpio.RaspiGpioProvider.export(RaspiGpioProvider.java:67)
        at com.pi4j.io.gpio.impl.GpioPinImpl.export(GpioPinImpl.java:165)
        at com.pi4j.io.gpio.impl.GpioControllerImpl.provisionPin(GpioControllerImpl.java:520)
        at com.pi4j.io.gpio.impl.GpioControllerImpl.provisionPin(GpioControllerImpl.java:499)
        at com.pi4j.io.gpio.impl.GpioControllerImpl.provisionDigitalOutputPin(GpioControllerImpl.java:651)
        at com.pi4j.io.gpio.impl.GpioControllerImpl.provisionDigitalOutputPin(GpioControllerImpl.java:661)
        at de.freitag.stefan.ledborg.LedBorg.setupGpio(LedBorg.java:63)
        at de.freitag.stefan.ledborg.LedBorg.setup(LedBorg.java:47)
        at de.freitag.stefan.ledborg.demo.LedBorgDemo.main(LedBorgDemo.java:27)
