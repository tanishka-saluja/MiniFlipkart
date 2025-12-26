# Mini Flipkart Product Recommendation System (Java)

A console-based e-commerce system that manages products, users, orders, and provides product recommendations.

## Features
- Add / View Products
- Add / View Users
- Track user purchases
- Recommend top products based on category, rating, and purchase history

## Folder / Class Structure
- `src/Product.java` → Product class with id, name, category, price, rating
- `src/User.java` → User class with id, name, purchase history
- `src/Order.java` → Order class to store purchases
- `src/RecommendationEngine.java` → Recommendation logic
- `src/Main.java` → Menu-driven console interface

## How to Run
1. Compile all Java files:
javac src/*.java

2. Run the main program:
java src/Main

## Concepts Implemented
- Object-Oriented Programming (Classes, Objects, Encapsulation)
- Data structures: ArrayList, HashMap, PriorityQueue
- Sorting & Recommendation algorithms
- Console-based interactive system
