package textgen;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Random;

public class MarkovTextGeneratorLoLTester {
    String oneWordSourceText;
    String shortSourceText;
    String mediumSourceText;
    String longSourceText;
    MarkovTextGeneratorLoL gen;
    @Before
    public void setUp() throws Exception {
        oneWordSourceText = "hi";
        shortSourceText = "hi there hi Leo";
        mediumSourceText = "I say hello, hello, hello, "+
                "I say hello, hello, hello, "+
                "I say hello, hello, hello, "+
                "I say hello, hello, hello, "+
                "You say goodbye";
        longSourceText = "You say yes, I say no, "+
                "You say stop, and I say go, go, go, "+
                "Oh no. You say goodbye and I say hello, hello, hello, "+
                "I don't know why you say goodbye, I say hello, hello, hello, "+
                "I don't know why you say goodbye, I say hello. "+
                "I say high, you say low, "+
                "You say why, and I say I don't know. "+
                "Oh no. "+
                "You say goodbye and I say hello, hello, hello. "+
                "I don't know why you say goodbye, I say hello, hello, hello, "+
                "I don't know why you say goodbye, I say hello. "+
                "Why, why, why, why, why, why, "+
                "Do you say goodbye. "+
                "Oh no. "+
                "You say goodbye and I say hello, hello, hello. "+
                "I don't know why you say goodbye, I say hello, hello, hello, "+
                "I don't know why you say goodbye, I say hello. "+
                "You say yes, I say no, "+
                "You say stop and I say go, go, go. "+
                "Oh, oh no. "+
                "You say goodbye and I say hello, hello, hello. "+
                "I don't know why you say goodbye, I say hello, hello, hello, "+
                "I don't know why you say goodbye, I say hello, hello, hello, "+
                "I don't know why you say goodbye, I say hello, hello, hello,";
        gen = new MarkovTextGeneratorLoL(new Random(42));
    }

    @Test
    public void testTrain() {
        gen.train(oneWordSourceText);
        assertEquals("hi: hi->\n", gen.toString());
        gen.retrain(shortSourceText);
        assertEquals("hi: there->Leo->\nthere: hi->\nLeo: hi->\n", gen.toString());
    }

    @Test
    public void testGenerateText() {
        assertEquals("", gen.generateText(78));
    }


}
