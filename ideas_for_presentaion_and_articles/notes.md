## presentaion about jmc and what else we can analyze in it
  - exceptions, possible to check with specific optiont default is error
  - network write read and call stacks
  - threads
  - io
  - gc pauses

## presentation about memory check plan 
  - open memory leak obvious
    - find that folder with summary logger issue.
  - how to compare to heap dump
  - objects which is not clened in MAT
  - retained size, using scrolling in Visual VM. Conneptiont of shallow heap. 
  - conceptoint to find less count with a lot of retained size.
  - OQL in Visual VM and MAt. Samples. Link to reference.
  - what we need to look at. Small amount of big object
  - how to use query language to show the objects.
  - how to compare to heap dump in visual vm
  - how to compare in MAT
  - GC tuning using JFR? Is it memory enough?
  - MAT reports. How to compare to heap dump in MAT.

 ## profile presentaion
   - test real application
   - to compare version we do not need profiling, we need metrics and load tests of real system.
   - it is about optimization
   - conceptioin about instrumented profiler and async profilers. About time frame. And byte code changes.
   - show how to async profile in runtime
     - start up
     - start profiling
     - run load
     - stop profiling
     - stop app
     - open jfr in intelij, show flame graph and explain. show merged calles.
    - show instrumented profile using visual vm
      - start profile with specifing specific class to profile
      - to show how it is affected by reponse time
      - actually it is possible to use pause then it would be less effect but still.
      - to see real time. 