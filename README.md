# QRCodeApplication
A QR code generator and scanner application with journeyapp and zxing libraries.


implementation('com.journeyapps:zxing-android-embedded:3.6.0') { transitive = false } 
implementation 'com.google.zxing:core:3.3.0'

I used these two libraries to make a Qr code generator and a Qr code scanner. Codes can be easily implemented to any project.
In this project my goal was to be able to show scanned data in another activity and I made some customizations, like can be scanned
at most 5 codes.
