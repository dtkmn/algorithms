package hackerrank;

/**
 * Created by dtkmn on 8/07/2015.
 */

import java.io.*;
import java.util.*;

public class DependencyTrees01 {
    static class Part {
        public String getName() { return "X"; }
    }

    static class Operation {
        private String name_;
        public Operation(final String name) { name_ = name; }
        public String getName() { return name_; }
        public void operate(Part p) {
            System.out.println("Operation " + name_ + " on part " + p.getName());
        }
    }

    static class StepManager {

        private Map<String, Operation> operations = new HashMap<>();
        private Map<String, Set<Operation>> operationMapping = new HashMap<>();

        public void addOperation(final Operation operation, final String[] prerequisites) {
            // Add your implementation here. This method is called
            // once for each type of operation during setup.
            if(prerequisites.length == 0) {
                operations.put(operation.getName(), operation);
            } else {
                Set<Operation> pres = new HashSet<>();
                for(String preName: prerequisites) {
                    Operation exist = operations.get(preName);
                    if(exist == null) {
                        Operation newOp = new Operation(preName);
                        operations.put(preName, newOp);
                        pres.add(newOp);
                    } else {
                        pres.add(exist);
                    }

                }
                operationMapping.put(operation.getName(), pres);
                operations.put(operation.getName(), operation);
            }

        }

        public void performOperation(String operationName, Part p) {
            // Add your implementation here. When this method is called,
            // you must call the 'operate()' method for the named operation,
            // as well as all prerequisites for that operation.
            Set<Operation> js = getListOfJob(operationName);
//            System.out.println(js);
            Operation op = operations.get(operationName);
            for(Operation o: js) {
                o.operate(p);
            }
            op.operate(p);

//            Set<Operation> jobs = operationMapping.get(operationName);
//            if(jobs != null) {
//                for (Operation j : jobs) {
//                    performOperation(j.getName(), p);
//                }
//            }
//            op.operate(p);
        }

        public Set<Operation> getListOfJob(String operationName) {
            Set<Operation> jobs = operationMapping.get(operationName);
            if(jobs != null) {
                for (Operation j : jobs) {
                    Set<Operation> subjob = getListOfJob(j.getName());
                    if(subjob != null) {
                        jobs.addAll(subjob);
                    }
                }
            }
            return jobs;
        }

    }

    public static void main(String[] args) throws Exception {
        StepManager manager = new StepManager();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            if (s.startsWith("#")) {
                continue;
            }
            String[] parts = s.split(",");
            manager.addOperation(new Operation(parts[0]),  Arrays.copyOfRange(parts, 1, parts.length));
        }
        manager.performOperation("final", new Part());
    }
}
