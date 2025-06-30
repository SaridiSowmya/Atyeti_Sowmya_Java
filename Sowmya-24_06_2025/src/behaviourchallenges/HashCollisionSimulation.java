package behaviourchallenges;
import java.util.*;

public class HashCollisionSimulation {
        String name;

        public HashCollisionSimulation (String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 42;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof HashCollisionSimulation)) return false;
            return Objects.equals(this.name, ((HashCollisionSimulation) obj).name);
        }

        public String toString() {
            return name;
        }
}



