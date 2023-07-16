# RunApp Android App

https://github.com/Asnvir/RunApp/assets/51398263/c12b5b2a-51f3-4625-9e7b-de9affa8a291

## Overview

RunApp is an Android application that allows users to track and manage their running activities. The app leverages various technologies and libraries to provide a seamless experience for runners of all levels. With RunApp, users can view their running routes on Google Maps, monitor their progress through intuitive charts, store their data in a Room database, and much more. This README will guide you through the features, technologies used, and how to set up the project.

## Features

- **Google Maps Integration:** Display the user's running routes on Google Maps, providing a visual representation of their activities.

- **MVVM Pattern:** The app follows the Model-View-ViewModel architectural pattern, promoting separation of concerns and maintainability.

- **Dagger Hilt:** Utilizes Dagger Hilt for dependency injection, ensuring a modular and scalable codebase.

- **Glide:** Efficiently load and display images, such as user avatars or images associated with running activities.

- **Easy Permissions Library:** Simplify the process of requesting and handling runtime permissions required by the app.

- **Room Database:** Persistently store running activities, enabling users to view their history and track progress over time.

- **MPAndroidChart:** Present users with intuitive and interactive charts to visualize their running statistics and progress.

- **Fragments:** Organize the app's UI into fragments, promoting reusability and a responsive user experience.

- **Navigating for Fragments:** Implement smooth navigation between different fragments, enhancing user flow and engagement.

## Setup

Follow these steps to set up the project on your local machine:

1. **Clone the repository:** Begin by cloning this repository to your local machine using the following command:

git clone git@github.com:Asnvir/RunApp.git


2. **Android Studio:** Open Android Studio and select "Open an existing Android Studio project." Navigate to the location where you cloned the repository and select the project's root directory.

3. **SDK Version and Gradle Sync:** Make sure your Android Studio is using a compatible SDK version and allow Gradle to sync the project.

4. **API Keys:**

- Google Maps: The app uses Google Maps integration, so you need to obtain a Google Maps API key. Place the API key in the `google_maps_api.xml` file located in the `res/values` directory.

5. **Build and Run:** Once all the setup steps are complete, build the project and run it on an Android emulator or a physical device.



