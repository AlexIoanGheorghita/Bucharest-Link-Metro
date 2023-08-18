# Bucharest-Link-Metro (OLD - 2020 project)

Note: You might see as contributor Alex-Tela, which is the GitHub account where I originally stored this repository. I have now moved it here in order to have all my past and future projects centralized.

This is an old Android application made in Java in Android Studio. Its purpose is to show metro routes, and approximate times at which a train arrives. You can find this app on Google Play Store here: https://play.google.com/store/apps/details?id=com.alextela.myapplication

This application contains many features, such as:
- an information panel for how much tickets cost.
- the ability to change the language from English to Romanian and vice versa.
- a route planner which accepts a starting station and a destination station, displaying all stations in between, where you need to change lines, and the time it takes for a train to travel between two stations.
- the ability to view further information about a station in the route planner if you click on it, including nearby attractions, stores, bus and tram stations, and a Google Maps panel.

## Mistakes

This application was created at a time when I just started learning about programming (specifically in my first year of University). Therefore, you will see many mistakes throughout the application, such as the prevalent use of `if` statements, the fact that secrets, such as the Google Maps Android API v2 key is not stored as an environment variable, and the poor naming conventions. 

## Optimizations

Although the application works perfectly well, it could have been created in a better way. For example, an efficient way to store and make use of stations would be a dictionary (a hash map), graph, or doubly linked-list data structures. Using one of these data structures would have eliminated the need to use so many conditions and the need to store station names inside an array.

However, please bear in mind that this was a beginner's project.

## Maintenance

This application is no longer maintained unfortunately, as my focus has changed from Android mobile applications to web applications (that include Java for the back-end).

