package decision_tree;

import java.util.Comparator;

public class DNode implements Comparator<DNode>, Comparable<DNode> {
    public double length;
    public String species;

    public DNode(double length, String species) {
        this.length=length;
        this.species=species;
    }

    @Override
    public int compare(DNode o1, DNode o2) {
        return o1.length<o2.length?-1:o1.length>o2.length?1:0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DNode node = (DNode) o;

        if (Double.compare(node.length, length) != 0) return false;
        return species != null ? species.equals(node.species) : node.species == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (species != null ? species.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(DNode o) {
        return this.length<o.length?-1:this.length>o.length?1:0;
    }
}
