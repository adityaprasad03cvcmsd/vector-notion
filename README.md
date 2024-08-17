This project is a backend implementation of a collaborative document management and task planning platform, similar to Notion. It provides API endpoints for managing users, documents, tasks, Kanban boards, multimedia content, version control, comments, notifications, and more.

## Database Design

### User
| Field       | Type    | Description                 |
|-------------|---------|-----------------------------|
| id          | BIGINT  | Primary Key                 |
| username    | VARCHAR | Unique                      |
| email       | VARCHAR | Unique                      |
| password    | TEXT    |                             |
| created_at  | TIMESTAMP |                           |
| updated_at  | TIMESTAMP |                           |

### Document
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| title       | VARCHAR   |                             |
| content     | TEXT      |                             |
| user_id     | BIGINT    | Foreign Key to User         |
| uqKey       | VARCHAR   | Unique                      |
| created_at  | TIMESTAMP |                             |
| updated_at  | TIMESTAMP |                             |

### Task
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| title       | VARCHAR   |                             |
| description | TEXT      |                             |
| status      | VARCHAR   |                             |
| user_id     | BIGINT    | Foreign Key to User         |
| assigned_to | BIGINT    | Foreign Key to User         |
| due_date    | TIMESTAMP |                             |
| created_at  | TIMESTAMP |                             |
| updated_at  | TIMESTAMP |                             |

### Board
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| name        | VARCHAR   |                             |
| user_id     | BIGINT    | Foreign Key to User         |
| created_at  | TIMESTAMP |                             |
| updated_at  | TIMESTAMP |                             |

### BoardTask
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| board_id    | BIGINT    | Foreign Key to TaskBoard    |
| task_id     | BIGINT    | Foreign Key to Task         |
| id          | BIGINT    | Primary Key                 |

### Permission
| Field           | Type      | Description                 |
|-----------------|-----------|-----------------------------|
| id              | BIGINT    | Primary Key                 |
| document_id     | BIGINT    | Foreign Key to Document     |
| user_id         | BIGINT    | Foreign Key to User         |
| type            | VARCHAR   | 'read', 'write', 'admin'    |
| created_at      | TIMESTAMP |                             |

### Media
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| document_id | BIGINT    | Foreign Key to Document     |
| type        | VARCHAR   | 'image', 'video', 'link'    |
| url         | TEXT      |                             |
| created_at  | TIMESTAMP |                             |

### DocumentVersion
| Field          | Type      | Description                 |
|----------------|-----------|-----------------------------|
| id             | BIGINT    | Primary Key                 |
| document_id    | BIGINT    | Foreign Key to Document     |
| documentUqKey  | INTEGER   |                             |
| description    | TEXT      |                             |
| created_at     | TIMESTAMP |                             |

### Comment
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| document_id | BIGINT    | Foreign Key to Document     |
| user_id     | BIGINT    | Foreign Key to User         |
| content     | TEXT      |                             |
| created_at  | TIMESTAMP |                             |
| created_at  | TIMESTAMP |                             |
| mentioned   | JSONOBJECT|                             |

### Notification
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| user_id     | BIGINT    | Foreign Key to User         |
| content     | TEXT      |                             |
| is_read     | BOOLEAN   |                             |
| created_at  | TIMESTAMP |                             |

### FolderMetaData
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| user_id     | BIGINT    | Foreign Key to User         |
| name        | VARCHAR   |                             |
| created_at  | TIMESTAMP |                             |
| updated_at  | TIMESTAMP |                             |

### FolderDocument
| Field       | Type      | Description                 |
|-------------|-----------|-----------------------------|
| id          | BIGINT    | Primary Key                 |
| folder_id   | BIGINT    | Foreign Key to Users        |
| document_id | BIGINT    | Foreign key to Doument      |


## API Contracts

### User Authentication

#### Signup User
- **Endpoint**: `/auth/v1/signup`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "userName": "string",
    "email": "string",
    "password": "string"
  }

### Login User

  
