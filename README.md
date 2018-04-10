# DV Media Player
The application is a Media Player which contains basic features such as Play/Pause, Stop, Full Screen Mode, Loop, Shuffle, Saving and Loading the Songs etc…

Technologies Used: ```Java, JavaFx and CSS```.

## Getting Started

### Prerequisites
- Software Used: **IntelliJ IDEA 2017.3.5 (Community Edition)**
- Dependencies: **Jdk 1.8** or above, it has inbuilt JavaFx support

### Importing the project
-	In IntelliJ IDEA IDE select ```FILE>OPEN```
-	In dialog box enter path (eg ```C:\Users\XXXX\Desktop\Java\JavaFx\DV Player```)

The project is ready to be executed!

### Configuring the project
- In the IDE on top right corner click **Edit Configurations**.
- In the dialog box write ```sample.Main``` in Main class.

![alt text](https://github.com/deva101/Media-Player/blob/master/Info/ScreenShot/Configure.jpg)

Click OK and Run the project

### Running the application
- First of all set the ```path``` manually in **Controller.java** file line number **75**.
![alt text](https://github.com/deva101/Media-Player/blob/master/Info/ScreenShot/Run.jpg)

- Then click ‘Shift + F10’ to run the application.


## Main Application
![alt text](https://github.com/deva101/Media-Player/blob/master/Info/ScreenShot/App.jpg)

### Functionalities

  Menu Bar
  - Media:
    - Open: Open Multiple Files
    - Save: Save current playlist to ‘playlist.ser’ file
    - Load: Load saved playlist
    - Close: Close the application
  - Help
    - About: about the application

  - Bottom Pane:
    - Play/Pause toggle button
    - Previous Video
    - Stop Video
    - Next Video
    - Maximize Screen
    - Songs Playlist
    - Loop current song or not
    - Randomize the songs
    - Volume Control

  - Shortcuts:
    - ‘M’: Mute the audio
    - ‘{‘: reduce rate of song
    - ‘}’: increase rate of song
    - ‘F’ or double click: Maximize the screen

Playlist

![alt text](https://github.com/deva101/Media-Player/blob/master/Info/ScreenShot/Playlist.jpg)

About

![alt text](https://github.com/deva101/Media-Player/blob/master/Info/ScreenShot/About.jpg)
