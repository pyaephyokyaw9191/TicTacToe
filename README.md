# TicTacToe Java Game 🎮

A simple command-line Tic-Tac-Toe game written in Java. Supports:

- User vs User
- User vs Easy AI (random)
- User vs Medium AI (blocks and wins)

## How to Play

Run the `Main` class. On start, you'll be prompted:


Accepted player types:
- `user`
- `easy`
- `medium`

Or type `exit` to quit.

## Structure

- `AiPlayer`: Abstract class for AI players
- `EasyAi`: Random move AI
- `MediumAi`: Smart AI (win/block)
- `TicTacToeBoard`: Board logic (printing, move validation, win check)
- `TicTacToeGame`: Main game loop
- `UserPlayer`: Handles user input

---

> Made for learning. Built with 💻 and ☕