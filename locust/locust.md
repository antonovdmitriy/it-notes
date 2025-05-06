- [Installation](#installation)
  - [Linux](#linux)
  - [Mac](#mac)
- [Command Reference](#command-reference)
- [Run Locust without Docker](#run-locust-without-docker)
- [Run locust as a container](#run-locust-as-a-container)
- [Payload](#payload)
  - [Example](#example)
  - [How to Create a Payload Script](#how-to-create-a-payload-script)
- [on start](#on-start)
  - [Example](#example-1)
- [wait\_time attribute](#wait_time-attribute)
  - [Fixed wait time](#fixed-wait-time)
  - [Random wait time (uniform distribution)](#random-wait-time-uniform-distribution)
  - [Constant pacing](#constant-pacing)
  - [Constant throughput](#constant-throughput)
- [weight and fixed\_count attributes](#weight-and-fixed_count-attributes)
- [@tag decorator](#tag-decorator)
- [Validating responses](#validating-responses)
- [Connection reuse](#connection-reuse)
- [Connection pooling](#connection-pooling)
- [Examples](#examples)
- [Misc](#misc)
  - [har2locust](#har2locust)
    - [How to use](#how-to-use)
    - [Notes](#notes)

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

For a file to be a valid locustfile it must contain at least one class inheriting from `User`.

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

## on start

The `on_start` method in Locust is a special hook that runs once per simulated user before they begin executing tasks. It's useful for setup actions like authentication or fetching session tokens.

### Example

```python
from locust import HttpUser, task

class MyUser(HttpUser):

    def on_start(self):
        # This runs once per user before any tasks
        self.client.post("/login", json={"username": "user", "password": "pass"})

    @task
    def load_main_page(self):
        self.client.get("/")
```

In this example, each simulated user logs in before performing the `load_main_page` task.

the same for `on_stop`

## wait_time attribute

The `wait_time` attribute defines how long a simulated user waits between tasks. This helps create more realistic load by spacing out requests.

There are several types of wait times available in Locust:

### Fixed wait time

All users wait the same fixed time between tasks:

```python
from locust import HttpUser, task, constant

class FixedUser(HttpUser):
    wait_time = constant(2)  # waits exactly 2 seconds

    @task
    def index(self):
        self.client.get("/")
```

### Random wait time (uniform distribution)

Users wait for a random time between the specified minimum and maximum:

```python
from locust import HttpUser, task, between

class RandomUser(HttpUser):
    wait_time = between(1, 5)  # waits between 1 and 5 seconds

    @task
    def index(self):
        self.client.get("/")
```

### Constant pacing

Ensures each task starts approximately every `X` seconds, regardless of execution time:

```python
from locust import HttpUser, task, constant_pacing

class PacingUser(HttpUser):
    wait_time = constant_pacing(3)  # task cycle ~3 seconds

    @task
    def index(self):
        self.client.get("/")
```

This is useful for simulating consistent traffic, especially in headless or CI testing scenarios.

### Constant throughput

Use `constant_throughput` to target a specific number of task runs per second, regardless of the number of users:

```python
from locust import HttpUser, task, constant_throughput

class ThroughputUser(HttpUser):
    wait_time = constant_throughput(0.5)  # 0.5 tasks per second (1 every 2 seconds)

    @task
    def index(self):
        self.client.get("/")
```

This approach is useful when you're aiming to maintain a precise request rate (e.g., in performance benchmarking or capacity testing), and want Locust to handle the pacing for you, dynamically adjusting user wait times.

## weight and fixed_count attributes

- If more than one user class exists in the file, and no user classes are specified on the command line, Locust will spawn an equal number of each of the user classes. 
- You can also specify which of the user classes to use from the same locustfile by passing them as command line arguments:

```sh
locust -f locust_file.py WebUser MobileUser
```

- If you wish to simulate more users of a certain type than another you can set a weight attribute on those classes.

```py
class WebUser(User):
    weight = 3
    ...

class MobileUser(User):
    weight = 1
    ...
```

- you can set the fixed_count attribute. In this case, the weight attribute will be ignored and only that exact number users will be spawned.

```py
class AdminUser(User):
    wait_time = constant(600)
    fixed_count = 1

    @task
    def restart_app(self):
        ...

class WebUser(User):
    ...
```

## @tag decorator

By tagging tasks using the `@tag` decorator, you can be picky about what tasks are executed during the test using the `--tags` and `--exclude-tags` arguments. 

```py
from locust import User, constant, task, tag

class MyUser(User):
    wait_time = constant(1)

    @tag('tag1')
    @task
    def task1(self):
        pass

    @tag('tag1', 'tag2')
    @task
    def task2(self):
        pass

    @tag('tag3')
    @task
    def task3(self):
        pass

    @task
    def task4(self):
        pass
```

If you started this test with `--tags tag1`, only `task1` and `task2` would be executed during the test. If you started it with `--tags tag2 tag3`, only `task2` and `task3` would be executed.

`--exclude-tags` will behave in the exact opposite way. So, if you start the test with `--exclude-tags tag3`, only `task1`, `task2`, and `task4` will be executed. Exclusion always wins over inclusion, so if a task has a tag you’ve included and a tag you’ve excluded, it will not be executed.

## Validating responses

Requests are considered successful if the HTTP response code is OK (<400), but it is often useful to do some additional validation of the response.

You can mark a request as failed by using the catch_response argument, a with-statement and a call to `response.failure()`

```py
with self.client.get("/", catch_response=True) as response:
    if response.text != "Success":
        response.failure("Got wrong response")
    elif response.elapsed.total_seconds() > 0.5:
        response.failure("Request took too long")
```

You can also mark a request as successful, even if the response code was bad:

```py
with self.client.get("/does_not_exist/", catch_response=True) as response:
    if response.status_code == 404:
        response.success()
```

You can even avoid logging a request at all by throwing an exception and then catching it outside the with-block. Or you can throw a locust exception, like in the example below, and let Locust catch it.

```py
from locust.exception import RescheduleTask
...
with self.client.get("/does_not_exist/", catch_response=True) as response:
    if response.status_code == 404:
        raise RescheduleTask()
```

## Connection reuse

By default, connections are reused by an HttpUser, even across tasks runs. To avoid connection reuse you can do:

```py
self.client.get("/", headers={"Connection": "close"})
self.client.get("/new_connection_here")
```

Or you can close the entire requests.Session object (this also deletes cookies, closes the SSL session etc). This has some CPU overhead (and the response time of the next request will be higher due to SSL renegotiation etc), so dont use this unless you really need it.

```py
self.client.get("/")
self.client.close()
self.client.get("/new_connection_here")
```

## Connection pooling

As every HttpUser creates new HttpSession, every user instance has its own connection pool. This is similar to how real users (browsers) would interact with a web server.

If you instead want to share connections, you can use a single pool manager. To do this, set pool_manager class attribute to an instance of urllib3.PoolManager.

```py
from locust import HttpUser
from urllib3 import PoolManager

class MyUser(HttpUser):
    # All instances of this class will be limited to 10 concurrent connections at most.
    pool_manager = PoolManager(maxsize=10, block=True)
```

## Examples

- [examples](https://github.com/locustio/locust/tree/master/examples)


## Misc


### har2locust

`har2locust` is a command-line tool that converts HTTP Archive (HAR) files into Locust test scripts.

HAR files can be exported from most browsers' developer tools and contain a log of network requests. This tool reads those requests and generates a Locust script that mimics the behavior recorded in the session.

#### How to use

1. Export your HAR file from the browser.
2. Run `har2locust`:
   ```sh
   har2locust -f session.har -o locustfile.py
   ```
3. A `locustfile.py` will be created with `@task` definitions representing the recorded traffic.

#### Notes
- You may need to install `har2locust` with pip:
  ```sh
  pip install har2locust
  ```
- The generated script might need manual cleanup or restructuring for more realistic testing scenarios.
