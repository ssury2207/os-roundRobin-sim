import java.util.*;
import java.util.Map.*;

public class RoundRobin{
    public static class  Process{

        String process_id; 
        int burst_time; //Unit of time required to Complete the process
        int arrival_time; //Instance at which the process actually starts
        public Process(String process_id, int burst_time, int arrival_time){
            this.process_id = process_id; this.burst_time = burst_time; this.arrival_time  = arrival_time;
        }
        public String getProcessId(){
            return process_id;
        }
        public int getBurstTime(){
            return burst_time;
        }
         public int getArrivalTime(){
            return arrival_time;
        }
    }
    public static void printInput(int processes[]){
        System.out.println();
        for(int i=0;i<processes.length;i++){
            System.out.println("P"+(i+1)+" "+ processes[i]+" "+" "+(i));
        }
        System.out.println();
    }
    
    public static void printTime(HashMap<String, ArrayList<Integer>> process_completion_time){
        for(Entry<String,ArrayList<Integer>> entry: process_completion_time.entrySet()){
            String key = entry.getKey();
            System.out.print(key+" | ");
            for(int number: entry.getValue()){
                System.out.print(number+" | ");
            }
            System.out.println();
        }
    }

    public static void roundRobinSimulation( int processes[],int arrivalTime[], int n, int quanta ){
        Queue<Process> q = new LinkedList<>();
        for(int i=0 ;i<n;i++){
            q.add(new Process("P"+(i+1) , processes[i], arrivalTime[i]) );
        }
        HashMap<String, ArrayList<Integer>> process_completion_time = new HashMap<>();
        int elapsedTime = 0;
         
        System.out.println("-------------------------------------------");
        System.out.println("Round Robin Process Execution has Started ");
        System.out.println("-------------------------------------------");
        int total_turn_around_time=0 ;int total_waiting_time= 0;
        while(!q.isEmpty()){
            Process p = q.poll(); 
            
            String curr_process_id = p.getProcessId();
            int curr_burst_time = p.getBurstTime();

            //Check if the Current Process can be completed 
            if(curr_burst_time<=quanta){
                //this process can be completed
                elapsedTime+=curr_burst_time;
                System.out.println("-------------------------------------------");
                System.out.println("Process "+ curr_process_id +" is Completed "+elapsedTime);
                System.out.println("-------------------------------------------");
                //remove this process out of the Queue
                //check how much is the actual time when the process will get completed
                ArrayList<Integer> list = new ArrayList<>();
                //completion Time of the Process , Turn around time
                int completion_time = elapsedTime;
                int turn_around_time = completion_time - p.getArrivalTime();
                int waiting_time = turn_around_time - p.getBurstTime();

                list.add( completion_time ); 
                list.add( turn_around_time ); 
                list.add( waiting_time ); 

                total_turn_around_time+= turn_around_time;
                total_waiting_time+= waiting_time;

                process_completion_time.put( curr_process_id, list );
            }
            else{
                //we should decrease the time i.e. curr_burst_time-quanta
                int remaning_time = curr_burst_time-quanta;
                //remove the current process and add it back to the queue
                System.out.println("Process "+ curr_process_id +" is not yet Completed, added back to the Queue with Remaing time "+ remaning_time);
                // process_completion_time.put( curr_process_id, process_completion_time.getOrDefault(curr_process_id,0)+elapsedTime );
                q.add(new Process(curr_process_id, remaning_time,p.getArrivalTime() ));
                elapsedTime+=quanta;
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("Total Time Taken by Each Process to Complete");
        System.out.println("---------------------------------------------");
        // System.out.println(process_completion_time);
        printTime(process_completion_time);
        double avg_turn_around_time = (double) total_turn_around_time / n;
        double avg_waiting_time =   (double) total_waiting_time/ n;

        System.out.println("---------------------------------------------");
        System.out.println("Average turn around time : "+ avg_turn_around_time );
        System.out.println("Average waiting time : "+ avg_waiting_time );
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Input the Number of Processes");
        int n = sc.nextInt();
        int processes[] = new int[n];
        int arrivalTime[] = new int[n];
        
        // int processes[] = new int[n];
        // System.out.println("Input the Burst time for each Processes");
        for(int i=0; i<n; i++){
          System.out.println("Input the Burst time for Process P"+(i+1));
            processes[i] = sc.nextInt();
          System.out.println("Input the Arrival time for Process P"+(i+1));
           arrivalTime[i]= sc.nextInt();
        }
        //Quantum
        printInput(processes);
        System.out.println("Please enter desired time slice");
        int quanta = sc.nextInt();
        roundRobinSimulation(processes,arrivalTime, n, quanta );
        sc.close();
    }
}