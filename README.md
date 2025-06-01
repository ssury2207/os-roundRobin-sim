# os-roundRobin-sim
Built a Java-based scheduler where every process gets its fair slice of CPU time — no priority, no favoritism, just a rotating queue of equally impatient threads. It’s not the fastest, but as we know... fairness has a cost.
# 🌀 Round Robin CPU Scheduling Simulator (Java)

This project simulates the **Round Robin (RR)** scheduling algorithm — a fundamental CPU scheduling technique that distributes CPU time fairly among processes using a fixed time quantum.

---

## 📌 What This Project Does

- Simulates **Round Robin scheduling** using process burst times and arrival times.
- Accepts a **time quantum** to allocate CPU time slices.
- Calculates key CPU scheduling metrics:
  - ✅ **Completion Time (CT)**
  - ✅ **Turnaround Time (TAT)**
  - ✅ **Waiting Time (WT)**
- Logs each step of the scheduling process.
- Displays a summary of final results for all processes.

---

## 🧠 What is Round Robin Scheduling?

**Round Robin** is a preemptive scheduling algorithm that:

- Gives each process a fixed **time slice (quantum)** to execute.
- If a process finishes within the time slice → it's removed from the queue.
- If not → it is paused and moved to the **end of the queue**.
- The scheduler continues this **cyclical rotation** until all processes are completed.

🎯 **Goal**: Ensure fairness by sharing CPU time equally among all processes.

---

## 📊 Key Concepts and Metrics

### 1. **Arrival Time (AT)**

> The time when a process enters the system and becomes ready to run.

### 2. **Burst Time (BT)**

> The total amount of CPU time a process requires to complete.

### 3. **Completion Time (CT)**

> The exact time when a process finishes execution.

🧠 _"When did the process finish?"_

### 4. **Turnaround Time (TAT)**

> The total time a process spends in the system (from arrival to completion).

**Formula:**

TAT = Completion Time − Arrival Time

🧠 _"How long did the process take from start to finish?"_

### 5. **Waiting Time (WT)**

> The total time a process spent **waiting in the ready queue**, excluding actual execution.

**Formula:**

WT = Turnaround Time − Burst Time

🧠 _"How long did the process wait while others were using the CPU?"_  
🔵 _"Waiting is the time spent **excluding actual process execution**."_

---

## 🛠️ How the Simulator Works

1. Input a list of processes, each with:
   - `Process ID`
   - `Burst Time`
   - `Arrival Time`
2. Provide a **time quantum**.
3. The scheduler:
   - Tracks elapsed system time
   - Enqueues arriving processes dynamically
   - Applies Round Robin logic
   - Prints:
     - Step-by-step execution log
     - Completion, turnaround, and waiting time per process

---

## 📈 What Do Average Waiting Time and Turnaround Time Tell Us?

Understanding these averages helps evaluate **CPU performance** and **scheduling efficiency**.

---

### 🟡 What does **Average Waiting Time** tell me?

> It tells me **how efficiently the CPU is managing process access**.

- A lower average waiting time means processes are spending **less time idle in the queue**, indicating:
  - 🔄 Fair time allocation
  - ⚡ Better CPU utilization
  - 🎯 Less system congestion

🧠 _“Are processes waiting too long before getting CPU time?”_  
If yes → the scheduler might be inefficient, or the system could be overloaded.

---

### 🟢 What does **Average Turnaround Time** tell me?

> It tells me **how quickly, on average, processes are being completed**.

- A lower average turnaround time means the system is delivering **faster results**, which is especially important for:
  - ⏱️ Batch jobs
  - 📂 File processing
  - 📦 Overall throughput

🧠 _“How long is the system taking to complete jobs from the moment they arrive?”_

---

### 🔁 Combined Insight

| Metric                      | What It Reflects                      |
| --------------------------- | ------------------------------------- |
| **Average Waiting Time**    | CPU fairness and idle time efficiency |
| **Average Turnaround Time** | Overall speed of process completion   |

A **good scheduling algorithm** aims to keep **both averages low** — balancing fairness (waiting) and speed (completion).
