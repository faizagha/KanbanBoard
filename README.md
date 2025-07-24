#  Kanban Board API 🚀

A simple yet powerful RESTful API for a Kanban-style project management board, built with Spring Boot. This backend provides the core functionalities needed to manage tasks and columns visually.

## ✨ Features

* **View Full Board:** Fetch a complete board structure, including all columns and their tasks, presented in the correct order.
* **Move Tasks:** Seamlessly move tasks between different columns.
* **Reorder Tasks:** Easily change the order of tasks within a single column.
* **Persistent Ordering:** Uses Spring Data JPA's `@OrderColumn` to automatically manage and persist the order of columns and tasks in the database.

## 🛠️ Technologies Used

* **Java 17**
* **Spring Boot 3**
* **Spring Web:** For creating RESTful APIs.
* **Spring Data JPA:** For database interaction and object-relational mapping.
* **H2 Database:** An in-memory database for easy setup and development.
* **Lombok:** To reduce boilerplate code.
* **Maven:** For project build and dependency management.

## 🏁 Getting Started

Follow these instructions to get the project up and running on your local machine.

### Prerequisites

* JDK 17 or later installed.
* Apache Maven installed.
* An IDE like IntelliJ IDEA (recommended) or VS Code.

### Installation & Running

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/](https://github.com/)[your-username]/[your-repo-name].git
    ```

2.  **Navigate to the project directory:**
    ```bash
    cd [your-repo-name]
    ```

3.  **Run the application:**
    * **Using IntelliJ IDEA:** Open the project, wait for dependencies to download, and click the green "Run" button on the `KanbanApplication` class.
    * **Using Maven command line:**
        ```bash
        mvn spring-boot:run
        ```

4.  The application will start on `http://localhost:8080`.

## ⚙️ API Endpoints

Here are the milestone API endpoints available.

*(Note: For this initial design, you'll need to manually populate the H2 database with some data on startup to have a board to test. You can do this with a `data.sql` file in your `src/main/resources` folder.)*

---

### Get Full Board

Retrieves the full board details, including ordered columns and tasks.

* **URL:** `/api/boards/{boardId}`
* **Method:** `GET`
* **Example Response:**
    ```json
    {
        "id": 1,
        "title": "My Project Board",
        "columns": [
            {
                "id": 101,
                "title": "To Do",
                "tasks": [
                    { "id": 1001, "content": "Analyze requirements" },
                    { "id": 1002, "content": "Design UI mockups" }
                ]
            },
            {
                "id": 102,
                "title": "In Progress",
                "tasks": []
            }
        ]
    }
    ```

---

### Move a Task to a Different Column

Moves a task to a new column at a specified position.

* **URL:** `/api/boards/tasks/{taskId}/move`
* **Method:** `POST`
* **Request Body:**
    ```json
    {
        "newColumnId": 102,
        "newPosition": 0
    }
    ```

---

### Reorder a Task within its Column

Changes the position of a task within its current column.

* **URL:** `/api/boards/tasks/{taskId}/reorder`
* **Method:** `POST`
* **Request Body:**
    ```json
    {
        "newPosition": 1
    }
    ```

---

## 🔮 Future Improvements

* [ ] Implement user authentication and authorization with Spring Security.
* [ ] Add endpoints for creating and deleting boards, columns, and tasks.
* [ ] Switch from H2 to a persistent database like PostgreSQL or MySQL.
* [ ] Implement full DTO (Data Transfer Object) mapping to decouple the API from the database entities.
* [ ] Add more detailed task properties like `assignee`, `dueDate`, and `priority`.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
