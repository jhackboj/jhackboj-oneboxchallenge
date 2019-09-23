package es.onebox.exercise.trains.models;

import org.junit.Assert;
import org.junit.Test;

public class EdgeTest
{

    @Test
    public void Should_Equal_When_DifferentWeight() {
        final Edge firstEdge = Edge.newInstanceBy("A", "B", 5);
        final Edge secondEdge = Edge.newInstanceBy("A", "B", 7);
        Assert.assertEquals(firstEdge, secondEdge);
    }

    @Test
    public void Should_NotEqual_When_DifferentEdge() {
        final Edge firstEdge = Edge.newInstanceBy("A", "B", 5);
        final Edge secondEdge = Edge.newInstanceBy("B", "C", 7);

        Assert.assertNotEquals(firstEdge, secondEdge);
    }

}
