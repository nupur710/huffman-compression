import org.example.HuffmanCompression;
import org.example.HuffmanNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

public class HuffmanTest {
    HuffmanCompression h;
    String text= "aaabbccg";
    @Before
    public void init() {
        h= new HuffmanCompression();
    }
    @Test
    public void frequencyTableTest() {
        int[] frequencyTable= h.frequencyTable(text.toCharArray());
        Assert.assertEquals(h.CHARACTER_LIMIT, frequencyTable.length); //create 256 length char array to keep track of all chars
        Assert.assertEquals(frequencyTable[97], 3);
        Assert.assertEquals(frequencyTable[98],2);
        Assert.assertEquals(frequencyTable[99],2);
        Assert.assertEquals(frequencyTable[103],1);
    }

    @Test
    public void createPriorityQueueTest() {
        int[] frequencyTable= h.frequencyTable(text.toCharArray());
        PriorityQueue<HuffmanNode> queue= h.createPriorityQueue(frequencyTable);
        //g-1 b-2 c-2 a-3
        Assert.assertEquals('g',queue.peek().ch);
        Assert.assertEquals(1, queue.poll().freq);
        //reads b first, then c
        //b-2 c-2 a-3
        Assert.assertEquals('b',queue.peek().ch);
        Assert.assertEquals(2, queue.poll().freq);
        //c-2 a-3
        Assert.assertEquals('c',queue.peek().ch);
        Assert.assertEquals(2, queue.poll().freq);
        //a-3
        Assert.assertEquals('a',queue.peek().ch);
        Assert.assertEquals(3, queue.poll().freq);
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void getLeastFrequencyNode() {
        int[] frequencyTable=h.frequencyTable(text.toCharArray());
        PriorityQueue<HuffmanNode> queue= h.createPriorityQueue(frequencyTable);
        //g-1 b-2 c-2 a-3
        HuffmanNode node1= h.getLeastFrequencyNode(queue);
        Assert.assertEquals('-', node1.ch);
        Assert.assertEquals(3, node1.freq);
        Assert.assertEquals('g', node1.leftChild.ch);
        Assert.assertEquals(1, node1.leftChild.freq);
        Assert.assertNull(node1.leftChild.leftChild);
        Assert.assertNull(node1.leftChild.rightChild);
        Assert.assertEquals('b', node1.rightChild.ch);
        Assert.assertEquals(2, node1.rightChild.freq);
        Assert.assertNull(node1.rightChild.leftChild);
        Assert.assertNull(node1.rightChild.rightChild);
        //c-2 a-3
        HuffmanNode node2= h.getLeastFrequencyNode(queue);
        Assert.assertEquals('-', node2.ch);
        Assert.assertEquals(5, node2.freq);
        Assert.assertEquals('c', node2.leftChild.ch);
        Assert.assertEquals(2, node2.leftChild.freq);
        Assert.assertNull(node2.leftChild.leftChild);
        Assert.assertNull(node2.leftChild.rightChild);
        Assert.assertEquals('a', node2.rightChild.ch);
        Assert.assertEquals(3, node2.rightChild.freq);
        Assert.assertNull(node2.rightChild.leftChild);
        Assert.assertNull(node2.rightChild.rightChild);
    }
}
