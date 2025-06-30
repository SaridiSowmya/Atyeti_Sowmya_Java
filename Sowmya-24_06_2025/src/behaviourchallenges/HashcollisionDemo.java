package behaviourchallenges;

import java.util.HashSet;
import java.util.Set;

public class HashcollisionDemo {
        public static void main(String[] args) {
            Set<HashCollisionSimulation> set = new HashSet<>();
            set.add(new HashCollisionSimulation("A"));
            set.add(new HashCollisionSimulation("B"));
            set.add(new HashCollisionSimulation("A"));//duplicate

            System.out.println("HashSet with collisions: " + set);
        }
}

