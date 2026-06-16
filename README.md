# 🔗 Linked List Manager - Java Console Application

> **Title:** Custom Doubly Linked List with Sort, Delete, and Navigation  
> **Purpose:** A fully functional doubly linked list implementation with interactive console UI

---

## 📋 Projektinformationen

| Feld                   | Inhalt                                                          |
|------------------------|-----------------------------------------------------------------|
| **Projektname**        | Linked List Manager                                             |
| **Beschreibung**       | Eigene doppelt verkettete Liste mit Add, Sort, Delete und Cursor-Navigation |
| **Typ**                | Schulaufgabe / JAVA – Anwendung                                 |
| **Programmiersprache** | Java                                                            |
| **Version**            | 1.0                                                             |
| **Status**             | ✅ Produktionsreife                                              |
| **Datum**              | 2026                                                            |
| **Entwickler**         | Bashar Salmo                                                    |
| **Lehrer**             | G.Jarz                                                          |
| **Institution**        | BFI-Leoben                                                      |

---

## 🎯 Project Description

The **Linked List Manager** is a Java console application that implements a custom doubly linked list from scratch. Users can add string items interactively, then sort, delete, or navigate through the list using a simple menu.

### 📈 Program Functionality

1. **Add ( A )** – Add string items to the list on startup
2. **Sort ( S )** – Alphabetically sort all items (selection sort)
3. **Delete ( D )** – Remove one or more items by name (comma-separated)
4. **List ( L )** – Display all current items in the list
5. **Next ( N )** – Move the cursor forward one position
6. **Previous ( P )** – Move the cursor backward one position
7. **Quit ( Q )** – Exit the application

### 📝 Data Management

| Field | Type | Description |
|-------|------|-------------|
| **data** | String | The value stored in the node |
| **next** | Node | Reference to the next node |
| **prev** | Node | Reference to the previous node |
| **head** | Node | First node in the list |
| **tail** | Node | Last node in the list |
| **cursor** | Node | Current position for navigation |

---

## 🛠️ Development Environment

### Software & Tools Used

| Tool / Software | Version | Purpose |
|---|---|---|
| **IntelliJ IDEA** | 2025+ | Integrated Development Environment (IDE) |
| **Java JDK** | 8, 11, 17, 21+ | Programming language & compiler |
| **Terminal/Console** | Windows/Linux/macOS | Program execution |

### 💻 Operating System

- ✅ **Windows** 10/11
- ✅ **macOS** 10.13+
- ✅ **Linux** (Ubuntu, Debian, CentOS, etc.)

### 📦 Dependencies

- **No external dependencies!** Uses only the Java Standard Library
- `java.util.Scanner` – Reading user input
- `java.util.InputMismatchException` – Input error handling
- Works with **Java 8 and newer**

---

## 📥 Installation & Setup

### Prerequisites

- **Java JDK 8+** installed ([Download](https://www.oracle.com/java/technologies/downloads/))
- **IDE** (IntelliJ IDEA, Eclipse, VS Code) or **Terminal/Command Prompt**

### Step 1: Set up project structure

```bash
mkdir LinkedListManager
cd LinkedListManager
```

### Step 2: Prepare Java files

```
LinkedListManager/
└── src/
    ├── Node.java
    ├── List.java
    └── Main.java
```

### Step 3: Compile the program

**In IntelliJ IDEA:**
```
Build → Build Project
```

**In Terminal:**
```bash
javac Node.java List.java Main.java
```

### Step 4: Run the program

**In IntelliJ IDEA:**
```
Right-click on main() → Run 'Main.main()'
or Shortcut: Shift+F10 (Windows) / Ctrl+R (macOS)
```

**In Terminal:**
```bash
java Main
```

---

## 🚀 Usage Guide

### 📘 Program Flow

```
START
  ↓
addItem() – Prompt user to enter items until "X" is typed
  ↓
Display initial list
  ↓
WHILE true:
  │
  ├─ menu() – Display menu & read selection
  │
  ├─ SWITCH selection:
  │  ├─ S: sort()     – Alphabetically sort the list
  │  │                  Display sorted list
  │  ├─ D: delete()   – Read comma-separated items to remove
  │  │                  myList.remove() for each item
  │  │                  Display updated list
  │  ├─ L:            – Display all items in the list
  │  ├─ P: previous() – Move cursor backward & show item
  │  ├─ N: next()     – Move cursor forward & show item
  │  └─ Q:            – Print goodbye message & exit
  │
  └─ Back to menu
  ↓
ENDE
```

### 📊 Example Execution

```
Please enter the item (X to stop the program): Apple
Please enter the item (X to stop the program): Mango
Please enter the item (X to stop the program): Banana
Please enter the item (X to stop the program): X

Items in the List = Apple -> Mango -> Banana

-----Available Actions-----
(S)orting
(D)elete
(L)ist
(P)revious
(N)ext
(Q)uit
select your option by typing letter: S

Sorting.......
Sorted List = Apple -> Banana -> Mango

select your option by typing letter: N
Next item: Banana

select your option by typing letter: D
Write the item(s) to delete from list, separated by commas: 
Banana

Items in the List = Apple -> Mango

select your option by typing letter: Q

CIAO......🫡
```

---

## 💻 Code Structure & Explanation

### 📂 File Overview

#### **Node.java** – Data class for list nodes

```java
public class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) { ... }

    // Getters & Setters
    public String getDate()        { return data; }
    public void setDate(String d)  { this.data = d; }
    public Node getNext()          { return next; }
    public void setNext(Node n)    { this.next = n; }
    public Node getPrev()          { return prev; }
    public void setPrev(Node p)    { this.prev = p; }

    @Override
    public String toString()       { return "Node{date='" + data + "'}"; }
}
```

#### **List.java** – Core linked list logic

```java
public class List {
    Node head, tail, cursor;

    public List() { ... }

    public void add(Node newNode)      { ... } // Append to end of list
    public void sort()                 { ... } // Selection sort by swapping data
    public void remove(String string)  { ... } // Find and unlink a node by value
    public int size()                  { ... } // Count all nodes
    public String get(int num)         { ... } // Access node at index
    public String next()               { ... } // Advance cursor, return data
    public String previous()           { ... } // Move cursor back, return data

    @Override
    public String toString()           { ... } // Format as "a -> b -> c"
}
```

#### **Main.java** – Entry point and user interface

```java
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List myList     = new List();

    public static void main(String[] args) { ... } // Entry point & menu loop
    public static void addItem()           { ... } // Input phase before menu
    public static String menu()            { ... } // Display & read menu option
    public static void sort()              { ... } // Call list sort & display
    public static void delete()            { ... } // Read & remove items
    public static void next()              { ... } // Advance cursor & print
    public static void previous()          { ... } // Move cursor back & print
}
```

---

### 🔍 Code Analysis – List.java

| Code Element | Explanation | Type |
|---|---|---|
| `head` | First node in the list | Variable |
| `tail` | Last node in the list | Variable |
| `cursor` | Current navigation position | Variable |
| `add(Node)` | Appends node; sets head/tail on first insert | Method |
| `sort()` | Selection sort by swapping `data` between nodes | Method |
| `remove(String)` | Case-insensitive search; re-links neighbors | Method |
| `size()` | Traverses list and counts nodes | Method |
| `get(int)` | Returns data at index; throws on out-of-bounds | Method |
| `next()` | Moves cursor forward; returns null at end | Method |
| `previous()` | Moves cursor backward; returns null at start | Method |
| `toString()` | Builds `"a -> b -> c"` string representation | Override |

### 🔍 Code Analysis – Main.java

| Method | Description |
|---|---|
| `main()` | Entry point: calls `addItem()`, then runs `while(true)` menu loop |
| `addItem()` | Reads items until "X"; validates letters only (including ä/ö/ü/ß) |
| `menu()` | Prints option block, reads one line, returns uppercase option |
| `sort()` | Delegates to `myList.sort()` and prints result |
| `delete()` | Splits input on commas, trims each token, calls `myList.remove()` |
| `next()` | Calls `myList.next()` and prints result or "Already at the end." |
| `previous()` | Calls `myList.previous()` and prints result or "Already at the beginning." |

---

### 🎯 Key Concepts in the Code

#### 1. Doubly Linked List – Bidirectional Traversal

```java
// Each node holds references to both neighbors
node.next = nextNode;   // forward link
node.prev = prevNode;   // backward link

// This enables both next() and previous() navigation
```

The doubly linked structure is what makes cursor navigation in both directions possible without needing to restart from the head.

#### 2. `sort()` – Selection Sort by Data Swap

```java
public void sort() {
    Node current = head;
    while (current != null) {
        Node index = current.next;
        while (index != null) {
            if (current.data.compareTo(index.data) > 0) {
                String temp = current.data;
                current.data = index.data;
                index.data = temp;
            }
            index = index.next;
        }
        current = current.next;
    }
}
```

Only the `data` values are swapped — the node links stay in place. Simple and effective for short lists.

#### 3. `remove()` – Safe Node Unlinking

```java
// Re-link neighbors to skip the removed node
if (current.prev != null) current.prev.next = current.next;
else head = current.next;           // removed node was head

if (current.next != null) current.next.prev = current.prev;
else tail = current.prev;           // removed node was tail
```

Handles all four edge cases: removing from head, tail, middle, or a single-item list.

#### 4. Input Validation – Letters Only

```java
if (!input.matches("[a-zA-ZäöüÄÖÜß ]+")) {
        System.out.println("Please enter only STRING items.");
    continue;
            }
```

The regex also allows German umlauts and spaces, making the app suitable for names and European text.

---

## 🧪 Testing & Validation

| # | Input | Expected | Status |
|---|-------|----------|--------|
| 1 | Add "Apple", "Mango", "Banana" | `Apple -> Mango -> Banana` | ✅ |
| 2 | Sort | `Apple -> Banana -> Mango` | ✅ |
| 3 | Next (cursor at Apple) | `Next item: Banana` | ✅ |
| 4 | Previous (cursor at Banana) | `Previous item: Apple` | ✅ |
| 5 | Previous at start | `Already at the beginning.` | ✅ |
| 6 | Next at end | `Already at the end.` | ✅ |
| 7 | Delete "Banana" | `Apple -> Mango` | ✅ |
| 8 | Delete non-existent item | `Item not found: xyz` | ✅ |
| 9 | Delete multiple: "Apple, Mango" | Empty list | ✅ |
| 10 | Enter number as item | `Please enter only STRING items.` | ✅ |
| 11 | Enter special character | `Please enter only STRING items.` | ✅ |
| 12 | Invalid menu option | `Invalid option. Please try again.` | ✅ |

---

## 📚 Concepts Used (School Material)

| Concept | Usage in Project |
|---------|---|
| **Classes & Objects** | `Node`, `List`, `Main` classes |
| **Constructors** | `Node(String)`, `List()` |
| **Encapsulation** | Getter/Setter methods in `Node` |
| **Doubly Linked List** | `prev` + `next` references on every node |
| **Loops (while)** | Main menu loop, sort loop, traversal |
| **Switch Statement** | Menu option routing |
| **If / Try-Catch** | Null checks, `IndexOutOfBoundsException` |
| **Static Methods & Fields** | All in `Main` |
| **String Methods** | `compareTo()`, `equalsIgnoreCase()`, `matches()`, `split()`, `trim()` |
| **StringBuilder** | Efficient string building in `toString()` |
| **Override** | `toString()` in `List` |
| **Regex** | Input validation with `[a-zA-ZäöüÄÖÜß ]+` |

---

## ⚠️ Error Handling

- ✅ Non-letter input (numbers, special characters) rejected during `addItem()`
- ✅ Deletion of non-existent items prints a friendly message without crashing
- ✅ Navigation beyond the list boundaries returns a null-safe message
- ✅ Index out of bounds in `get()` throws `IndexOutOfBoundsException`
- ✅ Invalid menu options handled by `default` case

### Error Messages

```
Please enter only STRING items. Numbers and special characters are not allowed.
Item not found: xyz
Already at the end.
Already at the beginning.
Invalid option. Please try again.
```

---

## 📄 Project Structure

```
LinkedListManager/
│
├── src/
│   ├── Node.java      # Node model – data, next, prev pointers
│   ├── List.java      # Core list logic – add, sort, remove, navigate
│   └── Main.java      # UI & program flow
│
└── README.md
```

---

## 🔧 Troubleshooting

### Compilation error `cannot find symbol`

```bash
# Make sure all three files are in the same directory
javac Node.java List.java Main.java
java Main
```

### Sort doesn't seem to work after deletion

Sorting only swaps `data` values — node structure stays intact. After deletion, call Sort again to re-sort the remaining items.

### Cursor behaves unexpectedly after sort

The cursor object still points to the same `Node` in memory. After sorting, the data at that position may have changed. Reset navigation by restarting or deleting items.

### Delete is case-insensitive

`remove()` uses `equalsIgnoreCase()`, so deleting `"apple"` will also remove `"Apple"` or `"APPLE"`.

---

## 📊 Algorithm Complexity

| Operation | Time Complexity | Notes |
|-----------|----------------|-------|
| `add()` | O(1) | Direct tail insertion |
| `sort()` | O(n²) | Selection sort, swaps data only |
| `remove()` | O(n) | Linear search by value |
| `size()` | O(n) | Full traversal |
| `get(int)` | O(n) | Linear scan to index |
| `next()` / `previous()` | O(1) | Direct pointer jump |
| `toString()` | O(n) | Full traversal |

---

## ✅ Usage Checklist

- [ ] Java 8+ is installed
- [ ] All three files (`Node.java`, `List.java`, `Main.java`) are present
- [ ] Compilation successful (`javac`)
- [ ] Program starts without errors
- [ ] Items can be added (letters only)
- [ ] Sorting works correctly (alphabetical order)
- [ ] Deletion works for single and multiple items
- [ ] Cursor navigation (Next/Previous) works correctly
- [ ] Boundary messages appear at start/end of list

---

## 📜 License

```
School Project – JAVA Application
Not intended for commercial use
Freely available for educational purposes
```

---

**Version:** 1.0 | **Status:** ✅ Production Ready