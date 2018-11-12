## Event Tracker Project

#### Technologies Used
* Spring Tool Suite
* Spring Boot
* JSON API
* Hibernate
* MySql
* Spring Data JPA
* Gradle
* Java
* RESTful Services






#### Overview
This is a RESTful API to manage a database with the results of Magic: The Gathering game statistics.
Full C.R.U.D. operations are implemented, as well as a couple custom Querys.

### Routes

#### Get
* api/games/                      Get's all games from the database.
* api/games/{id}                  Get's a game by Id.
* api/gamesDeck/{deck}            Get's all games where you played a specific deck. (sample: "Fish")
* api/gamesOpponentDeck/{deck}    Get's all games where your opponent played a specific deck. (sample: "Affinity")

#### Post
* api/games                       Add's a game to the database

#### Put
* games/{id}                      Updates a specific game based on id

#### Delete
* games/{id}                      Deletes a game based on id



#### Lessons Learned
Don't forget to restart your server, or you will try to fix an error that doesn't need to be fixed.
