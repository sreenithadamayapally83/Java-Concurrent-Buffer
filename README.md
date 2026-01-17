# Concurrent Buffer Manager (Java)

## Overview
This project is a high-performance, thread-safe data buffer implemented in **Core Java**. It bridges the gap between hardware logic and software engineering by simulating a **Synchronous FIFO (First-In-First-Out)** system using the **Producer-Consumer design pattern**.

## Technical Highlights
* **Concurrency Management:** Utilizes `synchronized` methods, `wait()`, and `notifyAll()` to manage shared resources and prevent race conditions.
* **Complexity Analysis:** Uses a `LinkedList` based Queue to ensure $O(1)$ time complexity for both data ingestion (push) and retrieval (pop).
* **Object-Oriented Design (OOAD):** Follows clean code principles by encapsulating buffer logic within a `SharedBuffer` class, separate from the execution threads.
* **Error Handling:** Implements `InterruptedException` handling to ensure robust thread termination.

## How It Works (Simulation)
The project simulates two active threads:
1. **Producer:** Mimics an input data stream (e.g., a sensor or API) pushing data every 500ms.
2. **Consumer:** Mimics a processing unit pulling data every 1000ms.
3. **Logic:** When the buffer reaches its capacity (5 units), the Producer automatically enters a 'Wait' state until the Consumer creates space, preventing data overflow.



## Skills Demonstrated
`Core Java` `Multi-threading` `Data Structures` `Git` `OOAD`
