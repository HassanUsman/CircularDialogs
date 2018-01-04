# CircularDialogs [![Build Status](https://travis-ci.org/hypeapps/MaterialTimelineView.svg?branch=master)](https://travis-ci.org/hypeapps/MaterialTimelineView) [![Download](https://api.bintray.com/packages/hypeapps/maven/MaterialTimelineView/images/download.svg)](https://bintray.com/hypeapps/maven/MaterialTimelineView/_latestVersion)  [![Platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com) 

CircularDialogs is custom Android dialog library to give user feedback about the common operations like Success, Warning and Errors. You can easily use the it by adding the dependency to your gradle file. It allows you to make beautiful dialogs with just few lines of code. You can choose from the predefined entry and exit animations. You can use lot of options as discussed below:

## Screenshots 

![Alt text](https://media.giphy.com/media/26FeUOgHGdlqK5b6E/giphy.gif "Succes")
![Alt text](https://media.giphy.com/media/d47I14DOMBgSt4tO/giphy.gif "Error")
![Alt text](https://media.giphy.com/media/xUNd9R5AkswC22VCs8/giphy.gif "Error")

## Add Gradle dependency 

Add it in your root build.gradle at the end of repositories:


```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```
Add the dependency

```
  dependencies {
	        compile 'com.github.hassanusman:CircularDialogs:1.2'
	}
  
```

### Example


```
new CDialog(this).createAlert("You missed something",
                CDConstants.WARNING,   // Type of dialog
                CDConstants.LARGE)    //  size of dialog
                .setAnimation(CDConstants.SCALE_FROM_BOTTOM_TO_TOP)     //  Animation for enter/exit  
                .setDuration(2000)   // in milliseconds
                .setTextSize(CDConstants.LARGE_TEXT_SIZE)  // CDConstants.LARGE_TEXT_SIZE, CDConstants.NORMAL_TEXT_SIZE
                .show();
```    

### Options Available

Here are the different customizations that you can use to make things look different.

For Animations
```   
     CDConstants.SCALE_FROM_BOTTOM_TO_TOP, CDConstants.SCALE_FROM_RIGHT_TO_LEFT, 
      // Bottom and top can be exchanged as well as right to left.
     // Like scale you can also use SLIDE animation just replace SLIDE with SCALE.
     CDConstants.SLIDE_FROM_BOTTOM_TO_TOP
 ```    
 TextSize
 ```
    setTextSize(CDConstants.NORMAL_TEXT_SIZE | CDConstants.LARGE_TEXT_SIZE);
    // NOTE: If you give any other value it won't work always use these two values only.
    
 ```
 Duration
 
 You can give duration in milliseconds. If you don't give duration dialog will close after user tap on the screen.
 ```
    .setDuration(2000)   // in milliseconds
 
 ```
 
 Dialog Type
 
 Right now only three types of dialogs are supported CDConstants.SUCCES, CDConstants.WARNING and CDConstants.ERROR.
 see the top example for usage.
 
 ### Use your own icon
 
 You can use your own icons if you want. Here is the way :
 
 ```
    CDialog createAlert(String message,Bitmap icon,int alertType,int size);        // using Bitmap
    CDialog createAlert(String message,Drawable icon,int alertType,int size);       // Using Drawable
 
    // Everything will be same just parameters are changed.
 ...
 ```
 
 ## Maintainer
[![HassanUsman](https://avatars0.githubusercontent.com/u/10232094?v=4&s=40) HassanUsman](https://github.com/HassanUsman)  

