# CS-360 Inventory Tracker

This repo contains a mobile application that can be used to track items in a warehouse made with Android Studio using Java.  

The main goals of the app include:
- A database with at least two tables, one to store the inventory items and one to store user logins and passwords
- A screen for logging into the app. Note that this should also be used to create a login if the user has never logged in before.
- A screen, with a grid, that displays all items in the inventory
- A mechanism by which the user can add and remove items from inventory
- A mechanism by which the user can increase or decrease the number of a specific item in the inventory
- A mechanism by which the application will notify the user when the amount of any item in the inventory has been reduced to 0 (zero)

To support the user needs for this application, 3 main screens for the UI were created including the login screen, the dashboard screen, and the notifications screen. The login screen would allow the user to either login to an existing account or create a new account. The Dashboard screen displayed a grid of each item in the inventory database. The Notifications screen included a button that allowed a user to grant permissions for SMS notifications. I tried to keep the design minimal so the application was easy to use and add onto for future development.

I relied a lot on skills gained from participating in the course's zyBooks material as many of the example projects built there had similar features that I wanted my project to include. I had to Google a lot and learn from some YouTube tutorials which led me down many rabbit holes since there is a lot that apparently goes into coding an Android Studio app. I will continue to be resourceful though as that has always helped me gain a greater understanding of the overall concepts.

There are not tests included in this application but the way Android Studio's IDE is built, it's always testing along the way in some form such as warning you about unused imports, missing semicolons, improperly used data types or methods, etc. This was super helpful along the way as it was rarely a mystery as to what part of the application broke, I could focus more on *how* to fix the problem and not on *where* is the problem. 

Utilizing the database was tricky for me as I had only had experience with web development where APIs and ORMs were used instead of raq SQL queries so there was some innovation there to figure out how to connect the frontend and the database without that extra layer especially with little time to complete the project.

I believe I was fairly successful in my planning stage, where I came up with my overall design plan, screens to be utiilized and how I wanted the different parts to interact with each other. Given more time, I feel I would've been able to execute my plan better but I really liked the initial design I had planned.
