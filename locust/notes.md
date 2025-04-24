- [Installation](#installation)
  - [Linux](#linux)
  - [Mac](#mac)
- [Command Reference](#command-reference)
- [Run Locust without Docker](#run-locust-without-docker)
- [Run locust as a container](#run-locust-as-a-container)
- [Payload](#payload)
  - [Example](#example)
  - [How to Create a Payload Script](#how-to-create-a-payload-script)

## Installation

### Linux

```sh
apt install locust
```


### Mac

You can install Locust directly on macOS using Homebrew:

```sh
brew install locust
```

After installation, you can run Locust scripts directly from the terminal:

```sh
locust -f path/to/your/locustfile.py
```

## Command Reference

| Option             | Description                                              |
|--------------------|----------------------------------------------------------|
| `-f FILE`          | Path to the Locust script (`locust.py`)                 |
| `-u NUM`           | Number of users to simulate                              |
| `-r NUM`           | Spawn rate (users per second)                            |
| `-H HOST`          | Host (target URL for load testing)                       |
| `--autostart`      | Start the test immediately (no UI input required)        |
| `--print-stats`    | Output test statistics to the terminal                   |
| `--headless`       | Run without the web UI (for CI or logs)                  |
| `--web-port PORT`  | Specify a custom port for the web UI (default is 8089)   |
| `--run-time TIME`  | Set test duration (e.g. `1m`, `10s`, `2h`)               |


## Run Locust without Docker

Once Locust is installed, you can run it directly using a command like:

```sh
locust -f ./compose/configs/load-locust-http/locust.py \
       --autostart \
       --print-stats \
       -u 5 \
       -r 1 \
       -H 'http://localhost:8080'
```

This command will:
- Use the test file `locust.py` located in `./compose/configs/load-locust-http`
- Start immediately (`--autostart`)
- Print stats in the terminal (`--print-stats`)
- Simulate 5 users (`-u 5`)
- Spawn 1 user per second (`-r 1`)
- Target the local gateway service (`-H http://localhost:8080`)


## Run locust as a container

This example shows how to run Locust in a Docker container using `docker-compose`.

```yaml
load-generator:
  image: locustio/locust:latest
  volumes:
    - ./configs/load-locust-http:/mnt/locust
  ports:
    - "8089:8089"
  command:
    - -f
    - /mnt/locust/locust.py
    - --autostart
    - --print-stats
    - -u
    - "${LOCUST_USERS:-5}"
    - -r
    - "${LOCUST_SPAWN_RATE:-1}"
    - -H
    - http://gateway:8080
  depends_on:
    - gateway
  networks:
    - gateway-network
```

**Explanation of key parts:**

- **image**: Uses the official Locust image from Docker Hub.
- **volumes**: Mounts the local test scripts (e.g. `locust.py`) into the container at `/mnt/locust`.
- **ports**: Exposes the Locust web UI on port 8089.
- **command**:
  - `-f /mnt/locust/locust.py`: Load test script location.
  - `--autostart`: Start the test automatically without web UI interaction.
  - `--print-stats`: Output stats to the terminal.
  - `-u`: Total number of users to simulate (default is 5 unless overridden).
  - `-r`: Spawn rate — how many users per second (default is 1).
  - `-H`: Target host to test, here it is `http://gateway:8080`.
- **depends_on**: Ensures the target service (`gateway`) is started first.
- **networks**: Connects to a shared Docker network for service communication.

**Tips for Usage:**

- To scale the load test, set environment variables before running:  
  ```sh
  export LOCUST_USERS=100
  export LOCUST_SPAWN_RATE=10
  docker-compose up
  ```

- You can view the test progress and results at [http://localhost:8089](http://localhost:8089).

- The `--autostart` flag is useful for automation (e.g., CI pipelines) but can be removed to control test parameters via the web UI.

- For debugging or local development, add `--headless` to run Locust without opening the web UI:
  ```yaml
  command:
    - --headless
  ```

- Consider version-pinning the Locust image (e.g., `locustio/locust:2.25.1`) to ensure consistent results over time.

## Payload

### Example

```python
from locust import HttpUser, task

class GatewayUser(HttpUser):

    @task
    def post_camel_api(self):
        payload = {
            "system": {
                "name": "cool customer",
                "stream": "new system stream"
            },
            "company": {
                "name": "XYZ Corp",
                "founded": 1995,
                "locations": [
                    {
                        "country": "USA",
                        "city": "San Francisco",
                        "address": "1234 Pine St",
                        "postalCode": "94101"
                    },
                    {
                        "country": "Canada",
                        "city": "Vancouver",
                        "address": "5678 Maple Rd",
                        "postalCode": "V5K 0A1"
                    }
                ],
                "executives": [
                    {
                        "name": "John Doe",
                        "title": "CEO",
                        "email": "jdoe@xyzcorp.com",
                        "startDate": "2005-06-01"
                    },
                    {
                        "name": "Jane Smith",
                        "title": "CFO",
                        "email": "jsmith@xyzcorp.com",
                        "startDate": "2007-10-15"
                    }
                ],
                "products": [
                    {
                        "name": "Product A",
                        "category": "Software",
                        "price": 199.99,
                        "versions": [
                            {"version": "1.0", "releaseDate": "2010-05-20"},
                            {"version": "2.0", "releaseDate": "2013-04-15"}
                        ]
                    },
                    {
                        "name": "Product B",
                        "category": "Hardware",
                        "price": 99.99,
                        "versions": [
                            {"version": "1.0", "releaseDate": "2012-11-30"},
                            {"version": "1.1", "releaseDate": "2014-02-28"}
                        ]
                    }
                ]
            }
        }
        headers = {"Content-Type": "application/json"}
        self.client.post("/camel/api", json=payload, headers=headers)
```

### How to Create a Payload Script

A Locust payload script defines how your virtual users behave during the test.
You typically subclass `HttpUser` and define one or more `@task` methods to simulate actions.

**Steps to create a basic payload script:**

1. **Import Locust classes:**
   ```python
   from locust import HttpUser, task
   ```

2. **Create a user class inheriting from `HttpUser`:**
   ```python
   class MyUser(HttpUser):
   ```

3. **Define tasks using the `@task` decorator:**
   Each task simulates a user action like a `GET` or `POST` request.
   ```python
       @task
       def load_home(self):
           self.client.get("/")
   ```

4. **Add request headers if needed (e.g., JSON content):**
   ```python
   headers = {"Content-Type": "application/json"}
   ```

5. **Create and send a payload in a task method:**
   ```python
       @task
       def create_entity(self):
           payload = {"name": "Example"}
           self.client.post("/api/entity", json=payload, headers=headers)
   ```

6. **Save the file as `locust.py` or another name if you specify `-f yourfile.py`.

**Tips:**
  - Locust will automatically run all methods marked with `@task`.
  - You can control the **relative frequency** of tasks using weights.  
    For example:
    ```python
    @task(1)
    def task_one(self):
        ...

    @task(3)
    def task_two(self):
        ...
    ```
    In this case, `task_two` will run approximately 3 times as often as `task_one`.

  - Add **wait time** between tasks to simulate realistic user behavior.  
    You can define a fixed or random wait interval by setting `wait_time` in the user class:
    - Fixed delay:  
      ```python
      wait_time = constant(2)  # always waits 2 seconds between tasks
      ```
    - Random range (uniform):  
      ```python
      wait_time = between(1, 5)  # waits between 1 and 5 seconds
      ```
    - Random exponential delay (rare short waits, occasional long waits):  
      ```python
      wait_time = constant_pacing(3)  # ensures task starts ~every 3 seconds regardless of duration
      ```

    These wait times help prevent unrealistically fast, constant requests which could overload the system.