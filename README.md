Network Interface
=================

Network interface information plugin for Cordova/PhoneGap that supports Android, Blackberry 10, iOS, and Windows Phone 8.

## PhoneGap Build

To include the Network Interface plugin in your PhoneGap Build application, add this to your config.xml:

    <gap:plugin name="cordova-plugin-networkinterface" source="npm" />

## Command Line Install

    cordova plugin add cordova-plugin-networkinterface

## Usage (iOS, Android)

The plugin creates the object `networkinterface` with the method `getIPAddress(onSuccess, onError)`.

Example:

	networkinterface.getIPAddress(function (ips) { alert(ips); });

The result contains a JSON Array of IPs.

iOS:

```js
[
  {
    adapter: "en0", // wifi
    ip: "1.2.3.4"
  },
  {
    adapter: "pdp_ip0", // cellular
    ip: "1.2.3.4"
  },
  ...
]
```

Android:

```js
[
  {
    adapter: "wlan0", // wifi
    ip: "1.2.3.4"
  },
  {
    adapter: "rmnet0", // cellular
    ip: "1.2.3.4"
  },
  ...
]
```

## License

The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
