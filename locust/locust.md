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

Use `constant_throughput` to target a specific number of task runs per second **per user**. The actual total throughput depends on how many users you simulate.

```python
from locust import HttpUser, task, constant_throughput

class ThroughputUser(HttpUser):
    wait_time = constant_throughput(0.5)  # 0.5 tasks per second (1 every 2 seconds)

    @task
    def index(self):
        self.client.get("/")
```

for an adaptive time that ensures the task runs (at most) X times per second.

This approach is useful when you're aiming to maintain a per-user request rate (e.g., in performance benchmarking or capacity testing). Locust will dynamically adjust user wait times to maintain the desired rate.
