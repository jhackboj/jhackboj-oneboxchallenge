package es.onebox.exercise.trains.models;

public class Edge
{
    private final String source;
    private final String destination;
    private final int weight;

    private Edge(final String source,
                 final String destination,
                 final int distance) {
        this.source = source;
        this.destination = destination;
        this.weight = distance;
    }

    public static Edge newInstanceBy(final String source, final String destination, final int weight) {
        return new Edge(source, destination, weight);
    }

    public String getSource() {
        return source;
    }

    public String getDestination()
    {
        return destination;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public int hashCode()
    {
        int prime = 31;
        int hash = 1;
        hash = prime * hash + (source == null ? 0 : source.hashCode());
        hash = prime * hash + (destination == null ? 0 : destination.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        final Edge other = (Edge) obj;
        if (!this.source.equals(other.source))
            return false;

        return this.destination.equals(other.destination);
    }
}
