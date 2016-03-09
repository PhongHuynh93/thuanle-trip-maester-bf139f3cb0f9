# Usecases

## Introduction

This document describes all usecases of the Trip Maester. Here is the list of Usecases:

 ID    |  Group         | Name 
-------|----------------|------
 UC001 | Authentication | Login
 UC002 | Authentication | Logout
|||
 UC051 | Configuration  | Change app settings
 UC052 | Configuration  | Change the map layer
|||
 UC101 | Trip           | Create new trip
 UC102 | Trip           | View my trips
 UC103 | Trip           | Edit a trip
 UC104 | Trip           | Invite friend to current trip
 UC105 | Trip           | Follow a friend
|||
 UC151 | Location       | Navigate to current location
 UC152 | Location       | Report location status
 UC153 | Location       | Capture photo at a location
 UC153 | Location       | Capture note at a location
|||
 UC201 | Search         | Search
|||
 UC251 | Social         | Displayed nearby friends
 UC252 | Social         | View friends trips
 UC253 | Social         | Like friends trips
 UC254 | Social         | Comment on a trip
 UC255 | Social         | Invite friends to use app
 UC256 | Social         | Share a trip on social network
 UC257 | Social         | Add friend to a favorite list


## Details

### 000 - Authentication

#### UC001.Login

| | |
|-|-|
| Actors            | User 
| Preconditions     | User is not logined 
| Basic flows       | 1. User open left navigation menu. 
|                   | 2. User tap on **Login** button.
|                   | 3. User login via Facebook.
|                   | 4. User authorizes Facebook to login.
|                   | 5. User logined. 
|                   | 6. Profile picture is displayed on navigation menu.
|||
| Alternative flows | 4.a. User does not grant privilege permission.
|                   | 4.a.1 The app displays message show error to user.
|||
| Alternative flows | 5.a. User does not have account yet.
|                   | 5.a.1. Create an account for user.
|                   | 5.a.2. User logined. 
|                   | 5.a.3. Profile picture is displayed on navigation menu.

#### UC002.Logout

| | |
|-|-|
| Actors            | User 
| Preconditions     | User logined.
| Basic flows       | 1. User open left navigation menu. 
|                   | 2. User tap on **Settings** button. The app navigate to Setting screen.
|                   | 3. User tap on **Logout** button.
|                   | 4. Confirm message is shown.
|                   | 5. User chooses **Logout**. 
|                   | 6. The login token is clear.
|||
| Alternative flows | 5.a. User chooses **Cancel**. The app returns to **Settings** Screen.

### 050 - Configuration

#### UC051.Change app settings

| | |
|-|-|
| Actors            | User 
| Basic flows       | 1. User open left navigation menu. 
|                   | 2. User tap on **Settings** button.
|                   | 3. User can change the settings.
|                   | 4. The settings applied immediately.
|||
| Alternative flows | 3.a. User can change the **Routing Method**.
|||
| Alternative flows | 3.b. User can change the **Nofitication** settings.
|||
| Alternative flows | 3.c. User can change the application **Language**.
|                   | 3.c.1. A dialog displayed the available language.
|                   | 3.c.2. User choose a language.
|                   | 3.c.3. The application will changed the language.


#### UC052.Change the map layer

| | |
|-|-|
| Actors            | User 
| Basic flows       | 1. User open left navigation menu. 
|                   | 2. User can change the settings on drawer menu.
|                   | 3. The settings configuration will be updated immediately.
|||
| Alternative flows | 2.a. User can change the **Transportation Method**.
|                   | 2.a.1. The corresponding layers will be displayed and updated.
|||
| Alternative flows | 2.b. User can choose to display the **Traffic Info** layer.
|                   | 2.b.1 The corresponding layers will be displayed and updated.
|||
| Alternative flows | 2.c. User can choose to display the **Warning Info** layer.
|                   | 2.c.1 The corresponding layers will be displayed and updated.


### 100 - Trip

#### UC101.Create new trip

| | |
|-|-|
| Actors            | User 
| Preconditions     | User logined 
| Basic flows       | 1. 
|                   | 2. 
|                   | 3. 
|                   | 4. 
|                   | 5. 

### 150 - Location 

#### UC151.Navigate to current location

#### UC152.Report location status



### 200 - Search
#### UC201.Search


