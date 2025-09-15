# Java Design Patterns

This project demonstrates some of the most commonly used **Design Patterns in Java**.  
Each pattern is implemented with real-world inspired examples and well-commented code, making it a great reference for learning and interview preparation.  

---

## 📌 Patterns Implemented

### 1. Singleton Pattern
- Ensures only one instance of a class exists in the JVM.  
- Example: Logger, Database connection manager.  
- Includes thread-safe implementation with **Double-Checked Locking** and prevention against Reflection, Cloning, and Serialization.

---

### 2. Factory Pattern
- Provides a centralized way to create objects without exposing the instantiation logic.  
- Example: Payment Factory that produces `CreditCardPayment`, `PayPalPayment`, or `GooglePayPayment`.  
- Promotes loose coupling and flexibility.

---

### 3. Builder Pattern
- Helps construct complex objects step by step.  
- Example: Immutable `User` object with optional fields.  
- Avoids telescoping constructors and improves readability.

---

### 4. Strategy Pattern
- Defines a family of interchangeable algorithms at runtime.  
- Example: Different payment strategies (Credit Card, PayPal, Google Pay).  
- Supports the Open/Closed principle.

---

### 5. Observer Pattern
- Defines a one-to-many dependency between objects.  
- Example: Notification service with multiple subscribers (`EmailSubscriber`, `SmsSubscriber`).  
- Commonly used in event-driven systems.

---

## 🎯 Key Features
- Clean **Java implementations**.  
- **Real-world inspired examples**.  
- Each pattern has a **demo class with `main()`**.  
- Great for **interview preparation** and learning design patterns.  

---

## 🚀 How to Run
1. Clone the repo:
   ```bash
   git clone git@github.com:Temptation4/java-design-patterns.git
   cd java-design-patterns

   ## 👨‍💻 Author
Neelu Sahai  
