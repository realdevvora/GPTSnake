# GPTSnake
A simple implementation of the Snake game using ChatGPT (prompts are provided in Snake Game in java.pdf)

Testing and JUnit Dependencies:

implementation("org.junit.jupiter:junit-jupiter:5.8.1") 
testImplementation(platform("org.junit:junit-bom:5.9.1"))
testImplementation("org.junit.jupiter:junit-jupiter")

SDK: Amazon Corretto Version 11.0.19


USE CASES:
- Handling movement
- Collisions

USER STORIES:
- As a user, I want to be able to see my points somewhere on the screen (window title)
- As a user, I want to be able to know what keybinds I am pressing to play the game (title at the start of the game, before colliding with apple)

VIOLATIONS:

GameController:
- Violates the SRP because it implements a "draw" method when it is supposed to be a controller class
- Setting the UI panel, breaks the dependency rule of Clean Architecture (Controller has access to UI class)

Other Violations:
- Dependency inversion broken in certain parts of the program because adding interfaces would make it more complex than it needs to be.
- Long class code smells, because certain classes are responsible for several UI components, and others are responsible for several use case/controller activities
