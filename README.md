# Rover Navigation System
## Overview

This project implements a robot navigation system.

## Features
- Support for three commands:
  - `L` - Turn left 90 degrees
  - `R` - Turn right 90 degrees  
  - `F` - Move forward one grid position
- Robots are marked as "LOST" when moving off the grid
- Positions where robots are lost leave "scents" to prevent future robots from falling off at the same location

## Project Structure
Main class: `org.redbadger.app.RobotExecutor`
Other classes: `org.redbadger.app.Robot`, `org.redbadger.app.Orientation`
Test classes: `org.redbadger.app.RobotExecutorTest`, `org.redbadger.app.RobotTest`, `org.redbadger.app.OrientationTest`

## Input Format

```
5 3
1 1 E
RFRFRFRF
3 2 N
FRRFLLFFRRFLL
0 3 W
LLFFFLFLFL
```

## Output Format
```
1 1 E
3 3 N LOST
2 3 S
```

## Building and Running

### Prerequisites
- Java 11 or higher
- Gradle 7.x

### Build
```bash
./gradlew build
```

### Run Tests
```bash
./gradlew test
```

### Run Application
```bash
./gradlew run
```

Or compile and run directly:
```bash
./gradlew build
java -cp app/build/libs/app.jar org.redbadger.app.RobotExecutor
```

## Technical Details

### Robot Class
- Maintains position (x, y) and orientation
- Tracks lost status
- Implements turning and movement logic

### ORIENTATION Enum
- Represents four cardinal directions (N, E, S, W)
- Handles 90-degree rotations

### RobotExecutor
- Main entry point
- Parses input and coordinates robot movements
- Maintains scent tracking to prevent repeated losses at same positions

## Testing
- Robot movement and turning logic
- Orientation changes
- Scent functionality test

Run tests with: `./gradlew test`